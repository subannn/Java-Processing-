import processing.core.PApplet;

import javax.swing.*;
import java.util.Random;

public class Problem05 extends PApplet {

    boolean f;

    int size = 4;


    public void settings() {
        fullScreen();
    }
    public void setup() {
        rectMode(CENTER);
        textAlign(CENTER);
        size = 4;
        f = false;

    } // 51 // 61

    public void draw() {
        background(1,2,3);

        textSize(40);
        fill(255,0,0);
        text("Size " + size + ": use +/- to change size int [4..12]", width / 2f, height - 50f);

        float sz = 900f / size;

        float xp = width / 2f - 450f + sz / 2f;
        float yp = height / 2f - 450f + sz / 2f;


        noStroke();
        int c = 0;
        boolean f = false;
        for(int i = 0;i < size;i++)
        {
            if(i % 2 == 0) c = 0;
            else c = 1;
            for(int j = 0;j < size;j++)
            {
                if(c % 2 == 0) {
                    if(mouseX > xp - sz / 2f && mouseX < xp + sz / 2f && mouseY > yp - sz / 2f && mouseY < yp + sz / 2f)
                    {
                        strokeWeight(4);
                        stroke(255,0,0);
                        fill(255,255,255);
                        rect(xp,yp,sz - 8,sz - 8);

                        textSize(50);
                        fill(255,0,0);
                        text("Row: " + (i + 1) + "; Column: " + (j + 1) + "; Color: White", width / 2, 50);
                    }
                    else {
                        strokeWeight(2);
                        stroke(255,255,255);
                        fill(255,255,255);
                        rect(xp,yp,sz,sz);
                    }

                }
                else {
                    if(mouseX > xp - sz / 2f && mouseX < xp + sz / 2f && mouseY > yp - sz / 2f && mouseY < yp + sz / 2f)
                    {
                        strokeWeight(4);
                        stroke(255,0,0);
                        fill(22,22,22);
                        rect(xp,yp,sz - 8,sz - 8);

                        textSize(50);
                        fill(255,0,0);
                        text("Row: " + (i + 1) + "; Column: " + (j + 1) + "; Color: Black", width / 2, 50);
                    }
                    else {
                        strokeWeight(0);
                        stroke(255,255,255);
                        fill(22,22,22);
                        rect(xp,yp,sz,sz);
                    }

                }
                xp += sz;
                c++;
            }
            yp += sz;
            xp = width / 2f - 450f + sz / 2;





        }



    }
    public void keyPressed() {
        if(size >= 4 && size < 12 && keyCode == 61) size++;
        else if(size > 4 && size <= 12 && keyCode == 45) size--;

    }


    public static void main(String[] args) {
        PApplet.main("Problem05");
    }
}