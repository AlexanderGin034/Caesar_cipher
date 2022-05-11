package com.example.caesar_cipher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Font;

import java.io.IOException;

public class CaesarCipherApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CaesarCipherApplication.class.getResource("caesarCipher-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1400, 600);
        stage.setTitle("Caesar cipher");
        stage.setScene(scene);
        stage.getScene().getStylesheets().add(CaesarCipherApplication.class.getResource("caesarCipher-css.css").toString());
        stage.setMaxHeight(600);
        stage.setMaxWidth(1400);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}