import java.util.Arrays;

public class DiceScoreCalculator {
	public static int[] getScored(Die[] dice) {
		int[] diceInt = convertToInt(dice);
		Arrays.sort(diceInt);
		int[] scores = new int[13];
		for (int i = 0; i < 6; i++) {
			scores[i] = intScore(i+1,diceInt);
		}
		scores[6] = threeOfAKind(diceInt);
		scores[7] = fourOfAKind(diceInt);
		scores[8] = fullHouse(diceInt);
		scores[9] = smallStraight(diceInt);
		scores[10] = largeStraight(diceInt);
		scores[11] = chance(diceInt);
		scores[12] = yahtzeepoints(diceInt);
		
		return scores;
	}
	
	public static int intScore(int i, int[] diceInt) {
		int g = 0;
		for (int n = 0; n < 5; n++) {
			if (diceInt[n] == i) {
				g++;
			}
		}
		return g*i;
	}
	
	private static int threeOfAKind(int[] diceInt) {
		for (int i = 1; i <= 6; i++) {
			if (count(i, diceInt) >= 3) return sum(diceInt);
		}
		return 0;
	}
	
	private static int fourOfAKind(int[] diceInt) {
		for (int i = 1; i <= 6; i++) {
			if (count(i, diceInt) >= 4) return sum(diceInt);
		}
		return 0;
	}
	
	private static int fullHouse(int[] diceInt) {
		boolean hasThree = false;
		boolean hasTwo = false;
		for (int i = 1; i <= 6; i++) {
			int c = count(i, diceInt);
			if (c == 3) hasThree = true;
			if (c == 2) hasTwo = true;
		}
		return (hasThree && hasTwo) ? 25 : 0;
	}
	
	private static int largeStraight(int[] diceInt) {
		int[] longs = {12345, 23456};
		String diceString = Arrays.toString(Arrays.stream(diceInt).distinct().toArray());
		String digits = diceString.replaceAll("[^0-9]", "");
		for (int s : longs) {
			if (digits.contains(String.valueOf(s))) return 40;
		}
		return 0;
		
	}
	
	private static int smallStraight(int[] diceInt) {
		int[] straights = {1234, 2345, 3456};
		String diceString = Arrays.toString(Arrays.stream(diceInt).distinct().toArray());
		String digits = diceString.replaceAll("[^0-9]", "");
		for (int s : straights) {
			if (digits.contains(String.valueOf(s))) return 30;
		}
		return 0;
		
	}
	
	private static int yahtzeepoints(int[] diceInt) {
		for (int i = 1; i <= 6; i++) {
			if (count(i, diceInt) == 5) return 50;
		}
		return 0;
	}
	
	private static int chance(int[] diceInt) {
		return sum(diceInt);
	}
	
	private static int count(int value, int[] diceInt) {
	    int c = 0;
	    for (int die : diceInt) {
	        if (die == value)
	            c++;
	    }
	    return c;
	}

	private static int sum(int[] diceInt) {
		int s = 0;
		for (int die : diceInt) {
			s += die;
		}
		return s;
	}

	private static int[] convertToInt(Die[] dice) {
	    int[] newDies = new int[dice.length];
	    for (int i = 0; i < dice.length; i++) {
	        newDies[i] = dice[i].getDieValue();
	    }
	    return newDies;
	}

}
