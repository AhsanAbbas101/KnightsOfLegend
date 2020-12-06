
import java.util.Random;

/**
 * A simple class that handles rolling of Dice.
 * 
 */
public class DiceSet {

	private Random rand;
	
	public DiceSet() {
		rand = new Random();
	}
	
	/**
	 * Rolls a dice based on DiceType. D4 means 1-4, D6 means 1-6, and so on until D20 means 1-20. 
	 * Always returns whole numbers between 1 and DiceType
	 * @param diceType the DiceType to roll n
	 * @return an int value between 1 and DiceType/sides
	 */
	public int roll(DiceType diceType) {
		
		int min = 1;
		int max ; 
		switch(diceType) {
			case D4:
				max = 4;break;
			case D6:
				max = 6;break;
			case D8:
				max = 8;break;
			case D10:
				max = 10;break;
			case D12:
				max = 12;break;
			case D20:
				max = 20;break;
			default:
				max = 4;
		}
		
		return rand.nextInt((max - min) + 1) + min;
	
	}
}
