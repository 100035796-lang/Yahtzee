import java.util.Arrays;

public class DiceScoreCalculator {
	private int[] diceInt;
	public int[] getScored(Die[] dice) {
		diceInt = convertToInt(dice);
		Arrays.sort(diceInt);
		int[] scores = new int[13];
		for (int i = 0; i < 6; i++) {
			scores[i] = intScore(i+1);
		}
		scores[6] = threeOfAKind();
		scores[7] = fourOfAKind();
		scores[8] = fullHouse();
		scores[9] = smallStraight();
		scores[10] = largeStraight();
		scores[11] = yahtzeepoints();
		scores[12] = chance();
		
		return scores;
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
	
	private int threeOfAKind() {
		for (int i = 1; i <= 6; i++) {
			if (count(i) >= 3) return sum();
		}
		return 0;
	}
	
	private int fourOfAKind() {
		for (int i = 1; i <= 6; i++) {
			if (count(i) >= 4) return sum();
		}
		return 0;
	}
	
	private int fullHouse() {
		boolean hasThree = false;
		boolean hasTwo = false;
		for (int i = 1; i <= 6; i++) {
			int c = count(i);
			if (c == 3) hasThree = true;
			if (c == 2) hasTwo = true;
		}
		return (hasThree && hasTwo) ? 25 : 0;
	}
	
	private int largeStraight() {
		int[] longs = {12345, 23456};
		String diceString = Arrays.toString(Arrays.stream(diceInt).distinct().toArray());
		String digits = diceString.replaceAll("[^0-9]", "");
		for (int s : longs) {
			if (digits.contains(String.valueOf(s))) return 40;
		}
		return 0;
		
	}
	
	private int smallStraight() {
		int[] straights = {1234, 2345, 3456};
		String diceString = Arrays.toString(Arrays.stream(diceInt).distinct().toArray());
		String digits = diceString.replaceAll("[^0-9]", "");
		for (int s : straights) {
			if (digits.contains(String.valueOf(s))) return 30;
		}
		return 0;
		
	}
	
	private int yahtzeepoints() {
		for (int i = 1; i <= 6; i++) {
			if (count(i) == 5) return 50;
		}
		return 0;
	}
	
	private int chance() {
		return sum();
	}
	
	private int count(int value) {
	    int c = 0;
	    for (int die : diceInt) {
	        if (die == value)
	            c++;
	    }
	    return c;
	}

	private int sum() {
		int s = 0;
		for (int die : diceInt) {
			s += die;
		}
		return s;
	}

	private int[] convertToInt(Die[] dice) {
	    int[] newDies = new int[dice.length];
	    for (int i = 0; i < dice.length; i++) {
	        newDies[i] = dice[i].getDieValue();
	    }
	    return newDies;
	}

	
	
	
}
