package oussama.hakik.game;

import javafx.scene.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class PuzzleControlle{
    private static int XMAX = Level.Xmax;
    private static int YMAX = Level.Ymax;

    protected static boolean[][] occuipedCells = new boolean[10][10];

    protected static Group makeGroupForm(PuzzleForm myForm){
        Group group = new Group();
        group.getChildren().addAll(myForm.a,myForm.b,myForm.c,myForm.d);
        return group;
    }

    protected static void Deplacer(Group groupe , GridPane gridPane , PuzzleForm objPuzzle){
        groupe.setOnMousePressed(event -> {
            double initX = groupe.getLayoutX();
            double initY = groupe.getLayoutY();
            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            groupe.setOnMouseDragged(e ->{
                double deltaX = e.getSceneX()-mouseX;
                double deltaY = e.getSceneY()-mouseY;
                groupe.setLayoutX(initX+deltaX);
                groupe.setLayoutY(initY+deltaY);
            });
        });
        double cordX = gridPane.getLayoutX();
        double cordY = gridPane.getLayoutY();


        groupe.setOnMouseReleased(event -> {
            double mouseX = event.getSceneX()-100;
            double mouseY = event.getSceneY()-100;
            int colIndex = (int) (mouseX/30);
            int rowIndex = (int) (mouseY/30);
            if(groupe.getLayoutX()<=cordX && groupe.getLayoutY()<=cordY){
                switch (objPuzzle.name){
                case "j":
                    if(occuipedCells[rowIndex][colIndex]!=true){
                    gridPane.add(groupe.getChildren().get(0),colIndex,rowIndex);
                    gridPane.add(groupe.getChildren().get(0),colIndex,rowIndex+1);
                    gridPane.add(groupe.getChildren().get(0),colIndex+1,rowIndex+1);
                    gridPane.add(groupe.getChildren().get(0),colIndex+2,rowIndex+1);
                    occuipedCells[rowIndex][colIndex] = true;
                    System.out.println("form j");
                    break;}
                case "l":
                    if(occuipedCells[rowIndex][colIndex]!=true){
                    gridPane.add(groupe.getChildren().get(0),colIndex+1,rowIndex);
                    gridPane.add(groupe.getChildren().get(0),colIndex+1,rowIndex+1);
                    gridPane.add(groupe.getChildren().get(0),colIndex-2+1+1,rowIndex+1);
                    gridPane.add(groupe.getChildren().get(0),colIndex-3+1+1,rowIndex+1);
                    System.out.println("form l");
                    occuipedCells[rowIndex][colIndex] = true;
                    break;}
                case "o":
                    if(occuipedCells[rowIndex][colIndex]!=true){
                    gridPane.add(groupe.getChildren().get(0),colIndex,rowIndex);
                    gridPane.add(groupe.getChildren().get(0),colIndex+1,rowIndex);
                    gridPane.add(groupe.getChildren().get(0),colIndex,rowIndex+1);
                    gridPane.add(groupe.getChildren().get(0),colIndex+1,rowIndex+1);
                    System.out.println("form o");
                        occuipedCells[rowIndex][colIndex] = true;
                    break;}
                case "s":
                    if(occuipedCells[rowIndex][colIndex]!=true){
                    gridPane.add(groupe.getChildren().get(0),colIndex,rowIndex+1);
                    gridPane.add(groupe.getChildren().get(0),colIndex+1,rowIndex+1);
                    gridPane.add(groupe.getChildren().get(0),colIndex+1,rowIndex-1+1);
                    gridPane.add(groupe.getChildren().get(0),colIndex+2,rowIndex-1+1);
                    System.out.println("form s");
                        occuipedCells[rowIndex][colIndex] = true;
                    break;}
                case "t":
                    if(occuipedCells[rowIndex][colIndex]!=true){
                    gridPane.add(groupe.getChildren().get(0),colIndex,rowIndex+1);
                    gridPane.add(groupe.getChildren().get(0),colIndex+1,rowIndex+1);
                    gridPane.add(groupe.getChildren().get(0),colIndex+2,rowIndex+1);
                    gridPane.add(groupe.getChildren().get(0),colIndex+1,rowIndex+1+1);
                    System.out.println("form t");
                        occuipedCells[rowIndex][colIndex] = true;
                    break;}
                case "z":
                    if(occuipedCells[rowIndex][colIndex]!=true){
                    gridPane.add(groupe.getChildren().get(0),colIndex,rowIndex+1-1);
                    gridPane.add(groupe.getChildren().get(0),colIndex+1,rowIndex+1-1);
                    gridPane.add(groupe.getChildren().get(0),colIndex+1,rowIndex+1+1-1);
                    gridPane.add(groupe.getChildren().get(0),colIndex+2,rowIndex+1+1-1);
                    System.out.println("form z");
                        occuipedCells[rowIndex][colIndex] = true;
                    break;}
                }
            }
        });

    }


}
