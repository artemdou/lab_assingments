package codeanalyzer;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import codeanalyzer.SourceCodeAnalyzer;

import static org.junit.Assert.*;

public class SourceCodeAnalyzerTest {
	private final static String TEST_CLASS = "src/test/resources/TestClass.java";
	private SourceCodeAnalyzer.StrcomSourceCodeAnalyzer sca2 = new SourceCodeAnalyzer.StrcomSourceCodeAnalyzer("local", TEST_CLASS);
	private SourceCodeAnalyzer.RegexSourceCodeAnalyzer sca1 = new SourceCodeAnalyzer.RegexSourceCodeAnalyzer("local", TEST_CLASS);

	
	@Test
	public void testCalculateRegexLOC() throws IOException {
		assertEquals(21, sca1.calculateLOC(TEST_CLASS));
	}
	
	@Test
	public void testCalculateStrCompLOC() throws IOException {
		assertEquals(7, sca2.calculateLOC(TEST_CLASS));
	}
	
	@Test
	public void testCalculateRegexNOM() throws IOException {
		assertEquals(3, sca1.calculateNOM(TEST_CLASS));
	}
	
	@Test
	public void testCalculateStrCompNOM() throws IOException {
		assertEquals(3, sca2.calculateNOM(TEST_CLASS));
	}
	
	@Test
	public void testCalculateRegexNOC() throws IOException {
		assertEquals(3, sca1.calculateNOC(TEST_CLASS));
	}
	
	@Test
	public void testCalculateStrCompNOC() throws IOException {
		assertEquals(3, sca2.calculateNOC(TEST_CLASS));
	}
	
}
