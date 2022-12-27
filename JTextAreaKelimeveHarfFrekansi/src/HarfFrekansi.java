import javax.swing.*;

public class HarfFrekansi {
    private JPanel panel1;



    public static void main(String[] args) {
        JFrame frame = new JFrame("HarfFrekansi");
        frame.setContentPane(new HarfFrekansi().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}

