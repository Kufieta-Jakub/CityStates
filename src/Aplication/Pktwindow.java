package Aplication;

import javax.swing.*;
import java.awt.*;

public class Pktwindow extends JFrame {
    JLabel pkt;
    Pktwindow() {
        //nadanie cech
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(new FlowLayout());
        this.setTitle("Okno z pkt");
        this.setResizable(false);
        this.setVisible(false);

        //panel
        pkt = new JLabel();

    }
    void hidewindow()
    {
        this.setVisible(false);
    }
    void showwindow()
    {
        this.setVisible(true);
    }

}
