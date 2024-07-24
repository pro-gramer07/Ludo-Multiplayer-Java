package Ludo;





import java.awt.Graphics2D;

public class Build_Player3p {

    Player3p[] pl=new Player3p[4];
    int[][] initialx= {
//            {1,1,3,3},
            {10,10,12,12},
            {10,10,12,12},
            {1,1,3,3}
    };
    int[][] initialy= {
//            {1,3,1,3},
            {1,3,1,3},
            {10,12,10,12},
            {10,12,10,12}
    };
    public Build_Player3p(int height, int width) {
        for(int i=0;i<4;i++) {
            pl[i]=new Player3p(height,width);
        }
    }
    public void draw(Graphics2D g) {
        for(int i=0;i<3;i++) {
            for(int j=0;j<4;j++) {
                pl[i].pa[j].draw(g,initialx[i][j],initialy[i][j],i);
            }
        }
    }
}

