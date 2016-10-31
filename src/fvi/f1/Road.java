package fvi.f1;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javafx.scene.shape.Rectangle;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;

public class Road extends JPanel implements ActionListener,Runnable {
    Timer mainTmier = new Timer(20, this); // go Car

    Image img = new ImageIcon("res/bg_road.jpg").getImage();

    Player p = new Player();


    Thread enemiesFactory = new Thread(this);// новий поток

    List<Enemy> enemies = new ArrayList<Enemy>();


    public Road() {
        mainTmier.start();
        enemiesFactory.start();
        addKeyListener(new MyKeyAdapter());
        setFocusable(true);
    }

    private class MyKeyAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            p.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) {
            p.keyReleased(e);
        }
    }

    public void paint(Graphics g) {
        g = (Graphics2D)g;
        g.drawImage(img, p.layer1, 0, null);
        g.drawImage(img, p.layer2, 0, null);
        g.drawImage(p.img, p.x, p.y, null);

        double v =(200/Player.MAX_V)*p.v; //
        g.setColor(Color.WHITE);
        Font font = new Font("Arial",Font.BOLD,20);
        g.setFont(font);
        g.drawString("Скорость: " + v +" км/год ", 100,30);

        Iterator <Enemy> i= enemies.iterator();
        while (i.hasNext()) {
            Enemy e = i.next();
            if (e.x >= 2200 || e.x <= -2200) {
                i.remove();
            } else {
                e.move();
                g.drawImage(e.img, e.x, e.y, null);

                 }
        }

    }

    public void actionPerformed(ActionEvent e) {
        p.move();
        repaint();// +перемалювати+
       // testCollisionWithEnemies();
    }

   /* public void testCollisionWithEnemies(){
        Iterator <Enemy> i= enemies.iterator();
       while (i.hasNext()) {
            Enemy e = i.next();
            if (p.getRect().intersects(e.getRect())) {
                JOptionPane.showMessageDialog(null," Ви програли!!! ");
                System.exit(1);
                }
        }

    }*/

    public  void run(){
        while (true){
            Random rand = new Random();
            try{
            Thread.sleep(rand.nextInt(1800));
            enemies.add(new Enemy(1100,rand.nextInt(400),rand.nextInt(40),this));

            } catch (InterruptedException e){
                e.printStackTrace();
            }


        }
    }
}
