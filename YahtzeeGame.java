import java.util.Scanner;

public class YahtzeeGame {
	private YahtzeeDice dice;
	private int[] rollSpecificDie;
	public YahtzeeGame() {
		dice = new YahtzeeDice();
	}
	
	public void startGame() {
		TextIO.putln("Welcome to Yahtzee with Bill");
		int rolls = 0;
		final int MAX_ROLLS = 3;
		boolean keepRolling = true;
		
		rollSpecificDie = new int[] {0,0,0,0,0};

		while (keepRolling && rolls < MAX_ROLLS)	 {
			rolls++;
			int total = dice.roll(rollSpecificDie);
			TextIO.putln("\nRoll #" + rolls + ":");
			TextIO.putln(dice.toString());
			TextIO.putln("You have rolled a total of: " + total);
			TextIO.putln("You have " + (MAX_ROLLS - rolls) + " rolls left");
			
			if (rolls < MAX_ROLLS) {
				TextIO.putln("Would you like to roll again? Type y for yes and n for no.");
				String response = TextIO.getlnString().trim().toLowerCase();
				if (!response.equals("y")) {
					keepRolling = false;
				}
			} else {
				TextIO.putln("No rolls remaining. Turn finished.");
			}
			for (int i = 1; i < 6; i++) {
				System.out.println("Do you want to save dice number "+i+"? (y/n)");
				if (TextIO.getAnyChar() == 'y') {
					rollSpecificDie[i-1] = 1;
				} else {
					rollSpecificDie[i-1] = 0;
				}
				
			}
		}
		TextIO.putln("\nFinal dice:");
		TextIO.putln(dice.toString());
		TextIO.putln("Thanks for playing!");
	}
	
	public Die[] getDice() {
		return dice.getDice();
	}
}
