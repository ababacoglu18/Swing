import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JListInputDialog {


    DefaultListModel model = new DefaultListModel();//modeli başlatmazsan aşağıya null gider Exception verir
                                                        //2 saatte çözüldü :S
    /*public JListInputDialog(DefaultListModel model) {
        kullaniciListesi.setModel(model); //CONSTRUCTORDA JLIST CONVERT EDILMİYOR ARASTIR. Her metodun içine yazmak zorundayım.
    }*/

    private int listeSayaci = 1;
    private JList kullaniciListesi;
    private JPanel panel1;



    private JButton deletebuton;
    private JButton addbuton;
    private JLabel mesajBox;


    public JListInputDialog() {


        addbuton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kullaniciListesi.setModel(model);               //Convert'u burda yapmalisin.


                mesajBox.setText("");
                String cevap = JOptionPane.showInputDialog("Kullanıcı İsmi");
                if(cevap != null){
                    if(cevap.trim().equals("")){
                        mesajBox.setText("Boş Bir Kullanıcı İsmi Girdiniz. ");

                    }else{
                        model.addElement(  listeSayaci+". "+cevap);

                        mesajBox.setText("Kullanıcı Başarılı Bir Şekilde Eklendi. ");
                        listeSayaci++;
                    }
                }else {
                    mesajBox.setText("İşlem İptal Edildi.");
                }

            }
        });
        deletebuton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mesajBox.setText("");
               // kullaniciListesi.setModel(model);   //2 KERE MODEL SETLEME INDEXİ -1 E ÇEVİRİYOR.
                int selectedIndex = kullaniciListesi.getSelectedIndex(); //Önemli -1 boş

                if(selectedIndex == -1){
                    if (model.getSize()==0){
                        mesajBox.setText("Liste Şu Anda Boş, Değer Silinemez.");
                    }else {
                        mesajBox.setText("Lütfen Silinecek Bir Kullanıcı Seçiniz. ");
                    }
                }else {
                    Object silinecek= model.getElementAt(selectedIndex);
                    model.removeElement(model.getElementAt(selectedIndex)); //Object Referans İstiyor.
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
