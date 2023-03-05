import org.jetbrains.annotations.NotNull;
import processing.core.*;

public class Problem05 extends PApplet {
    static String s1,s2;

    float x1,x2;

    float sx1,sx2;

    float sz1 = 2;
    float sz2 = -2;

    public static void main(String [] args) {
        PApplet.main("Problem05");
        if (args.length != 2) {
            System.out.println("Wrong number of arguments: it must be 2");
            System.exit(0);
        }
        s1 = args[0];
        s2 = args[1];
    }

    public void settings() {
        fullScreen();
    }


    public void setup() {
        background(1,2,3);
        textAlign(CENTER);


        sx1 = 2;
        sx2 = -2;

        sz1 = 2;
        sz2 = -2;

        x1 = width / 2;
        x2 = width / 2;

        fill(255,0,0);
        textSize(200);
        text(s1,x1, 300);

        fill(255,255,255);
        textSize(200);
        text(s2,x2, height - 300);

        sx1 = (width - textWidth(s1)) / 50f;
        sx2 = -(width - textWidth(s2)) / 50f;
    }

    public void draw() {
        background(1,2,3);

        fill(255,0,0);
        textSize(200);
        text(s1,x1, 300);

        fill(255,255,255);
        textSize(200);
        text(s2,x2, height - 300);

        if(textWidth(s1) / 2f >= x1) sx1 = -sx1;
        else if(width - (textWidth(s1) / 2f) <= x1) sx1 = -sx1;

        if(textWidth(s2) / 2f >= x2) sx2 = -sx2;
        else if(width - (textWidth(s2) / 2f) <= x2) sx2 = -sx2;

        x1 += sx1;
        x2 += sx2;


    }
}