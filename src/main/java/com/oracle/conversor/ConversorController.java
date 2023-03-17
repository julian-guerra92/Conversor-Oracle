package com.oracle.conversor;

import com.oracle.conversor.api.CurrencyApi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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

public class ConversorController implements Initializable {
    @FXML
    private ChoiceBox<String> choiceCurrency1;
    @FXML
    private ChoiceBox<String> choiceCurrency2;
    @FXML
    private TextField textCantInitial;
    @FXML
    private Label labelResultado;
    @FXML
    private BorderPane scenePane;
    private CurrencyApi currencyApi;
    private String currency, source;
    private float quantity, exchangeRate, total;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public ConversorController() throws IOException, InterruptedException {
        currencyApi = new CurrencyApi();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (String key : currencyApi.getCurrenciesList().keySet()) {
            String value = currencyApi.getCurrenciesList().get(key);
            choiceCurrency1.getItems().add(key + " - " + value);
            choiceCurrency2.getItems().add(key + " - " + value);
        }
    }

    public void calcularValue(ActionEvent actionEvent) throws IOException, InterruptedException {
        source = choiceCurrency1.getValue().substring(0, 3);
        currency = choiceCurrency2.getValue().substring(0, 3);
        try {
            quantity = Float.parseFloat(textCantInitial.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Ingresar sólo números");
            alert.showAndWait();
        }
        exchangeRate = currencyApi.getExchangeRate(currency, source);
        total = quantity * exchangeRate;
        labelResultado.setText("  " + String.format("%.2f", total));
    }

    public void exchangeValues(ActionEvent actionEvent) {
        String currency = choiceCurrency2.getValue();
        choiceCurrency2.setValue(choiceCurrency1.getValue());
        choiceCurrency1.setValue(currency);
    }

    public void exitAplication(ActionEvent actionEvent) {
        stage = (Stage) scenePane.getScene().getWindow();
        stage.close();
    }

    public void switchToMagnitudes(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("magnitudes-view.fxml"));
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage = (Stage) scenePane.getScene().getWindow();
        stage.setScene(scene);
        stage.toFront();
        stage.show();
    }
}