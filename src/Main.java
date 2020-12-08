
import java.lang.String;

/**
 * 
 *  
 *	
 *	Main driver class for the Game. The game has a number of program arguments, with only two that are **required** to function.
 *	<ul>
 *	<li>--data={data filename}</li>
 *	data file needed for the game, contains MOBs and Fortunes
 *	<li>{save filename}</li>
 *	save file needed for the game, contains knights
 *	</ul>
 *	Both are optional, as they have default values.
 *	Examples:
 *
 *	java Main 
 *  java Main savedData.csv 
 *  java Main --data=gamedata.csv
 *  java Main --data=gamedata2.csv mygame.csv
 *
 *	Note: while not required, it is also useful to have a --debug and --verbose (or -d and -v). If using the provided Logger.java, the argument to enable it was --debug-level={int}.
 *
 *
 *
 */
public class Main {

	
	
	/**
	 * Takes in command line parameters, looks through the program arguments. 
	 * Builds the objects to run the game, and passes control over to the GameController. 
	 * Example code includes
     * 		
     * 		ProgramArguments pargs = new ProgramArguments(args);
     * 		GameData data = new CSVGameData(pargs.gamedata, pargs.saveData);
     * 		GameView view  = new ConsoleView();
     * 		CombatEngine engine = new CombatEngine(data, view);
     * 		GameController controller = new GameController(data, view, engine);
     * 		controller.start();
	 * 
	 * @param args the command line arguments option
	 */
	public static void main(String[] args) {
		
		// TODO verify
 		ProgramArguments pargs = new ProgramArguments(args);
 		System.out.println(pargs.gamedata +" "+ pargs.saveData);
  		GameData data = new CSVGameData(pargs.gamedata, pargs.saveData);
  		GameView view  = new ConsoleView();
  		CombatEngine engine = new CombatEngine(data, view);
  		GameController controller = new GameController(data, view, engine);
  		controller.start();

	}

	
	public Main() {
		
	}
	
	/**
	 * Internal class to handle program arguments. (students: this is optional, as you could choose to this all in the Mainclass
	 * 
	 */
	public static final class ProgramArguments {
		/**
		 * The location of the game data. defaults to data/gamedata.csv, but the --data={file} arg will reset the value
		 */
		private String gamedata;
		
		/**
		 * The location of the saved file, with a default (new game) file being data/knights.csv. The first non-specific/flagged argument replaces this file <strong>important</strong>
		 */
		private String saveData;
		
		
		/**
		 * Looks a the program arguments passed into a public static void main(String[] args) method
		 * 
		 * @param args the program arguments passed in from main
		 */
		public ProgramArguments(java.lang.String[] args){
			// TODO parse and extract args and save them in variables
			if (args.length < 1 || args.length > 2)
			{
				gamedata = "data/gamedata.csv";
				saveData = "data/knights.csv";
				return;
			}
			for( String s : args) {
				if (s.startsWith("--data=")) {
					try {
						gamedata = s.split("=")[1];
					} catch (IndexOutOfBoundsException e) {
						gamedata = "data/gamedata.csv";
					}
				}
				else {
					saveData = s;
				}
			}
			if (gamedata == null)
				gamedata = "data/gamedata.csv";
		}
	}
	
	
}
