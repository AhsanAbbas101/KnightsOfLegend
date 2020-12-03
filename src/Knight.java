
/**
 * A knight is the primary protagonist of the game. 
 * It contains stats/attributes, experience points, and a fortune that can adjust the attributes. 
 * Additional, knights are assigned an ID, to help separate one from another.
 * 
 *
 */

public class Knight extends MOB {

	/**
	 * keeps track of experience points. May be set on load
	 */
	protected int xp;
	
	/**
	 * ID - set as final, as may not change after building the knight
	 */
	protected final int id;
	
	
	/**
	 * Basic constructor for the knight object
	 * @param id the ID - should be unique across all knights
	 * @param name the name of the knight	
	 * @param hp the max hitpoints of the knight
	 * @param armor the armor value of the knight
	 * @param hitmodifier the hit modifier of the knight
	 * @param damageDie the damage dice they use on a successful hit.
	 * @param xp the xp for the knight
	 */
	public Knight(int id,
            String name,
            int hp,
            int armor,
            int hitmodifier,
            DiceType damageDie,
            int xp) : MOB(name,
     	           hp,
    	           armor,
    	           hitModifier,
    	           damageDie) {
		
	}
	
	/**
	 * Gets the armor value of the knight. 
	 * If an activeFortune is in affect, it is the armor bonus from the active fortune + the armor of the knight 
	 * - else it is just the knights armor Students: hint, use super.getArmor() to get the value stored in armor. 
	 * Also, if the getActiveFortune() is null, then you know there isn't one.
	 * 
	 * @return the armor value of the knight, possibly with a fortune bonus
	 * @see getActiveFortune()
	 */
	@Override
	public int getArmor() {
		
	}
	
	/**
	 * Gets the maxHP value of the knight. 
	 * If an activeFortune is in affect, it is the maxHP bonus from the active fortune + the maxHP of the knight - 
	 * else it is just the knights maxHP Students: hint, use super.getMaxHP() to get the value stored in maxHP.
	 * 
	 * @return the maxHP value of the knight, possibly with a fortune bonus
	 * @see getActiveFortune()
	 */
	@Override
	public int getMaxHP() {
		
	}
	
	/**
	 * Gets the damageDie value of the knight. 
	 * If an active fortune is in place, returns the value from the active fortune (damage die boosts replace the other damage die)
	 * 
	 * @return the damage die of the knight or the active fortune
	 * @see getActiveFortune()
	 */
	@Override
	public DiceType getDamageDie() {
		
	}
	
	/**
	 * Gets the hit modifier value of the knight. 
	 * If an activeFortune is in affect, it is the hit modifier bonus from the active fortune + the hit modifier of the knight - 
	 * else it is just the knights hit modifier Students: hint, use super.getHitModifier() to get the value stored in hitModifier.
	 * 
	 * @return the hitModifier value of the knight, possibly with a fortune bonus
	 * @see Knight#getActiveFortune()
	 */
	@Override
	public int getHitModifier() {
		
	}
	
	/**
	 * Returns the knights experience points.
	 * @return the experience points as a whole number.
	 */
	public int getXP() {
		
	}
	
	/**
	 * Gets the active fortune currently being applied to the knight.
	 * @return the activeFortune currently being applied to the knight.
	 */
	public Fortune getActiveFortune() {
		
	}
	
	/**
	 * Sets the active fortune.
	 * @param activeFortune the fortune to set to the knight.
	 */
	public void setActiveFortune(Fortune activeFortune) {
		
	}
	
	/**
	 * Adds a whole number to the knights current experience point value
	 * @param xp the amount to add
	 */
	public void addXP(int xp) {
		
	}
	
	/**
	 * Gets the knights id as an Integer (not int). Integer is used, as toString is often used in other parts other program.
	 * @return the Integer value of the id.
	 */
	public java.lang.Integer getId() {
		
	}
	
	/**
	 * The toString for the knight, returns a 'knight card' examples of the card as as follows:
	 *   +============================+
     *	 | Morgawse                   |
	 *	 | id: 11                     |
	 *	 |                            |
	 *	 | Health: 35      XP: 0      |
	 *	 |  Power: D8      Armor: 14  |
	 *	 |                            |
	 *	 +============================+  
	 *	 
	 *	 +============================+
	 *	 | Danu of Ireland            |
	 *	 | id: 4                      |
	 *	 |                            |
	 *	 | Health: 40      XP: 0      |
	 *	 |  Power: D6      Armor: 16  |
	 *	 |                            |
	 *	 +============================+
	 *	 
	 *	 +============================+
	 *	 | Arthur                     |
	 *	 | id: 12                     |
	 *	 |                            |
	 *	 | Health: 40      XP: 0      |
	 *	 |  Power: D8      Armor: 16  |
	 *	 |                            |
	 *	 +============================+
	 *	 
	 *	The split for the spacing is:
	 *		<ul>
	 *		<li>30 characters wide</li>
	 *		<li>Name uses %-27s</li>
	 *		<li>id uses %-23d (as a space is required between id: and the value</li>
	 *		<li>health, Power - both %-6d</li>
	 *		<li>XP %-7d</li>
	 *		<li>Armor: %-4d</li>
	 *		</ul>
	 *	@return A formatted knight card
	 */
	public String toString() {
		
	}
	
	/**
	 * Returns a Comma Seperated value representation of the knight. The order is as follows
	 * 
	 * name,maxHP,armor,hitmodifer,damageDie,xp
	 * 
	 * for example, arthur, who has won zero battles, would return:
	 * 
	 * 	Arthur,40,16,2,D8,0
	 * 
	 * This is used when writing out the file to save.
	 * @return a CSV representation of the object
	 */
	public String toCSV() {
		
	}
}
