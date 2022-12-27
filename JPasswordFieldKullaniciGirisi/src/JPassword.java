import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPassword {
    private JButton girisYapButton;
    private JPanel panel1;
    private JPasswordField parolaAlani;
    private JTextField kullaniciAdiAlani;
    private JLabel kullaniciLabel;
    private JLabel sifreLabel;


    public JPassword() {
        girisYapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String kullanici_adi = kullaniciAdiAlani.getText();
                String parola = new String(parolaAlani.getPassword());

                String message;

                if(kullanici_adi.equals("fazilsay") && parola.equals("12345")){
                    System.out.println("Lutfen Bekleyiniz.");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    message = "Hosgeldiniz " + kullanici_adi ;
                }
               else if(!kullanici_adi.equals("fazilsay") && parola.equals("1234")){
                    System.out.println("Lutfen Bekleyiniz.");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    message = "kullanici adi veya parola yanlis ama hangisi soylemem ";
                }
               else if(kullanici_adi.equals("fazilsay") && !parola.equals("1234")){
                    System.out.println("Lutfen Bekleyiniz.");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }

                    message = "Parola Yanlış.";
                }else {
                   message = " yok ki oyle bisey";
                }

                JOptionPane.showMessageDialog(null,message);
               kullaniciAdiAlani.setText("");
               parolaAlani.setText("");
               System.exit(1);
            }

        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("JPassword");
        frame.setContentPane(new JPassword().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
