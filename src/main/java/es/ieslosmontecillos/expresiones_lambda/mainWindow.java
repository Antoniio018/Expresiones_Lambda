package es.ieslosmontecillos.expresiones_lambda;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.text.DecimalFormat;

public class mainWindow extends Application {
    TextField txtInterestRate = new TextField();
    TextField txtYears = new TextField();
    TextField txtLoan = new TextField();
    TextField txtMonth = new TextField();
    TextField txtTotal = new TextField();


    @Override
    public void start(Stage primaryStage){
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        //Annual Interest Rate
        Label lblInterest = new Label("Annual Interest Rate: ");
        grid.add(lblInterest, 0, 1);

        grid.add(txtInterestRate, 1, 1);

        //Number of Years
        Label lblYears = new Label("Number of Years: ");
        grid.add(lblYears, 0, 2);

        grid.add(txtYears, 1, 2);

        //Loan Amount
        Label lblLoan = new Label("Loan Amount: ");
        grid.add(lblLoan, 0, 3);

        grid.add(txtLoan, 1, 3);

        //Monthly Payment
        Label lblMonth = new Label("Monthly Payment: ");
        grid.add(lblMonth, 0, 4);

        grid.add(txtMonth, 1, 4);

        //Total Payment
        Label lblTotal = new Label("Total Payment: ");
        grid.add(lblTotal, 0, 5);

        grid.add(txtTotal, 1, 5);

        Button btnCalc = new Button("Calculate");
        grid.add(btnCalc, 1, 6);


        btnCalc.setOnAction(e ->{
            calculoCuota();
        });

        Scene scene = new Scene(grid, 320, 240);
        primaryStage.setTitle("Calculadora de Prestamo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void calculoCuota(){
        double monthlyPayment = 0;
        double totalPayment = 0;
        double rForm = 0;
        double loan = Double.parseDouble(txtLoan.getText());
        double years = Double.parseDouble(txtYears.getText());
        double rate = Double.parseDouble(txtInterestRate.getText());
        rForm = rate / (100*12);
        double denForm = Math.pow((1 + rForm),(12 * years));

        monthlyPayment = (loan * rForm) / ( 1 - ( 1 / denForm));
        totalPayment = (monthlyPayment * 12) * years;

        txtMonth.setText("$" + String.format("%.2f",monthlyPayment));
        txtTotal.setText("$" + String.format("%.2f",totalPayment));
    }

    public static void main(String[] args) {
        launch();
    }
}