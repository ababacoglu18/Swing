import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class JFChooserJColor {
    private JPanel JFileblablaPanel;
    private JButton dosyaAcButton;
    private JButton renkDegistirButton;
    private JTextArea yaziAlani;



    public JFChooserJColor() {
    dosyaAcButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
              JFileChooser fc = new JFileChooser();
              int i = fc.showOpenDialog(null);

              if(i == JFileChooser.APPROVE_OPTION){
                  File file = fc.getSelectedFile();
                  String icerik = "";                                                   //BUFFERED READER KULLAN TRWWITHRESOURCES
                  try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(file)))) {
                    while (scanner.hasNextLine()){
                        icerik += scanner.nextLine() + "\n";

                    }
                    yaziAlani.setText(icerik);

                  } catch (FileNotFoundException ex) {
                      throw new RuntimeException(ex);
                  }
              }


        }
    });
}
    public static void main(String[] args) {
        JFrame frame = new JFrame("JFChooserJColor");
        frame.setContentPane(new JFChooserJColor().JFileblablaPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
