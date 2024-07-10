package proyectoabyssrúbrica;

import javax.swing.*;

public class App {

    public static void main(String[] args) throws Exception {
        int boardWidth = 360;
        int boardHeight = 640;

        JFrame frame = new JFrame("Proyecto Abyss");
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Abyss abyss = new Abyss();
        frame.add(abyss);
        frame.pack();
        abyss.requestFocus();
        frame.setVisible(true);
    }
}
