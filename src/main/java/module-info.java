module com.oracle.conversor {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;


    opens com.oracle.conversor to javafx.fxml;
    exports com.oracle.conversor;
}