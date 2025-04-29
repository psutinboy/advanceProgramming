package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:sqlite:todo_list.db";
    private Connection connection;

    public DatabaseManager() {
        try {
            // Create connection to SQLite database
            connection = DriverManager.getConnection(DB_URL);
            System.out.println("Connected to the database successfully.");

            // Create tasks table if it doesn't exist
            createTasksTable();
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }

    private void createTasksTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS tasks (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "title TEXT NOT NULL," +
                "description TEXT," +
                "status TEXT DEFAULT 'Pending')";

        try (Statement statement = connection.createStatement()) {
            statement.execute(createTableSQL);
            System.out.println("Tasks table created or already exists.");
        } catch (SQLException e) {
            System.out.println("Error creating tasks table: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            System.out.println("Error closing the database connection: " + e.getMessage());
        }
    }
}