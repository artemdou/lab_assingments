package codeanalyzer;

/**
 * Produces the appropriate SourceCodeAnalyzer output
 * @author artemdou
 */
public class SourceCodeAnalyzerFactory {

	private String fileReaderType;
	
	/**
	 * 
	 * @param fileReaderType
	 */
	public SourceCodeAnalyzerFactory(String fileReaderType) {
		this.fileReaderType = fileReaderType;
	}
	
	/**
	 * 
	 * @param filepath
	 * @param analyzerType
	 * @return SourceCodeAnalyzer
	 */
	public SourceCodeAnalyzer createsSourceCodeAnalyzer(String filepath, String analyzerType) {
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
