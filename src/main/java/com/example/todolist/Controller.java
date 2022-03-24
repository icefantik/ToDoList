package com.example.todolist;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private static ObservableList<Task> tasksData = FXCollections.observableArrayList(
            new Task(1, "Сделать toDoList", "Мне нужно сделать задание по инструменталкам", "24.02.22", "24.02.22")
    );

    @FXML
    private TableView<Task> tableTasks;

    @FXML
    private TableColumn<Task, Integer> idColumn;
    @FXML
    private TableColumn<Task, String> titleColumn;
    @FXML
    private TableColumn<Task, String> descColumn;
    @FXML
    private TableColumn<Task, String> startColumn;
    @FXML
    private TableColumn<Task, String> dueColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idColumn.setCellValueFactory(new PropertyValueFactory<Task, Integer>("Id"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("Title"));
        descColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("Desc"));
        startColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("Start"));
        dueColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("Due"));
        tableTasks.setItems(tasksData);
    }

    public static void delId(int id) {
        for (int index = 0; index < tasksData.size(); ++index) {
            if (id == tasksData.get(index).id) {
                delTasksData(index);
            }
        }
    }

    public static Task findOnIdElem(int id)
    {
        for (Task tasksDatum : tasksData) {
            if (id == tasksDatum.id) {
                return new Task(tasksDatum.id, tasksDatum.title, tasksDatum.desc, tasksDatum.start, tasksDatum.due);
            }
        }
        return null;
    }

    private void updateTasksData()
    {
        tableTasks.setItems(tasksData);
    }

    public static void addTasksData(Task task) {
        tasksData.add(task);
    }

    public static void delTasksData(int index) {
        tasksData.remove(index);
    }

    public void openDelWindow(ActionEvent actionEvent) throws IOException {
        DelWindow delWindow = new DelWindow();
        delWindow.newWindow();
    }

    public void openEditWindow(ActionEvent actionEvent) throws IOException {
        AddWindow addWindow = new AddWindow();
        addWindow.newWindow();
    }

    public void openGetIdWindow(ActionEvent actionEvent) throws IOException {
        GetIdWindow getIdWindow = new GetIdWindow();
        getIdWindow.newWindow();
    }
}