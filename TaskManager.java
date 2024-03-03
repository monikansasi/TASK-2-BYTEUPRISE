import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskManager {
    private static Map<String, Task> tasks = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addTask();
                    break;
                case "2":
                    viewTasks();
                    break;
                case "3":
                    editTask();
                    break;
                case "4":
                    deleteTask();
                    break;
                case "5":
                    System.out.println("Exiting program. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nTask Management System");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Edit Task");
        System.out.println("4. Delete Task");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addTask() {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        System.out.print("Enter task due date (YYYY-MM-DD): ");
        String dueDate = scanner.nextLine();
        Task task = new Task(title, description, dueDate);
        tasks.put(title, task);
        System.out.println("Task added successfully.");
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            System.out.println("Tasks:");
            for (Task task : tasks.values()) {
                System.out.println(task);
            }
        }
    }

    private static void editTask() {
        System.out.print("Enter title of task to edit: ");
        String title = scanner.nextLine();
        Task task = tasks.get(title);
        if (task == null) {
            System.out.println("Task not found.");
        } else {
            System.out.println("Enter new task details:");
            System.out.print("Enter new task description: ");
            String newDescription = scanner.nextLine();
            System.out.print("Enter new task due date (YYYY-MM-DD): ");
            String newDueDate = scanner.nextLine();
            task.setDescription(newDescription);
            task.setDueDate(newDueDate);
            System.out.println("Task edited successfully.");
        }
    }

    private static void deleteTask() {
        System.out.print("Enter title of task to delete: ");
        String title = scanner.nextLine();
        if (tasks.containsKey(title)) {
            tasks.remove(title);
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Task not found.");
        }
    }
}

class Task {
    private String title;
    private String description;
    private String dueDate;

    public Task(String title, String description, String dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nDescription: " + description + "\nDue Date: " + dueDate + "\n";
    }
}
