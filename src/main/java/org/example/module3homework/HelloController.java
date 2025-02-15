package org.example.module3homework;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class HelloController {
    @FXML
    private TextField interestRate;

    @FXML
    private TextField numYears;

    @FXML
    private TextField loanAmount;

    @FXML
    private Label monthlyPaymentOutput ;

    @FXML
    private Label totalPaymentOutput;

    @FXML
    private Label warningText;

    private void calculateOutput() {
        String rate = interestRate.getText();
        String years = numYears.getText();
        String amount = loanAmount.getText();

        try {
            double rateDouble = (Double.parseDouble(rate))/100;
            int yearsDouble = Integer.parseInt(years);
            double loanAmount = Double.parseDouble(amount);


            double monthlyPayment = (loanAmount * rateDouble / 12) / (1 - Math.pow(1 + rateDouble/ 12, -1 * 12 * yearsDouble));
            double totalAmount = 12 * yearsDouble * monthlyPayment;

            monthlyPaymentOutput.setText(String.format("$%.2f", monthlyPayment));
            totalPaymentOutput.setText(String.format("$%.2f", totalAmount));
        }
        catch (NumberFormatException e) {
            warningText.setText("Invalid Input!");
        }
    }

    @FXML
    protected void onHelloButtonClick() {
        //welcomeText.setText("Welcome to JavaFX Application!");
        calculateOutput();
    }
}