import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterLoginMain extends JFrame{


    private JButton registerButton;
    private JPanel panel1;
    private JButton loginButton1;
    private JTextField textField1;
    private JPasswordField passwordField1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("RegisterLoginMain");
        frame.setContentPane(new RegisterLoginMain().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public RegisterLoginMain() {
    registerButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {


        }
    });
}
}
