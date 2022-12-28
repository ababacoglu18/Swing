import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StokUygulamasi {
    private JPanel StokPanel;
    private JTextField tf_urun;
    private JTextField tf_fiyat;
    private JComboBox cb_kategori;
    private JLabel mesaj_yazisi;
    private JTable urunTablosu;
    private JScrollPane scrollpane;
    private JButton urunEkleButton;
    private JButton urunGuncelleButton;

    public StokUygulamasi() {
        urunEkleButton.addActionListener(new ActionListener() {
          boolean a= true;
            @Override
            public void actionPerformed(ActionEvent e) {
                mesaj_yazisi.setText("");
                DefaultTableModel model = (DefaultTableModel) urunTablosu.getModel();

                while (a == true) {
                    model.addColumn("Urun");            //manual DO ONCE XD
                    model.addColumn("Kategori");
                    model.addColumn("Fiyat");
                    a = false;
                }

                if(tf_urun.getText().trim().equals("")){
                    mesaj_yazisi.setText("Ürün Ismi Bos Bırakılamaz.");
                }else {

                    Object[] eklenecek = {tf_urun.getText(),cb_kategori.getSelectedItem().toString(),tf_fiyat.getText()};

                    model.addRow(eklenecek);
                }

            }
        });
        urunGuncelleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mesaj_yazisi.setText("");
                DefaultTableModel model = (DefaultTableModel) urunTablosu.getModel();
                int secili_row = urunTablosu.getSelectedRow();

                if(secili_row == -1 ){
                    if(urunTablosu.getRowCount() == 0){

                        mesaj_yazisi.setText("Urun Tablosu Şu anda Boş.");
                    }else  {
                        mesaj_yazisi.setText("Lutfen Guncellenecek Bir Ürün Seçin");
                    }
                }else {
                    model.setValueAt(tf_urun.getText(),secili_row,0);
                    model.setValueAt(cb_kategori.getSelectedItem().toString(),secili_row,1);
                    model.setValueAt(tf_fiyat.getText(),secili_row,2);
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("StokUygulamasi");
        frame.setContentPane(new StokUygulamasi().StokPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
