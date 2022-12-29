import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
    private JButton urunSilButton;

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
        urunTablosu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DefaultTableModel model = (DefaultTableModel) urunTablosu.getModel();
                int secili_row = urunTablosu.getSelectedRow();

                tf_urun.setText(model.getValueAt(secili_row,0).toString());             //Tıklanılan Row'u yukardaki bosluga yazar
                cb_kategori.setSelectedItem(model.getValueAt(secili_row,1).toString());
                tf_fiyat.setText(model.getValueAt(secili_row,2).toString());

            }
        });
        urunSilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mesaj_yazisi.setText("");
                DefaultTableModel model = (DefaultTableModel) urunTablosu.getModel();
                int secili_row = urunTablosu.getSelectedRow();
                if(secili_row == -1){

                    if(secili_row ==0){
                        mesaj_yazisi.setText("Ürün Tablosu Şu Anda Boş.");
                    }
                   else  {
                        mesaj_yazisi.setText("Lutfen Silinecek Ürünü Seçiniz");
                    }
                }else {
                model.removeRow(urunTablosu.getSelectedRow());
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
