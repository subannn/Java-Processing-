import processing.core.PApplet;

import java.util.Random;


public class Problem02 extends PApplet {

    float[] d = new float[100];

    float[] SnowLakeSize = new float[100];

    float[] Red = new float[100];
    float[] Green = new float[100];
    float[] Blue = new float[100];

    float[] px = new float[100];
    float[] py = new float[100];

    float[] SpeedX = new float[100];
    float[] SpeedY = new float[100];

    float[] Rotation = new float[100];


    void drawSnowLake(float x, float y, float size, float rc, float gc, float bc, float rotation) {


        float r = PI;
        pushMatrix();
        translate(x,y);
        rotate(degrees(rotation * 0.01f));

        for(int i = 0;i < 5;i++) {
            pushMatrix();
            rotate(r);
            stroke(rc, gc, bc);
            strokeWeight(4);
            line(-size, 0, size, 0);
            r += PI / 5;
            popMatrix();

        }
        popMatrix();

    }

    public void settings() {
        fullScreen();
    }

    public void setup() {
        background(1,2,3);
        rectMode(CENTER);

        Random rand = new Random();

        for(int i = 0;i < 100;i++) {
            d[i] = 0.05f;


            float size = rand.nextFloat(10, 50);
            SnowLakeSize[i] = size;

            float red = rand.nextFloat(15, 255);
            float green = rand.nextFloat(15, 255);
            float blue = rand.nextFloat(15, 255);

            Red[i] = red;
            Green[i] = green;
            Blue[i] = blue;

            float x = rand.nextFloat(SnowLakeSize[i], width - SnowLakeSize[i]);
            float y = rand.nextFloat(SnowLakeSize[i], height - SnowLakeSize[i]);

            px[i] = x;
            py[i] = y;

            float spX = rand.nextFloat(-30, 30);
            float spY = rand.nextFloat(-30, 30);

            SpeedX[i] = spX * 0.2f;
            SpeedY[i] = spY * 0.2f;

        }





    }

    public void draw() {
        background(1,2,3);


        for(int i = 0;i < 100;i++) {
            Rotation[i] += d[i];
            drawSnowLake(px[i], py[i], SnowLakeSize[i], Red[i], Green[i], Blue[i], Rotation[i]);

        }
        for(int i = 0;i < 100;i++) {
            px[i] += SpeedX[i];
            py[i] += SpeedY[i];
        }


        for(int i = 0;i < 100;i++) {
            if(px[i] >= width - (SnowLakeSize[i])) { // right
                SpeedX[i] = SpeedX[i] * -1;

                if(SpeedY[i] > 0 && d[i] > 0) {
                    d[i] = -d[i];
                }
                if(SpeedY[i] < 0 && d[i] < 0) {
                    d[i] = -d[i];
                }
            }
            if(px[i] <= SnowLakeSize[i])  { // left
                SpeedX[i] = SpeedX[i] * -1;

                if(SpeedY[i] > 0 && d[i] < 0) {
                    d[i] = -d[i];
                }
                if(SpeedY[i] < 0 && d[i] > 0) {
                    d[i] = -d[i];
                }
            }

            if(py[i] >= height - (SnowLakeSize[i])) { // down
                SpeedY[i] = SpeedY[i] * -1;

                if(SpeedX[i] > 0 && d[i] < 0) {
                    d[i] = -d[i];
                }
                if(SpeedX[i] < 0 && d[i] > 0) {
                    d[i] = -d[i];
                }
            }
            if(py[i] <= SnowLakeSize[i])  { // up
                SpeedY[i] = SpeedY[i] * -1;

                if(SpeedX[i] > 0 && d[i] > 0) {
                    d[i] = -d[i];
                }
                if(SpeedX[i] < 0 && d[i] < 0) {
                    d[i] = -d[i];
                }
            }

        }















    }

    public static void main(String[] args) {
        PApplet.main("Problem02");
    }
}