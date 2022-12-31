import javax.swing.*;
import java.awt.*;

public class oyunEkrani extends JFrame {


    public oyunEkrani(String title) throws HeadlessException {
        super(title);
    }

    public static void  main(String[] args){





        oyunEkrani ekran = new oyunEkrani("Uzay Oyunu");
        ekran.setResizable(false);
        ekran.setFocusable(false);              //Odak noktası JFRAME'e odaklanmayacak.

        ekran.setSize(800,600);
        ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Oyun oyun = new Oyun();
        oyun.requestFocus();  //klavye işlemleri için focus istiyor
        oyun.addKeyListener(oyun);   //keylistener implement et
        oyun.setFocusable(true);            //sıraları önemli
        oyun.setFocusTraversalKeysEnabled(false);  //unutma false

        ekran.add(oyun);
        ekran.setVisible(true);




    }
}




