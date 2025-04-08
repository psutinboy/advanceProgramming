import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Image {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        ImageIcon image = new ImageIcon("movieDB.jpg");
        JLabel label = new JLabel(image);
        frame.add(label);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}