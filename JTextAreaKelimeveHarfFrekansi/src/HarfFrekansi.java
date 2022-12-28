import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HarfFrekansi {
    private JPanel HarfFrekansi;
    private JTextArea yaziAlani;
    private JButton kelimeVeHarfSayisiButton;
    private JLabel kelime_alani;
    private JLabel harf_alanis;


    public HarfFrekansi() {
        kelimeVeHarfSayisiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String yazi = yaziAlani.getText();
                int karakter_sayisi = 0;
                int kelime_sayisi = -1;
                int kelimes2 = 0;

                for(int i = 0; i<yazi.length(); i++){
                    if(yazi.charAt(i) != ' '){
                       karakter_sayisi++;
                    }}

                    ArrayList<String[]> list = new ArrayList();
                    list.add((yazi.split(" ")));
                    for (String[] s : list){
                        kelimes2 ++ ;
                        System.out.println(kelimes2);
                    }
                System.out.println(kelimes2);  //çalışmıyor

                   String[] kelimeArray = yazi.split(" ");
                   String[] kelimeArray2 = yazi.split("\n");

                    for(String s : kelimeArray){

                        kelime_sayisi++;
                    }
                for(String s : kelimeArray2){

                    kelime_sayisi++;
                }
                    kelime_alani.setText("Kelime Sayisi: "+ kelime_sayisi);
                    harf_alanis.setText("Harf Sayısı: " + karakter_sayisi);

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("HarfFrekansi");
        frame.setContentPane(new HarfFrekansi().HarfFrekansi);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}

