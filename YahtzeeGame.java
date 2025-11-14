import java.util.Arrays;
import java.util.Scanner;

public class YahtzeeGame {
	private YahtzeeDice dice;
	private int[] rollSpecificDie;
	private boolean[] chosen = new boolean[]{false, false, false, false, false, false, false, false, false, false, false, false, false};
	private int[] totalScores = new int[13];
	private int roundNumber = 1;
	Scanner sc;
	
	public YahtzeeGame() {
		dice = new YahtzeeDice();
	}
	
	public void startGame() {
		sc = new Scanner(System.in);
		System.out.println("Welcome to Yahtzee with Bill");
		for (int i = 0; i < 13; i++) {
			
			playRound();
		}
		
		System.out.println("The game is now finished!");
		System.out.println("Here is your final scoreboard.");
		displayScoreboard();
		
		int total = Arrays.stream(totalScores).sum();
		System.out.println("Final Total Score: " + total);
		System.out.println("Thanks for playing!");
	}
		

		
			
	
	public void playRound() {
		int rolls = 0;
			final int MAX_ROLLS = 3;
			boolean keepRolling = true;
			
			rollSpecificDie = new int[] {0,0,0,0,0};
			
			while (keepRolling && rolls < MAX_ROLLS)	 {
				rolls++;
				int total = dice.roll(rollSpecificDie);
				System.out.println("\nRound #" + roundNumber + ":");
				System.out.println("Roll #" + rolls + ":");
				System.out.println(dice.toString());
				System.out.println("Now displaying scores for Ones, Twos, Threes, Fours, Fives,");
				System.out.println("Sixes, Three of a Kind, Four of a Kind, Full House,");
				System.out.println("Small Straight, Large Straight, Chance, and Yahtzee. In that order.");
				System.out.println("[1s 2s 3s 4s 5s 6s 3k 4k FH SS LS Ch Yz]");
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
						System.out.println("No rolls left.");
				}
			}
			System.out.println("\nFinal dice/score:");
			System.out.println(dice.toString());
			System.out.println("[1s 2s 3s 4s 5s 6s 3k 4k FH SS LS Ch Yz]");
			System.out.println(Arrays.toString(DiceScoreCalculator.getScored(dice.getDice())));
			int[] scores = DiceScoreCalculator.getScored(dice.getDice());
			displayScoreboard();
			
			int chosenScore = playerChooseScore(scores);
			roundNumber++;
			System.out.println("You scored " + chosenScore + " points this round");
			System.out.println("Round Over. Bill wil now attempt to beat you up!");
			System.out.println("Whoops! Bill died!");
			billDisaster();
			System.out.println("Don't worry though! He's still willing to play with you!");
			System.out.println("✧ദ്ദി( ˶^ᗜ^˶ )");
			System.out.println(Arrays.toString(scores));
	}	
	
	public Die[] getDice() {
		return dice.getDice();
	}
	
	public int playerChooseScore(int[] scores) {
		int response;
		do {
			System.out.println("Please enter which score you want to claim between 1 and 13");
			response = sc.nextInt() - 1;
			sc.nextLine();
		} while (!(response>=0 && response<13 && !chosen[response]));
		
		chosen[response] = true;
		totalScores[response] = scores[response];
		return scores[response];
	}

    public void displayScoreboard() {
        System.out.println("\nCurrent Scoreboard:");
        System.out.println("[1s 2s 3s 4s 5s 6s 3k 4k FH SS LS Ch Yz]");
        System.out.println(Arrays.toString(totalScores));
    }

    public void displayChosen() {
        System.out.print("Chosen categories: ");
        for (int i = 0; i < chosen.length; i++) {
            if (chosen[i]) System.out.print((i + 1) + " ");
        }
        System.out.println();
    }
	
	public void billDisaster() {
		int sad = (int)(Math.random()*10+1);
		switch (sad) {
		case 1:
			System.out.println("Bill got involved in a car crash on the Rodoviao dos Imigrantes Highway!");
			break;
		case 2:
			System.out.println("Bill beat Kabir eight times in a row and Kabir killed him! :(");
			break;
		case 3:
			System.out.println("Bill tried to light a big balloon on fire. It didn't work out!");
			break;
		case 4: 
			System.out.println("Bill thought he was Walter White and attemted to drink hydrochloric acid!");
			break;
		case 5:
			System.out.println("Bill accidentally slipped on a banana and fell to his death!");
			break;
		case 6:
			System.out.println("Bill had severe allergies to pollen and accidentally sniffed a dandelion!");
			break;
		case 7:
			System.out.println("Bill told a terrible joke at a bar and the collective light reflected");
			System.out.println("from the eyerolls fried him!");
			break;
		case 8:
			System.out.println("Bill won a single gamble at a casino and bragged so much his ego inflated");
			System.out.println("and he floated away!");
			break;
		case 9:
			System.out.println("Bill microwaved a spoon with his cereal and ended up killing himself!");
			break;
		case 10:
			System.out.println("Bill claimed that he was \"too cool\" to hang out with his friends and");
			System.out.println("spontaneously turned into an ice statue!");
			break;
		}
	}
}
