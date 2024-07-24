package Ludo;



import java.awt.Graphics2D;

public class Player4p {
    int height,width,status,coin;
    Goat4p[] pa=new Goat4p[4];
    public Player4p(int height, int width) {
        status=-1;
        coin=0;
        for(int i=0;i<4;i++) {
            pa[i]=new Goat4p(height,width);
        }
    }
    public void draw(Graphics2D g) {

    }
}
