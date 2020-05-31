package codeanalyzer;

import org.junit.Rule;
import org.junit.rules.ExpectedException;

import org.junit.Test;

public class SourceFileReaderFactoryTest {

	private SourceFileReaderFactory factory = new SourceFileReaderFactory(); 
	
	@Test
	public void testLocal() {
		assert(factory.createsSourceFileReader("local") instanceof SourceFileReader.LocalSourceReader);
	}
	
	@Test
	public void testWeb() {
		assert(factory.createsSourceFileReader("web") instanceof SourceFileReader.WebSourceReader);
	}
	
	@Rule 
	public ExpectedException thrown = ExpectedException.none(); 

	@Test 
	public void testInvalidType() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Unknown Type: type");
		factory.createsSourceFileReader("type");
	}
	
	
}