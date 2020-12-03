
/**
 * Enumeration representing different types of dice. Ranges from D4 to D20. NOTE: the enum type will automatically add the following methods:
 *		<ul>
 *		<li>static DiceType valueOf(java.lang.String name)</li>
 *		<li>static DiceType[] values()</li>
 *		</ul>
 *	Even though they show up in the javadoc, you don't need to implement them.
 * 
 *
 */

public enum DiceType {
	/**
	 * a 4 sided die
	 */
	D4,
	
	/**
	 * a 6 sided die
	 */
	D6,
	
	/**
	 * a 8 sided die
	 */
	D8,
	
	/**
	 * a 10 sided die
	 */
	D10,
	
	/**
	 * a 12 sided die
	 */
	D12,
	
	/**
	 * a 20 sided die
	 */
	D20
}
