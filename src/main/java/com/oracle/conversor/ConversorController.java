package com.oracle.conversor;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ConversorController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}