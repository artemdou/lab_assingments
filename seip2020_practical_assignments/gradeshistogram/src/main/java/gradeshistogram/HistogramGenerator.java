package gradeshistogram;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class HistogramGenerator {

	public static void main(String[] args) throws IOException 
    {

		// first check to see if the program was run with the command line argument
		if(args.length < 1) {
			System.out.println("Error, usage: java ClassName inputfile");
		    System.exit(1);
		}

		File file = new File(args[0]);
		Integer[] grades = (arrayListToArray(readLines(file)));
		
		HistogramGenerator demo = new HistogramGenerator();
		demo.generateChart(grades);
    }
	
/*	public static Integer[] getFrequencies(Integer[] grades) {
		Integer[] frequencies = {0,0,0,0,0,0,0,0,0,0,0};
		for (int i = 0; i < grades.length;){
			if (grades[i] == 0) {
				frequencies[0]++;
			}
			if (grades[i] == 1) {
				frequencies[1]++;
			}
			if (grades[i] == 2) {
				frequencies[2]++;
			}
			if (grades[i] == 3) {
				frequencies[3]++;
			}
			if (grades[i] == 4) {
				frequencies[4]++;
			}
			if (grades[i] == 5) {
				frequencies[5]++;
			}
			if (grades[i] == 6) {
				frequencies[6]++;
			}
			if (grades[i] == 7) {
				frequencies[7]++;
			}
			if (grades[i] == 8) {
				frequencies[8]++;
			}
			if (grades[i] == 9) {
				frequencies[9]++;
			}
			if (grades[i] == 10) {
				frequencies[10]++;
			}
		}
		return frequencies;
	} */
	
	public static ArrayList<Integer> readLines(File file) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = "";
			ArrayList<Integer> grades = new ArrayList<Integer>(); 
			while((line = reader.readLine()) != null)
			{	
				try {
				grades.add(Integer.parseInt(line));
				} catch (Exception e) {
					System.out.println("NumberFormatException: " + e.getMessage());   
				}
			}
			reader.close();
			return grades;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
		}
	}
	
	public static Integer[] arrayListToArray(ArrayList<Integer> li) {
		Integer[] array = li.toArray(new Integer[li.size()]);
		return array;
	}
	
	public void generateChart(Integer[] dataValues) {
		/*
		 * The XYSeriesCollection object is a set XYSeries series (dataset) that
		 * can be visualized in the same chart
		 */
		XYSeriesCollection dataset = new XYSeriesCollection();
		/*
		 * The XYSeries that are loaded in the dataset. There might be many
		 * series in one dataset.
		 */
		XYSeries data = new XYSeries("random values");

		/*
		 * Get the Integer array of the frequency of the dataValues values
		 */
		Integer[] frequencies = {0,0,0,0,0,0,0,0,0,0,0};
		for (int i = 0; i < dataValues.length; i++) {
				if ( dataValues[i] == 0) {
					frequencies[0]++;
				}
				if ( dataValues[i] == 1) {
					frequencies[1]++;
				}
				if ( dataValues[i] == 2) {
					frequencies[2]++;
				}
				if ( dataValues[i] == 3) {
					frequencies[3]++;
				}
				if ( dataValues[i] == 4) {
					frequencies[4]++;
				}
				if ( dataValues[i] == 5) {
					frequencies[5]++;
				}
				if ( dataValues[i] == 6) {
					frequencies[6]++;
				}
				if ( dataValues[i] == 7) {
					frequencies[7]++;
				}
				if ( dataValues[i] == 8) {
					frequencies[8]++;
				}
				if ( dataValues[i] == 9) {
					frequencies[9]++;
				}
				if ( dataValues[i] == 10) {
					frequencies[10]++;
				}
			}
		
		/*
		 * Populating the XYSeries data object from the input Integer array
		 * values.
		 */
		for (int i = 0; i < 11; i++) {
			data.add(i, frequencies[i]);
		}

		// add the series to the dataset
		dataset.addSeries(data);

		boolean legend = false; // do not visualize a legend
		boolean tooltips = false; // do not visualize tooltips
		boolean urls = false; // do not visualize urls

		// Declare and initialize a createXYLineChart JFreeChart
		JFreeChart chart = ChartFactory.createXYLineChart("Grade Frequency", "grade", "number of students", dataset,
				PlotOrientation.VERTICAL, legend, tooltips, urls);

		/*
		 * Initialize a frame for visualizing the chart and attach the
		 * previously created chart.
		 */
		ChartFrame frame = new ChartFrame("First", chart);
		frame.pack();
		// makes the previously created frame visible
		frame.setVisible(true);
	}

	 

}