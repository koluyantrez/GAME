package oussama.hakik.game;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;



public class grilleTest {

   //private static final int SIZE = Level.size;
    //Rectangle rectangle;
    protected static GridPane gridPane;

    protected static  double    height=24;
    protected static  double   width=height;
    public void map(Stage stagePrincipal){
        stagePrincipal.close();
        Pane pane = new Pane();
        PuzzleForm objPuzzle = PuzzleForm.makeRect();

        /*créer une GridPane avec 10 colonnes et 10 lignes*/
        gridPane = new GridPane();
        for(int i =0 ; i < 10 ; i++){
            for(int j = 0 ; j < 10 ; j++){
                Rectangle rct = new Rectangle(24,24);
                rct.setFill(Color.WHITE);
                rct.setStroke(Color.BLACK);
                gridPane.add(rct , i , j);
            }
        }
        //gridPane.setHgap(2);
        //gridPane.setVgap(2);
        //gridPane.setPrefSize(240, 240);
        /*for (int i = 0; i < 10; i++) {
            ColumnConstraints column = new ColumnConstraints(24);
            gridPane.getColumnConstraints().add(column);
            RowConstraints row = new RowConstraints(24);
            gridPane.getRowConstraints().add(row);
        }*/

        gridPane.setTranslateX(80);
        gridPane.setTranslateY(80);


        Group groupe = PuzzleControlle.makeGroupForm(objPuzzle);
        PuzzleControlle.Deplacer(groupe,gridPane,objPuzzle);



        pane.getChildren().addAll(gridPane , groupe);

        Stage MapStage = new Stage();
        Scene scene = new Scene(pane , 500 , 500);
        MapStage.setScene(scene);
        MapStage.setTitle("Map Game ");
        MapStage.show();


    }
}
