package com.example.caesar_cipher;

import com.example.caesar_cipher.Model.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CaesarCipherController {
    @FXML
    private TextField path;

    @FXML
    private TextField key;

    @FXML
    private TextArea textAreaStart;

    @FXML
    private TextArea textAreaResult;

    @FXML
    private TextArea textAreaStatisticData;

    @FXML
    private CheckBox checkBoxStatisticData;

    @FXML
    protected void choicePatButtonClick() {
        FileChooser fileChooser = new FileChooser();
        path.setText(fileChooser.showOpenDialog(new Stage()).toString());
        CaesarCipherPath path1 = new CaesarCipherPath(path.getText());

        try {
            if (checkBoxStatisticData.isSelected()) {
                textAreaStatisticData.setText(path1.getTextString());
            }else {
                textAreaStart.setText(path1.getTextString());
            }
        }catch (IOException e) {
               Alert alert = new Alert(AlertType.INFORMATION);
               alert.setTitle("Ошибка ввода данных");
               alert.setContentText(e.getMessage());
               alert.showAndWait();

        }
    }

    @FXML
    protected void encodingBtnButtonClick() {
        if (textAreaStart.getText() == "") {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Ошибка поля ввода");
            alert.setContentText("Поле \"Текст шифрования\\дешифрование\" не может быть пустым");
            alert.showAndWait();
        }else {
            try {
                CaesarCipherCodeImpl encoding = new CaesarCipherCodeImpl(textAreaStart.getText(), key.getText());
                textAreaResult.setText(encoding.encoding());
            } catch (NumberFormatException e) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Ошибка поля ввода");
                alert.setContentText("В поле \"Ключ\" было введено некорректное значение");
                alert.showAndWait();
            }
        }
    }

    @FXML
    protected void decodingBtnButtonClick(){
        try {
            CaesarCipherCodeImpl decode = new CaesarCipherCodeImpl(textAreaStart.getText(), key.getText());
            textAreaResult.setText(decode.decode());
        }catch (NumberFormatException e) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Ошибка поля ввода");
            alert.setContentText("В поле \"Ключ\" было введено некорректное значение");
            alert.showAndWait();
        }
    }

    @FXML
    protected void saveResultButtonClick() throws IOException{
        FileChooser save = new FileChooser();
        String path = save.showSaveDialog(new Stage()).toString();

        CaesarCipherFile file = new CaesarCipherFile(path);
        file.addFile(textAreaResult.getText());
    }
    @FXML
    protected void BruteForceButtonClick() throws IOException {
        textAreaResult.setText(new CaesarCipherBruteForce(textAreaStart.getText()).isBruteForce());
    }

    @FXML
    protected void StatisticalDataButtonClick() {
        CaesarCipherStatisticalData statisticalData = new CaesarCipherStatisticalData(textAreaStart.getText(), textAreaStatisticData.getText());
        textAreaResult.setText(statisticalData.getResultStatisticData());
    }

    @FXML
    protected void swapTextButtonClick() {
        if (textAreaResult.getText() != "") {
            textAreaStart.setText(textAreaResult.getText());
            textAreaResult.clear();
        }else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Ошибка поля ввода");
            alert.setContentText("Поле \"Результат\" пустое");
            alert.showAndWait();
        }
    }

    @FXML
    protected void clearAllBtnButtonClick() {
        path.clear();
        key.clear();
        textAreaStart.clear();
        textAreaResult.clear();
    }

}