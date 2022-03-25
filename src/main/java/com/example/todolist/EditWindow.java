package com.example.todolist;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.example.todolist.Controller.addTasksData;
import static com.example.todolist.Controller.delTasksData;

// Класс для работы с окном изменения записи
public class EditWindow implements Initializable {
    @FXML
    public TextField textFieldTitle;
    @FXML
    public TextField textFieldDesc;
    @FXML
    public TextField textFieldStart;
    @FXML
    public TextField textFieldDue;
    private Task task;

    private static Stage primaryStage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // этот метод инициализирует значения
        task = Controller.findOnIdElem(GetIdWindow.idChange);
        assert task != null;
        textFieldTitle.setText(task.title);
        textFieldDesc.setText(task.desc);
        textFieldStart.setText(task.start);
        textFieldDue.setText(task.due);
    }

    public void newWindow() throws IOException {
        // метод создание окна
        Parent fxmlLoader = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("EditWindow.fxml")));
        Scene scene = new Scene(fxmlLoader);
        primaryStage = new Stage();

        primaryStage.setTitle("Изменить");
        primaryStage.setScene(scene);
        primaryStage.initModality(Modality.NONE);
        primaryStage.show();
    }

    public void changeElem(ActionEvent actionEvent) {
        // метод изменение записи
        Task changeTask = getText();
        Controller.delId(GetIdWindow.idChange);
        addTasksData(changeTask);
        primaryStage.close();
    }

    private Task getText() {
        // метод получения записи
        return new Task(GetIdWindow.idChange, textFieldTitle.getText(), textFieldDesc.getText(), textFieldStart.getText(), textFieldDue.getText());
    }
}
