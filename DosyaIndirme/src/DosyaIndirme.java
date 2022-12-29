import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

public class DosyaIndirme {

    private int say = 0;
    private int networkSpeed = 1000 ;//kb/S
    private boolean a = true;

    private JPanel DownloadSim;
    private JProgressBar checkProgress;
    private JButton dosyaIndir;

    public DosyaIndirme() {
        checkProgress.addComponentListener(new ComponentAdapter() {
        });

        int totalKB = 16000;
        dosyaIndir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long baslangic =  System.currentTimeMillis();
                Timer timer = new Timer(totalKB/networkSpeed,null);

                timer.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        say++;
                        checkProgress.setValue(say);
                        if(checkProgress.getValue() == 200 && a == true){
                            JOptionPane.showMessageDialog(null,"İndirme Tamamlandı!");
                            a = false;

                            timer.stop();

                            DownloadSim.setVisible(false);
                            JPanel p = new JPanel();
                            System.exit(0);
                            p.setVisible(true);
                        }
                    }
                });
                timer.start();
                long son =  System.currentTimeMillis();
                System.out.println(son-baslangic);
            }
        });
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("DosyaIndirme");
        frame.setContentPane(new DosyaIndirme().DownloadSim);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
