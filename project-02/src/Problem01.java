import processing.core.PApplet;

import java.util.Random;


public class Problem01 extends PApplet {

    void drawSnowFlake(float x, float y, float r, float d) {
        pushMatrix();

        translate(x,y);

        rotate(degrees(d * 0.0001f));

        stroke(233,233,233, 255f - (1500f / r));
        strokeWeight(3f);
        line(0 + 5f,0 + 5f,0 + 5f,r + 5f);
        line(0 + 5f,0 + 5f,r + 5f,0 + 5f);
        line(0 - r + 5 ,0 + 5f,0 + 5f,0 + 5f);
        line(0 + 5f,0 + 5f,0 + 5f,- r + 5f);

        line(0 + 5f, 0 + 5f,r / 2 + 5f, r / 2 + 5f);
        line(0 + 5f, 0 + 5f,-r / 2 + 5f, -r / 2 + 5f);
        line(0 + 5f, 0 + 5f,-r / 2 + 5f, r / 2 + 5f);
        line(0 + 5f, 0 + 5f,r / 2 + 5f, -r / 2 + 5f);

        popMatrix();





//        line(x, y, x + r, y);
//        line(x, y, x - r, y);
//        line(x, y, x, y + r);
//        line(x, y, x, y - r);
//
//        line(x,y, (x + r + x) / 2, (y + r + y) / 2);
//        line(x,y, (x + x - r) / 2, (y + y- r) / 2);
//
//        line(x,y, (x + r + x) / 2, (y + y - r) / 2);
//        line(x,y, (x + x - r) / 2, (y + r + y) / 2);
    }

    float[] x = new float[100];
    float[] y = new float[100];
    float[] size = new float[100];

    float[] rot = new float[100];

    boolean[] pov = new boolean[100];

    float[] s = new float[100];

    float d = 0;






    public void settings() {
        fullScreen();
    }

    public void setup() {
        background(1,2,3);
        Random rand = new Random();

        for(int i = 0;i < 100;i++) {
            float x1 = rand.nextFloat(width);
            float y1 = rand.nextFloat(height);
            float s1 = rand.nextFloat(10,40);
            float speedOfFalling = rand.nextFloat(10,50);

            x[i] = x1;
            y[i] = y1;
            size[i] = s1;
            s[i] = speedOfFalling;

            if(i % 2 == 0) pov[i] = false;
            else pov[i] = true;



        }

        d = 0;


    }

    public void draw() {
        background(1,2,3);
        Random rand = new Random();



        for(int i = 0;i < 100;i++) {
            drawSnowFlake(x[i], y[i], size[i], rot[i]);

            float x1 = rand.nextFloat(width);

            float d = rand.nextFloat(5, 15);

            float speedOfFalling = rand.nextFloat(10,50);



            if(y[i] >= height) {
                y[i] = -15;
                x[i] = x1;
                rot[i] = d;
                s[i] = speedOfFalling;
            }

            y[i] += s[i] * 0.08;
            if(i % 2 == 0) rot[i] += d;
            else rot[i] -= d;



        }











    }

    public static void main(String[] args) {
        PApplet.main("Problem01");
    }
}