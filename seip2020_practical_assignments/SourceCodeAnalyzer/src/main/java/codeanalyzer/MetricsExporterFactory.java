package codeanalyzer;

import java.util.Map;

public class MetricsExporterFactory {

	private String outputType;
	
	public MetricsExporterFactory(String outputType) {
		this.outputType = outputType;
	}
	
	public MetricsExporter createsMetricsExporter() {
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
