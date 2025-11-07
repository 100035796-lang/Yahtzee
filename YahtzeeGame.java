import java.util.Arrays;
import java.util.Scanner;

public class YahtzeeGame {
	private YahtzeeDice dice;
	private int[] rollSpecificDie;
	private boolean[] chosen = new boolean[]{false, false, false, false, false, false, false, false, false, false, false, false, false};
	Scanner sc;
	
	public YahtzeeGame() {
		dice = new YahtzeeDice();
	}
	
	public void startGame() {
		sc = new Scanner(System.in);
		System.out.println("Welcome to Yahtzee with Bill");
		
		
		for (int i = 0; i < 13; i++) {
			int rolls = 0;
			final int MAX_ROLLS = 3;
			boolean keepRolling = true;
			
			rollSpecificDie = new int[] {0,0,0,0,0};
			
			while (keepRolling && rolls < MAX_ROLLS)	 {
				rolls++;
				int total = dice.roll(rollSpecificDie);
				System.out.println("\nRoll #" + rolls + ":");
				System.out.println(dice.toString());
				System.out.println(Arrays.toString(DiceScoreCalculator.getScored(dice.getDice())));
				System.out.println("You have rolled a total of: " + total);
				System.out.println("You have " + (MAX_ROLLS - rolls) + " rolls left");
				
				if (rolls < MAX_ROLLS) {
					System.out.println("Would you like to roll again? Type y for yes and n for no.");
					String response = sc.nextLine().trim().toLowerCase();
					
					if (!response.equals("y")) {
						keepRolling = false;
				} else {
					for (int u = 1; u < 6; u++) {
						System.out.println("Do you want to save dice number "+u+"? (y/n)");
						String ifsave = sc.nextLine().trim().toLowerCase();
						if (ifsave.equals("y")) {
							rollSpecificDie[u-1] = 1;
						} else {
							rollSpecificDie[u-1] = 0;
						}
				}
				}
					} else {
						System.out.println("No rolls left. Thanks for playing!");
				}
			}
			System.out.println("\nFinal dice:");
			System.out.println(dice.toString());
			System.out.println("Thanks for playing!");
			int[] scores = DiceScoreCalculator.getScored(dice.getDice());
			System.out.println(Arrays.toString(scores));
			System.out.println(playerChooseScore(scores));
		}
	}
		
	
	public Die[] getDice() {
		return dice.getDice();
	}
	
	public int playerChooseScore(int[] scores) {
		int response;
		do {
			System.out.println("Please enter which score you want to claim between 1 and 13");
			response = sc.nextInt() - 1;
		} while (!(response>=0 && response<13 && !chosen[response]));
		
		return scores[response];
	}
}
