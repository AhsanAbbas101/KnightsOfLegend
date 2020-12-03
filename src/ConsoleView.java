import java.util.List;
import java.util.Scanner;


/**
 * The console view provides a specific implementation of writing output to the the Console / System.out The only methods implemented are those that match the GameView interface.
 * 
 *
 */
public class ConsoleView implements GameView {

	public ConsoleView() {
		
	}
	
	/**
	 * Prints a splashScreen that is called at the launch of the game. Students: you can make the splashScreen anything you want.
	 */
	@Override
	public void splashScreen() {
		// TODO Auto-generated method stub

	}

	/**
	 * Prints a goodbye message for completing the game.
	 */
	@Override
	public void endGame() {
		// TODO Auto-generated method stub

	}

	/**
	 * Displays a "menu" for the player. Really, for text based games this was often just a simple question. The following question will be displayed
	 *  		What would you like to do?
	 *  The clients response will be recorded, and returned out of the method.
	 *  
	 *  @return the clients response, as an entire line.
	 *  @see Scanner#nextLine(), Scanner, Scanner.in
	 */
	@Override
	public String displayMainMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Prints the help menu. The options are as follows.
	 * 
	 * 	Unsure what to do, here are some options:
	 * 			ls or list all  - listing the knights
	 * 			list active  - list the active knights knights only
	 * 			show name or id - show the knight details card
	 * 			set active name or id - set knight as active (note: only 4 knights can be active) 
	 * 			remove active name or id - remove a knight from active status (heals knight)
	 * 			explore or adventure or quest - find random monsters to fight
	 * 			save filename - save the game to the file name (default: saveData.csv)
	 * 			exit or goodbye - to leave the game
	 * 
	 * Game rules: You can have four active knights. As long as they are active, they won't heal, 
	 * but they can gain XP by going on adventures.
	 * When you make a knight inactive, they will heal. How many monsters can you defeat 
	 * before, you have to heal?  
	 * 
	 * Note the space before the options is the tab character.
	 */
	@Override
	public void printHelp() {
		// TODO Auto-generated method stub

	}

	/**
	 * Lists the knights by id: name. Example:
	 * 1: Guinevere
	 * 2: Morrigan Ravenskind
	 * 3: Eriu
	 * 4: Danu of Ireland
	 * 5: Fodla
	 * 6: Banba
	 * 7: Igraine of the Lake
	 * 8: Anna of the Mountains
	 * 9: Morgan la Fay
	 * 10: Elaine Pendragon
	 * 11: Morgawse
	 * 12: Arthur
	 * 13: Lancelot
	 * 14: Gwain
	 * 15: Argodras the Red
	 * 16: The Green Knight
	 * 17: Cam the Ram
	 * 
	 * If no knights are found, it prints the following:
	 * 	No knights to list
	 * 
	 * @param knights a set of knights to list
	 * @see {@link Knight#getId()}, {@link MOB#getName()}
	 */
	@Override
	public void listKnights(List<Knight> knights) {
		// TODO Auto-generated method stub

	}

	/**
	 * Prints
	 * 		Knight not found!
	 * To the console.
	 */
	@Override
	public void knightNotFound() {
		// TODO Auto-generated method stub

	}

	/**
	 * Prints a knight to the console, plus a blank line.
	 * @param knight the knight whose card is meant to print
	 * @see {@link Knight#toString()}
	 */
	@Override
	public void showKnight(Knight knight) {
		// TODO Auto-generated method stub

	}

	/**
	 * Prints the following message:
	 * 		Unable to set active knight. Only four can be active at a time.
	 * 
	 */
	@Override
	public void setActiveFailed() {
		// TODO Auto-generated method stub

	}

	/**
	 * Lists a number of knights side by side with their 'foes' (aka monsters). Example:
	 * 
	 * Our heroes come across the following monsters. Prepare for battle!
	 * Knights                     Foes
	 * Guinevere                   Umber Hulk
	 * Danu of Ireland
	 * Arthur
	 * 
	 * Our heroes come across the following monsters. Prepare for battle!
	 * Knights                     Foes
	 * Danu of Ireland             Frost Giant
	 * Arthur                      Orc
	 * Gwain                       Frost Giant
	 * 
	 * @param monsters a list of MOB objects
	 * @param activeKnights a list of Knight objectsw
	 */
	@Override
	public void printBattleText(List<MOB> monsters, List<Knight> activeKnights) {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * Prints that the MOB was defeaed. Examples
	 *      Frost Giant was defeated!
	 *      
	 *      Arthur was defeated!
	 *      
	 * @param dead the defeated MOB
	 */
	@Override
	public void printBattleText(MOB dead) {
		// TODO Auto-generated method stub

	}

	
	/**
	 * Prints fortunes for the knight that they draw at the beginning of the quest. Examples:
	 *  For this quest, our knights drew the following fortunes!
	 *  Danu of Ireland drew
	 *  +======================+
	 *  |Justice               |
	 *  |HP Bonus:           +5|
	 *  |AC Bonus:           +2|
	 *  |Hit Bonus:          +1|
	 *  |Damage Adj:          -|
	 *  +======================+
	 *  Arthur drew
	 *  +======================+
	 *  |Nobility              |
	 *  |HP Bonus:          +10|
	 *  |AC Bonus:           +1|
	 *  |Hit Bonus:          +1|
	 *  |Damage Adj:          -|
	 *  +======================+
	 *  Gwain drew
	 *  +======================+
	 *  |Obedience             |
	 *  |HP Bonus:           +0|
	 *  |AC Bonus:           +3|
	 *  |Hit Bonus:          +1|
	 *  |Damage Adj:          -|
	 *  +======================+
	 *  
	 *  @param activeKnights A List of Knights
	 */
	@Override
	public void printFortunes(List<Knight> activeKnights) {
		// TODO Auto-generated method stub

	}

	/**
	 * Checks with the user by asking if they want to continue their quest.
	 * 
	 * 		Would you like to continue on your quest (y/n)? 
	 * 
	 * @return true if the client types y, or yes - else false for anything else.
	 */
	@Override
	public boolean checkContinue() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Prints when all knights are defeated
	 * 		 All active knights have been defeated!
	 */
	@Override
	public void printDefeated() {
		// TODO Auto-generated method stub

	}

}
