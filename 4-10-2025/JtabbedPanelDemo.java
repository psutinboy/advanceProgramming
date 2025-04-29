import javax.swing.*;

public class JtabbedPanelDemo extends JFrame {

    public JtabbedPanelDemo() {
        super("JTabbedPanel Demo");
        
        // Create the tabbed panel
        JTabbedPane tabbedPane = new JTabbedPane();

        //create the content for each tab
        JPanel doctor = new JPanel();
        doctor.add(new JLabel("This is for Health Care Information"));

        JPanel infrastructure = new JPanel();
        infrastructure.add(new JLabel("This is the content of Infrastructure tab"));

        JPanel contactDetails = new JPanel();
        contactDetails.add(new JLabel("This is the content of Contact Details tab"));

        //add the tabs to the tabbed pane
        tabbedPane.addTab("Health Care Information", doctor);
        tabbedPane.addTab("Infrastructure", infrastructure);
        tabbedPane.addTab("Contact Details", contactDetails);

        //add the tabbed pane to the frame
        getContentPane().add(tabbedPane);
        
        // Set frame properties
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new JtabbedPanelDemo();
    }
}
