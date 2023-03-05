import processing.core.PApplet;

import javax.swing.*;
import java.util.Random;

public class Problem07 extends PApplet {


    void drawClock() {

        float r = PI;

        textSize(45f);
        text(second(), width / 2 + 70, height / 2 - 360f);

        textSize(45f);
        text(" : " + minute() + " : ", width / 2, height / 2 - 360f);

        textSize(45f);
        text(hour(), width / 2 - 70, height / 2 - 360f);


        for(int i = 0;i < 60;i++) {
            pushMatrix();
            translate(width / 2, height / 2);
            rotate(r);
            if(i % 5 == 0) {
                stroke(255,1,1);
                strokeWeight(5);
                line(0, -250, 0, -300);
            }
            else {
                stroke(255,1,1);
                strokeWeight(5);
                line(0, -250, 0, -280);
            }
            r += PI / 30f;
            popMatrix();
        }

        float h = hour();
        float m = minute();
        float s = second();

        float r1 = (PI / 30f) * second();
        float r2 = (PI / 30f) * minute();
        float r3 = (PI / 6f) * hour();

        pushMatrix();
        translate(width / 2, height / 2);
        rotate(r1);
        stroke(0,0,255);
        strokeWeight(5);
        line(0, 0,0,-200);

        fill(0,0,255);
        strokeWeight(5);
        quad(-10, -200, 0, -220, 10, -200, 0, -200);
        popMatrix();

        pushMatrix();
        translate(width / 2, height / 2);
        rotate(r2);
        stroke(5,195,221);
        strokeWeight(7);
        line(0, 0,0,-180);

        fill(5,195,221);
        strokeWeight(7);
        quad(-10, -180, 0, -200, 10, -180, 0, -180);
        popMatrix();

        pushMatrix();
        translate(width / 2, height / 2);
        rotate(r3);
        stroke(230,230,250);
        strokeWeight(9);
        line(0, 0,0,-160);

        fill(230,230,250);
        strokeWeight(9);
        quad(-10, -160, 0, -180, 10, -160, 0, -160);
        popMatrix();


    }

    public void settings() {
        fullScreen();
    }

    public void setup() {
        background(1,2,3);
        textAlign(CENTER);


    }

    public void draw() {
        background(1,2,3);

        drawClock();



    }

    public static void main(String[] args) {
        PApplet.main("Problem07");
    }
}