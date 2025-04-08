import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyGUI extends JFrame implements ActionListener {

    private JLabel label;
    private JTextField textField;
    private ImageIcon icon;
    private JButton button1;
    private JButton button2;

    public static void main(String[] args) {
        new MyGUI();
    }

    public MyGUI() {
        setTitle("My GUI");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // components
        label = new JLabel("Enter your name:");
        textField = new JTextField(20);
        icon = new ImageIcon("movieDB.jpg");
        button1 = new JButton("submit");
        button2 = new JButton("cancel");

        //set layout
        setLayout(new BorderLayout());

        //add components to frame
        add(label, BorderLayout.NORTH);
        add(textField, BorderLayout.CENTER);
        add(new JLabel(icon), BorderLayout.WEST);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        add(buttonPanel, BorderLayout.SOUTH);

        //add action listener to button
        button1.addActionListener(this);
        button2.addActionListener(this);

        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            String name = textField.getText();
            JOptionPane.showMessageDialog(this, "Hello " + name);
        } else if (e.getSource() == button2) {
            dispose();
        }
    }
}