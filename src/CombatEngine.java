import java.util.List;
import java.util.Random;

/**
 * The combat engine runs the combat for the game.
 * 
 *
 */
public class CombatEngine {

	private GameData data;
	private GameView view;
	private final Random random = new Random();
	private final DiceSet diceSet = new DiceSet();
	
	/**
	 * To run the combat, a GameData and GameView is essential for it to work. 
	 * It is designed to use classes that implement the GameView and GameData interfaces
	 * @param data a game dataset
	 * @param view a game view
	 */
	public CombatEngine(GameData data,
            GameView view) {
		this.data = data;
		this.view = view;
	}
	
	/**
	 * Before every quest, active knights are assigned random fortunes (GameData#getRandomFortune(). Once an a fortune is assigned 
	 * to each active knight, call GameView#printFortunes(List) )
	 */
	public void initialize() {
		// active knights are assigned random fortunes
		for( Knight kt : data.getActiveKnights()) {
			kt.setActiveFortune(data.getRandomFortune());
		}
		// call printFortunes
		view.printFortunes(data.getActiveKnights());
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
		
		List<Knight> activeknights = data.getActiveKnights();
	
		boolean continueQuest = true;
		while(continueQuest) {

			// Generate random list of MOBs
			List<MOB> monsters = data.getRandomMonsters();

			// Print battle text
			view.printBattleText(monsters, activeknights);

			// Run Combat
			while( !activeknights.isEmpty() && !monsters.isEmpty()) {
			
				// Knights attack monsters
				for( Knight kt : activeknights) {
					if (monsters.isEmpty())
						break;
					
					MOB attackMonster = monsters.get(random.nextInt(monsters.size()));
					int hit = calculateHit(kt);
					attackMonster.addDamage(hit);	
					if(attackMonster.getHP() <= 0) {
						monsters.remove(attackMonster);		// Remove defeated MOB			
						view.printBattleText(attackMonster);		// Print dead text
						for( Knight kt1: activeknights )
							kt1.addXP(1);		// Grant 1 xp to every active knight
					}
				}
				
				// Monsters attack Knights
				for (MOB mob : monsters) {
					if (activeknights.isEmpty())
						break;
					
					Knight attackKnight = activeknights.get(random.nextInt(activeknights.size()));
					int hit = calculateHit(mob);
					attackKnight.addDamage(hit);
					if (attackKnight.getHP() <= 0) {
						activeknights.remove(attackKnight);		// Remove defeated MOB			
						view.printBattleText(attackKnight); 	// Print dead text
					}
			
				}
							
			}
	
			// Notify if all knights are dead
			if (activeknights.isEmpty()) {
				view.printDefeated();
				continueQuest = false;
			} 
			else
				continueQuest = view.checkContinue();
		
		}
		
	}
	
	private int calculateHit(MOB object) {
		int D20 = diceSet.roll(DiceType.D20);
		int hitModifier = object.getHitModifier();		// TODO check polymorphism
		if (D20 + hitModifier > object.getArmor()) {
			return diceSet.roll(object.getDamageDie());
		}
		return 0;
	}

	
	/**
	 * Sets all fortunes to null across all knights.
	 * @see Knight#setActiveFortune(Fortune), GameData#getKnights()
	 */
	public void clear() {
		for( Knight kt: data.getKnights()) {
			kt.setActiveFortune(null); // TODO reset damage where?
		}
	}
}
