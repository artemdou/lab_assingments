package codeanalyzer;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.Test;

import codeanalyzer.SourceFileReader;


public class SourceFileReaderTest {
	private static SourceFileReader.LocalSourceReader sfrl = new SourceFileReader.LocalSourceReader();
	private static SourceFileReader.WebSourceReader sfrw = new SourceFileReader.WebSourceReader();
	private static List<String> expectedList;
	private static String expectedString;
	private final static String TEST_CLASS_LOCAL = "src/test/resources/TestClass.java";
	private final static String TEST_CLASS_WEB ="https://drive.google.com/uc?export=download&id=1z51FZXqPyun4oeB7ERFlOgfcoDfLLLhg";
	
	@BeforeClass
	public static void setUp() throws IOException {
		expectedList = Files.readAllLines(new File(TEST_CLASS_LOCAL).toPath(), Charset.defaultCharset());
		expectedString = String.join("\n", expectedList) + "\n"; // transforms a list into a String (with 'new line' as delimiter) 
	}
	
	@Test
	public void testReadFileIntoListLocal() throws IOException {
		//read a locally stored file into a List
		List<String> actualList = sfrl.readFileIntoList(TEST_CLASS_LOCAL);
		
		String[] expecteds = expectedList.stream().toArray(String[]::new);
		String[] actuals = actualList.stream().toArray(String[]::new);
		
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testReadFileIntoStringLocal() throws IOException {
		//read a locally stored file into a String
		String actuals = sfrl.readFileIntoString(TEST_CLASS_LOCAL);
		assertEquals(expectedString, actuals);
	}
		
	@Test
	public void testReadFileIntoListWeb() throws IOException {
		//read a file stored in the web into a List
		List<String> actualList = sfrw.readFileIntoList(TEST_CLASS_WEB);
		
		String[] expecteds = expectedList.stream().toArray(String[]::new);
		String[] actuals = actualList.stream().toArray(String[]::new);
		
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testReadFileIntoStringWeb() throws IOException {
		//read a file stored in the web into a String
		String actuals = sfrw.readFileIntoString(TEST_CLASS_WEB);
				
		assertEquals(expectedString, actuals);
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none(); 
	
	@Test
	public void testReadLocalFileIntoListNull() throws IOException {
		//give a none existing type to cause a null List return
		thrown.expect(java.io.FileNotFoundException.class);
		sfrl.readFileIntoList("any-filepath");
		
	}
	
	@Test
	public void testReadWeblFileIntoListNull() throws IOException {
		//give a none existing type to cause a null List return
		thrown.expect(java.net.MalformedURLException.class);
		sfrw.readFileIntoList("any-filepath");
	}
	
	@Test
	public void testLocalReadFileIntoStringNull() throws IOException {
		//give a none existing type to cause a null String return
		thrown.expect(java.io.FileNotFoundException.class);
		sfrl.readFileIntoString("any-filepath");
		
	} 
	
	@Test
	public void testWebReadFileIntoStringNull() throws IOException {
		//give a none existing type to cause a null String return
		thrown.expect(java.net.MalformedURLException.class);
		sfrw.readFileIntoString("any-filepath");
	} 
}
