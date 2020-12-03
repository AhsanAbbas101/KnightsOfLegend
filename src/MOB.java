
import java.lang.String;

/**
 * 
 * A MOB, short for Mobile Object, represents all 'moving' objects in the game, 
 * most notably monsters, though knight which is a specific type of MOB (playable) inherits from MOB as they share characteristics.
 * 
 *
 */
public class MOB implements Attributes {

	/**
	 * The hitModifier of the MOB. Required for the Attributes implementation
	 */
	protected int hitModifier;
	
	/**
	 * The armor rating of the mob
	 */
	protected int armor;
	
	/**
	 * the maxHP of the mob
	 */
	protected int maxHP;
	
	/**
	 * The amount of damage the MOB has taken
	 */
	protected int damage;
	
	/**
	 * the type of damage die used if the mob successfully strikes the target
	 */
	protected DiceType damageDie;
	
	
	/**
	 * The basic constructor for the mob. Most of these attributes never change, once set
	 * @param name name of the mob
	 * @param hp maxHP of the mob
	 * @param armor armor of the mob
	 * @param hitModifier hitModifier of the MOB
	 * @param damageDie damageDie
	 */
	public MOB(String name,
	           int hp,
	           int armor,
	           int hitModifier,
	           DiceType damageDie) {
		
	}
	
	
	@Override
	public int getArmor() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxHP() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DiceType getDamageDie() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getHitModifier() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * Gets the amount of damage the MOB has taken. Rarely used outside of the class itself. Instead it is better to use getHP()
	 * @return the amount of damage the MOB has taken
	 */
	public int getDamage() {
		
	}
	
	/**
	 * Returns the generic name of the MOB
	 * @return the name of the MOB
	 */
	public String getName() {
		
	}
	
	/**
	 * Adds damage to the mobs overall damage.
	 * @param damage the amount to add in whole numbers
	 */
	public void addDamage(int damage) {
		
	}
	
	/**
	 * Essentially returns the current HPs of the MOB. Taking the the maxHP, and subtracting the damage done, gives the current HP of the mob.
	 * @return the whole number value of the current hit points.
	 */
	public int getHP() {
		
	}

	/**
	 * Resets the damage taken to 0.
	 */
	public void resetDamage() {
		
	}
	
	/**
	 * Builds a MOB Card for easy printing of the stats. The game does not currently specify the specifics of this card, nor is it tested. 
	 * It is here to help with testing. You may want to grab the card from Practical1
	 * @return  formatted information about the MOB
	 */
	@Override
	public String toString() {
	
	}
	
	/**
	 * Copies the mob to a new mob. Does not care about any damage taken. When copying simply construct a new version of the mob, and return that.
	 * @return a copy/new MOB object
	 */
	public MOB copy() {
		
	}
	
}
