
import java.util.Random;
/**
 * GameData handles the data for the game. It is abstract, as a child class needs to define how that data is going to be loaded into the data objects, but most of the data
 * objects can run independently of the the child class. The rest of the game will assume the GameData class only.
 * 
 *
 */
public abstract class GameData {

	/**
	 * Random number generator, used for grabbing random items for the structures. For example, grabbing a random fortune would be fortunes.get(random.nextInt(fortunes.size()))
	 */
	protected static final Random random;
	
	/**
	 * List of fortunes.
	 */
	protected final java.util.List<Fortune> fortunes;
	
	/**
	 * List of MOBs/Monsters
	 */
	protected final java.util.List<MOB> monsters;
	
	/**
	 * List of all the knights available
	 */
	protected final java.util.List<Knight> knights;
	
	/**
	 * List of the active knights, they are references, not copies.
	 */
	protected final java.util.List<Knight> activeKnights;
	
	
	public GameData() {
		
	}
	
	/**
	 * Returns all knights.
	 * @return all knights stored in knights
	 */
	public java.util.List<Knight> getKnights() {
		
	}
	
	/**
	 * Returns list of knights currently set as active.
	 * @return Essentially returns activeKnights
	 */
	public java.util.List<Knight> getActiveKnights() {
		
	}
	
	/**
	 * Gets an active knight based on a string or id. 
	 * The string can be word in the knights name, and will return the first knight that it comes across that matches that string. 
	 * The id is supposed to be unique, and will find the knight with that idea, immediately returning the knight. 
	 * Uses findKnight to accomplish the task.
	 * @param nameOrId nameOrId - string or ID as a string
	 * @return the active knight if it exists, or null if it is not found
	 * @see findKnight(String, List)
	 */
	public Knight getActive(java.lang.String nameOrId) {
		
	}
	
	
	/**
	 * Gets an knight from the all knights list based on a string or id. The string can be word in the knights name, and will return the first knight that it comes
	 * across that matches that string. The id is supposed to be unique, and will find the knight with that idea, immediately returning the knight. Uses findKnight to
	 * accomplish the task.
	 * 
	 * @param nameOrId string or ID as a string
	 * @return the knight if it exists, or null if it is not found
	 * @see findKnight(String, List)
	 */
	public Knight getKnight(java.lang.String nameOrId) {
		
	}
	
	/**
	 * Finds a knight based on nameOrId based on the a List of knights passed into it. The name can be any part of the name (contains), but the ID must exactly
	 * match. Note for students: getId() returns an Integer (not int), so you can call toString, and just compare Strings. That is valid, no need to parse.
	 * @param nameOrId a name or id string
	 * @param list the list of knights to search - often knights or activeKnights
	 * @return the single knight if found, or null if not found.
	 * @see Knight.getId(), MOB.getName()
	 */
	protected Knight findKnight(java.lang.String nameOrId,
            java.util.List<Knight> list) {
		
	}
	
	/**
	 * Adds a knight to the activeKnights list, as long as there are no more than 4 knights in the list.
	 * @param kt knight to add
	 * @return true if the added was successful, false if the knight was added, due to too many knights already being in the list
	 */
	public boolean setActive(Knight kt) {
		
	}
	
	/**
	 * Removes a knight from the activeKnights list and resets the damage on the knight!
	 * @param kt knight to remove
	 * @see MOB.resetDamage()
	 */
	public void removeActive(Knight kt) {
		
	}
	
	/**
	 * Gets a random fortune from fortunes
	 * @return a Fortune from the fortunes list
	 */
	public Fortune getRandomFortune() {
		
	}
	
	/**
	 * Gets a random monster from monsters assuming the max number of monsters is less than or equal to activeKnights.size()
	 * @return a list of MOBs no greater than activeKnights.size()
	 */
	public java.util.List<MOB> getRandomMonsters() {
		
	}
	
	/**
	 * Builds a list of random monsters of size number. Note, that monsters should be copied into the return List, so they can be modified individually.
	 * @param number the number of monsters to randomly grab and copy
	 * @return a list of MOB/monsters (copies)
	 * @see MOB.copy()
	 */
	public java.util.List<MOB> getRandomMonsters(int number) {
		
	}
	
	/**
	 * Required for the implementing class to be able to save the file
	 * @param filename name of file to save
	 */
	public abstract void save(java.lang.String filename) {
		
	}
}
