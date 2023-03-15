module com.oracle.conversor {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;
    requires org.json;


    opens com.oracle.conversor to javafx.fxml;
    exports com.oracle.conversor;
}