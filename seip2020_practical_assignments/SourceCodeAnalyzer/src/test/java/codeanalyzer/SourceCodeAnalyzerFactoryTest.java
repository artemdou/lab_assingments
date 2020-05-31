package codeanalyzer;

import static org.junit.Assert.assertEquals;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import org.junit.Test;

public class SourceCodeAnalyzerFactoryTest {

	private final static String TEST_CLASS = "src/test/resources/TestClass.java";
	private SourceCodeAnalyzerFactory factory = new SourceCodeAnalyzerFactory("local"); 
	
	@Test
	public void testRegex() {
		assert(factory.createsSourceCodeAnalyzer(TEST_CLASS, "regex") instanceof SourceCodeAnalyzer.RegexSourceCodeAnalyzer);
	}
	
	@Test
	public void testStrcom() {
		assert(factory.createsSourceCodeAnalyzer(TEST_CLASS, "strcom") instanceof SourceCodeAnalyzer.StrcomSourceCodeAnalyzer);
	}
	
	@Rule 
	public ExpectedException thrown = ExpectedException.none(); 

	@Test 
	public void testInvalidType() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Unknown Type: type");
		factory.createsSourceCodeAnalyzer(TEST_CLASS, "type");
	}
	
	
}
