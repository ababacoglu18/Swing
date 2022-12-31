import javax.swing.*;
import java.awt.*;

public class MainScreen extends JFrame {

    public MainScreen(String title) throws HeadlessException {
        super(title);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);             //Grafik Kütüphanesi
      /*  g.setColor(Color.BLUE);

       // g.draw3DRect(50,50,300,500,true);
        g.drawRect(100,10,100,100);
        g.fillRect(200,100,50,40);
        g.drawOval(200,200,30,30);
        g.fillOval(200,250,40,80);
        g.drawLine(100,100,300,300);*/
    }

    public static void main(String[] args){

        GrafikKullanimi grafikKullanimi = new GrafikKullanimi();

        MainScreen mainScreen =new MainScreen("Grafik Kullanımı");
        mainScreen.setVisible(true);
        mainScreen.setResizable(true);
        mainScreen.setSize(800,600);
        mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainScreen.add(grafikKullanimi);
        GrafikKullanimi grafikKullanimi1 = new GrafikKullanimi();
        grafikKullanimi1.requestFocus();


        grafikKullanimi1.setFocusable(true);



    }
}
