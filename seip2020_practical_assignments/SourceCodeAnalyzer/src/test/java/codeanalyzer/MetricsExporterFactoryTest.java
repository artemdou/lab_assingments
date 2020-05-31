package codeanalyzer;

import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.Test;

public class MetricsExporterFactoryTest {

		private final static String TEST_CLASS = "src/test/resources/TestClass.java";
		private MetricsExporterFactory factory = new MetricsExporterFactory(); 
		
		@Test
		public void testCsv() {
			assert(factory.createsMetricsExporter("csv") instanceof MetricsExporter.CsvMetricsExporter);
		}
		
		@Test
		public void testJSON() {
			assert(factory.createsMetricsExporter("json") instanceof MetricsExporter.JSONMetricsExporter);
		}
		
		@Rule 
		public ExpectedException thrown = ExpectedException.none(); 

		@Test 
		public void testInvalidType() {
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("Unknown Type: type");
			factory.createsMetricsExporter("type");
		}
}
