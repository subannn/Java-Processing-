import processing.core.PApplet;

import java.io.File;
import java.util.Random;


public class Problem04 extends PApplet {

    int c = 0;

    float[] balls = new float[50];

    float[] px = new float[50];
    float[] py = new float[50];

    float[] SpeedX = new float[50];
    float[] SpeedY = new float[50];

    int cntBox1 = 0;
    int cntBox2 = 0;

    void drawBall(float x, float y) {
        noStroke();
        fill(255,255,255);
        circle(x,y,30);
    }

    public void settings() {
        fullScreen();
    }

    public void setup() {
        background(1,2,3);
        rectMode(CENTER);
        textAlign(CENTER);
        Random rand = new Random();
        c = 0;

        cntBox1 = 0;
        cntBox2 = 0;

        for(int i = 0;i < 50;i++) {
            float x = rand.nextFloat(width / 2f - 600f + 15f, width / 2f - 200f - 15f); // x walls of left box
            float y = rand.nextFloat(height / 2f - 200 + 15, height / 2f + 200 - 15);     // y walls of left box

            if(x == width / 2 - 400 && y == height / 2) {
                x += 7;
                y += 7;
            }

            px[i] = x;
            py[i] = y;

            int sx = rand.nextInt(1,3);
            int sy = rand.nextInt(1,3);

            SpeedX[i] = 3 * (float) Math.pow(-1f, sx);
            SpeedY[i] = 3 * (float) Math.pow(-1f, sy);

        }
    }

