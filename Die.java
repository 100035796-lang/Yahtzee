
public class Die {
	private int numSides;
	private int dieValue;
	
	public Die () {
		numSides = 6;
		roll();
	}
	
	public Die (int numSides) {
		this.numSides = numSides;
		roll();
	}

	public Die (int numSides, int value) {
		this.numSides = numSides;
		this.dieValue = value;
	}
	
	public void roll() {
		dieValue = (int) (Math.random() * numSides)+1;
	}

	/**
	 * @return the numSides
	 */
	public int getNumSides() {
		return numSides;
	}

	/**
	 * @param numSides the numSides to set
	 */
	public void setNumSides(int numSides) {
		this.numSides = numSides;
	}

	/**
	 * @return the value
	 */
	public int getDieValue() {
		return dieValue;
	}

	/**
	 * @param value the value to set
	 */
	public void setDieValue(int value) {
		this.dieValue = value;
	}
	
	public String toString() {
		return "# Sides: " + numSides + "   Die Value: "+dieValue;
				
	}
	

	
	
	
	
	
	
	
	
	
	
}
