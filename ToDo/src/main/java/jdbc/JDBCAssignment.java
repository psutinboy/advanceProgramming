package jdbc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class JDBCAssignment extends JFrame {

    private static DatabaseManager dbManager;
    private static TaskDao taskDao;
    
    // GUI Components
    private JTable taskTable;
    private DefaultTableModel tableModel;
    private JTextField titleField;
    private JTextArea descriptionArea;
    private JComboBox<String> statusComboBox;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton clearButton;
    
    // Colors
    private static final Color PRIMARY_COLOR = new Color(70, 130, 180);  // Steel Blue
    private static final Color SECONDARY_COLOR = new Color(240, 248, 255);  // Alice Blue
    private static final Color ACCENT_COLOR = new Color(30, 144, 255);  // Dodger Blue
    private static final Color SUCCESS_COLOR = new Color(46, 139, 87);  // Sea Green
    private static final Color DELETE_COLOR = new Color(220, 20, 60);  // Crimson
    
    private int selectedTaskId = -1;

    public JDBCAssignment() {
        // Initialize database and components
        dbManager = new DatabaseManager();
        taskDao = new TaskDao(dbManager.getConnection());
        
        // Set up the JFrame
        setTitle("To-Do List Application");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Create the main panels with a gradient background
        JPanel mainPanel = new JPanel(new BorderLayout(15, 15)) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                int w = getWidth();
                int h = getHeight();
                GradientPaint gp = new GradientPaint(0, 0, SECONDARY_COLOR, w, h, new Color(230, 240, 250));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }
        };
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        // Create form panel
        JPanel formPanel = createFormPanel();
        
        // Create table panel
        JPanel tablePanel = createTablePanel();
        
        // Add panels to main panel
        mainPanel.add(formPanel, BorderLayout.WEST);
        mainPanel.add(tablePanel, BorderLayout.CENTER);
        
        // Add main panel to frame
        add(mainPanel);
        
        // Custom icon if available
        try {
            setIconImage(new ImageIcon(getClass().getResource("/todo_icon.png")).getImage());
        } catch (Exception e) {
            // Icon not found, continue without it
        }
        
        // Load initial task data
        refreshTaskTable();
    }
    
    private JPanel createFormPanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 10));
        
        // Create a titled border with rounded corners and custom color
        TitledBorder titledBorder = BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(PRIMARY_COLOR, 2, true),
            "Task Details"
        );
        titledBorder.setTitleFont(new Font("Arial", Font.BOLD, 14));
        titledBorder.setTitleColor(PRIMARY_COLOR);
        
        panel.setBorder(BorderFactory.createCompoundBorder(
            titledBorder,
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        
        panel.setBackground(SECONDARY_COLOR);
        panel.setPreferredSize(new Dimension(350, 500));
        
        JPanel fieldsPanel = new JPanel(new GridBagLayout());
        fieldsPanel.setBackground(SECONDARY_COLOR);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 10, 5);
        
        // Title field
        JLabel titleLabel = new JLabel("Title:");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 12));
        titleLabel.setForeground(PRIMARY_COLOR);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        fieldsPanel.add(titleLabel, gbc);
        
        titleField = new JTextField(20);
        titleField.setFont(new Font("Arial", Font.PLAIN, 12));
        titleField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(PRIMARY_COLOR),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        fieldsPanel.add(titleField, gbc);
        
        // Description field
        JLabel descLabel = new JLabel("Description:");
        descLabel.setFont(new Font("Arial", Font.BOLD, 12));
        descLabel.setForeground(PRIMARY_COLOR);
        gbc.gridx = 0;
        gbc.gridy = 2;
        fieldsPanel.add(descLabel, gbc);
        
        descriptionArea = new JTextArea(6, 20);
        descriptionArea.setFont(new Font("Arial", Font.PLAIN, 12));
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        
        JScrollPane descScrollPane = new JScrollPane(descriptionArea);
        descScrollPane.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(PRIMARY_COLOR),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        fieldsPanel.add(descScrollPane, gbc);
        
        // Status field
        JLabel statusLabel = new JLabel("Status:");
        statusLabel.setFont(new Font("Arial", Font.BOLD, 12));
        statusLabel.setForeground(PRIMARY_COLOR);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        fieldsPanel.add(statusLabel, gbc);
        
        statusComboBox = new JComboBox<>(new String[]{"Pending", "In Progress", "Completed"});
        statusComboBox.setFont(new Font("Arial", Font.PLAIN, 12));
        statusComboBox.setRenderer(new StatusCellRenderer());
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        fieldsPanel.add(statusComboBox, gbc);
        
        panel.add(fieldsPanel, BorderLayout.CENTER);
        
        // Button panel
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 8, 8));
        buttonPanel.setBackground(SECONDARY_COLOR);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        
        addButton = createStyledButton("Add Task", SUCCESS_COLOR);
        updateButton = createStyledButton("Update Task", ACCENT_COLOR);
        deleteButton = createStyledButton("Delete Task", DELETE_COLOR);
        clearButton = createStyledButton("Clear Form", Color.GRAY);
        
        // Disable update and delete buttons initially
        updateButton.setEnabled(false);
        deleteButton.setEnabled(false);
        
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);
        
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        // Add action listeners to buttons
        addButton.addActionListener(e -> addTask());
        updateButton.addActionListener(e -> updateTask());
        deleteButton.addActionListener(e -> deleteTask());
        clearButton.addActionListener(e -> clearForm());
        
        return panel;
    }
    
    private JButton createStyledButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setForeground(Color.WHITE);
        button.setBackground(color);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Add hover effect
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(color.brighter());
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(color);
            }
        });
        
        return button;
    }
    
    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 10));
        
        // Create a titled border with rounded corners and custom color
        TitledBorder titledBorder = BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(PRIMARY_COLOR, 2, true),
            "Tasks"
        );
        titledBorder.setTitleFont(new Font("Arial", Font.BOLD, 14));
        titledBorder.setTitleColor(PRIMARY_COLOR);
        
        panel.setBorder(BorderFactory.createCompoundBorder(
            titledBorder,
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        
        panel.setBackground(SECONDARY_COLOR);
        
        // Create the table with columns
        String[] columns = {"ID", "Title", "Description", "Status"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table cells non-editable
            }
            
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 3) {
                    return String.class;
                }
                return super.getColumnClass(columnIndex);
            }
        };
        
        taskTable = new JTable(tableModel);
        taskTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        taskTable.getTableHeader().setReorderingAllowed(false);
        taskTable.setRowHeight(30);
        taskTable.setIntercellSpacing(new Dimension(10, 5));
        taskTable.setShowGrid(true);
        taskTable.setGridColor(new Color(220, 220, 220));
        
        // Table header styling
        JTableHeader header = taskTable.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 12));
        header.setBackground(PRIMARY_COLOR);
        header.setForeground(Color.WHITE);
        header.setBorder(BorderFactory.createLineBorder(PRIMARY_COLOR.darker()));
        
        // Set column widths
        TableColumnModel columnModel = taskTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(40);    // ID
        columnModel.getColumn(1).setPreferredWidth(120);   // Title
        columnModel.getColumn(2).setPreferredWidth(250);   // Description
        columnModel.getColumn(3).setPreferredWidth(100);   // Status
        
        // Custom renderer for the status column
        columnModel.getColumn(3).setCellRenderer(new StatusCellRenderer());
        
        // Row striping and styling
        taskTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, 
                    boolean isSelected, boolean hasFocus, int row, int column) {
                
                Component c = super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);
                
                if (isSelected) {
                    c.setBackground(ACCENT_COLOR);
                    c.setForeground(Color.WHITE);
                } else {
                    c.setBackground(row % 2 == 0 ? Color.WHITE : new Color(245, 250, 255));
                    c.setForeground(Color.BLACK);
                }
                
                setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));
                setFont(new Font("Arial", Font.PLAIN, 12));
                
                return c;
            }
        });
        
        // Add selection listener to table
        taskTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && taskTable.getSelectedRow() != -1) {
                int row = taskTable.getSelectedRow();
                selectedTaskId = (int) taskTable.getValueAt(row, 0);
                String title = (String) taskTable.getValueAt(row, 1);
                String description = (String) taskTable.getValueAt(row, 2);
                String status = (String) taskTable.getValueAt(row, 3);
                
                // Fill form with selected task data
                titleField.setText(title);
                descriptionArea.setText(description);
                statusComboBox.setSelectedItem(status);
                
                // Enable update and delete buttons
                updateButton.setEnabled(true);
                deleteButton.setEnabled(true);
                addButton.setEnabled(false);
            }
        });
        
        JScrollPane scrollPane = new JScrollPane(taskTable);
        scrollPane.setBorder(BorderFactory.createLineBorder(PRIMARY_COLOR, 1));
        scrollPane.getViewport().setBackground(Color.WHITE);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        JButton refreshButton = createStyledButton("Refresh Tasks", PRIMARY_COLOR);
        refreshButton.addActionListener(e -> refreshTaskTable());
        
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.setBackground(SECONDARY_COLOR);
        bottomPanel.add(refreshButton);
        panel.add(bottomPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private void addTask() {
        String title = titleField.getText().trim();
        String description = descriptionArea.getText().trim();
        
        if (title.isEmpty()) {
            showErrorMessage("Title cannot be empty!");
            return;
        }
        
        Task newTask = new Task(title, description);
        newTask.setStatus((String) statusComboBox.getSelectedItem());
        
        if (taskDao.addTask(newTask)) {
            showSuccessMessage("Task added successfully!");
            clearForm();
            refreshTaskTable();
        } else {
            showErrorMessage("Failed to add task!");
        }
    }
    
    private void updateTask() {
        if (selectedTaskId == -1) {
            return;
        }
        
        String title = titleField.getText().trim();
        String description = descriptionArea.getText().trim();
        String status = (String) statusComboBox.getSelectedItem();
        
        if (title.isEmpty()) {
            showErrorMessage("Title cannot be empty!");
            return;
        }
        
        Task task = taskDao.getTaskById(selectedTaskId);
        if (task != null) {
            task.setTitle(title);
            task.setDescription(description);
            task.setStatus(status);
            
            if (taskDao.updateTask(task)) {
                showSuccessMessage("Task updated successfully!");
                clearForm();
                refreshTaskTable();
            } else {
                showErrorMessage("Failed to update task!");
            }
        }
    }
    
    private void deleteTask() {
        if (selectedTaskId == -1) {
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to delete this task?",
            "Confirm Deletion",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );
        
        if (confirm == JOptionPane.YES_OPTION) {
            if (taskDao.deleteTask(selectedTaskId)) {
                showSuccessMessage("Task deleted successfully!");
                clearForm();
                refreshTaskTable();
            } else {
                showErrorMessage("Failed to delete task!");
            }
        }
    }
    
    private void clearForm() {
        titleField.setText("");
        descriptionArea.setText("");
        statusComboBox.setSelectedIndex(0);
        selectedTaskId = -1;
        
        // Reset button states
        addButton.setEnabled(true);
        updateButton.setEnabled(false);
        deleteButton.setEnabled(false);
        
        // Clear table selection
        taskTable.clearSelection();
    }
    
    private void refreshTaskTable() {
        // Clear existing table data
        tableModel.setRowCount(0);
        
        // Get all tasks and add to table
        List<Task> tasks = taskDao.getAllTasks();
        for (Task task : tasks) {
            Object[] row = {
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus()
            };
            tableModel.addRow(row);
        }
    }
    
    private void showSuccessMessage(String message) {
        JOptionPane.showMessageDialog(
            this, 
            message, 
            "Success", 
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    
    private void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(
            this, 
            message, 
            "Error", 
            JOptionPane.ERROR_MESSAGE
        );
    }
    
    // Custom renderer for status cell
    private class StatusCellRenderer extends DefaultListCellRenderer implements TableCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, 
                int index, boolean isSelected, boolean cellHasFocus) {
            
            Component c = super.getListCellRendererComponent(
                    list, value, index, isSelected, cellHasFocus);
            
            if (value instanceof String) {
                applyStatusStyles((JLabel)c, (String)value, isSelected);
            }
            
            return c;
        }
        
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel label = new JLabel();
            label.setOpaque(true);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));
            label.setFont(new Font("Arial", Font.BOLD, 12));
            
            if (value != null) {
                label.setText(value.toString());
                applyStatusStyles(label, value.toString(), isSelected);
            }
            
            return label;
        }
        
        private void applyStatusStyles(JLabel label, String status, boolean isSelected) {
            // Apply different colors based on status
            switch (status) {
                case "Pending":
                    label.setBackground(isSelected ? Color.ORANGE.darker() : Color.ORANGE);
                    break;
                case "In Progress":
                    label.setBackground(isSelected ? ACCENT_COLOR.darker() : ACCENT_COLOR);
                    break;
                case "Completed":
                    label.setBackground(isSelected ? SUCCESS_COLOR.darker() : SUCCESS_COLOR);
                    break;
            }
            
            if (!isSelected) {
                label.setForeground(Color.WHITE);
            }
            
            label.setOpaque(true);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));
            label.setFont(new Font("Arial", Font.BOLD, 12));
        }
    }
    
    // Window listener for proper cleanup
    private void setupWindowListener() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dbManager.closeConnection();
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        // Use Swing thread for GUI creation
        SwingUtilities.invokeLater(() -> {
            try {
                // Set system look and feel
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                
                // Customize certain UI elements
                UIManager.put("OptionPane.background", SECONDARY_COLOR);
                UIManager.put("Panel.background", SECONDARY_COLOR);
                UIManager.put("OptionPane.messageForeground", PRIMARY_COLOR);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            JDBCAssignment app = new JDBCAssignment();
            app.setupWindowListener();
            app.setVisible(true);
        });
    }
}
