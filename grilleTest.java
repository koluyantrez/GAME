package oussama.hakik.game;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;


    public class grilleTest {

   //private static final int SIZE = Level.size;
    //Rectangle rectangle;
    protected static GridPane gridPane;

    protected static Stage MapStage;
    protected static  double    height=24;
    protected static  double   width=height;
    //protected static boolean[][] occuipedCells = new boolean[20][20];
    public void map(Stage stagePrincipal){
        stagePrincipal.close();
        Pane pane = new Pane();
        PuzzleForm objPuzzle = Maps.initialiseForm();

        /*créer une GridPane avec 10 colonnes et 10 lignes*/
        gridPane = new GridPane();
        //lire le fichier txt
        /*try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Oussama Hakik\\OneDrive - UMONS\\Bureau\\GAME\\src\\main\\resources\\niveaux\\niveau2.txt"));
            String line;
            int rowIndex = 0;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(" ");
                int colIndex = 0;
                for (String str : values) {
                    if (str.equals("90")) {
                        //ajouter un rectangle avec une couleur noire
                        Rectangle rect = new Rectangle(25, 25);
                        rect.setFill(Color.BLACK);
                        rect.setStroke(Color.BLACK);
                        gridPane.add(rect, colIndex, rowIndex);
                        occuipedCells[rowIndex][colIndex] = true;
                    } else if (str.equals("00")) {
                        //ajouter un rectangle avec une couleur blanche
                        Rectangle rect = new Rectangle(25, 25);
                        rect.setFill(Color.WHITE);
                        rect.setStroke(Color.BLACK);
                        gridPane.add(rect, colIndex, rowIndex);
                    } else if (str.equals("80")) {
                        //ne rien ajouter et rendre la case invisible
                        //occuipedCells[rowIndex][colIndex] = true;
                        Rectangle rect = new Rectangle(25,25);
                        gridPane.add(rect,colIndex,rowIndex);
                        gridPane.getChildren().get(colIndex * gridPane.getRowCount() + rowIndex).setVisible(false);
                    }
                    colIndex++;
                }
                rowIndex++;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        Maps.InitialiserMap();

        gridPane.setTranslateX(80);
        gridPane.setTranslateY(80);


        Group groupe = PuzzleControlle.makeGroupForm(objPuzzle);
        PuzzleControlle.Deplacer(groupe,gridPane,objPuzzle);



        pane.getChildren().addAll(gridPane , groupe);

        MapStage = new Stage();
        Scene scene = new Scene(pane , 500 , 500);
        MapStage.setScene(scene);
        MapStage.setTitle("Map Game ");
        MapStage.show();

    }
}
