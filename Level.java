package oussama.hakik.game;

import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.Group;
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

public class Level {

    protected static final int move=25;
    protected static final int MOVE=25;

    protected static final int SIZE=25;

    protected static final int size=25;
    protected static int Xmax = size*10;
    protected static int Ymax = size*10;
    private static int[][] MESH = new int[Xmax/size][Ymax/size];
    protected int lvl ;
    private Button back , reload , next;

    Level(int lvl){
        this.lvl = lvl;
    }
    Level(){}

    private HBox buttons = new HBox();
    private Stage stage;

    protected GridPane gridPane;

    protected void startLevel(Stage principalStage , int lvl)  {
        principalStage.close();
        stage = new Stage();
        Pane root = new Pane();


        gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        /*for (int i = 0 ; i < 5 ; i++){
            for(int j = 0 ; j < 5 ; j++){
                if ((i==0&&j==0)||(i==0&&j==1)||(i==1&&j==1)||(i==1&&j==2)){
                    Rectangle rct = new Rectangle(24,24);
                    rct.setFill(Color.WHITE);
                    rct.setStroke(Color.BLACK);
                    gridPane.add(rct,j,i);
                }else {
                    gridPane.add(new Rectangle(24,24) , j , i);
                }
            }
        }*/




        for(int i =0 ; i < 10 ; i++){
            for(int j = 0 ; j < 10 ; j++){
                Rectangle rct = new Rectangle(24,24);
                rct.setFill(Color.WHITE);
                rct.setStroke(Color.BLACK);
                gridPane.add(rct , i , j);
            }
        }
        gridPane.setTranslateX(100);
        gridPane.setTranslateY(100);




        PuzzleForm myPuzzle = PuzzleForm.makeRect();
        Group groupe = PuzzleControlle.makeGroupForm(myPuzzle);
        groupe.setTranslateX(300);
        groupe.setTranslateY(200);
        PuzzleControlle.Deplacer(groupe , gridPane , myPuzzle);

        back = new Button("Back");
        reload = new Button("Reload");
        next = new Button("Next");

        buttons.setTranslateX(80);
        buttons.setTranslateY(400);
        buttons.setSpacing(120);
        back.setOnMouseClicked(event -> {backOnClicked();});
        reload.setOnMouseClicked(event -> {reloadOnClicked();});
        if (!(buttons.getChildren().contains(back))){
            buttons.getChildren().add(back);
        }
        if (!buttons.getChildren().contains(reload)){
            buttons.getChildren().add(reload);
        }
        if (!buttons.getChildren().contains(next)){
            buttons.getChildren().add(next);
        }

        root.getChildren().addAll(gridPane,groupe,buttons);
        Scene scene = new Scene(root , 500 , 500);
        stage.setScene(scene);
        stage.setTitle("Map");
        stage.show();
        scene.setOnKeyPressed(event -> {if (event.getCode()== KeyCode.ESCAPE) stage.close();});
    }

    protected void backOnClicked() {
        try {
            stage.close();
            new MainApp().start(new Stage());
        }catch (IOException e){
            //e.printStackTrace();
            System.out.println("ya une erreur!!");
        }
    }
    protected void reloadOnClicked() {
        stage.close();
        new Level().startLevel(new Stage(),this.lvl);
    }
    protected void nextOnClicked(){
        //buttons.getChildren().add(next);

    }




}
