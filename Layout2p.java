package Ludo;




import javax.swing.*;
import java.awt.*;

public class Layout2p extends JFrame{

    int x,y,width,height;
    JButton b1, b2, b3, b4;
    public Layout2p(int xi,int yi) {
        x=xi;
        y=yi;
        width=30;
        height=30;
    }
    public void draw(Graphics2D g){
        g.setColor(Color.WHITE);
        g.fillRect(x,y,15*width,15*height);

        // block having all the goats
        for(int i=0;i<6;i++) {
            g.setColor(Color.RED);
            g.fillRect(x+(i*width),y, width, height);
            g.fillRect(x, y+(i*height), width, height);
            g.fillRect(x+(i*width),y+(5*height), width, height);
            g.fillRect(x+(5*width), y+(i*height), width, height);
            g.setColor(Color.GREEN);
            g.fillRect(x+((i+9)*width),y, width, height);
            g.fillRect(x+(9*width), y+(i*height), width, height);
            g.fillRect(x+((i+9)*width),y+(5*height), width, height);
            g.fillRect(x+(14*width), y+(i*height), width, height);
            g.setColor(Color.YELLOW);
            g.fillRect(x+((i+9)*width),y+(9*height), width, height);
            g.fillRect(x+(9*width), y+((i+9)*height), width, height);
            g.fillRect(x+((i+9)*width),y+(14*height), width, height);
            g.fillRect(x+(14*width), y+((i+9)*height), width, height);
            g.setColor(Color.BLUE);
            g.fillRect(x+(i*width),y+(9*height), width, height);
            g.fillRect(x, y+((i+9)*height), width, height);
            g.fillRect(x+(i*width),y+(14*height), width, height);
            g.fillRect(x+(5*width), y+((i+9)*height), width, height);
        }

        // winning line
        for(int i=1;i<6;i++) {
            g.setColor(Color.RED);
            g.fillRect(x+(i*width),y+(7*height), width, height);
            g.setColor(Color.YELLOW);
            g.fillRect(x+((8+i)*width),y+(7*height), width, height);
            g.setColor(Color.GREEN);
            g.fillRect(x+(7*width),y+(i*height), width, height);
            g.setColor(Color.BLUE);
            g.fillRect(x+((7)*width),y+((8+i)*height), width, height);
        }

        // home and winning stop
        g.setColor(Color.RED);
        g.fillRect(x+(1*width),y+(6*height), width, height);
//        g.fillRect(x+(2*width),y+(8*height), width, height);
        g.setColor(Color.YELLOW);
        g.fillRect(x+((13)*width),y+(8*height), width, height);
//        g.fillRect(x+((12)*width),y+(6*height), width, height);
        g.setColor(Color.GREEN);
        g.fillRect(x+(8*width),y+(1*height), width, height);
//        g.fillRect(x+(6*width),y+(2*height), width, height);
        g.setColor(Color.BLUE);
        g.fillRect(x+((6)*width),y+((13)*height), width, height);
//        g.fillRect(x+((8)*width),y+((12)*height), width, height);

        int temp1=x+45,temp2=y+45;
        for(int i=0;i<2;i++) {
            for(int j=0;j<2;j++) { //rects holding goats
                g.setColor(Color.RED);
                g.fillRect(temp1+(2*i*width),temp2+(2*j*height), width, height);
                g.setColor(Color.YELLOW);
                g.fillRect(temp1+(2*i*width)+9*width,temp2+(2*j*height)+9*height, width, height);
                g.setColor(Color.GREEN);
                g.fillRect(temp1+(2*i*width)+9*width,temp2+(2*j*height), width, height);
                g.setColor(Color.BLUE);
                g.fillRect(temp1+(2*i*width),temp2+(2*j*height)+9*height, width, height);
            }
        }

        // triangles for winning area
        g.setColor(Color.RED);
        int xpoints0[] = {x+(6*width),x+(6*width), x+15+(7*width)};
        int ypoints0[] = {y+(6*height),y+(9*height),y+15+(7*width)};
        int npoints = 3;
        g.fillPolygon(xpoints0, ypoints0, npoints);
        g.setColor(Color.YELLOW);
        int xpoints1[] = {x+(9*width),x+(9*width), x+15+(7*width)};
        int ypoints1[] = {y+(6*height),y+(9*height),y+15+(7*width)};
        int npoints1= 3;
        g.fillPolygon(xpoints1, ypoints1, npoints1);
        g.setColor(Color.GREEN);
        int xpoints2[] = {x+(6*width),x+(9*width), x+15+(7*width)};
        int ypoints2[] = {y+(6*height),y+(6*height),y+15+(7*width)};
        int npoints2= 3;
        g.fillPolygon(xpoints2, ypoints2, npoints2);
        g.setColor(Color.BLUE);
        int xpoints3[] = {x+(6*width),x+(9*width), x+15+(7*width)};
        int ypoints3[] = {y+(9*height),y+(9*height),y+15+(7*width)};
        int npoints3= 3;
        g.fillPolygon(xpoints3, ypoints3, npoints3);

        g.setStroke(new BasicStroke(2)); //pen width
        g.setColor(Color.BLACK);
        for(int i=0;i<3;i++) {
            for(int j=0;j<6;j++) {
                // rects between red and green
                g.drawRect(x+((i+6)*width),y+(j*height), width, height);
                // between red and blue
                g.drawRect(x+((j)*width),y+((i+6)*height), width, height);
                // blue and yellow
                g.drawRect(x+((i+6)*width),y+((j+9)*height), width, height);
                // green and yellow
                g.drawRect(x+((j+9)*width),y+((i+6)*height), width, height);
            }
        }
        // red
        g.drawRect(x+((1)*width),y+(1*height),4*width,4*height);
        // green
        g.drawRect(x+((10)*width),y+(1*height),4*width,4*height);
        // blue
        g.drawRect(x+((1)*width),y+(10*height),4*width,4*height);
        // yellow
        g.drawRect(x+((10)*width),y+(10*height),4*width,4*height);
//        full
        g.drawRect(x,y,15*width,15*height);

        // rects inside home
        for(int i=0;i<2;i++) {
            for(int j=0;j<2;j++) {
                g.drawRect(temp1+(2*i*width),temp2+(2*j*height), width, height);
                g.drawRect(temp1+(2*i*width)+9*width,temp2+(2*j*height)+9*height, width, height);
                g.drawRect(temp1+(2*i*width)+9*width,temp2+(2*j*height)+0*height, width, height);
                g.drawRect(temp1+(2*i*width)+0*width,temp2+(2*j*height)+9*height, width, height);
            }
        }
        // triangles
        g.drawPolygon(xpoints0, ypoints0, npoints);
        g.drawPolygon(xpoints1, ypoints1, npoints1);
        g.drawPolygon(xpoints2, ypoints2, npoints2);
        g.drawPolygon(xpoints3, ypoints3, npoints3);

        // stops
        g.drawOval(x+5+(6*width),y+5+(2*height),width-10,height-10);
        g.drawOval(x+5+(12*width),y+5+(6*height),width-10,height-10);
        g.drawOval(x+5+(8*width),y+5+(12*height),width-10,height-10);
        g.drawOval(x+5+(2*width),y+5+(8*height),width-10,height-10);

        g.setFont(new Font("Times new roman", Font.BOLD, 40));
//        g.drawString("Player 1", 90, 35);
        g.drawString("Player 1", 370, 35);
        g.drawString("Player 2", 90, 540);
//        g.drawString("Player 3", 370, 540);
        g.drawString("Instruction:", 550,300);
        g.drawString("1.Press enter to roll dice.", 550,350);
        g.drawString("2.Click on coin to move.", 550,400);

        b1 = new JButton("Leave");
        b1.setBounds(10, 60, 30, 40);
        add(b1);
//        b2 = new JButton("Leave");
//        b1.setBounds(10, 60, 50, 40);
//        b3 = new JButton("Leave");
//        b1.setBounds(10, 60, 50, 40);
//        b4 = new JButton("Leave");


    }
}
