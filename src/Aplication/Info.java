package Aplication;

import javax.swing.*;
import java.awt.*;

public class Info extends JFrame{
    //info
    JLabel informacje;

    Info()
    {
        //nadanie cech
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(new FlowLayout());
        this.setTitle("Informacje");
        this.setResizable(false);
        this.setVisible(true);

        //panel

        informacje = new JLabel();
        informacje.setSize(500,500);
        informacje.setBackground(new Color(128, 253, 255));
        informacje.setBorder(BorderFactory.createLineBorder(Color.black));
        this.getContentPane().setLayout(new FlowLayout());
        this.add(informacje);
        informacje.setText("<html><center>" +
                "Witam!<br/>" +
                "Tutaj znajdują sie zasady gry. <br/>" +
                "W grze chodzi o to, aby uzyskać jak największy wynik <br/>" +
                "w dopasowywaniu stolicy do kraju. <br/>" +
                "Złe dopasowanie stolicy prowadzi do wyzerowania liczby punktów.<br/>" +
                "</center></html>");
        informacje.setOpaque(true); //defaultowo jest na false

    }
}
