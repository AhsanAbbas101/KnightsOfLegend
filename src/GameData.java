
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;
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
	protected static final Random random = new Random();
	
	/**
	 * List of fortunes.
	 */
	protected final List<Fortune> fortunes;
	
	/**
	 * List of MOBs/Monsters
	 */
	protected final List<MOB> monsters;
	
	/**
	 * List of all the knights available
	 */
	protected final List<Knight> knights;
	
	/**
	 * List of the active knights, they are references, not copies.
	 */
	protected final List<Knight> activeKnights;
	
	
	public GameData() {
		fortunes = new ArrayList<Fortune>();
		monsters = new ArrayList<MOB>();
		knights = new ArrayList<Knight>();
		activeKnights = new ArrayList<Knight>();
	}
	
	/**
	 * Returns all knights.
	 * @return all knights stored in knights
	 */
	public List<Knight> getKnights() {
		return this.knights;
	}
	
	/**
	 * Returns list of knights currently set as active.
	 * @return Essentially returns activeKnights
	 */
	public List<Knight> getActiveKnights() {
		return this.activeKnights;
	}
	
	/**
	 * Gets an active knight based on a string or id. 
	 * The string can be word in the knights name, and will return the first knight that it comes across that matches that string. 
	 * The id is supposed to be unique, and will find the knight with that idea, immediately returning the knight. 
	 * Uses findKnight to accomplish the task.
	 * @param nameOrId string or ID as a string
	 * @return the active knight if it exists, or null if it is not found
	 * @see findKnight(String, List)
	 */
	public Knight getActive(String nameOrId) {
		return findKnight(nameOrId, activeKnights);
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
	public Knight getKnight(String nameOrId) {
		return findKnight(nameOrId, knights);
	}
	
	/**
	 * Finds a knight based on nameOrId based on the a List of knights passed into it. The name can be any part of the name (contains), but the ID must exactly
	 * match. Note for students: getId() returns an Integer (not int), so you can call toString, and just compare Strings. That is valid, no need to parse.
	 * @param nameOrId a name or id string
	 * @param list the list of knights to search - often knights or activeKnights
	 * @return the single knight if found, or null if not found.
	 * @see Knight.getId(), MOB.getName()
	 */
	protected Knight findKnight(String nameOrId,List<Knight> list) {
		Knight toReturn = null;
		for (Knight k : list) {
			if (k.getId().toString().equals(nameOrId) || (k.getName().toLowerCase().contains(nameOrId))) // comparison based on id or name
			{
				toReturn = k;
				break;
			}
		}
		return toReturn;
	}
	
	/**
	 * Adds a knight to the activeKnights list, as long as there are no more than 4 knights in the list.
	 * @param kt knight to add
	 * @return true if the added was successful, false if the knight was added, due to too many knights already being in the list
	 */
	public boolean setActive(Knight kt) {
		if (this.activeKnights.size() < 4 && kt != null) {
			
			this.activeKnights.add(kt);
			return true;
		}
		return false;
	}
	
	/**
	 * Removes a knight from the activeKnights list and resets the damage on the knight!
	 * @param kt knight to remove
	 * @see MOB.resetDamage()
	 */
	public void removeActive(Knight kt) {
		// TODO verify null check
		this.activeKnights.remove(kt);
		kt.resetDamage();
	}
	
	/**
	 * Gets a random fortune from fortunes
	 * @return a Fortune from the fortunes list
	 */
	public Fortune getRandomFortune() {
		if (!fortunes.isEmpty())
			return fortunes.get(random.nextInt(fortunes.size()));
		return null;
	}
	
	/**
	 * Gets a random monster from monsters assuming the max number of monsters is less than or equal to activeKnights.size()
	 * @return a list of MOBs no greater than activeKnights.size()
	 */
	public List<MOB> getRandomMonsters() {
		int noOfmonsters = random.nextInt(activeKnights.size()) + 1 ;
		List<MOB> toReturn = new ArrayList<MOB>(noOfmonsters);
		for (int i = 0; i < noOfmonsters; i++) {
			MOB obj = monsters.get(random.nextInt(monsters.size()));
			toReturn.add(i, obj.copy());
		}
		return toReturn;
	}
	
	/**
	 * Builds a list of random monsters of size number. Note, that monsters should be copied into the return List, so they can be modified individually.
	 * @param number the number of monsters to randomly grab and copy
	 * @return a list of MOB/monsters (copies)
	 * @see MOB.copy()
	 */
	public List<MOB> getRandomMonsters(int number) {
		List<MOB> toReturn = new ArrayList<MOB>(number);
		for (int i = 0; i < number; i++) {
			MOB obj = monsters.get(random.nextInt(monsters.size()));
			toReturn.add(i, obj.copy());
		}
		return toReturn;
	}
	
	/**
	 * Required for the implementing class to be able to save the file
	 * @param filename name of file to save
	 */
	public abstract void save(String filename);
}
 