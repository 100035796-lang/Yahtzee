public class YahtzeeDice {

	// member variable: static
	public static final int NUM_OF_DICE = 5; 

	// member variable: non-static (instance variable, each BuggyYahtzeeDice object has own copy)
	// Declare instance variable 'dice', which will point to an
	// array of Die objects.  
	private Die[] dice; 


	// Constructors: 2 different overloaded ones.
	// Each forgot to do something.
	// ***(1) What did I forget here?  What is the consequence?
	public YahtzeeDice() {  
		dice = new Die[NUM_OF_DICE];
		for(int i = 0; i < NUM_OF_DICE; i++) {
			dice[i] = new Die(); 
		}
	}

	// ***(2) What did I forget here?  What is the consequence?
	public YahtzeeDice(int numSides) {
		dice = new Die[NUM_OF_DICE];
		for(int i = 0; i < NUM_OF_DICE; i++) {
			dice[i] = new Die(numSides); 
		}
	}

	// main can be inside the same class.
	// notice that we can create YahtzeeDice objects inside the 
	// main() of the YahtzeeDice class.
//	public static void main(String[] args) {
//
//		// ***(3) What's wrong here?
////		roll();
////		roll();
//
//		// Declare 2 different BuggyYahtzeeDice objects.  Call the 2 different constructors.
//		YahtzeeDice sixSidedQuintetOfDice = new YahtzeeDice();
//		YahtzeeDice twelveSidedQuintetOfDice = new YahtzeeDice(12);
//
//		System.out.println("Test rolling of default yahtzee dice: " + sixSidedQuintetOfDice.roll());
//		System.out.println("Test .toString() of default yahtzee dice: " + sixSidedQuintetOfDice);
//		System.out.println("Test getDiceValues of default yahtzee dice: ");
//		for(int i = 0; i < 5; i++) {
//			System.out.print(sixSidedQuintetOfDice.getDiceValues()[i] + ", ");
//		}
//
//		System.out.println("Test rolling of 12-sided yahtzee dice: " + twelveSidedQuintetOfDice.roll());
//		System.out.println("Test .toString() of 12-sided yahtzee dice: " + twelveSidedQuintetOfDice);
//		System.out.println("Test getDiceValues of 12-sided yahtzee dice: ");
//		for(int i = 0; i < 5; i++) {
//			System.out.print(twelveSidedQuintetOfDice.getDiceValues()[i] + ", ");
//		}
//
//
//	}

	//rolls all 5 dice and returns the total of the dice
	public int roll(int[] rollSpecificDie) { 
		int sum = 0;
		for (int i = 0; i < dice.length; i++) {
			if (rollSpecificDie[i] == 0) {
				dice[i].roll();
				sum += dice[i].getDieValue();
			}
		}

//		sum += (int)(Math.random()*6) + 1;
//		sum += (int)(Math.random()*6) + 1;
//		sum += (int)(Math.random()*6) + 1;
//		sum += (int)(Math.random()*6) + 1;
//		sum += (int)(Math.random()*6) + 1;

		return sum; // ***(4) Design-wise, what would be wrong if we did it like this?
	}

	//returns the dice array
	public Die[] getDice() {  
		return dice;
	}

	//returns an int[] containing the values of the 5 dice
	public int[] getDiceValues() {  
		int[] diceValues = new int[NUM_OF_DICE];
		for(int i = 0; i < dice.length; i++) {
			diceValues[i] = dice[i].getDieValue();  	// ***(5) What's wrong here?
		}
		return diceValues;
	}

	//returns a String representation of the object
	public String toString() {
		String yahtzee = "The " + NUM_OF_DICE + " dice read: ";

		for(int i = 0; i < dice.length; i++) {
			if(i < dice.length - 1)	
				yahtzee += dice[i].getDieValue() + ", ";
			else
				yahtzee += dice[i].getDieValue() + ".";
		}
		return yahtzee;
	}

}