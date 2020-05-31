package codeanalyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public interface SourceFileReader {

	public List<String> readFileIntoList(String filepath) throws IOException;
	public String readFileIntoString(String filepath) throws IOException;
	
	
	
	class LocalSourceReader implements SourceFileReader{
		
		/*private String filepath;
		
		public LocalSourceReader(String filepath) {
			this.filepath = filepath; 
		}*/
		@Override
		public List<String> readFileIntoList(String filepath) throws IOException {
			// read a locally stored file
			List<String> lines = new ArrayList<>();
			File file = new File(filepath);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
			reader.close();
			return lines;
		}
		
		/**
		 * Reads a file and returns its content in a single String
		 * @param fileReaderType the location of a file 
		 * (<b>local</b> for locally stored files, 
		 * <b>web</b> for files stored on the web). 
		 * @param filepath the url of the file
		 * @return a String that contains the contents of the file
		 * or null if the type is neither <b>local</b> nor <b>web</b>
		 * @throws IOException
		 */
		public String readFileIntoString(String filepath) throws IOException {
			StringBuilder sb = new StringBuilder();
			File file = new File(filepath);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			reader.close();
			return sb.toString();
		}
	}	
	
	class WebSourceReader implements SourceFileReader{
		
		/**
		 * Reads a file and returns its content in a List
		 * @param fileReaderType the location of a file 
		 * (<b>local</b> for locally stored files, 
		 * <b>web</b> for files stored on the web). 
		 * @param filepath the url of the file
		 * @return a List that contains the contents of the file 
		 * or null if the type is neither <b>local</b> nor <b>web</b>
		 * @throws IOException
		 */
		public List<String> readFileIntoList(String filepath) throws IOException {
			List<String> lines = new ArrayList<>();
		    URL url = new URL(filepath);
		    BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		      	lines.add(line);
		    }
		    reader.close();
			return lines;
		}
		
		/**
		 * Reads a file and returns its content in a single String
		 * @param fileReaderType the location of a file 
		 * (<b>local</b> for locally stored files, 
		 * <b>web</b> for files stored on the web). 
		 * @param filepath the url of the file
		 * @return a String that contains the contents of the file
		 * or null if the type is neither <b>local</b> nor <b>web</b>
		 * @throws IOException
		 */
		public String readFileIntoString(String filepath) throws IOException {
			StringBuilder sb = new StringBuilder();
		    URL url = new URL(filepath);
		    BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		      	sb.append(line + "\n");
		    }
		    reader.close();
		    return sb.toString();
		}
		
	}
}
