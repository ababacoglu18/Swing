import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterLoginPage {



    private JPanel LoginPanel;
    private JPanel RegisterLoginPanel;
    private JPanel LoginPanel2;
    private JButton registerButton;
    private JButton loginButton;
    private JTextField kullaniciAdiAlani;
    private JPasswordField parolaAlani;


    public RegisterLoginPage() {
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           Se se_second_tab = new Se();
           se_second_tab.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("RegisterLoginPage");
        frame.setContentPane(new RegisterLoginPage().LoginPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }

    public static class secondtab  extends RegisterLoginPage{
        private JPanel secondtab;

        public JPanel getSecondtab() {
            return secondtab;
        }

        public void setSecondtab(JPanel secondtab) {
            this.secondtab = secondtab;
        }

        private void createUIComponents() {
            // TODO: place custom component creation code here
        }
    }
}
