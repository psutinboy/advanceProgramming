import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class JScrollProgram extends JFrame {
  public JScrollProgram() {
    super("JscrollPane Example");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel content = new JPanel();
    content.setLayout(new GridLayout(20, 20));
    for (int i = 1; i <= 300; i++) {
      content.add(new JButton("Button " + i));
    }

    JScrollPane scrollPane = new JScrollPane(content);

    getContentPane().add(scrollPane);

    setSize(400, 400);
    setVisible(true);
  }

  public static void main(String args[]) {
    new JScrollProgram();
  }
}