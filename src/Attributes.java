

/**
 * Basic "attributes" or stats used throughout the game. Anything that utilizes the states (MobileObjects, Buffs, etc) should implement this interface, so the various stats can be applied. For this version of the game, the stats are
 *		<ul>
 *		<li>armor</li>
 *		<li>max Health (Hit Points / HP)</li>
 *		<li>damage die used in attacks</li>
 *		<li>hit modifier - modifier to roll to hit</li>
 *		</ul>
 *	If you are curious about why these are called attributes or statistics, it is common in roleplaying games.
 *
 *
 */
public interface Attributes {

	/**
	 * Gets the armor attribute value, often between 8-20 for a D20 system, but not fixed.
	 * @return whole number value of the armor stat
	 */
	int getArmor();
	
	/**
	 * Gets the maximum hit points attribute. While HP can go over max, they should always be reset to maxHP
	 * @return whole number value of the HP
	 */
	int getMaxHP();
	
	/**
	 * Gets the Damage Die Type
	 * @return a DiceType often ranging from D4-D12
	 */
	DiceType getDamageDie();
	
	/**
	 * Modifier to apply to "to hit" roles before calculate hits
	 * @return whole number value of the modifier
	 */
	int getHitModifier();
}
