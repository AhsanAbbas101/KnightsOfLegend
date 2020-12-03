
import java.util.List;
import java.lang.String;

/**
 * This is a slightly more advanced CSV reader that can handle quoted tokens.
 * 
 */
public class CSVReader {
	
	/**
	 * Basic constructor that assumes the first line should be skipped.
	 * @param file name of file to read
	 */
	public CSVReader(java.lang.String file) {
		
	}
	
	/**
	 * A constructor that requires the name of the file to open
	 * 
	 * @param file filename to read
	 * @param skipHeader true to skip header, false if it is to be read
	 */
	public CSVReader(java.lang.String file,
            boolean skipHeader) {
		
	}

	/**
	 * Reads a line (nextLine()) and splits it into a String array by the DELIMINATOR, 
	 * if the line is empty it will also return null. 
	 * This is the proper way to check for CSV files as compared to string.split - as it allows for "quoted" strings ,",",.
	 * 
	 * @return a String List if a line exits or null if not
	 */
	public List<String> getNext() {
		
	}
	
	/**
	 * Checks to see if the fileScanner has more lines and returns the answer.
	 * @return true if the file scanner has more lines (hasNext())
	 */
	public boolean hasNext() {
		
	}
}
