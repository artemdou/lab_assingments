package codeanalyzer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author artemdou
 *
 */
public class Facade {
	
	/**
	 * Produces a document consisting of the appropriate metrics
	 * @param filepath
	 * @param sourceCodeAnalyzerType
	 * @param sourceFileLocation
	 * @param outputFilePath
	 * @param outputFileType
	 */
	public void produceMetrics(String filepath, String sourceCodeAnalyzerType, String sourceFileLocation, String outputFilePath, String outputFileType) {
		SourceCodeAnalyzerFactory analyzerFactory = new SourceCodeAnalyzerFactory();
		SourceCodeAnalyzer analyzer = analyzerFactory.createsSourceCodeAnalyzer(sourceFileLocation, filepath, sourceCodeAnalyzerType);
		try {
			int loc = analyzer.calculateLOC(filepath);
			int nom = analyzer.calculateNOM(filepath);
			int noc = analyzer.calculateNOC(filepath);
			Map<String, Integer> metrics = new HashMap<>();
			metrics.put("loc",loc);
			metrics.put("nom",nom);
			metrics.put("noc",noc);
			MetricsExporterFactory exporterFactory = new MetricsExporterFactory();
			MetricsExporter exporter = exporterFactory.createsMetricsExporter(outputFileType);
			exporter.writeFile(metrics, outputFilePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
}
