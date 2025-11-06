
public class PairOfDice {
	int numSides;
	int valueOfDice;
	private Die d1;
	private Die d2;
	
	public PairOfDice() {
		d1 = new Die();
		d2 = new Die();
	//	valueOfDice = d1.getdieValue() + d2.getdieValue();
		roll();
	}
	public PairOfDice(int numSides) {
		this.numSides = numSides;
		d1 = new Die(numSides);
		d2 = new Die(numSides);
		roll();
	}
	public void roll() {
		d1.roll();
		d2.roll();
		valueOfDice = d1.getdieValue() + d2.getdieValue();
	}
	
	public Die[] getDice() {
		Die[] dice = new Die[] {d1,d2};
		return dice;
	}
	
	public int[] getDiceValues() {
		int[] diceValues = new int[] {d1.getdieValue(),d2.getdieValue()};
		return diceValues;
	}
	
	public String toString() {
		return d1.toString() + "   ,   " + d2.toString();
	}
}
