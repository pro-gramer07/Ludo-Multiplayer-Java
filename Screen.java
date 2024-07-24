package Ludo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Screen implements KeyListener {
    JLabel label, label2;
    JFrame frame;
    JButton btn;

    public Screen() {
        frame = new JFrame("LUDO");
        frame.getContentPane().setBackground(Color.BLUE);

        Icon i = new ImageIcon(getClass().getResource("ludo2.png"));
        label = new JLabel(" Press 2 for 2 Player | Press 3 for 3 Player | Press 4 for 4 Player");
        label.setFont(new Font("Calibri", Font.BOLD, 25));
        label.setForeground(Color.WHITE);
        label.setIcon(i);
        label.setVerticalTextPosition(SwingConstants.BOTTOM);
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        frame.add(label);
        frame.addKeyListener(this);



        frame.setSize(900, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        new Screen();

    }



    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_2){
            frame.dispose();
            new Frame2p();
        }
        if(e.getKeyCode()==KeyEvent.VK_3){
            frame.dispose();
            new Frame3p();
        }
        if(e.getKeyCode()==KeyEvent.VK_4){
            frame.dispose();
            new Frame4p();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_2){
            frame.dispose();
            new Frame2p();
        }
        if(e.getKeyCode()==KeyEvent.VK_3){
            frame.dispose();
            new Frame3p();
        }
        if(e.getKeyCode()==KeyEvent.VK_4){
            frame.dispose();
            new Frame4p();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
