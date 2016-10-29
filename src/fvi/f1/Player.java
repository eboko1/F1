package fvi.f1;

import javax.swing.*;
import java.awt.*;


public class Player {
    Image img = new ImageIcon("res/car_player.png").getImage();
    int v=10;
    int dv=0;
    int s=0;

    int x=30;
    int y=100;

    int layer1= 0;
    int layer2= 1100;

    public void move() {
        s = s + v;
        if (layer2 - v <= 0) {
            layer1 = 0;
            layer2 = 1200;
        } else {
            layer1 = layer1 - v;
            layer2 = layer2 - v;
        }
    }
}
