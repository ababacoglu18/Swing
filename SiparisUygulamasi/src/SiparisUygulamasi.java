import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashSet;
import java.util.Set;

public class SiparisUygulamasi {
    Set<String> set = new LinkedHashSet<>();

    private JPanel SiparisPanel;
    private JCheckBox pythonCheckBox;
    private JCheckBox javaCheckBox;
    private JCheckBox cppCheckBox;
    private JButton gosterButton;
    private JLabel sunlarSecildiLabel;

    public SiparisUygulamasi() {
        gosterButton.addActionListener(new ActionListener() {

           public void LabelDegistir(){
               String yazi = "Şunlar Seçildi: " ;
               for (String i : set){
                   yazi += i + " ";
               }
               sunlarSecildiLabel.setText(yazi);
           }
            @Override
            public void actionPerformed(ActionEvent e) {
                if(javaCheckBox.isSelected()){
                    set.add("Java");
                }else {
                    set.remove("Java");
                }
                if(cppCheckBox.isSelected()){
                    set.add("C++");
                }else {
                    set.remove("C++");
                } if(pythonCheckBox.isSelected()){
                    set.add("Pyhton");
                }else {
                    set.remove("Pyhton");
                }
                LabelDegistir();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SiparisUygulamasi");
        frame.setContentPane(new SiparisUygulamasi().SiparisPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
