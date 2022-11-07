package Aplication;

import javax.swing.*;

public class MainAplication {
    public static void main(String[] args) {
        try{
            SwingUtilities.invokeLater(Frontend::new);
        }catch(Exception e)
        {
            System.out.println("Wystąpił nieoczekiwany problem");
        }
    }
}
