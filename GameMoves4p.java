package Ludo;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GameMoves4p extends JPanel implements KeyListener, ActionListener,MouseListener{

    private static final long serialVersionUID = 1L;
    Layout4p la;
    Build_Player4p p;
    Timer time;
    int delay=10;
    int current_player,dice;
    int flag=0,roll,kill=0;
    public GameMoves4p() {
        // disabling focus traversal keys (Tab for forward and shift + tab for backward)
        setFocusTraversalKeysEnabled(false);
        requestFocusInWindow();
        current_player=0;
        la = new Layout4p(80,50);
        p = new Build_Player4p(la.height,la.width);
        dice=0;
        flag=0;
        roll=0;
        kill=0;
    }


    @Override
    public void paint(Graphics g) {
        la.draw((Graphics2D)g);
        p.draw((Graphics2D)g);
        if(p.pl[current_player].coin==4) {
            g.setColor(Color.WHITE);
            g.fillRect(590, 100, 380,130);
            if(current_player==0) {
                g.setColor(Color.RED);
            }
            else if(current_player==1) {
                g.setColor(Color.GREEN);
            }
            else if(current_player==2) {
                g.setColor(Color.YELLOW);
            }
            else if(current_player==3) {
                g.setColor(Color.BLUE);
            }
            g.setFont(new Font("Times new roman", Font.BOLD, 40));
            g.drawString("Player "+(current_player+1)+" wins.", 600, 150);
            g.drawString("Congratulations.", 600, 200);
            current_player=0;
            la = new Layout4p(80,50);
            p=new Build_Player4p(la.height,la.width);
            dice=0;
            flag=0;
            roll=0;
            kill=0;
        }
        else if(dice!=0) {
            g.setColor(Color.WHITE);
            g.fillRect(590, 100, 380,130);
            if(current_player==0) {
                g.setColor(Color.RED);
            }
            else if(current_player==1) {
                g.setColor(Color.GREEN);
            }
            else if(current_player==2) {
                g.setColor(Color.YELLOW);
            }
            else if(current_player==3) {
                g.setColor(Color.BLUE);
            }
            g.setFont(new Font("serif", Font.BOLD, 40));
            g.drawString("Player "+(current_player+1), 600, 150);
            g.drawString("Number on dice is "+dice, 600, 200);
        }
        if(flag==0&&dice!=0&&dice!=6&&kill==0) {
            current_player=(current_player+1)%4;
        }
        kill=0;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER&&flag==0) {
            roll=0;
            dice=1 + (int)(Math.random() * 6);
            repaint();
            for(int i=0;i<4;i++) {
                if(p.pl[current_player].pa[i].current!=-1&&p.pl[current_player].
                        pa[i].current!=56&&(p.pl[current_player].pa[i].current+dice)<=56) {
                    flag=1;
                    break;
                }
            }
            if(flag==0&&dice==6) {
                for(int i=0;i<4;i++) {
                    if(p.pl[current_player].pa[i].current==-1) {
                        flag=1;
                        break;
                    }
                }
            }
        }
    }

    public void mouseClicked(MouseEvent e) {
        if(flag==1) {
            int x=e.getX();
            int y=e.getY();
            x=x-80;
            y=y-50;
            x=x/30;
            y=y/30;
            int value=-1;
            //System.out.println(x+" "+y);
            if(dice==6) {
                for(int i=0;i<4;i++) {
                    if(p.pl[current_player].pa[i].x==x&&p.pl[current_player].pa[i].y==y&&
                            (p.pl[current_player].pa[i].current+dice)<=56) {
                        value=i;
                        flag=0;
                        break;
                    }
                }
                if(value!=-1) {
                    p.pl[current_player].pa[value].current+=dice;
                    if(p.pl[current_player].pa[value].current==56) {
                        p.pl[current_player].coin++;
                    }
                    int k=0;
                    int hou=p.pl[current_player].pa[value].current;
                    if((hou%13)!=0&&(hou%13)!=8&&hou<51)
                    {
                        for(int i=0;i<4;i++) {
                            if(i!=current_player) {
                                for(int j=0;j<4;j++) {
                                    int tem1= Path4p.ax[current_player][p.pl[current_player].pa[value].current],
                                            tem2= Path4p.ay[current_player][p.pl[current_player].pa[value].current];
                                    if(p.pl[i].pa[j].x==tem1&&p.pl[i].pa[j].y==tem2) {
                                        p.pl[i].pa[j].current=-1;
                                        kill=1;
                                        k=1;
                                        break;
                                    }
                                }
                            }
                            if(k==1)
                                break;
                        }
                    }
                }
                else {
                    for(int i=0;i<4;i++) {
                        if(p.pl[current_player].pa[i].current==-1) {
                            p.pl[current_player].pa[i].current=0;
                            flag=0;
                            break;
                        }
                    }
                }
            }
            else {
                for(int i=0;i<4;i++) {
                    if(p.pl[current_player].pa[i].x==x&&p.pl[current_player].pa[i].y==y
                            &&(p.pl[current_player].pa[i].current+dice)<=56) {
                        value=i;
                        flag=0;
                        break;
                    }
                }
                if(value!=-1) {
                    p.pl[current_player].pa[value].current+=dice;
                    if(p.pl[current_player].pa[value].current==56) {
                        p.pl[current_player].coin++;
                    }
                    int k=0;
                    int hou=p.pl[current_player].pa[value].current;
                    if((hou%13)!=0&&(hou%13)!=8&&hou<51)
                    {
                        for(int i=0;i<4;i++) {
                            if(i!=current_player) {
                                for(int j=0;j<4;j++) {
                                    int tem1= Path4p.ax[current_player][p.pl[current_player].pa[value].current],
                                            tem2= Path4p.ay[current_player][p.pl[current_player].pa[value].current];
                                    if(p.pl[i].pa[j].x==tem1&&p.pl[i].pa[j].y==tem2) {
                                        p.pl[i].pa[j].current=-1;
                                        kill=1;
                                        k=1;
                                        break;
                                    }
                                }
                            }
                            if(k==1)
                                break;
                        }
                    }
                }
            }
            repaint();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent arg0) {

    }

    @Override
    public void keyTyped(KeyEvent arg0) {

    }

    @Override
    public void mouseEntered(MouseEvent arg0) {

    }

    @Override
    public void mouseExited(MouseEvent arg0) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {

    }


}
