package fvi.f1;
import javax.swing.*;

public class Main {
    public static void main (String[] args){
        JFrame f= new JFrame("Java F1");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500,400);
        f.add(new Roat() );
        f.setVisible(true);

    }
}
