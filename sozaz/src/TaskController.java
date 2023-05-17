import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskController {
    private List<Task> tasks;
    private final String FILE_NAME = "tasks.obj";

    public TaskController() {
        tasks = new ArrayList<>();
    }

    public void saveTask(Task task) {
        tasks.add(task);

        try (FileOutputStream fileOut = new FileOutputStream(FILE_NAME);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            objectOut.writeObject(tasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Task> getAllTasks() {
        try (FileInputStream fileIn = new FileInputStream(FILE_NAME);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

            List<Task> tasks = (List<Task>) objectIn.readObject();
            return tasks;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}
