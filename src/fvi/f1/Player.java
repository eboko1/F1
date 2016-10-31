package fvi.f1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import javafx.scene.shape.Rectangle;

public class Player {
    public static final int MAX_V=50;
    public static final int MAX_TOP=10; // верхня координата
    public static final int MAX_BUTTOM=470;// нижня координата

    Image img = new ImageIcon("res/car_player.png").getImage();

    int v=0;
    int dv=0;
    int s=0;

    int x=30;
    int y=100;
    int dy=0;

    int layer1= 0;
    int layer2= 1100;

    public void move() {
        s = s + v;
        v=v+dv;// збільшуеться скорость
        if(v<=0)v=0;// не їздить назад
        if (v>=MAX_V) v=MAX_V;

        y=y-dy;// вісь починається зверху вниз
        if (y<=MAX_TOP) y=MAX_TOP;
        if (y>=MAX_BUTTOM) y=MAX_BUTTOM;
        if (layer2 - v <= 0) { // рух слоїв
            layer1 = 0;
            layer2 = 1200;
        } else {
            layer1 = layer1 - v;
            layer2 = layer2 - v;
        }
    }
    public void keyPressed (KeyEvent e){
        int key=e.getKeyCode();
        if (key==KeyEvent.VK_RIGHT){
            dv=1;
        }
        if (key==KeyEvent.VK_LEFT){
            dv=-1;
        }
        if (key==KeyEvent.VK_UP){
            dy=5;
        }
        if (key==KeyEvent.VK_DOWN){
            dy=-5;
        }
    }

    public Rectangle getRect(){// прямокутники
        return new Rectangle (x,y,317,230);
    }

    public void keyReleased (KeyEvent e){
        int key=e.getKeyCode();
        if (key==KeyEvent.VK_RIGHT || key==KeyEvent.VK_LEFT){
            dv=0;
        }
        if (key==KeyEvent.VK_UP ||key==KeyEvent.VK_DOWN ){
            dy=0;
        }

    }
}
