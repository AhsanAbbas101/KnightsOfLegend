import java.lang.String;
import java.util.StringTokenizer;
/**
 * Central point of communication between GameData, GameView and CombatEngine.
 * 
 *
 */
public class GameController {

	private GameData data;
	private GameView view;
	private CombatEngine engine;
	
	/**
	 * The GameController needs all major components of the game to work - view, data and combat
	 * @param data GameData - does not care the type (CSV, JSON, etc), just the abstract class
	 * @param view GameView - calles the various methods based on feedback from data
	 * @param engine runs combat between an active knight group and MOBs
	 */
	public GameController(GameData data,
            GameView view,
            CombatEngine engine) {
		this.data = data;
		this.view = view;
		this.engine = engine;
	}
	
	/**
	 * Starts the game, causing it to run until a client exits. Starts with splashScreen, loops as long as processCommand returns true, prints endgame when loop is done.
	 * 
	 * @see GameView#displayMainMenu()
	 */
	public void start() {
		view.splashScreen();
		
		boolean cont = true;
		while(cont) {
			String command = view.displayMainMenu();
			cont = processCommand(command);
		}
		
		view.endGame();
	}
	
	/**
	 * Setup as a helper method for start() }, processes commands the client passes in through GameView.displayMainMenu(). The following command
	 * combinations are allowed:
	 * <ul>
	 * <li>exit or bye (contains) - causes processCommand to return false</li>
	 * <li>ls or list all - list all knights. For example, view.listKnights(data.getKnights())</li>
	 * <li>list active - list active knights via GameData.getActiveKnights()</li>
	 * <li>show (name or id) - if the command starts with show, take the remainder and show the knight card</li>
	 * <li>set active (name or id) - if command starts with set active, grabs the remainder of the line, and try to add the knight to the active knight list.</li>
	 * <li>remove (name or id) - if command starts with remove, grabs the remainder of the line, attempts to remove the knight from active status.</li>
	 * <li>save (filename - optional) - saves the game. If a file name is provided saves the knights to the file. If a file name is left off, saves out to saveData.csv</li>
	 * <li>explore, adventure or quest - if any three of these words are used, it starts a combat sequence. For example.
	 * 
	 * 
	 * 			engine.initialize();
	 * 			engine.runCombat();
	 * 			engine.clear();
	 *   		}</li>
	 *   
	 * <li>any other input, print the help menu.</li>
	 * </ul>
	 * @param command command to process.
	 * @return true unless exit or bye is used.
	 */
	protected boolean processCommand(java.lang.String command) {
		StringTokenizer st = new StringTokenizer(command.toLowerCase(), " ");
		String t = "";
		switch (st.nextToken()) {
		case "exit":
		case "bye":
			return false;
	
		case "ls":
		case "list":
			if (st.hasMoreTokens()) {
				t = st.nextToken();
				if (t.equals("all")) {
					view.listKnights(data.getKnights());
				} else if (t.equals("active")) {
					view.listKnights(data.getActiveKnights());
				}
			} else {
				view.listKnights(data.getKnights());
			}
	
			break;
		case "show":
			t = st.nextToken("\n");
			view.showKnight(data.getKnight(t));
			break;
	
		case "set":
			t = st.nextToken();
			if (t.equals("active")) {
				t = st.nextToken("\n");
				boolean result = data.setActive(data.getKnight(t));
				if (!result)
					view.setActiveFailed();
			}
			break;
	
		case "remove":
			t = st.nextToken("\n");
			data.removeActive(data.getKnight(t));
			break;
	
		case "save":
			if (st.hasMoreTokens()) {
				t = st.nextToken();
				data.save(t);
			}else {
				data.save("saveData.csv");
			}
			break;
		case "explore":
		case "adventure":
		case "quest":
			 engine.initialize();
			 engine.runCombat();
			 engine.clear();
			break;
	
		default:
			view.printHelp();
		}
		return true;
	}
}
