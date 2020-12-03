
/**
 * Fortunes are bonuses that can be applied to knights before they go on quests. 
 * As the bonus can apply to any attribute, they implement the Attributes interface. 
 * Fortunes are immutable.
 * 
 *
 */
public class Fortune implements Attributes {

	/**
	 * Basic constructor assuming no DamageDice replacement
	 * @param name name of fortune card
	 * @param hpBonus hp bonus
	 * @param armor armor bonus
	 * @param hitModifier to hit bonus
	 */
	public Fortune(java.lang.String name,
            int hpBonus,
            int armor,
            int hitModifier) {
		
	}
	
	/**
	 * Constructor with a damage dice replacement by DiceType type
	 * @param name name of fortune card
	 * @param hpBonus hp bonus
	 * @param armor armor bonus
	 * @param hitModifier to hit bonus
	 * @param type the damage dice replacement value
	 */
	public Fortune(java.lang.String name,
            int hpBonus,
            int armor,
            int hitModifier,
            DiceType type) {
		
	}
	
	/**
	 * Return the amount of bonus to the knights armor
	 * @return whole number value
	 */
	@Override
	public int getArmor() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * return the amount of bonus to the knights maxHP
	 * @return whole number value
	 */
	@Override
	public int getMaxHP() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Returns the replacement damage dice for the knight.
	 * @return DiceType of the knight damage die
	 */
	@Override
	public DiceType getDamageDie() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns the the bonus to the knights hit modifier.
	 * @return whole number value
	 */
	@Override
	public int getHitModifier() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * returns the name of the fortune card - often named after the knightly virtues.
	 * @return Name of the knight card
	 */
	public String getName() {
		
	}

	/**
	 * Returns a nicely formatted String value of the fortune. Examples look like:
	 * +======================+
	 * |Nobility              |
	 * |HP Bonus:          +10|
	 * |AC Bonus:           +1|
	 * |Hit Bonus:          +1|
	 * |Damage Adj:          -|
	 * +======================+
	 * 
	 * Spacing is -22s for the name, 12s for the HP Bonus, 12s for the AC bonus, 11s for the hit bonus and 10s for the damage adj.
	 * 
	 * @return String value of the fortune
	 */
	public java.lang.String toString() {
		
	}
}
