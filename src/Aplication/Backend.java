package Aplication;


import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class Backend {
Path path;
    int lines = 0;
    List<String> States = new ArrayList();
    List<String> Capitals = new ArrayList();
    public void explorer()
    {

        try {
            System.out.println(getInputPath("explorer C:\\documents"));
        }catch(Exception e)
        {
            System.out.println("Problem z plikiem");
        }

    }
    public void explorerfile()
    {
        try {
            path=getInputPath("explorer C:\\documents");
            System.out.println(path);
            ReadFile();
        }catch(Exception e)
        {
            System.out.println("Problem z plikiem");
        }
    }
    public static Path getInputPath(String s) {

        //pytajnik inaczej if else podmienia new JFileChooser
        JFileChooser jd = s == null ? new JFileChooser() : new JFileChooser(s);

        jd.setDialogTitle("Wybierz plik");
        int returnVal= jd.showOpenDialog(null);

        if (returnVal != JFileChooser.APPROVE_OPTION) {
            return null;
        }
        return jd.getSelectedFile().toPath();

    }
    public void ReadFile()
    {

        File file= new File(String.valueOf(path));
        System.out.println(file);
            try 
            {

                BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(path)));

                while (reader.readLine() != null) {
                    lines++;
                }

                System.out.println(lines);
                reader.close();
                BufferedReader reader2 = new BufferedReader(new FileReader(String.valueOf(path)));
                for(int i=1;i<=lines;i++)
                {
                    if(i%2==1) {
                        States.add(reader2.readLine());
                    }
                    else{
                        Capitals.add(reader2.readLine());
                    }
                }
                reader2.close();

            }
            catch (Exception e)
            {
                System.out.println("Nie znaleziono pliku");
            }

    }
    List<String> returnListStates()
    {
        return States;
    }
}
