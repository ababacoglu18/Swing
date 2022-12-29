import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


class User{
    private String kullaniciAdi;
    private String parola;

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public User(String kullaniciAdi, String parola) {
        this.kullaniciAdi = kullaniciAdi;
        this.parola = parola;
    }
}
public class RegisterLoginMain extends JFrame{

    private static ArrayList<User> user_list_obj = new ArrayList<User>();  //STATIC YAPILARA HER YERDEN ULAŞILABİLİR.

    public static ArrayList<User> getUser_list_obj() {
        return user_list_obj;
    }

    //GETTER SETTER

    public static void setUser_list_obj(ArrayList<User> user_list_obj) {
        RegisterLoginMain.user_list_obj = user_list_obj;
    }

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
            Pff3 pff3 = new Pff3();
           pff3.setVisible(true);

        }
    });
        loginButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String kullaniciLogin = textField1.getText();
                String passwordLogin = new String(passwordField1.getPassword());
                if (user_list_obj.size() == 0){
                    JOptionPane.showMessageDialog(null,"Lütfen Kayıt Olmayı Deneyiniz.");
                }else {             //coder ara

                    for(User s : user_list_obj){

                        if(s.getKullaniciAdi().equals(kullaniciLogin) && s.getParola().equals(passwordLogin)){
                            JOptionPane.showMessageDialog(null, "Hoş Geldiniz " + kullaniciLogin);
                                return;
                        }
                        }

                        JOptionPane.showMessageDialog(null,"Kullanıcı Bulunmamaktadır. ");


                }
            }
        });
    }
}
