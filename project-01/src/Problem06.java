import processing.core.PApplet;


public class Problem06 extends PApplet {

    float radiusMoon = 0;
    float rSun = 0;

    boolean fVenus = false;
    boolean fEarth = false;
    boolean fMoon = false;

    public void settings() {
        fullScreen();
    }

    public void objectDraw(float x, float y, float rad, float r, float g, float b) {
        float h1 = rad / 100;
        float r1 = r / 100, g1 = g / 100, b1 = b / 100;
        float r2 = 0, g2 = 0, b2 = 0;
        for(int i = 0;i < 100;i++) {
            fill(r2,g2,b2);
            circle(x, y, rad);
            r2 += r1;
            g2 += g1;
            b2 += b1;
            rad -= h1;
        }

    }
    public void objectName(String s, float y) {
        fill(0,0,255);
        textSize(50);
        rect(width - 150, 87.5f + y, 200, 75);
        fill(255,255,255);
        text(s,width - 150, 87.5f + y + 10);
    }

    public void drawOrbite(float w, float h, float x) {
        strokeWeight(1);
        stroke(255,0,0);
        fill(0,0,0);
        circle(w, h, x);
    }

    public static boolean mouseInObject(float mX, float mY, float x, float x1, float y, float y1) {
        if(mX > x && mX < x1 && mY > y && mY < y1) return true;
        else {
            return false;
        }
    }

    public void setup() {
        background(1,2,3);

        rectMode(CENTER);
        textAlign(CENTER);

        radiusMoon = 0;
    }

    public void draw() {

        background(1,2,3);

        fVenus = false;
        fEarth = false;
        fMoon = false;

        // stroke(255,255,255);
        // fill(0,0,0);
        // rect(width - 150, 200, 200,300);

        stroke(255,255,255);
        strokeWeight(1);
        objectName("Sun", 0f);
        objectName("Venus", 75f);
        objectName("Earth", 150f);
        objectName("Moon", 225f);

        if(mouseInObject(mouseX, mouseY, width - 150 - 100, width - 150 + 100, 200 - 150,125)) {
            stroke(255,0,0);
            strokeWeight(3);
            objectName("Sun", 0f);

            drawOrbite(width / 2f, height / 2f, 320);
        }
        if(mouseInObject(mouseX, mouseY, width - 150 - 100, width - 150 + 100, 200 - 150 + 75,200)) {
            stroke(255,0,0);
            strokeWeight(3);
            objectName("Venus", 75f);

            drawOrbite(width / 2f, height / 2f,500);

            fVenus = true;
        }
        if(mouseInObject(mouseX, mouseY, width - 150 - 100, width - 150 + 100, 200 - 150 + 150,275)) {
            stroke(255,0,0);
            strokeWeight(3);
            objectName("Earth", 150f);

            drawOrbite(width / 2f, height / 2f,800);

            fEarth = true;
        }
        if(mouseInObject(mouseX, mouseY, width - 150 - 100, width - 150 + 100, 200 - 150 + 225, 350)) {
            stroke(255,0,0);
            strokeWeight(3);
            objectName("Moon", 225f);

            fMoon = true;
        }

        noStroke();

        pushMatrix();

        translate(width / 2, height / 2);

        rotate(degrees(rSun));

        objectDraw(0,0,300,255,234,0);


        if(fVenus) {
            drawOrbite(250,0,120);

            noStroke();

            objectDraw(250,0,100,0,191,255);
        }
        else {
            noStroke();

            objectDraw(250,0,100,0,191,255);
        }

        if(fEarth) {

            drawOrbite(-400,0,90);

            noStroke();
            objectDraw(-400,0,70,0,0,250);
        }
        else {
            noStroke();

            objectDraw(-400,0,70,0,0,250);
        }

        translate(-400,0);
        if(fMoon) {

            drawOrbite(0,0,160);

            noStroke();

            objectDraw(0,0,80,0,0,250);

            strokeWeight(1);
            rotate(degrees(radiusMoon * 3));
            drawOrbite(80, 0, 40);

            noStroke();

            objectDraw(80,0,20,105,105,105);

        }
        else {
            noStroke();
            rotate(degrees(radiusMoon * 3));
            objectDraw(80,0,20,105,105,105);
        }
        popMatrix();

        rSun += 0.0004;

        radiusMoon += 0.0004;
    }
    public static void main(String[] args) {
        PApplet.main("Problem06");
    }
}