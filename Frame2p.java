package Ludo;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Frame2p implements ActionListener {
    JButton ex;
    public Frame2p() {
        JFrame jframe = new JFrame();
        jframe.setBounds(10, 10, 1000, 600);
        jframe.setTitle("LUDO");
        jframe.setResizable(false);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ex = new JButton("Exit");
        jframe.add(ex);
        ex.setBounds(750, 500, 100, 50);
        ex.addActionListener(this);
        ex.setBackground(Color.CYAN);

        GameMoves2p gm = new GameMoves2p();
        gm.setFocusable(true);
        gm.addKeyListener(gm);
        gm.addMouseListener(gm);
        jframe.add(gm);
        jframe.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
////

}

