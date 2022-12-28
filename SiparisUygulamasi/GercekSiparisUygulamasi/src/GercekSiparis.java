import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;

public class GercekSiparis {

    Map<String,Integer> siparis_isleri  = new LinkedHashMap<String,Integer>();

    private JCheckBox iskender15TLCheckBox;
    private JCheckBox beyti12TLCheckBox;
    private JCheckBox salata5TLCheckBox;
    private JCheckBox ayran2TLCheckBox;
    private JPanel MenuGercek;
    private JButton sipButon;

    public void SiparisleriGoster(){
        String mesaj = "";
        int tutar = 0;
        if(siparis_isleri.isEmpty()){
            mesaj = "Siparişiniz Bulunmamaktadır.";
        }else {
            mesaj += "Siparişler\n";
            for (Map.Entry<String,Integer> entry : siparis_isleri.entrySet()){
                mesaj +=    entry.getKey() + "\n";
                tutar +=    entry.getValue() ;
            }
        }
        mesaj += "\n Tutar: " + tutar;
        JOptionPane.showMessageDialog(null, mesaj);
    }


    public GercekSiparis() {
        sipButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            if(iskender15TLCheckBox.isSelected()){
               siparis_isleri.put("Iskender",15);
            }else {
                siparis_isleri.remove("Iskender");
            }if(beyti12TLCheckBox.isSelected()){
                    siparis_isleri.put("Beyti",12);
                }else {
                    siparis_isleri.remove("Beyti");
                }if(salata5TLCheckBox.isSelected()){
                    siparis_isleri.put("Salata",5);
                }else {
                    siparis_isleri.remove("Salata");
                }if(ayran2TLCheckBox.isSelected()){
                    siparis_isleri.put("Ayran",2);
                }else {
                    siparis_isleri.remove("Ayran");
                }
                SiparisleriGoster();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GercekSiparis");
        frame.setContentPane(new GercekSiparis().MenuGercek);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
