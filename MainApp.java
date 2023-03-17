package oussama.hakik.game;



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

import static java.lang.Integer.valueOf;

public class MainApp extends Application {
    private static int XMAX = Level.Xmax;
    private static int YMAX = Level.Ymax;
    private static final int SIZE = Level.size;
    private static final int MOVE = Level.move;
    private static int[][] MESH = new int[XMAX/SIZE][YMAX/SIZE];



    private static int[][] grid = new int[10][10];

    private static final int height = 700;
    private static final int widht = 700;

    Pane root = new Pane();
    VBox choix = new VBox();
    Button start = new Button("Start");
    Button charger = new Button("Charger");
    Button exit = new Button("Exit");
    Button option = new Button("Option");
    Button credit = new Button("Crédit");
    Scene firstScene;
    private static Level levelClass = new Level(1) ;
    private static grilleTest mapTest = new grilleTest();

    protected   Stage HomeStage = new Stage();
    @Override
    public void start(Stage stageHome) throws IOException {
        firstScene = new Scene(root , widht , height);
        root.setStyle("-fx-background-color: #bdc3c7;");

        start.setPrefSize(150 , 50);        //button start
        start.setPadding(new Insets(20));
        start.setAlignment(Pos.CENTER);
        start.setStyle("-fx-background-color: #F2F2F2;");
        start.setOnMouseEntered(event -> {
            start.setStyle("-fx-background-color: #000000;");
            start.setTextFill(Color.WHITE);
        });
        start.setOnMouseExited(event -> {
            start.setStyle("-fx-background-color: #F2F2F2;");
            start.setTextFill(Color.BLACK);
        });
        start.setOnMouseClicked(event -> {
            levelClass.startLevel(stageHome , levelClass.lvl);
        });

        charger.setPrefSize(150 , 50);      //button charger
        charger.setPadding(new Insets(20));
        charger.setAlignment(Pos.CENTER);
        charger.setStyle("-fx-background-color: #F2F2F2;");
        charger.setOnMouseEntered(event -> {
            charger.setStyle("-fx-background-color: #000000;");
            charger.setTextFill(Color.WHITE);
        });
        charger.setOnMouseExited(event -> {
            charger.setStyle("-fx-background-color: #F2F2F2;");
            charger.setTextFill(Color.BLACK);
        });
        charger.setOnMouseClicked(event -> {
            mapTest.map(stageHome);
        });

        option.setPrefSize(150 , 50);      //button charger
        option.setPadding(new Insets(20));
        option.setAlignment(Pos.CENTER);
        option.setStyle("-fx-background-color: #F2F2F2;");
        option.setOnMouseEntered(event -> {
            option.setStyle("-fx-background-color: #000000;");
            option.setTextFill(Color.WHITE);
        });
        option.setOnMouseExited(event -> {
            option.setStyle("-fx-background-color: #F2F2F2;");
            option.setTextFill(Color.BLACK);
        });

        credit.setPrefSize(150 , 50);      //button charger
        credit.setPadding(new Insets(20));
        credit.setAlignment(Pos.CENTER);
        credit.setStyle("-fx-background-color: #F2F2F2;");
        credit.setOnMouseEntered(event -> {
            credit.setStyle("-fx-background-color: #000000;");
            credit.setTextFill(Color.WHITE);
        });
        credit.setOnMouseExited(event -> {
            credit.setStyle("-fx-background-color: #F2F2F2;");
            credit.setTextFill(Color.BLACK);
        });

        exit.setPrefSize(150 , 50);         //button exit
        exit.setPadding(new Insets(20));
        exit.setAlignment(Pos.CENTER);
        exit.setOnMouseClicked(event -> {stageHome.close();});
        exit.setStyle("-fx-background-color: #F2F2F2;");
        exit.setOnMouseEntered(event -> {
            exit.setStyle("-fx-background-color: #000000;");
            exit.setTextFill(Color.WHITE);
        });
        exit.setOnMouseExited(event -> {
            exit.setStyle("-fx-background-color: #F2F2F2;");
            exit.setTextFill(Color.BLACK);
        });

        choix.getChildren().addAll(start , charger , option , credit ,  exit);

        choix.setTranslateX(270);
        choix.setTranslateY(190);
        choix.setSpacing(20);

        root.getChildren().add(choix);
        stageHome.setTitle("My Game");
        stageHome.setScene(firstScene);
        stageHome.setResizable(false);
        firstScene.setOnKeyPressed(event -> {if(event.getCode()== KeyCode.ESCAPE) stageHome.close();});
        stageHome.show();
    }


    public static void main(String[] args) {launch();}
}