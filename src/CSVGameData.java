
/**
 * Reads the game data from CSV files, and loads it into the protected methods in GameData.
 * 
 *
 */
public class CSVGameData extends GameData {

	
	/**
	 * Constructs the CSVGameData object, by loading CSV files passed into it.
	 * @param gamedata A game data file containing fortunes and MOBS
	 * @param saveData A data file containing knights
	 */
	public CSVGameData(java.lang.String gamedata,
            java.lang.String saveData) {
		
	}
	
	/**
	 * Loads in the data from a knights CSV file. Constructs a new Knight and adds it to the Knight List GameData.knights. Starts a counter for the IDs, with each
	 * new knight being assigned an ID in order of which they are read from the file
	 * @param saveData a file containing knight information
	 */
	void loadSaveData(java.lang.String saveData) {
		
	}
	
	/**
	 * Loads game data based on fortunes or MOBs. first line of the CSV file determines type, the rest loads directly into a MOB or Fortune object. Stores MOBs in
	 * GameData.monsters and fortunes into GameData.fortunes.
	 * @param gamedata a game data CSV file with MOBs and Fortunes
	 */
	void loadGameData(java.lang.String gamedata) {
		
	}
	
	/**
	 * Saves out the knight data as a CSV to the given filename.
	 * @param filename name of file to save knights out to
	 * @see Knight.toCSV()
	 */
	@Override
	public void save(String filename) {
		// TODO Auto-generated method stub

	}

}
