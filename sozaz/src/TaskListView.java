
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class TaskListView extends JFrame {

    private JTable taskTable;

    public TaskListView() {
        setTitle("Task List");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create table model
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Task Name");
        tableModel.addColumn("Task Description");
        tableModel.addColumn("Expire Date");

        // Create table
        taskTable = new JTable(tableModel);

        // Add table to scroll pane
        JScrollPane scrollPane = new JScrollPane(taskTable);

        // Set layout
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);

        loadTasks();
    }

//    private void loadTasks() {
//        try {
//            FileInputStream fileIn = new FileInputStream("tasks.obj");
//            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
//            List<Task> tasks = new ArrayList<>();
//
//            while (fileIn.available() > 0) {
//                Task task = (Task) objectIn.readObject();
//                tasks.add(task);
//            }
//
//            objectIn.close();
//            fileIn.close();
//
//            // Add tasks to table
//            DefaultTableModel tableModel = (DefaultTableModel) taskTable.getModel();
//            for (Task task : tasks) {
//                Object[] rowData = {task.getTaskName(), task.getTaskDescription(), task.getExpireDateTime()};
//                tableModel.addRow(rowData);
//            }
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Error loading tasks!");
//        }
//    }
//    private void loadTasks() {
//        try ( FileInputStream fileIn = new FileInputStream("tasks.obj");  ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
//
//            DefaultTableModel tableModel = (DefaultTableModel) taskTable.getModel();
//
//            while (true) {
//                try {
//                    Task task = (Task) objectIn.readObject();
//                    Object[] rowData = {task.getTaskName(), task.getTaskDescription(), task.getExpireDateTime()};
//                    tableModel.addRow(rowData);
//                } catch (ClassNotFoundException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        } catch (IOException e) {
//            // End of file reached
//            System.out.println("All tasks loaded.");
//        }
//    }
    private void loadTasks() {
        try ( FileInputStream fileIn = new FileInputStream("tasks.obj");  ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

            List<Task> tasks = new ArrayList<>();

            while (fileIn.available() > 0) {
                Task task = (Task) objectIn.readObject();
                tasks.add(task);
            }

            // Add tasks to table
            DefaultTableModel tableModel = (DefaultTableModel) taskTable.getModel();
            for (Task task : tasks) {
                Object[] rowData = {task.getTaskName(), task.getTaskDescription(), task.getExpireDateTime()};
                tableModel.addRow(rowData);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading tasks!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TaskListView();
            }
        });
    }
}
