public class DiceScoreCalculator {
	int[] diceInt;
	public int[] getScored(Die[] dice) {
		diceInt = convertToInt(dice);
		int[] scores = new int[13];
		for (int i = 0; i < 6; i++) {
			scores[i] = intScore(i+1);
		}
		scores[6] = 
		
		
	}
	
	public int intScore(int i) {
		int g = 0;
		for (int n = 0; n < 5; n++) {
			if (diceInt[n] == i) {
				g++;
			}
		}
		return g*i;
	}
	
	private int[] convertToInt(Die[] dice) {
		int[] newDies = new int[5];
		for (int i = 0; i < dice.length; i++) {
			diceInt[i] = dice[i].getDieValue();
		}
		return newDies;
	}
	
	private int threeScore() {
		for (int i = 1; i <=6; i++) {
			diceInt
		}		
		
		return ;
	}
	
	
}
