
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InventoryManager {

    private static final String DB_URL = "jdbc:sqlite:inventory.db";

    /*
    public static void main(String[] args) {
        String url = "jdbc:sqlite:inventory.db";
        
        try (Connection conn = DriverManager.getConnection(url)) {
            System.out.println("Connection established successfully.");
            createTable();
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        }
    }
     */
    // Create products table if it doesn't exist
    private static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS products (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name TEXT NOT NULL," +
            "quantity INTEGER NOT NULL," +
            "price REAL NOT NULL" +
            ")";
        try (Connection conn = DriverManager.getConnection(DB_URL);
            Statement stmt = conn.createStatement()) {
                stmt.execute(sql);
                System.out.println("Table created successfully");
        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
        }
    }

    // Add a new product
    private static void addProduct(String name, int quantity, double price) {
        String sql = "INSERT INTO products (name, quantity, price) VALUES (?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, quantity);
            pstmt.setDouble(3, price);
            pstmt.executeUpdate();
            System.out.println("Product added: " + name);
        } catch (SQLException e) {
            System.err.println("Error adding product: " + e.getMessage());
        }
    }

    // Display all products
    private static void displayInventory() {
        String sql = "SELECT * FROM products";

        try (Connection conn = DriverManager.getConnection(DB_URL); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\nCurrent Inventory:");
            System.out.println("ID | Name | Quantity | Price");
            System.out.println("------------------------------");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");

                System.out.printf("%d | %s | %d | $%.2f%n",
                        id, name, quantity, price);
            }
        } catch (SQLException e) {
            System.err.println("Error displaying inventory: " + e.getMessage());
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    public static void main(String[] args) {
        createTable();
        addProduct("Laptop", 10, 999.99);
        addProduct("Mouse", 5, 9.99);
        
        displayInventory();
    }
}
