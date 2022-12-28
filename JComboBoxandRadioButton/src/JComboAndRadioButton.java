import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashSet;
import java.util.Set;

public class JComboAndRadioButton {

    Set<String> diller = new LinkedHashSet<>();
    private JRadioButton javaRadioButton;
    private JRadioButton pyhtonRadioButton;
    private JRadioButton cppRadioButton;
    private JButton dil_gosterButton;
    private JPanel ComboPanel;
    private JButton goster2Button;
    private JComboBox cbDillerBox1;

    public JComboAndRadioButton() {


        dil_gosterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            if(javaRadioButton.isSelected()){

                diller.add("Java");
            }else {
                diller.remove("Java");
            }if(pyhtonRadioButton.isSelected()){

                    diller.add("Pyhton");
                }else {
                    diller.remove("Pyhton");
                }if(cppRadioButton.isSelected()){

                    diller.add("C++");
                }else {
                    diller.remove("C++");
                }

            goster();
            }

        });
        goster2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "Şu Dil Seçildi: " + cbDillerBox1.getSelectedItem();
            JOptionPane.showMessageDialog(null, message);
            }

        });
    }
    public void goster(){
        String mesaj = "Şu Dil Seçildi: ";
        for (String dil : diller){

            mesaj += dil + " ";
        }
        JOptionPane.showMessageDialog(null,mesaj);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("JComboAndRadioButton");
        frame.setContentPane(new JComboAndRadioButton().ComboPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
