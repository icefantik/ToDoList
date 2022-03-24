package com.example.todolist;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class DelWindow implements Initializable {
    public TextField textFieldDelId;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void newWindow() throws IOException {
        Parent fxmlLoader = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("DelWindow.fxml")));
        Scene scene = new Scene(fxmlLoader);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Удаление");
        primaryStage.setScene(scene);
        primaryStage.initModality(Modality.NONE);
        primaryStage.show();
    }
    public void findDelId() {
        Controller.delId(Integer.parseInt(textFieldDelId.getText()));
    }
}
