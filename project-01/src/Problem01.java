import processing.core.PApplet;
import java.util.Random;

public class Problem01 extends PApplet {
    int x = 0, y = 0;
    int sx = 15, sy = 15;

    public void settings() {
        fullScreen();
    }

    public void setup() {


    }

    public void draw() {
        noStroke();



        fill(0, 0, 0,50);

        rect(0, 0, width, height);




        fill(238, 130, 238);
        circle(width / 2f + x, height / 2f + y, 60);

        fill(0, 0, 255);
        circle(width/4f + x, height/4f + y, 60);

        fill(255, 255, 51);
        circle(width / 4f + x, height / 2f + height / 4f + y, 60);

        fill(0, 255, 0);
        circle(width / 4f + width / 2f + x, height / 4f + y, 60);

        fill(255, 0, 0);
        circle(width / 4f + width / 2f + x, height / 4f + height / 2f + y, 60);

        if(x >= width / 4 - 30 ||  x <= -width / 4 + 30)
        {
            sx = -sx;
        }
        if(y >= height / 4 - 30 ||  y <= -height / 4 + 30)
        {
            sy = -sy;
        }




        x += sx;
        y += sy;



    }

    public static void main(String[] args) {
        PApplet.main("Problem01");
    }
}