package Aplication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Frontend extends JFrame implements ActionListener {
    private final Backend Backend = new Backend();
    JLabel thumb,pktthiswindow;
    ImageIcon img;
    JMenuBar menuBar;
    JMenu option,country,capital,info;
    JMenuItem zasady,fileexp;
    JCheckBoxMenuItem pointscounting,otherwindow,thiswindow,consoleinfo;
    JButton expl,testpoints;
    boolean console=false,pointwimdow=false;
    int pktdodaj=0;
    Pktwindow pktwindow = new Pktwindow();
    Frontend()
    {
        //Frame
        this.setTitle("Państwa Miasta");
        this.setSize(650,450);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        //MenuBar
        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        //opcje
        option = new JMenu("Opcje");
        menuBar.add(option);
        fileexp = new JMenuItem("Załaduj plik");
        option.add(fileexp);
        fileexp.addActionListener(this);
        pointscounting = new JCheckBoxMenuItem("Licznie pkt");
        option.add(pointscounting);
        pointscounting.setSelected(true);
        pointscounting.addActionListener(this);
        thiswindow = new JCheckBoxMenuItem("Te okno pkt");
        option.add(thiswindow);
        thiswindow.addActionListener(this);
        otherwindow = new JCheckBoxMenuItem("Inne okno z pkt");
        option.add(otherwindow);
        otherwindow.addActionListener(this);
        consoleinfo = new JCheckBoxMenuItem("Wyświetl w konsoli");
        consoleinfo.addActionListener(this);
        option.add(consoleinfo);

        //kraj
        country = new JMenu("Kraj");
        menuBar.add(country);
        //Stolica
        capital = new JMenu("Stolica");
        menuBar.add(capital);
        //Informacje
        info = new JMenu("Informacje");
        menuBar.add(info);
        zasady = new JMenuItem("zasady");
        info.add(zasady);
        zasady.addActionListener(this);

        //Background
        img = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/2137n1.png")));
        thumb = new JLabel(img);
        thumb.setSize(650,450);
        this.add(thumb);

        //Button explorer
        expl = new JButton("Explorer");
        expl.setBounds(275,325,100,50);
        thumb.add(expl);
        expl.addActionListener(this);

        //Test point button
        testpoints = new JButton("Dodaj pkt");
        testpoints.setBounds(275,225,100,50);
        thumb.add(testpoints);
        testpoints.addActionListener(this);


        // pkt w oknie
        pktthiswindow = new JLabel();
        pktthiswindow.setBounds(50,50,100,50);
        pktthiswindow.setText("<html><span style='font-size:15px'><font color='white'>PKT:</font> <font color='red'>"+pktdodaj+"</font></span></html>");
        pktthiswindow.setVisible(false);
        thumb.add(pktthiswindow);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==expl)
        {
            Backend.explorer();
            if(console)
            {
                System.out.println("Wybieranie tla");
            }
        }
        if(e.getSource()==zasady)
        {
                SwingUtilities.invokeLater(Info::new);
                if(console)
                {
                    System.out.println("Wybrano zasady");
                }
        }
        if(e.getSource()==fileexp)
        {
            Backend.explorerfile();
            List<String> Miasta = new ArrayList<>();
            Miasta.addAll(Backend.States);

            int i = 1;
            while (i <= Miasta.size()) {
                JMenuItem item = new JMenuItem(Miasta.get(i));

                item.addActionListener(this);
                System.out.println(Miasta.get(i));
                i++;

            }
            if(console)
            {
                System.out.println("Wybieranie pliku...");
            }
        }
        if(e.getSource()==consoleinfo)
        {
            if(consoleinfo.isSelected())
            {
                System.out.println("Włączono wyświetlanie w konsoli");
                console=true;
            }
            if(!consoleinfo.isSelected())
            {
                System.out.println("Wyłączono wyświetlanie w konsoli");
                console=false;
            }

        }
        if(e.getSource()==thiswindow)
        {
            if(console && thiswindow.isSelected())
            {
                System.out.println("Włączono wyświetlanie pkt w oknie głównym");
            }
            if(console && !thiswindow.isSelected())
            {
                System.out.println("Wyłączono wyświetlanie pkt w oknie głównym");
            }
            if(thiswindow.isSelected())
            {
                pktthiswindow.setVisible(true);
            }
            if(!thiswindow.isSelected())
            {
                pktthiswindow.setVisible(false);
            }
        }
        if(e.getSource()==pointscounting)
        {
            if(console && pointscounting.isSelected())
            {
                System.out.println("Włączono licznie pkt");
            }
            else if(console && !pointscounting.isSelected())
            {
                System.out.println("Wyłączono licznie pkt");
            }
        }
        if(e.getSource()==testpoints)
        {
            if(pointscounting.isSelected())
            {
                pktdodaj++;
                pktthiswindow.setText("<html><span style='font-size:15px'><font color='white'>PKT:</font> <font color='red'>"+pktdodaj+"</font></span></html>");
                if(console)
                {
                    System.out.println("Dodano pkt");
                }
            }
        }
        if(e.getSource()==otherwindow)
        {
            if(otherwindow.isSelected())
            {
                if(console)
                {
                    System.out.println("Włączono dodatkowe okno z pkt");
                }
                if(pointwimdow) {
                    pktwindow.showwindow();
                }
                if(!pointwimdow) {
                    try {
                        SwingUtilities.invokeLater(Pktwindow::new);
                        pktwindow.showwindow();
                    } catch (Exception d) {
                        System.out.println("Nie da sie otworzyć okna");
                    }
                    pointwimdow=true;
                }
            }
            if(!otherwindow.isSelected())
            {
                if(pointwimdow) {
                    pktwindow.hidewindow();
                }
                if(console)
                {
                    System.out.println("Wyłączono dodatkowe okno z pkt");
                }
            }
        }

    }

}
