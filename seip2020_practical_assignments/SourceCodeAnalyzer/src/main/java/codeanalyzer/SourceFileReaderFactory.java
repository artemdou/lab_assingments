package codeanalyzer;

public class SourceFileReaderFactory {

	public SourceFileReader createsSourceFileReader(String type) {
		SourceFileReader reader;
		if(type.equals("local"))
			reader = new SourceFileReader.LocalSourceReader();
		else if(type.equals("web"))
			reader = new SourceFileReader.WebSourceReader();
		else 
			throw new IllegalArgumentException("Unknown Type: "+type);
		return reader; 
	}
	
}
