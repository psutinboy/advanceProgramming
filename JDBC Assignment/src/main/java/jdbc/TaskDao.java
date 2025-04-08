package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TaskDao {
    private Connection connection;

    public TaskDao(Connection connection) {
        this.connection = connection;
    }

    // Add a new task using PreparedStatement
    public boolean addTask(Task task) {
        String sql = "INSERT INTO tasks (title, description, status) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, task.getTitle());
            pstmt.setString(2, task.getDescription());
            pstmt.setString(3, task.getStatus());

            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("Error adding task: " + e.getMessage());
            return false;
        }
    }

    // Get all tasks using Statement
    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT * FROM tasks";

        try (Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Task task = new Task(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("status"));
                tasks.add(task);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving tasks: " + e.getMessage());
        }

        return tasks;
    }

    // Get a task by ID
    public Task getTaskById(int id) {
        String sql = "SELECT * FROM tasks WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Task(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getString("description"),
                            rs.getString("status"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving task: " + e.getMessage());
        }

        return null;
    }

    // Update an existing task using PreparedStatement
    public boolean updateTask(Task task) {
        String sql = "UPDATE tasks SET title = ?, description = ?, status = ? WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, task.getTitle());
            pstmt.setString(2, task.getDescription());
            pstmt.setString(3, task.getStatus());
            pstmt.setInt(4, task.getId());

            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println("Error updating task: " + e.getMessage());
            return false;
        }
    }

    // Delete a task using PreparedStatement
    public boolean deleteTask(int id) {
        String sql = "DELETE FROM tasks WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            int rowsDeleted = pstmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.out.println("Error deleting task: " + e.getMessage());
            return false;
        }
    }
}