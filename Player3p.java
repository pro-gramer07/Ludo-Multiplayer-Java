package Ludo;




import Ludo.Goat3p;

import java.awt.Graphics2D;

public class Player3p {
    int height,width,status,coin;
    Goat3p[] pa=new Goat3p[4];
    public Player3p(int height,int width) {
        status=-1;
        coin=0;
        for(int i=0;i<4;i++) {
            pa[i]=new Goat3p(height,width);
        }
    }
    public void draw(Graphics2D g) {

    }
}
