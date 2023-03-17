package com.oracle.conversor;

import com.oracle.conversor.models.Longitud;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MagnitudesController implements Initializable {
    @FXML
    private BorderPane scenePane;
    @FXML
    private ChoiceBox<String> choiceUnit1;
    @FXML
    private ChoiceBox<String> choiceUnit2;
    @FXML
    private TextField textCantInitial;
    @FXML
    private Label labelResultado;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private String[] subString;
    private String firstUnit, secondUnit;
    private double quantity, conversionValue, total;

    public void switchToDivisas(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("conversor-view.fxml"));
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage = (Stage) scenePane.getScene().getWindow();
        stage.setScene(scene);
        stage.toFront();
        stage.show();
    }

    public void exitAplication(ActionEvent actionEvent) {
        stage = (Stage) scenePane.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (String key : Longitud.measurementUnits.keySet()) {
            String value = Longitud.measurementUnits.get(key);
            choiceUnit1.getItems().add(key + " - " + value);
            choiceUnit2.getItems().add(key + " - " + value);
        }
    }

    public void exchangeValues(ActionEvent actionEvent) {
        String currency = choiceUnit2.getValue();
        choiceUnit2.setValue(choiceUnit1.getValue());
        choiceUnit1.setValue(currency);
    }

    public void calcularValue(ActionEvent actionEvent) {
        subString = choiceUnit1.getValue().split(" ");
        firstUnit = subString[0];
        subString = choiceUnit2.getValue().split(" ");
        secondUnit = subString[0];
        try {
            quantity = Float.parseFloat(textCantInitial.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Ingresar sólo números");
            alert.showAndWait();
        }
        conversionValue = Longitud.equivalencies.get(firstUnit + "-" + secondUnit);
        System.out.println(conversionValue);
        total = quantity * conversionValue;
        labelResultado.setText("  " + String.valueOf(total));
    }
}
