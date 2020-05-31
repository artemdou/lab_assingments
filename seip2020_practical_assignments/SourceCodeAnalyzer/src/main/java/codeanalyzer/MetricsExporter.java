package codeanalyzer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * 
 * @author artemdou
 *
 */
public interface MetricsExporter {
	
	/**
	 * Exports (writes) the metrics to a given output.
	 * The output can be CSV or JSON files.
	 * @param metrics
	 * @param filepath
	 */
	public void writeFile(Map<String, Integer> metrics, String filepath);
	
	//interface implementation for csv output
	class CsvMetricsExporter implements MetricsExporter{
		
		//output is a csv file
		@Override
		public void writeFile(Map<String, Integer> metrics, String filepath) {
			File outputFile = new File(filepath + ".csv");
			StringBuilder metricsNames = new StringBuilder();
			StringBuilder metricsValues = new StringBuilder();
			
			for (Map.Entry<String, Integer> entry : metrics.entrySet()) {
				metricsNames.append(entry.getKey() + ",");
				metricsValues.append(entry.getValue()+",");
			}
			
			try {
				FileWriter writer = new FileWriter(outputFile);
				writer.append(metricsNames + "\n");
				writer.append(metricsValues + "\n");
				writer.close();
				System.out.println("Metrics saved in " + outputFile.getAbsolutePath());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	//interface implementation for json output
	class JSONMetricsExporter implements MetricsExporter{
		
		@Override
		public void writeFile(Map<String, Integer> metrics, String filepath) {
			// Functionality not implemented yet
			// No need to implement it for the assignment
		}
	}
	
}
