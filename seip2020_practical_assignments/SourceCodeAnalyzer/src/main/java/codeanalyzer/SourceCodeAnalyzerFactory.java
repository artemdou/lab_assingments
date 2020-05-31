package codeanalyzer;

/**
 * Produces the appropriate SourceCodeAnalyzer output
 * @author artemdou
 */
public class SourceCodeAnalyzerFactory {

	/**
	 * 
	 * @param filepath
	 * @param analyzerType
	 * @return SourceCodeAnalyzer
	 */
	public SourceCodeAnalyzer createsSourceCodeAnalyzer(String fileReaderType, String filepath, String analyzerType) {
		SourceCodeAnalyzer analyzer;
		if(analyzerType.equals("regex"))
			analyzer = new SourceCodeAnalyzer.RegexSourceCodeAnalyzer(fileReaderType, filepath);
		else if(analyzerType.equals("strcom"))
			analyzer = new SourceCodeAnalyzer.StrcomSourceCodeAnalyzer(fileReaderType, filepath);
		else 
			throw new IllegalArgumentException("Unknown Type: "+analyzerType);
		return analyzer; 
	}
	
}
