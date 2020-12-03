
import java.lang.String;
import java.util.List;
/**
 * GameView defines the various methods for getting and sending information to the client. Inheriting classes are specific to the type of input and output. For this assignment, read method descriptions in ConsoleView
 * 
 *
 */
public interface GameView {

	
	void splashScreen();
	void endGame();
	String displayMainMenu();
	void printHelp();
	void listKnights(List<Knight> knights);
	void knightNotFound();
	void showKnight(Knight knight);
	void setActiveFailed();
	void printBattleText(List<MOB> monsters,List<Knight> activeKnights);
	void printBattleText(MOB dead);
	void printFortunes(List<Knight> activeKnights);
	boolean checkContinue();
	void printDefeated();
	

}
