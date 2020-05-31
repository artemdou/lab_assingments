package codeanalyzer;

public class SourceCodeAnalyzerFactory {

	private String fileReaderType;
	
	public SourceCodeAnalyzerFactory(String fileReaderType) {
		this.fileReaderType = fileReaderType;
	}
	
	public SourceCodeAnalyzer createsSourceCodeAnalyzer(String filepath, String analyzerType) {
		SourceCodeAnalyzer analyzer;
		if(analyzerType.equals("regex"))
			analyzer = new SourceCodeAnalyzer.RegexSourceCodeAnalyzer(fileReaderType);
		else if(analyzerType.equals("strcom"))
			analyzer = new SourceCodeAnalyzer.StrcomSourceCodeAnalyzer(fileReaderType);
		else 
			throw new IllegalArgumentException("Unknown Type: "+analyzerType);
		return analyzer; 
	}
	
}