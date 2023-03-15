package com.oracle.conversor;

import com.oracle.conversor.api.CurrencyApi;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Conversor extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Conversor.class.getResource("conversor-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        launch();
        CurrencyApi currencyApi = new CurrencyApi();
        currencyApi.getListCurrency();
    }
}