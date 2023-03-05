import processing.core.PApplet;

import javax.swing.*;
import java.util.Random;

public class Problem04 extends PApplet {
    int cnt = 0;
    float cx = width / 2f - 455f + 32.5f;
    float cy = height / 2f - 455f + 32.5f;

    int k;

    Boolean f = true;
    Random rand = new Random();

    int rx = rand.nextInt(12);
    int ry = rand.nextInt(12);

    public void settings() {
        fullScreen();
    }

    public void setup() {
        background(1,2,3);
        cx = (width / 2f - 455f + 32.5f);
        cy = (height / 2f - 455f + 32.5f);

        rx = rand.nextInt(12);
        ry = rand.nextInt(12);

    }

    public void draw() {
        noStroke();
        fill(0,0,0,25);
        rect(0,0,width,height);

        textSize(40);
        fill(255,255,255);
        textAlign(CENTER);
        text("Game: Collect White Circles using Arrow Button",width / 2, 0 + 50);

        textSize(35);
        fill(255,255,255);
        textAlign(CENTER);
        text("Score: " + cnt,width / 2, height - 45);



        noStroke();
        fill(255,255,255);
        circle((width / 2f - 455f + 32.5f) + (65f * rx), (height / 2f - 455f + 32.5f) + (65f * ry), 60f);


        int x1 = width / 2 - 455;
        int y1 = height / 2 - 455;

        int x2 = width / 2 + 455;

        for(int i = 0;i < 15;i++)
        {
            stroke(0,0,255);
            line(x1, y1, x2, y1);


            y1 += 65;
        }

        x1 = width / 2 - 455;

        y1 = height / 2 - 455;
        int y2 = height / 2 + 455;

        for(int i = 0;i < 15;i++)
        {
            stroke(0,0,255);
            line(x1, y1, x1, y2);


            x1 += 65;
        }

        noStroke();
        fill(255,0,0);
        circle(cx, cy, 60);

        delay(60);



        k = keyCode;
        if(keyPressed) f = true;
        if(f == true) {

            if (k == RIGHT && cx >= width / 2f - 455f + 32.5f && cx < width / 2f + 455f - 32.5f) {
                cx += 65f;

            }
            if (k == LEFT && cx > width / 2f - 455f + 32.5f && cx <= width / 2f + 455f - 32.5f) {
                cx -= 65f;

            }
            if (k == DOWN && cy >= height / 2f - 455f + 32.5f && cy < height / 2f + 455f - 32.5f) {
                cy += 65f;

            }
            if (k == UP && cy > height / 2f - 455f + 32.5f && cy <= height / 2f + 455f - 32.5f) {
                cy -= 65f;

            }

        }
        if(cx == (width / 2f - 455f + 32.5f) + (65f * rx) && cy == (height / 2f - 455f + 32.5f) + (65f * ry)) {
            fill(1,2,3);
            circle(cx,cy,64);
            cnt++;

            rx = rand.nextInt(14);
            ry = rand.nextInt(14);


            textSize(35);
            fill(255,255,255);



        }


    }

    public static void main(String[] args) {
        PApplet.main("Problem04");
    }
}