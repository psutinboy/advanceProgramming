package jdbc;

public class Task {
    private int id;
    private String title;
    private String description;
    private String status;

    // Constructor for creating a new task
    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.status = "Pending";
    }

    // Constructor for existing tasks from database
    public Task(int id, String title, String description, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task #" + id + "\n" +
                "Title: " + title + "\n" +
                "Description: " + description + "\n" +
                "Status: " + status + "\n";
    }
}