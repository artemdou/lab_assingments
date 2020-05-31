package codeanalyzer;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import codeanalyzer.SourceFileReader;

public interface SourceCodeAnalyzer {

	public int calculateLOC(String filepath) throws IOException;
	
	public int calculateNOM(String filepath) throws IOException;
	
	public int calculateNOC(String filepath) throws IOException;
	
	 
	public class RegexSourceCodeAnalyzer implements SourceCodeAnalyzer {
		
		
		private SourceFileReader fileReader;
		
		public RegexSourceCodeAnalyzer(String fileReaderType, String filepath) {
			SourceFileReaderFactory factroy = new SourceFileReaderFactory();
			this.fileReader = factroy.createsSourceFileReader(fileReaderType);
		}

		@Override
		public int calculateLOC(String filepath) throws IOException {
			String sourceCode = fileReader.readFileIntoString(filepath);
			Pattern pattern = Pattern.compile("((//.*)|(/\\*.*)|(\\*+.*))");
		    Matcher nonCodeLinesMatcher = pattern.matcher(sourceCode);
		    int nonCodeLinesCounter = 0;
		    while (nonCodeLinesMatcher.find()) {
		       	nonCodeLinesCounter++;
		    }
			int sourceFileLength = sourceCode.split("\n").length;
		    int loc =  sourceFileLength - nonCodeLinesCounter;        
			return loc;
		}
		
		@Override
		public int calculateNOM(String filepath) throws IOException {
			String sourceCode = fileReader.readFileIntoString(filepath);
			Pattern pattern = Pattern.compile(".*(public |protected |private |static )?[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;]).*"); 
		    Matcher methodSignatures = pattern.matcher(sourceCode);
	        int methodCounter = 0;
	        while (methodSignatures.find()) {
	        	methodCounter++;
	        }
			return methodCounter;
		}
		@Override
		public int calculateNOC(String filepath) throws IOException {
			String sourceCode = fileReader.readFileIntoString(filepath);
			Pattern pattern = Pattern.compile(".*\\s*class\\s+.*"); 
		    Matcher classSignatures = pattern.matcher(sourceCode);
		    int classCounter = 0;
		    while (classSignatures.find()) {
		    	classCounter++;
		    }
			return classCounter;
		}
		
	}
	
	public class StrcomSourceCodeAnalyzer implements SourceCodeAnalyzer {
		
		private SourceFileReader fileReader;
		
		public StrcomSourceCodeAnalyzer(String fileReaderType, String filepath) {
			SourceFileReaderFactory factroy = new SourceFileReaderFactory();
			this.fileReader = factroy.createsSourceFileReader(fileReaderType);
		}
		
		@Override
		public int calculateLOC(String filepath) throws IOException {
			List<String> sourceCodeList = fileReader.readFileIntoList(filepath);
			int nonCodeLinesCounter = 0;
			for (String line : sourceCodeList) {
				line = line.trim(); //clear all leading and trailing white spaces
				if (line.startsWith("//") || line.startsWith("/*") || line.startsWith("*") || line.equals("{") || line.equals("}") || line.equals(""))
					nonCodeLinesCounter++;
			}
			int loc = sourceCodeList.size() - nonCodeLinesCounter;
			return loc; 
		}
		
		@Override
		public int calculateNOM(String filepath) throws IOException {
			List<String> sourceCodeList = fileReader.readFileIntoList(filepath);
			int methodCounter = 0;
			for (String line : sourceCodeList) {
				line = line.trim(); //clear all leading and trailing white spaces
				if ( ((line.contains("public") || line.contains("private") || line.contains("protected"))
						|| line.contains("void") || line.contains("int") || line.contains("String"))
					&& line.contains("(") && line.contains(")") && line.contains("{") )
					methodCounter++;
			}
			return methodCounter; 
		}
	
		@Override
		public int calculateNOC(String filepath) throws IOException {
			List<String> sourceCodeList = fileReader.readFileIntoList(filepath);
			int classCounter = 0;
			for (String line : sourceCodeList) {
				line = line.trim(); //remove leading and trailing white spaces
				if ((line.startsWith("class ") || line.contains(" class ")) && line.contains("{")) {
					classCounter++;
				}
			}
			return classCounter; 
		}
		
	}
}
