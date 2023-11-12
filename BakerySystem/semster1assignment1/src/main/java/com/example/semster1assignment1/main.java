package com.example.semster1assignment1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class main extends Application {

    public static FunkyList<BakedGood> BakedGoodList = new FunkyList<>();
    public static Scene scene1,scene2,scene3,scene4;
    public static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage=stage;
        FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource("mainpage.fxml"));
        scene1 = new Scene(fxmlLoader.load(),600,400);
        stage.setTitle("Baking Information System");
        stage.setScene(scene1);
        stage.show();

        fxmlLoader = new FXMLLoader(main.class.getResource("recipe.fxml"));
        scene2 = new Scene(fxmlLoader.load(),600,400);

        fxmlLoader = new FXMLLoader(main.class.getResource("ingredient.fxml"));
        scene3 = new Scene(fxmlLoader.load(),600,400);

        fxmlLoader = new FXMLLoader(main.class.getResource("viewing.fxml"));
        scene4 = new Scene(fxmlLoader.load(),600,400);


        // main.primaryStage.setScene(main.scene2);

    }
    public static void main(String[] args) {
        launch();
    }
}
