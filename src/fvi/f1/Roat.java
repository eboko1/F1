package fvi.f1;

import javax.swing.*;
import java.awt.*;

public class Roat extends JPanel {
    Image img = new ImageIcon("res/bg_road.jpg").getImage();
    public  void  paint(Graphics g){
        g =(Graphics2D) g;
        g.drawImage(img,0,0,null);
    }
}
