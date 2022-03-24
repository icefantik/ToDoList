package com.example.todolist;

import javafx.event.ActionEvent;
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

public class AddWindow implements Initializable {
    public TextField textFieldId;
    public TextField textFieldTitle;
    public TextField textFieldDesc;
    public TextField textFieldStart;
    public TextField textFieldDue;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void newWindow() throws IOException {
        Parent fxmlLoader = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AddWindow.fxml")));
        Scene scene = new Scene(fxmlLoader);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Добавление");
        primaryStage.setScene(scene);
        primaryStage.initModality(Modality.NONE);
        primaryStage.show();
    }

    public void getTextField() {
        Task task = new Task(Integer.parseInt(textFieldId.getText()), textFieldTitle.getText(), textFieldDesc.getText(), textFieldStart.getText(), textFieldDue.getText());
        Controller.addTasksData(task);
    }

    public void EditTask(ActionEvent actionEvent) {
        getTextField();
    }
}
