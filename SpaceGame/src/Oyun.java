import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Oyun extends JPanel implements KeyListener, ActionListener {

        class Ates{
            private int x;
            private int y;

            public int getX() {
                return x;
            }

            public void setX(int x) {
                this.x = x;
            }

            public int getY() {
                return y;
            }

            public void setY(int y) {
                this.y = y;
            }

            public Ates(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        private int gecen_sure = 0;
        private int harcanan_ates = 0;
        private BufferedImage image;
        private ArrayList<Ates> ates = new ArrayList<Ates>();

        private int atesDirY = 1;
        private int topX=0;
        private int topdirX = 2;
        private int uzayGemisiX = 0;//BaslangicX

    private int dirUzayX = 20;

    @Override
    public void repaint() {
        super.repaint();

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    g.setColor(Color.RED);
    g.fillOval(topX,0,20,20);

    g.drawImage(image,uzayGemisiX,490,image.getWidth() /10,image.getHeight()/10,this);
    }

    public Oyun() {

        try {
            image  = ImageIO.read(new FileImageInputStream(new File("uzaygemisi.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setBackground(Color.BLACK);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
