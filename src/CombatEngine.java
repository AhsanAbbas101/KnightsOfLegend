
/**
 * The combat engine runs the combat for the game.
 * 
 *
 */
public class CombatEngine {

	/**
	 * To run the combat, a GameData and GameView is essential for it to work. 
	 * It is designed to use classes that implement the GameView and GameData interfaces
	 * @param data a game dataset
	 * @param view a game view
	 */
	public CombatEngine(GameData data,
            GameView view) {
		
	}
	
	/**
	 * Before every quest, active knights are assigned random fortunes (GameData#getRandomFortune(). Once an a fortune is assigned 
	 * to each active knight, call GameView#printFortunes(List) )
	 */
	public void initialize() {
		
	}
	
	/**
	 * Runs the combat simulation. Combat will continue to run as long as there are either knights or monsters/MOBs. If MOBs are reduced to zero, the player will
	 * be promoted to see if they wish to continue exploring GameView.checkContinue(). If they respond yes, more random monsters will be generated, and combat
	 * begins again. At the start of each battle:
	 * 	<ul>
	 * 	<li>Generates a random list of MOBs, no larger than the total number of knights GameData#getRandomMonsters()</li>
	 * 	<li>Prints the battle text, on who the fight is between GameView#printBattleText(List, List)</li>
	 * 	<li>Runs through the combat
	 * 	</ul>
	 * The combat order itself is undefined on order of actions, but the following must happen
	 * 	<ul>
	 * 	<li>When knights are defeated (MOB.getHP() <= 0), they are removed from active knights</li>
	 * 	<li>When MOBs are defeated, every active knight earns 1 XP point (Knight.addXP(int))</li>
	 * 	<li>While combat order is undefined, a common implementation is cycle through the knights having them attack a random monster. We then cycle through
	 * 	    the MOBs having them each attack a random knight.</li>
	 * 	<li>When a knight or mob is defeated, we print that they were defeated GameView.printBattleText(MOB)</li>
	 * 	</ul>
	 * If all knights are defeated, we notify the player using GameView.printDefeated().
	 * 
	 * <strong>Calculating Hits</strong>
	 * To calculate a successful hit, you roll a D20 (DiceSet.roll(DiceType) take that value, add the MOBs/Knights toHitModifier. If the value is greater than the
	 * armor value, they score a hit, and the damage die is rolled.
	 * 
	 * 				D20 + hitModifier  > armor  (successful hit formula)
	 * 
	 * Upon a successful strike, the damage die is rolled to determine the amount of damage the opponent takes Hint to students: private helper methods are
	 * extremely helpful here. As is helps break up the above steps. Make sure to take it in small parts, printing out in each step.
	 *
	 * 
	 * @see DiceSet#roll(DiceType)
	 */
	public void runCombat() {
		
	}
	
	/**
	 * Sets all fortunes to null across all knights.
	 * @see Knight#setActiveFortune(Fortune), GameData#getKnights()
	 */
	public void clear() {
		
	}
}
