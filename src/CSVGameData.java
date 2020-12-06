import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.String;
import java.util.List;
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
	public CSVGameData(String gamedata,String saveData) {
		if(gamedata != null)
			loadGameData(gamedata);
		if(saveData != null)
			loadSaveData(saveData);
	}
	
	/**
	 * Loads in the data from a knights CSV file. Constructs a new Knight and adds it to the Knight List GameData.knights. Starts a counter for the IDs, with each
	 * new knight being assigned an ID in order of which they are read from the file
	 * @param saveData a file containing knight information
	 */
	void loadSaveData(java.lang.String saveData) {
		CSVReader reader = new CSVReader(saveData,false);
		int idCounter = 0;
		while(reader.hasNext()) {
			List<String> line = reader.getNext();
			//name,maxHP,armor,hitmodifer,damageDie,xp
			Knight kt = new Knight(++idCounter, 
					line.get(0), 
					Integer.parseInt(line.get(1)), 
					Integer.parseInt(line.get(2)), 
					Integer.parseInt(line.get(3)), 
					getDiceType(line.get(4)), 
					Integer.parseInt(line.get(5)));
			
			this.knights.add(kt);
		}
	}
	
	private DiceType getDiceType(String type) {
		switch (type) {
		case "D4": return DiceType.D4;
		case "D6": return DiceType.D6;
		case "D8": return DiceType.D8;
		case "D10": return DiceType.D10;
		case "D12": return DiceType.D12;
		case "D20": return DiceType.D20;
		case "-": return null;
		default: return DiceType.D4;
		}
	}
	
	
	/**
	 * Loads game data based on fortunes or MOBs. first line of the CSV file determines type, the rest loads directly into a MOB or Fortune object. Stores MOBs in
	 * GameData.monsters and fortunes into GameData.fortunes.
	 * @param gamedata a game data CSV file with MOBs and Fortunes
	 */
	void loadGameData(String gamedata) {
		CSVReader reader = new CSVReader(gamedata,false);
		while(reader.hasNext()) {
			List<String> line = reader.getNext();
			
			if (line.get(0).equals("MOB")) {
				MOB obj = new MOB(line.get(1), 	// name
						Integer.parseInt(line.get(2)), // hp
						Integer.parseInt(line.get(3)), //armor
						Integer.parseInt(line.get(4)), //hitModifier
						getDiceType(line.get(5))); // demageDie
				this.monsters.add(obj);
			}
			else if (line.get(0).equals("FORTUNE")) {
				Fortune obj = new Fortune(line.get(1), // name
						Integer.parseInt(line.get(2)), //hpBonus
						Integer.parseInt(line.get(3)),  // armor
						Integer.parseInt(line.get(4)), // hitModifier
						getDiceType(line.get(5)));		// dieReplacement
				this.fortunes.add(obj);
			}
		}
	}
	
	/**
	 * Saves out the knight data as a CSV to the given filename.
	 * @param filename name of file to save knights out to
	 * @see Knight.toCSV()
	 */
	@Override
	public void save(String filename) {
		
		try {
			FileWriter writer = new FileWriter(filename);
			for (Knight kt: this.knights) {
				writer.write(kt.toCSV()+'\n');
				// TODO Handle \n ?
			}
			writer.close();
				
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
	}

}
