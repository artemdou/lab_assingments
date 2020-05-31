package codeanalyzer;

import java.util.Map;

/**
 * Produces the appropriate MetricExporter output
 * @author artemdou
 */
public class MetricsExporterFactory {

	/**
	 * 
	 * @param outputType
	 * @return MetricsExporter
	 */
	public MetricsExporter createsMetricsExporter(String outputType) {
		MetricsExporter exporter;
		if(outputType.equals("csv"))
			exporter = new MetricsExporter.CsvMetricsExporter();
		else if(outputType.equals("json"))
			exporter = new MetricsExporter.JSONMetricsExporter();
		else 
			throw new IllegalArgumentException("Unknown Type: "+outputType);
		return exporter; 
	}
	
}
