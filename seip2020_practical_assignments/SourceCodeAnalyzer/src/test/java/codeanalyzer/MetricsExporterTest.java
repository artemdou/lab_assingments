package codeanalyzer;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import codeanalyzer.MetricsExporter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doCallRealMethod;

public class MetricsExporterTest {
	
	MetricsExporter CsxExporter = new MetricsExporter.CsvMetricsExporter();
	MetricsExporter JSONExporter = new MetricsExporter.JSONMetricsExporter();
	
	@Test
	public void testWriteCsv() {
		// create the metrics content
		Map<String, Integer> metrics = new HashMap<>();
		metrics.put("loc",30);
		metrics.put("nom",5);
		metrics.put("noc",2);
		
		// generate and write the output file
		String outputFilepath = "src/test/resources/output_metrics";
		CsxExporter.writeFile(metrics, outputFilepath);
		
		// evaluate that the file exists
		File outputFile = new File(outputFilepath + ".csv");
		Assert.assertTrue(outputFile.exists());
		
		// delete the generated file
		outputFile.delete();
	}
	
	@Test
	public void testWriteJson() {
		MetricsExporter mockedExporter = mock(MetricsExporter.JSONMetricsExporter.class);
		// create an empty metrics content
		Map<String, Integer> metrics = new HashMap<>();
		String outputFilepath = "whatever-path";
		
		//this is a demo of how a mocked object can call a real method (partial mocking)
		doCallRealMethod().when(mockedExporter).writeFile( metrics, outputFilepath);
		mockedExporter.writeFile( metrics, outputFilepath);
		//just verify that the method was executed/called
		verify(mockedExporter).writeFile( metrics, outputFilepath);
	}
	

}
