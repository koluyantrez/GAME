package oussama.hakik.game;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Maps {

    protected static int levelNum = 1 ;
    //static GridPane gridPane = grilleTest.gridPane;

    protected static void InitialiserMap(){
        /*créer une GridPane avec 10 colonnes et 10 lignes*/
        //gridPane = new GridPane();
        Level.gridPane.setTranslateX(80);
        Level.gridPane.setTranslateY(80);
        //lire le fichier txt
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Oussama Hakik\\OneDrive - UMONS\\Bureau\\GAME\\src\\main\\resources\\niveaux\\niveau"+levelNum+".txt"));
            String line;
            int rowIndex = 0;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(" ");
                int colIndex = 0;
                for (String str : values) {
                    if (str.equals("90")) {
                        //ajouter un rectangle avec une couleur noire
                        Rectangle rect = new Rectangle(28, 28);
                        rect.setFill(Color.BLACK);
                        rect.setStroke(Color.BLACK);
                        Level.gridPane.add(rect, colIndex, rowIndex);
                        PuzzleControlle.occuipedCells[rowIndex][colIndex] = true;
                    } else if (Integer.parseInt(str) >= 00 && Integer.parseInt(str) <= 50) {
                        //ajouter un rectangle avec une couleur blanche
                        Rectangle rect = new Rectangle(28, 28);
                        rect.setFill(Color.WHITE);
                        rect.setStroke(Color.BLACK);
                        Level.gridPane.add(rect, colIndex, rowIndex);
                    } else if (str.equals("80")) {
                        //ne rien ajouter et rendre la case invisible
                        //occuipedCells[rowIndex][colIndex] = true;
                        Rectangle rect = new Rectangle(28,28);
                        rect.setFill(Color.WHITE);
                        Level.gridPane.add(rect,colIndex,rowIndex);
                        Level.gridPane.getChildren().get(colIndex * Level.gridPane.getRowCount() + rowIndex).setVisible(false);
                        PuzzleControlle.occuipedCells[rowIndex][colIndex] = true;
                    }
                    colIndex++;
                }
                rowIndex++;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //si ya pas de false donc on passe au niveau suivant:

    public static boolean containsFalse(boolean[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == false) {
                    return true;
                }
            }
        }
        return false;
    }

    protected static PuzzleForm initialiseForm(){
        PuzzleForm result = new PuzzleForm();
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Oussama Hakik\\OneDrive - UMONS\\Bureau\\GAME\\src\\main\\resources\\niveaux\\niveau"+levelNum+".txt"));
            String line;
            int rowIndex = 0;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(" ");
                int colIndex = 0;
                for (String str : values) {
                    if (Integer.parseInt(str)==01) {
                       result =  PuzzleForm.makeL();
                    } else if (Integer.parseInt(str)==02) {
                        result = PuzzleForm.makeLI();
                    } else if (Integer.parseInt(str)==03) {
                        result = PuzzleForm.makeC();
                    } else if (Integer.parseInt(str)==04) {
                        result = PuzzleForm.makeZI();
                    } else if (Integer.parseInt(str)==05) {
                        result = PuzzleForm.makeTI();
                    } else if (Integer.parseInt(str)==06) {
                        result = PuzzleForm.makeZ();
                    } else if (Integer.parseInt(str)==07) {
                        result = PuzzleForm.makeD();
                    }
                    colIndex++;
                }
                rowIndex++;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