    public void draw() {
        background(1,2,3);

        stroke(0,0,255);
        fill(1,2,3);
        rect(width / 2f - 400, height / 2f, 400, 400);
        rect(width / 2f + 400, height / 2f, 400, 400);

        stroke(1,2,3);
        rect(width / 2f,height / 2f,400, 200);

        stroke(0,0,255);
        line(width / 2f - 200, height / 2f - 100,width / 2f + 200, height / 2f - 100); // upper line
        line(width / 2f - 200, height / 2f + 100,width / 2f + 200, height / 2f + 100); // lower line

        for(int i = 0;i < 50;i++) {
            drawBall(px[i], py[i]);
            px[i] += SpeedX[i];
            py[i] += SpeedY[i];
        }


        for(int i = 0;i < 50;i++) {

            if(px[i] >= width / 2f - 600f + 15f) SpeedX[i] = -SpeedX[i]; // left wall
            if(px[i] <= width / 2f + 600f - 15f) SpeedX[i] = -SpeedX[i]; // right wall

            if(py[i] <= height / 2f - 200f + 15f) SpeedY[i] = -SpeedY[i]; // upper wall
            if(py[i] >= height / 2f + 200f - 15f) SpeedY[i] = -SpeedY[i]; // lower wall



            if(py[i] <= height / 2f - 100 && px[i] >= width / 2f - 200 - 15 && px[i] <= width / 2f + 200 && SpeedX[i] > 0) SpeedX[i] = -SpeedX[i]; // верхняя левая //
            if(py[i] >= height / 2f + 100 && px[i] >= width / 2f - 200 - 15 && px[i] <= width / 2f + 200 && SpeedX[i] > 0) SpeedX[i] = -SpeedX[i]; // нижжняя левая


            if(py[i] <= height / 2f - 100 && px[i] <= width / 2f + 200 + 15 && px[i] >= width / 2f - 200 && SpeedX[i] < 0) SpeedX[i] = -SpeedX[i];
            if(py[i] >= height / 2f + 100 && px[i] <= width / 2f + 200 + 15 && px[i] >= width / 2f - 200 && SpeedX[i] < 0) SpeedX[i] = -SpeedX[i];


            if((px[i] >= width / 2f - 200f && px[i] <= width / 2f + 200f) && (py[i] <= height / 2f - 100f + 15f) && SpeedY[i] < 0) SpeedY[i] = -SpeedY[i];
            if((px[i] >= width / 2f - 200f && px[i] <= width / 2f + 200f) && (py[i] >= height / 2f + 100f - 15f) && SpeedY[i] > 0) SpeedY[i] = -SpeedY[i];

        }

        cntBox1 = 0;
        cntBox2 = 0;

        for(int i = 0;i < 50;i++) {
            if(px[i] >= width / 2f - 600f && px[i] <= width / 2f - 200f) cntBox1++;
            if(px[i] <= width / 2f + 600f && px[i] >= width / 2f + 200f) cntBox2++;
        }

        textSize(40);
        text(cntBox1, width / 2f - 400, height / 2f - 220);
        text(cntBox2, width / 2f + 400, height / 2f - 220);




//        fill(255,0,0);
//        circle(width / 2 - 200, height / 2 - 200,20);

//        if(px[i] <= width / 2f - 600f + 15f) SpeedX[i] = -SpeedX[i]; // left wall
//        if(px[i] >= width / 2f + 600f - 15f) SpeedX[i] = -SpeedX[i]; // right wall
//
//        if(py[i] <= height / 2f - 200f + 15f) SpeedY[i] = -SpeedY[i]; // upper wall
//        if(py[i] >= height / 2f + 200f - 15f) SpeedY[i] = -SpeedY[i]; // lower wall
//
//
//        if(py[i] <= height / 2 - 100 + 15 && px[i] >= width / 2 - 200 - 15 && px[i] <= width / 2 + 200) SpeedX[i] = -SpeedX[i];
//        if(py[i] >= height / 2 + 100 - 15 && px[i] >= width / 2 - 200 - 15 && px[i] <= width / 2 + 200) SpeedX[i] = -SpeedX[i];
//
//
//        if(py[i] <= height / 2 - 100 + 15 && px[i] <= width / 2 + 200 + 15 && px[i] >= width / 2 - 200) SpeedX[i] = -SpeedX[i];
//        if(py[i] >= height / 2 + 100 - 15 && px[i] <= width / 2 + 200 + 15 && px[i] >= width / 2 - 200) SpeedX[i] = -SpeedX[i];
//
//
//        if((px[i] > width / 2 - 200 + 15 && px[i] <= width / 2 + 200 - 15) && (py[i] <= height / 2 - 100 + 15)) SpeedY[i] = -SpeedY[i];
//        if((px[i] > width / 2 - 200 + 15 && px[i] <= width / 2 + 200 - 15) && (py[i] >= height / 2 + 100 - 15)) SpeedY[i] = -SpeedY[i];

        // Countring

//        for(int i = 0;i < 50;i++) {
//
//        }

//        fill(255,0,0);
//
//        circle(width / 2f - 200 - 15 , height / 2f - 100 + 15, 10);
//        circle(width / 2f - 200 - 15 , height / 2f + 100 - 15, 10);

//        circle(width / 2 - 600 + 15, height / 2, 30);
//        circle(width / 2 - 200 - 15, height / 2, 30);
//
//        circle(width / 2 - 600 + 15, height / 2 - 200 + 15, 30);
//        circle(width / 2 - 200 - 15, height / 2 + 200 - 15, 30);



    }

    public static void main(String[] args) {
        PApplet.main("Problem04");
    }
}
//if(px[i] <= width / 2f - 600f + 15f) SpeedX[i] = -SpeedX[i]; // left wall
//        if(px[i] >= width / 2f + 600f - 15f) SpeedX[i] = -SpeedX[i]; // right wall
//
//        if(py[i] <= height / 2f - 200f + 15f) SpeedY[i] = -SpeedY[i]; // upper wall
//        if(py[i] >= height / 2f + 200f - 15f) SpeedY[i] = -SpeedY[i]; // lower wall
//
//        if(py[i] <= height / 2 - 100 - 15 && px[i] >= width / 2 - 200f - 15) SpeedX[i] = -SpeedX[i];
//        if(py[i] >= height / 2 + 100 + 15 && px[i] >= width / 2 - 200f - 15) SpeedX[i] = -SpeedX[i];