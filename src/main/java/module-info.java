module es.ieslosmontecillos.expresiones_lambda {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ieslosmontecillos.expresiones_lambda to javafx.fxml;
    exports es.ieslosmontecillos.expresiones_lambda;
}