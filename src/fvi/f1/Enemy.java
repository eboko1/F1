package fvi.f1;


import javafx.scene.shape.Rectangle;

import javax.swing.*;
import java.awt.*;

public class Enemy {
    int x;
    int y;
    int v;

    Image img = new ImageIcon("res/car_track.png").getImage();
    Road road;

    public Rectangle getRect(){
        return new Rectangle(x,y,282,144);
    }

    public  Enemy(int x, int y, int v, Road road){
        this.x=x;
        this.y=y;
        this.v=v;
        this.road=road;
    }



    public void move (){
      x=x-road.p.v+v;
    }

}
