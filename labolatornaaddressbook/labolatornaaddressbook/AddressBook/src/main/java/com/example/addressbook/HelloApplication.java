package com.example.addressbook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        scene.getStylesheets().clear();
        File file = new File("/src/main/java/com/example/addressbook/my.css");
        String file_s = file.toURI().toString();
        scene.getStylesheets().add(file_s);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

 stage.setMinHeight(600);
        stage.setMinWidth(600);
        stage.setTitle("Адресна книга");

    HelloController controller = fxmlLoader.getController();
        controller.setNewStage(stage);

        stage.setScene(scene);
        stage.show();

    test();

        stage.setOnCloseRequest(event -> {
        event.consume();
        logout(stage);
    });
}

    public void test(){
        ControllerAddressBook addressBook = new ControllerAddressBook();
        addressBook.fillTestData();
        addressBook.print();
    }

    void logout(Stage stage) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Вихід з програми");
        alert.setContentText("Ви дійсно бажаєте вийти?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            System.out.println("Ви успішно вийшли з програми");
            stage.close();
        }

    }
}
