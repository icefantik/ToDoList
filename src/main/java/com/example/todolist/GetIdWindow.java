package com.example.todolist;

import javafx.event.ActionEvent;
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

// класс для работы с окном получения id
public class GetIdWindow implements Initializable {
    public TextField getIDChange;
    public static int idChange;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void newWindow() throws IOException {
        // метод создания окна
        Parent fxmlLoader = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("GetIdWindow.fxml")));
        Scene scene = new Scene(fxmlLoader);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Номер задачи для изменения");
        primaryStage.setScene(scene);
        primaryStage.initModality(Modality.NONE);
        primaryStage.show();
    }
    public void openChangeWindow(ActionEvent actionEvent) throws IOException {
        // метод открытия окна удаления записи
        idChange = Integer.parseInt(getIDChange.getText());
        EditWindow editWindow = new EditWindow();
        if (Controller.findOnIdElem(idChange) != null)
            editWindow.newWindow();
        getIDChange.clear();
    }
}
