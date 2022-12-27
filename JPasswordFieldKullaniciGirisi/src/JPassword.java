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
