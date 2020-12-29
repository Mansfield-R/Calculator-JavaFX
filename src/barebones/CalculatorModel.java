package barebones;

import java.util.Stack;

public class CalculatorModel {

	private Double curValue;
	private double nextOp;
	private Stack<InputElement> nextOpStack;

	double scale = Math.pow(10, 10);

	public CalculatorModel() {
		curValue = null;
		nextOp = 0.0;
		nextOpStack = new Stack<InputElement>();
	}

	public void clear() {
		curValue = null;
		nextOp = 0.0;
		nextOpStack = new Stack<InputElement>();
	}

	private void clean() {
		curValue = Math.round(curValue * scale) / scale;
		if(curValue == 0.0)
			curValue = 0.0;
	}

	private void generateNextOpFromStack() {
		StringBuilder nextOpString = new StringBuilder();

		while (!nextOpStack.isEmpty()) {
			InputElement curInputElement = nextOpStack.pop();

			if (curInputElement instanceof Digit) {
				nextOpString.insert(0, ((Digit) curInputElement).getValue());
			} else if (curInputElement instanceof Decimal) {
				nextOpString.insert(0, ".");
			} else if (curInputElement instanceof Negative) {
				nextOpString.insert(0, "-");
			}
		}

		nextOp = Double.parseDouble(nextOpString.toString());
	}

	public void handleIfFirstInput() {
		if (curValue == null) {
			if (nextOpStack.isEmpty()) {
				curValue = 0.0;
			} else {
				generateNextOpFromStack();
				curValue = nextOp;
			}
		}
	}

	public void add() {
		generateNextOpFromStack();
		curValue += nextOp;
		clean();
	}

	public void subtract() {
		generateNextOpFromStack();
		curValue -= nextOp;
		clean();
	}

	public void multiply() {
		generateNextOpFromStack();
		curValue *= nextOp;
		clean();
	}

	public void divide() {
		generateNextOpFromStack();
		if (nextOp == 0.0)
			throw new ArithmeticException("Cannot divide by zero");
		curValue /= nextOp;
		clean();
	}

	public void negate() {
		curValue = curValue * -1.0;
		clean();
	}

	public double getCurValue() {
		return curValue;
	}

	public boolean curValueIsInt() {
		return (Math.floor(curValue) == curValue) || (Math.ceil(curValue) == curValue);
	}

	public void setCurValue(double curValue) {
		this.curValue = curValue;
	}

	public String pushToNextOp(InputElement n) {
		nextOpStack.push(n);

		String rv = null;

		if (n instanceof Digit) {
			rv = ((Digit) n).getValue() + "";
		} else if (n instanceof Decimal) {
			rv = ".";
		}

		return rv;
	}

	public void popFromNextOp() {
		nextOpStack.pop();
	}

	public static void main(String[] args) {
		double x = -0.0;
		if(x == 0.0)
			x = 0.0;
		System.out.println(x);
	}
}
