package oussama.hakik.game;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class PuzzleForm {

    PuzzleForm(){}



    enum FormeName{
        UN,DEUX,TROIS,QUATRE,CINQ,SIX,SEPT;
    }
    Rectangle a , b , c , d ;
    static String name ;
    Color color;

    private static int XMAX = Level.Xmax;
    private static int YMAX = Level.Ymax;
    private static final int SIZE = Level.size;

    public int form = 1 ;
    public PuzzleForm(Rectangle a, Rectangle b, Rectangle c, Rectangle d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    //PuzzleForm(){}

    PuzzleForm(Rectangle a , Rectangle b , Rectangle c, Rectangle d , String name){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.name = name;
        switch (name) {
            case "j":
                color = Color.SLATEGRAY;
                break;
            case "l":
                color = Color.DARKGOLDENROD;
                break;
            case "o":
                color = Color.INDIANRED;
                break;
            case "s":
                color = Color.FORESTGREEN;
                break;
            case "t":
                color = Color.CADETBLUE;
                break;
            case "z":
                color = Color.HOTPINK;
                break;
            case "i":
                color = Color.SANDYBROWN;
                break;

        }
        this.a.setFill(color);
        this.b.setFill(color);
        this.c.setFill(color);
        this.d.setFill(color);
    }

    public String getName() {
        return name;
    }


    public void changeForm() {
        if (form != 4) {
            form++;
        } else {
            form = 1;
        }
    }

    /**
     * Methode qui genere une forme de puzzle
     */


    protected static PuzzleForm makeL(){
        Rectangle a = new Rectangle(SIZE-1, SIZE-1), b = new Rectangle(SIZE-1, SIZE-1), c = new Rectangle(SIZE-1, SIZE-1),
                d = new Rectangle(SIZE-1, SIZE-1);
        a.setX(XMAX / 2 - SIZE);
        b.setX(XMAX / 2 - SIZE);
        b.setY(SIZE);
        c.setX(XMAX / 2);
        c.setY(SIZE);
        d.setX(XMAX / 2 + SIZE);
        d.setY(SIZE);
        name = "j";
        //L normal
        return new PuzzleForm(a, b, c, d, name);
    }
    protected static PuzzleForm makeLI(){
        Rectangle a = new Rectangle(SIZE-1, SIZE-1), b = new Rectangle(SIZE-1, SIZE-1), c = new Rectangle(SIZE-1, SIZE-1),
                d = new Rectangle(SIZE-1, SIZE-1);
        a.setX(XMAX / 2 + SIZE);
        b.setX(XMAX / 2 - SIZE);
        b.setY(SIZE);
        c.setX(XMAX / 2);
        c.setY(SIZE);
        d.setX(XMAX / 2 + SIZE);
        d.setY(SIZE);
        name = "l";
        //L ma9louba
        return new PuzzleForm(a, b, c, d, name);
    }
    protected static PuzzleForm makeC(){
        Rectangle a = new Rectangle(SIZE-1, SIZE-1), b = new Rectangle(SIZE-1, SIZE-1), c = new Rectangle(SIZE-1, SIZE-1),
                d = new Rectangle(SIZE-1, SIZE-1);
        a.setX(XMAX / 2 - SIZE);
        b.setX(XMAX / 2);
        c.setX(XMAX / 2 - SIZE);
        c.setY(SIZE);
        d.setX(XMAX / 2);
        d.setY(SIZE);
        name = "o";
        //carre
        return new PuzzleForm(a, b, c, d, name);
    }
    protected static PuzzleForm makeZI(){
        Rectangle a = new Rectangle(SIZE-1, SIZE-1), b = new Rectangle(SIZE-1, SIZE-1), c = new Rectangle(SIZE-1, SIZE-1),
                d = new Rectangle(SIZE-1, SIZE-1);
        a.setX(XMAX / 2 + SIZE);
        b.setX(XMAX / 2);
        c.setX(XMAX / 2);
        c.setY(SIZE);
        d.setX(XMAX / 2 - SIZE);
        d.setY(SIZE);
        name = "s";
        //z ma9louba
        return new PuzzleForm(a, b, c, d, name);
    }
    protected static PuzzleForm makeTI(){
        Rectangle a = new Rectangle(SIZE-1, SIZE-1), b = new Rectangle(SIZE-1, SIZE-1), c = new Rectangle(SIZE-1, SIZE-1),
                d = new Rectangle(SIZE-1, SIZE-1);
        a.setX(XMAX / 2 - SIZE);
        b.setX(XMAX / 2);
        c.setX(XMAX / 2);
        c.setY(SIZE);
        d.setX(XMAX / 2 + SIZE);
        name = "t";
        //T ma9louba
        return new PuzzleForm(a, b, c, d, name);
    }
    protected static PuzzleForm makeZ(){
        Rectangle a = new Rectangle(SIZE-1, SIZE-1), b = new Rectangle(SIZE-1, SIZE-1), c = new Rectangle(SIZE-1, SIZE-1),
                d = new Rectangle(SIZE-1, SIZE-1);
        a.setX(XMAX / 2 + SIZE);
        b.setX(XMAX / 2);
        c.setX(XMAX / 2 + SIZE);
        c.setY(SIZE);
        d.setX(XMAX / 2 + SIZE + SIZE);
        d.setY(SIZE);
        name = "z";
        //z normal
        return new PuzzleForm(a, b, c, d, name);
    }
    protected static PuzzleForm makeD(){
        Rectangle a = new Rectangle(SIZE-1, SIZE-1), b = new Rectangle(SIZE-1, SIZE-1), c = new Rectangle(SIZE-1, SIZE-1),
                d = new Rectangle(SIZE-1, SIZE-1);
        a.setX(XMAX / 2 - SIZE - SIZE);
        b.setX(XMAX / 2 - SIZE);
        c.setX(XMAX / 2);
        d.setX(XMAX / 2 + SIZE);
        name = "i";
        return new PuzzleForm(a, b, c, d, name);
    }

}
