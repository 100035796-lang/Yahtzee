import java.util.Scanner;

public class YahtzeeGame {
	private YahtzeeDice dice;
	private int[] rollSpecificDie;
	
	public YahtzeeGame() {
		dice = new YahtzeeDice();
	}
	
	public void startGame() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Yahtzee with Bill");
		int rolls = 0;
		final int MAX_ROLLS = 3;
		boolean keepRolling = true;
		
		rollSpecificDie = new int[] {0,0,0,0,0};

		while (keepRolling && rolls < MAX_ROLLS)	 {
			rolls++;
			int total = dice.roll(rollSpecificDie);
			System.out.println("\nRoll #" + rolls + ":");
			System.out.println(dice.toString());
			System.out.println("You have rolled a total of: " + total);
			System.out.println("You have " + (MAX_ROLLS - rolls) + " rolls left");
			
			if (rolls < MAX_ROLLS) {
				System.out.println("Would you like to roll again? Type y for yes and n for no.");
				String response = sc.nextLine().trim().toLowerCase();
				
				if (!response.equals("y")) {
					keepRolling = false;
			} else {
				for (int i = 1; i < 6; i++) {
					System.out.println("Do you want to save dice number "+i+"? (y/n)");
					String ifsave = sc.nextLine().trim().toLowerCase();
					if (ifsave.equals("y")) {
						rollSpecificDie[i-1] = 1;
					} else {
						rollSpecificDie[i-1] = 0;
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
	}
	
	public Die[] getDice() {
		return dice.getDice();
	}
}
