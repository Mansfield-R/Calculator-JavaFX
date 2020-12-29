package barebones;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CalculatorController implements Initializable {

    @FXML
    private Button dot;

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
    private TextField display;


    @FXML
    public void handleNumbers(ActionEvent actionEvent) {
        String number = ((Button)actionEvent.getSource()).getText();
        display.setText(display.getText() + number);
    }

    @FXML
    public void handleButtonAction(ActionEvent event) {
//
//        // Create if statements for inputs:
//        if (event.getSource() == zero) {
//            display.setText(display.getText() + "0");
//        } else if (event.getSource() == one) {
//            display.setText(display.getText() + "1");
//        } else if (event.getSource() == two) {
//            display.setText(display.getText() + "2");
//        } else if (event.getSource() == three) {
//            display.setText(display.getText() + "3");
//        } else if (event.getSource() == four) {
//            display.setText(display.getText() + "4");
//        } else if (event.getSource() == five) {
//            display.setText(display.getText() + "5");
//        } else if (event.getSource() == six) {
//            display.setText(display.getText() + "6");
//        } else if (event.getSource() == seven) {
//            display.setText(display.getText() + "7");
//        } else if (event.getSource() == eight) {
//            display.setText(display.getText() + "8");
//        } else if (event.getSource() == nine) {
//            display.setText(display.getText() + "9");
//        } else if (event.getSource() == dot) {
//            // Check for decimal place already cannot add more than one:
//            if (!hasOneDecimal(display)) {
//                display.setText(display.getText() + ".");
//            }
//        } else if (event.getSource() == add) {
//            // Store current input into memory:
//            this.operand = parseDisplayTextForDouble(display);
//            // Addition Operator set to 1:
//            this.operator = 1;
//            // Clear display for new input:
//            display.setText("");
//        } else if (event.getSource() == subtract) {
//            this.operand = parseDisplayTextForDouble(display);
//            this.operator = 2;
//            display.setText("");
//        } else if (event.getSource() == multiply) {
//            this.operand = parseDisplayTextForDouble(display);
//            this.operator = 3;
//            display.setText("");
//        } else if (event.getSource() == divide) {
//            this.operand = parseDisplayTextForDouble(display);
//            this.operator = 4;
//            display.setText("");
//        } else if (event.getSource() == equals) {
//            double secondOperand = Double.parseDouble(display.getText());
//            // Switch case for operating:
//            switch (operator) {
//                // Addition
//                case 1:
//                    double additionAnswer = operand + secondOperand;
//                    display.setText(String.valueOf(additionAnswer));
//                    // Subtraction
//                case 2:
//                    double subtractionAnswer = operand - secondOperand;
//                    display.setText(String.valueOf(subtractionAnswer));
//                    // Multiplication
//                case 3:
//                    double multiplicationAnswer = operand * secondOperand;
//                    display.setText(String.valueOf(multiplicationAnswer));
//                    // Division
//                case 4:
//                    if (secondOperand == 0) {
//                        display.setText("Cannot divide by Zero");
//                    } else {
//                        double divisionAnswer = operand / secondOperand;
//                        display.setText(String.valueOf(divisionAnswer));
//                    }
//            }
//        } else if (event.getSource() == clear) {
//            display.clear();
//        } else if (event.getSource() == delete) {
//            // Call method that uses String builder to delete last character:
//            deleteFunctionality(display);
//        }
    }

    @FXML
    public boolean hasOneDecimal(TextField textField) {
        return textField.getText().contains(".");
    }

//    @FXML
//    public void applyTextFormatter(TextField textField) {
//        textField.setTextFormatter(textFormatter);
//    }

    @FXML
    public Double parseDisplayTextForDouble(TextField textField) {
        return Double.parseDouble(textField.getText());
    }

    // Delete Button Functionality; Pass in the text field use string builder to manipulate.
    @FXML
    public void deleteFunctionality(TextField textField) {
        // Pass the text in the field to string builder:
        StringBuilder str = new StringBuilder(textField.getText());
        // As long as there is something in the string, delete the last character in the string.
        if (str.length() != 0) {
            str.deleteCharAt((str.length() - 1));
            String newText = str.toString();
            textField.setText(newText);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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
