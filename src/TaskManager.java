import javax.lang.model.element.Name;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
    private static ArrayList<Task> tasks = new ArrayList<Task>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = getUserChoice();
            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    removeTask();
                    break;
                case 3:
                    viewTasks();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор, давай ещё раз!");
            }
        }
        System.out.println("До встречи!");
    }

    private static void showMenu() {
        System.out.println("Чем займёмся сегодня?");
        System.out.println("1. Создать задачу");
        System.out.println("2. Удалить задачу");
        System.out.println("3. Просмотреть все задачи");
        System.out.println("4. Выход");
    }

    private static int getUserChoice() {
        System.out.println("Что делаем?");
        return scanner.nextInt();
    }

    private static void addTask() {
        scanner.nextLine();
        System.out.println("Введи название задачи:");
        String name = scanner.nextLine();
        System.out.println("Введи описание задачи:");
        String description = scanner.nextLine();
        tasks.add(new Task(name, description));
        System.out.println("Задача добавлена.");
        viewTasks();
    }

    private static void removeTask() {
        if (tasks.isEmpty()) {
            System.out.println("Список задач пуст.");
            return;
        }
        viewTasks();
        scanner.nextLine();
        System.out.println("Введи название задачи, которую нужно удалить:");
        String taskName = scanner.nextLine();
        Task taskToRemove = null;
        for (Task task : tasks) {
            if (task.getName().equalsIgnoreCase(task.getName())) {
                taskToRemove = task;
                break;
            }
        }
        if (taskToRemove != null) {
            tasks.remove(taskToRemove);
            System.out.println("Задача удалена.");
            viewTasks();
        }
        else {
            System.out.println("Задача с таким названием не найдена.");
            viewTasks();
        }
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Список задач пуст. Добавим?");
            addTask();
        }
        else {
            System.out.println("Ваши задачи:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}

class Task {
    private String name;
    private String description;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Название: <" + name + ">; " + "Описание: " + description;
    }
}