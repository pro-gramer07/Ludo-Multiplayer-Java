package Ludo;


import java.awt.*;

public class Goat3p {
    int x,y;
    int current;
    int height,width;
    public Goat3p(int h, int w){
        current=-1;
        x=-1;
        y=-1;
        height=h;
        width=w;
    }
    public void draw(Graphics2D g, int i, int j,int play) {
        if(current==-1) {
            int temp1=80+(height/2),temp2=50+(width/2);
            x=i;
            y=j;
//            if(play==0) {
//                g.setColor(Color.RED);
//            }
            if(play==0) {
                g.setColor(Color.GREEN);
            }
            else if(play==1) {
                g.setColor(Color.YELLOW);
            }
            else if(play==2) {
                g.setColor(Color.BLUE);
            }
            g.fillOval(temp1+5+(i*width),temp2+5+(j*height),width-10,height-10);
            g.setStroke(new BasicStroke(2));
            g.setColor(Color.BLACK);
            g.drawOval(temp1+5+(i*width),temp2+5+(j*height),width-10,height-10);
        }
        else
        {
            int temp1=80,temp2=50;
            x= Path3p.ax[play][current];
            y= Path3p.ay[play][current];
//            if(play==0) {
//                g.setColor(Color.RED);
//            }
            if(play==0) {
                g.setColor(Color.GREEN);
            }
            else if(play==1) {
                g.setColor(Color.YELLOW);
            }
            else if(play==2) {
                g.setColor(Color.BLUE);
            }
            g.fillOval(temp1+5+(x*width),temp2+5+(y*height),width-10,height-10);
            g.setStroke(new BasicStroke(2));
            g.setColor(Color.BLACK);
            g.drawOval(temp1+5+(x*width),temp2+5+(y*height),width-10,height-10);
        }
    }
}
