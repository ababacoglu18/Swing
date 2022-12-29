import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Pff3 extends JDialog {
    private JPanel contentPane;
    private JButton buttonRegister;
    private JButton buttonCancel;
    private JTextField kullanici_adi_alani;
    private JPasswordField passwordField1;

    public Pff3() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonRegister);



        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        buttonRegister.addActionListener(new ActionListener() {         //BUTON REGISTER
            @Override
            public void actionPerformed(ActionEvent e) {
                   String kullanici_adi =  kullanici_adi_alani.getText();
                   String parola = new String(passwordField1.getPassword());
                ArrayList<User> userlist = RegisterLoginMain.getUser_list_obj();
                userlist.add(new User(kullanici_adi,parola));
                System.out.println(userlist.size());
                setVisible(false);

            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Pff3 dialog = new Pff3();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
