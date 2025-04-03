package jdbc;

import java.util.List;
import java.util.Scanner;

public class JDBCAssignment {

    private static DatabaseManager dbManager;
    private static TaskDao taskDao;
    private static Scanner scanner;

    public static void main(String[] args) {
        // Initialize database and components
        dbManager = new DatabaseManager();
        taskDao = new TaskDao(dbManager.getConnection());
        scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    addNewTask();
                    break;
                case 2:
                    viewAllTasks();
                    break;
                case 3:
                    updateTask();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting the application...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        // Close resources
        scanner.close();
        dbManager.closeConnection();
    }

    private static void displayMenu() {
        System.out.println("\n===== To-Do List Application =====");
        System.out.println("1. Add a new task");
        System.out.println("2. View all tasks");
        System.out.println("3. Update an existing task");
        System.out.println("4. Delete a task");
        System.out.println("5. Exit the application");
        System.out.print("Enter your choice (1-5): ");
    }

    private static int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1; // Invalid choice, will be handled in the switch statement
        }
    }

    private static void addNewTask() {
        System.out.println("\n----- Add a New Task -----");

        System.out.print("Enter task title: ");
        String title = scanner.nextLine();

        System.out.print("Enter task description: ");
        String description = scanner.nextLine();

        Task newTask = new Task(title, description);

        if (taskDao.addTask(newTask)) {
            System.out.println("Task added successfully!");
        } else {
            System.out.println("Failed to add the task.");
        }
    }

    private static void viewAllTasks() {
        System.out.println("\n----- All Tasks -----");

        List<Task> tasks = taskDao.getAllTasks();

        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            for (Task task : tasks) {
                System.out.println(task);
                System.out.println("------------------------");
            }
        }
    }

    private static void updateTask() {
        System.out.println("\n----- Update an Existing Task -----");

        System.out.print("Enter the ID of the task to update: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());

            Task task = taskDao.getTaskById(id);

            if (task == null) {
                System.out.println("No task found with ID: " + id);
                return;
            }

            System.out.println("Current task details:");
            System.out.println(task);

            System.out.print("Enter new title (press Enter to keep current): ");
            String title = scanner.nextLine();
            if (!title.isEmpty()) {
                task.setTitle(title);
            }

            System.out.print("Enter new description (press Enter to keep current): ");
            String description = scanner.nextLine();
            if (!description.isEmpty()) {
                task.setDescription(description);
            }

            System.out.print("Enter new status (Pending/In Progress/Completed) (press Enter to keep current): ");
            String status = scanner.nextLine();
            if (!status.isEmpty()) {
                task.setStatus(status);
            }

            if (taskDao.updateTask(task)) {
                System.out.println("Task updated successfully!");
            } else {
                System.out.println("Failed to update the task.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format. Please enter a number.");
        }
    }

    private static void deleteTask() {
        System.out.println("\n----- Delete a Task -----");

        System.out.print("Enter the ID of the task to delete: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());

            Task task = taskDao.getTaskById(id);

            if (task == null) {
                System.out.println("No task found with ID: " + id);
                return;
            }

            System.out.println("Task to delete:");
            System.out.println(task);

            System.out.print("Are you sure you want to delete this task? (y/n): ");
            String confirmation = scanner.nextLine().toLowerCase();

            if (confirmation.equals("y") || confirmation.equals("yes")) {
                if (taskDao.deleteTask(id)) {
                    System.out.println("Task deleted successfully!");
                } else {
                    System.out.println("Failed to delete the task.");
                }
            } else {
                System.out.println("Task deletion cancelled.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format. Please enter a number.");
        }
    }
}
