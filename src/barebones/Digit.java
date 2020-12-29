package barebones;

public class Digit implements InputElement{
	private int digitValue;
	
	public Digit(int value) {
		digitValue = value;
	}
	
	public int getValue() {
		return digitValue;
	}

}
