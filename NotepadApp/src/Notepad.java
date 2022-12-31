import javax.swing.*;

public class Notepad {
    private JPanel menuPanel;
    private JTabbedPane tabbedPane1;
    private JTree tree1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Notepad");
        frame.setContentPane(new Notepad().menuPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
