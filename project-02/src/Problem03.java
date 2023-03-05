import processing.core.PApplet;

import java.util.Random;


public class Problem03 extends PApplet {
    Random rand = new Random();

    float[] px = new float[200];
    float[] py = new float[200];
    float[] size = new float[200];

    int[] rgb = new int[200];

    float m = 1.015f;
    float ms = 1.015f;

    float sz;

    public void settings() {
        fullScreen();
    }

    public void setup() {
        background(1,2,3);
        Random rand = new Random();



        m = 1.018f;



        sz = width / 1000f;

        translate(width / 2, height / 2);
        for(int i = 0;i < 200;i++) {
            while(true) {
                px[i] = rand.nextFloat(-width / 2, width / 2);
                py[i] = rand.nextFloat(-height / 2, height / 2);
                rgb[i] = rand.nextInt(3);
                size[i] = sz;

                if(Math.sqrt(Math.pow(px[i],2) + Math.pow(py[i],2)) > 100) break;
            }

        }
        fill(255,0,0);

    }

    public void draw() {
        noStroke();
        fill(0,50);
        rect(0,0,width,height);
        translate(width / 2, height / 2);

        for(int i = 0;i < 200;i++){
            int[] cl = getRgb(rgb[i]);
            fill(cl[0], cl[1], cl[2]);
            circle(px[i], py[i], size[i]);
            px[i] *= m;
            py[i] *= m;
            size[i] *= m;

            if(px[i] > width / 2 + size[i] || px[i] < -width / 2 - size[i] || py[i] > height / 2 + size[i] || py[i] < -height / 2 - size[i]) {

                while(true) {
                    px[i] = rand.nextFloat(-width / 2, width / 2);
                    py[i] = rand.nextFloat(-height / 2, height / 2);
                    rgb[i] = rand.nextInt(3);
                    size[i] = sz;

                    if(Math.sqrt(Math.pow(px[i],2) + Math.pow(py[i],2)) > 100) break;
                }


            }
        }
//        fill(255,0,0);
//        circle(-100, 0,100);


    }
    public int[] getRgb(int c) {
        return switch (c) {
            case 0 -> new int[]{255, 0, 0};
            case 1 -> new int[]{0, 255, 0};
            case 2 -> new int[]{0, 0, 255};
            default -> null;
        };
    }

    public static void main(String[] args) {
        PApplet.main("Problem03");
    }
}