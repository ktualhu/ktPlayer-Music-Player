package com.ktplayer;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

// notice 'extends Application' - Main is a concrete implementation of an abstract class
// javafx provides developers with an application 'template'

public class Main extends Application {

    private ObservableList<Song> songData = FXCollections.observableArrayList(); // used in Controller.java
    private static Stage primaryStage;

    public Main() {}

    @Override
    public void start(Stage primaryStage) throws Exception { // called in main()

        setStage(primaryStage);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ktPlayer.fxml"));
        System.out.println(getClass().getResource("/ktPlayer.fxml"));

        Parent root = fxmlLoader.load();

        // connects this Main application with Controller.java - most interface / application logic handled there
        Controller controller = fxmlLoader.getController();
        controller.setMain(this);

        Scene scene = new Scene(root, 820, 740);
        scene.getStylesheets().add(ClassLoader.getSystemResource("LightTheme.css").toExternalForm());

        scene.setFill(Color.TRANSPARENT);

        primaryStage.setTitle("ktPlayer 0.1v"); // TODO when new version finalized change this
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT); // maybe add a dark mode?
        primaryStage.setResizable(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // launch() called in the Main class calls the start() method in the same class
    }

    public static Stage getStage() {
        return Main.primaryStage;
    }

    private void setStage(Stage stage) {
        Main.primaryStage = stage;
    }
}

