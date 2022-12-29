import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JListInputDialog {
    public JListInputDialog(DefaultListModel model) {
        this.model = (DefaultListModel) kullaniciListesi.getModel();  //CONSTRUCTORDA JLIST CONVERT EDILMİYOR ARASTIR.
    }

    DefaultListModel model;



    private JList kullaniciListesi;
    private JPanel panel1;



    private JButton deletebuton;
    private JButton addbuton;
    private JLabel mesajBox;


    public JListInputDialog() {


        addbuton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mesajBox.setText("");
                String cevap = JOptionPane.showInputDialog("Kullanıcı İsmi");
                if(cevap != null){
                    if(cevap.trim().equals("")){
                        mesajBox.setText("Boş Bir Kullanıcı İsmi Girdiniz. ");

                    }else{
                        model.addElement(cevap);
                    }
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("JListInputDialog");
        frame.setContentPane(new JListInputDialog().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
