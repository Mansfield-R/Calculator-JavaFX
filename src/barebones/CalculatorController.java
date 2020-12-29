package barebones;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.ResourceBundle;

public class CalculatorController implements Initializable {

	@FXML
	private Button equals;

	@FXML
	private Button add;

	@FXML
	private Button subtract;

	@FXML
	private Button multiply;

	@FXML
	private Button divide;

	@FXML
	private Button clear;

	@FXML
	private Button delete;

	@FXML
	private Button negative;

	@FXML
	private Button zero;

	@FXML
	private Button one;

	@FXML
	private Button two;

	@FXML
	private Button three;

	@FXML
	private Button four;

	@FXML
	private Button five;

	@FXML
	private Button six;

	@FXML
	private Button seven;

	@FXML
	private Button eight;

	@FXML
	private Button nine;

	@FXML
	private Button dot;

	private Button selectedOp;

	private StringBuilder currentDisplayValue;

	@FXML
	private TextField display;

	private HashMap<Button, InputElement> buttonValueMap = new HashMap<Button, InputElement>();

	private CalculatorModel calc = new CalculatorModel();

	@FXML
	public void handleNumbers(ActionEvent actionEvent) {
		currentDisplayValue.append(calc.pushToNextOp(buttonValueMap.get(actionEvent.getSource())));
		display.setText(currentDisplayValue.toString());
	}

	@FXML
	public void handleOpActions(ActionEvent event) {
		Button source = (Button) event.getSource();

		if (source == equals) {
			if (selectedOp != null) {
				if (selectedOp == add) {
					calc.add();
				} else if (selectedOp == subtract) {
					calc.subtract();
				} else if (selectedOp == multiply) {
					calc.multiply();
				} else if (selectedOp == divide) {
					calc.divide();
				}
				currentDisplayValue = new StringBuilder();
				currentDisplayValue.append(calc.getCurValue());
				display.setText(currentDisplayValue.toString());
			}
		} else if (source == negative) {
			calc.handleIfFirstInput();
			calc.negate();
			currentDisplayValue = new StringBuilder();
			currentDisplayValue.append(calc.getCurValue());
			display.setText(currentDisplayValue.toString());
		} else {
			selectedOp = source;
			calc.handleIfFirstInput();
			display.setText(currentDisplayValue.toString());
			currentDisplayValue = new StringBuilder();
		}
	}

	@FXML
	public void handleClear() {
		calc.clear();
		currentDisplayValue = new StringBuilder();
		display.setText("0");
	}

	@FXML
	public void handleDelete() {
		try {
			calc.popFromNextOp();
			currentDisplayValue.deleteCharAt(currentDisplayValue.length() - 1);
			display.setText(currentDisplayValue.toString());
		} catch (EmptyStackException ese) {
			// pass
		}
	}

	@FXML
	public void getFormattedText() {
//    	calc.curValueIsInt();
//        textField.setTextFormatter(textFormatter);
	}

	// Delete Button Functionality; Pass in the text field use string builder to
	// manipulate.
	@FXML
	public void deleteFunctionality(TextField textField) {
		// Pass the text in the field to string builder:
		StringBuilder str = new StringBuilder(textField.getText());
		// As long as there is something in the string, delete the last character in the
		// string.
		if (str.length() != 0) {
			str.deleteCharAt((str.length() - 1));
			String newText = str.toString();
			textField.setText(newText);
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		buttonValueMap.put(zero, new Digit(0));
		buttonValueMap.put(one, new Digit(1));
		buttonValueMap.put(two, new Digit(2));
		buttonValueMap.put(three, new Digit(3));
		buttonValueMap.put(four, new Digit(4));
		buttonValueMap.put(five, new Digit(5));
		buttonValueMap.put(six, new Digit(6));
		buttonValueMap.put(seven, new Digit(7));
		buttonValueMap.put(eight, new Digit(8));
		buttonValueMap.put(nine, new Digit(9));
		buttonValueMap.put(dot, new Decimal());

		currentDisplayValue = new StringBuilder();

		display.setText("0");
	}

//    TextFormatter<Double> textFormatter = new TextFormatter<>(converter, 0.0, filter);

//    Pattern validEditingState = Pattern.compile("-?(([1-9][0-9]*)|0)?(\\.[0-9]*)?");
//
//    UnaryOperator<TextFormatter.Change> filter = c -> {
//        String text = c.getControlNewText();
//        if (validEditingState.matcher(text).matches()) {
//            return c ;
//        } else {
//            return null ;
//        }
//    };
//
//    StringConverter<Double> converter = new StringConverter<Double>() {
//
//        @Override
//        public Double fromString(String s) {
//            if (s.isEmpty() || "-".equals(s) || ".".equals(s) || "-.".equals(s)) {
//                return 0.0 ;
//            } else {
//                return Double.valueOf(s);
//            }
//        }
//
//
//        @Override
//        public String toString(Double d) {
//            return d.toString();
//        }
//    };

}
