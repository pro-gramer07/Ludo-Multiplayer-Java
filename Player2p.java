package Ludo;




import java.awt.Graphics2D;

public class Player2p {
    int height,width,status,coin;
    Goat2p[] pa=new Goat2p[4];
    public Player2p(int height,int width) {
        status=-1;
        coin=0;
        for(int i=0;i<4;i++) {
            pa[i]=new Goat2p(height,width);
        }
    }
    public void draw(Graphics2D g) {

    }
}
