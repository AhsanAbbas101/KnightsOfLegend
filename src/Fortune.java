import java.lang.String;
/**
 * Fortunes are bonuses that can be applied to knights before they go on quests. 
 * As the bonus can apply to any attribute, they implement the Attributes interface. 
 * Fortunes are immutable.
 * 
 *
 */
public class Fortune implements Attributes {

	private final String name;
	private final int hpBonus;
	private final int armor;
	private final int hitModifier;
	private final DiceType type;
	
	/**
	 * Basic constructor assuming no DamageDice replacement
	 * @param name name of fortune card
	 * @param hpBonus hp bonus
	 * @param armor armor bonus
	 * @param hitModifier to hit bonus
	 */
	public Fortune(String name,
            int hpBonus,
            int armor,
            int hitModifier) {
		this(name,hpBonus,armor,hitModifier,null);
	}
	
	/**
	 * Constructor with a damage dice replacement by DiceType type
	 * @param name name of fortune card
	 * @param hpBonus hp bonus
	 * @param armor armor bonus
	 * @param hitModifier to hit bonus
	 * @param type the damage dice replacement value
	 */
	public Fortune(String name,
            int hpBonus,
            int armor,
            int hitModifier,
            DiceType type) {
		this.name = name;
		this.hpBonus = hpBonus;
		this.armor = armor;
		this.hitModifier = hitModifier;
		this.type  = type;	
	}
	
	/**
	 * Return the amount of bonus to the knights armor
	 * @return whole number value
	 */
	@Override
	public int getArmor() {
		return this.armor;
	}

	/**
	 * return the amount of bonus to the knights maxHP
	 * @return whole number value
	 */
	@Override
	public int getMaxHP() {
		return this.hpBonus;
	}

	/**
	 * Returns the replacement damage dice for the knight.
	 * @return DiceType of the knight damage die
	 */
	@Override
	public DiceType getDamageDie() {
		return this.type;
	}

	/**
	 * Returns the the bonus to the knights hit modifier.
	 * @return whole number value
	 */
	@Override
	public int getHitModifier() {
		return this.hitModifier;
	}
	
	/**
	 * returns the name of the fortune card - often named after the knightly virtues.
	 * @return Name of the knight card
	 */
	public String getName() {
		return this.name;
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
		// TODO verify card and add spaces
		String s = "+======================+\n";
		s += "|" + getName()+ "|\n";
		s += "|HP Bonus:" + getMaxHP() + "|\n";
		s += "|AC Bonus:" + getArmor() + "|\n"; // TODO verify
		s += "|Hit Bonus:" + getHitModifier() + "|\n";
		s += "|Damage Adj:";
		String dice = getDamageDie() == null ? "-" : "" + getDamageDie();
		s +=  dice + "|\n";
		s += "+======================+\n";

		return s;
	}
}
