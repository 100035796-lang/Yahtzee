
public class YahtzeeGame {
	private YahtzeeDice dice;
	
	public YahtzeeGame() {
		dice = new YahtzeeDice();
	}
	
	public void startGame() {
		TextIO.putln("Welcome to Yahtzee with Bill");
		int rolls = 0;
		final int MAX_ROLLS = 3;
		boolean keepRolling = true;
		
		while (keepRolling && rolls < MAX_ROLLS)	 {
			rolls++;
			int total = dice.roll();
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
		}
		TextIO.putln("\nFinal dice:");
		TextIO.putln(dice.toString());
		TextIO.putln("Thanks for playing!");
	}
}
