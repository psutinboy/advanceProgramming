import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class JButtonProgram extends JFrame {
    
    private static final int ROWS = 20;
    private static final int COLS = 20;
    
    public JButtonProgram() {
        setTitle("JButton Program");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Create the panel that will hold buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(ROWS, COLS, 2, 2)); // 20x20 grid with small gaps
        
        // Pre-size the panel for better rendering performance
        int totalButtons = ROWS * COLS; // 400 buttons total
        buttonPanel.setPreferredSize(new Dimension(600, 800));
        
        // Create buttons for the grid
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                int buttonNum = row * COLS + col + 1;
                JButton button = new JButton(Integer.toString(buttonNum));
                buttonPanel.add(button);
            }
        }
        
        // Create scroll pane with optimized scrolling
        JScrollPane scrollPane = new JScrollPane(buttonPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // Faster scrolling
        
        add(scrollPane, BorderLayout.CENTER);
    }
    
    public static void main(String[] args) {
        // Use the Event Dispatch Thread for Swing applications
        SwingUtilities.invokeLater(() -> {
            JButtonProgram frame = new JButtonProgram();
            frame.setVisible(true);
        });
    }
} 