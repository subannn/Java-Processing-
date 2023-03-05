import processing.core.PApplet;
import java.util.Random;

public class Problem02 extends PApplet {
    String s1 = "Java slogan:";
    String s2 = "Write once,";
    String s3 = "run anywhere!";
    int size1 = 100, size2 = 100, size3 = 100;

    int x1,x2,x3;

    boolean f = true;
    int c = 1;


    public void settings() {
        fullScreen();
    }

    public void setup() {
        background(1,2,3);
        textAlign(CENTER);
        x1 = 100;
        x2 = 100;
        x3 = 100;
        f = true;
        c = 1;
    }

    public void draw() {
        background(1,2,3);

        textSize(size1);
        fill(255,0,0);
        text(s1, width / 2, height / 4);

        textSize(size2);
        fill(0,255,0);
        text(s2, width / 2, height / 2);

        textSize(size3);
        fill(0,0,255);
        text(s3, width / 2, height / 2 + height / 4);

        if(c == 1)
        {
            if(size1 == 200) f = false;
            if(f == true)
            {
                size1++;
            }
            else if(f == false && size1 > 100)
            {
                size1--;
            }
            else
            {
                c++;
                f = true;
            }
        }
        if(c == 2)
        {
            if(size2 == 200) f = false;
            if(f == true)
            {
                size2++;
            }
            else if(f == false && size2 > 100)
            {
                size2--;
            }
            else
            {
                c++;
                f = true;
            }

        }
        if(c == 3)
        {
            if(size3 == 200) f = false;
            if(f == true)
            {
                size3++;
            }
            else if(f == false && size3 > 100)
            {
                size3--;
            }
            else
            {
                c = 1;
                f = true;
            }
        }





    }

    public static void main(String[] args) {
        PApplet.main("Problem02");
    }
}