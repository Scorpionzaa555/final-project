
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;

public class TaskInputView extends JFrame {

    private JTextField taskNameField;
    private JTextField taskDescriptionField;
    private JTextField expireDateField;
    private JTextField expireTimeField;

    public TaskInputView() {
        setTitle("Task Input");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        JLabel taskNameLabel = new JLabel("Task Name:");
        JLabel taskDescriptionLabel = new JLabel("Task Description:");
        JLabel expireDateLabel = new JLabel("Expire Date (YYYY-MM-DD):");
        JLabel expireTimeLabel = new JLabel("Expire Time (HH:MM):");

        taskNameField = new JTextField(20);
        taskDescriptionField = new JTextField(20);
        expireDateField = new JTextField(10);
        expireTimeField = new JTextField(5);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveTask();
            }
        });

        // Create layout
        setLayout(new GridLayout(5, 2));
        add(taskNameLabel);
        add(taskNameField);
        add(taskDescriptionLabel);
        add(taskDescriptionField);
        add(expireDateLabel);
        add(expireDateField);
        add(expireTimeLabel);
        add(expireTimeField);
        add(saveButton);

        setVisible(true);
    }

//    private void saveTask() {
//        String taskName = taskNameField.getText();
//        String taskDescription = taskDescriptionField.getText();
//        String expireDate = expireDateField.getText();
//        String expireTime = expireTimeField.getText();
//
//        LocalDateTime expireDateTime = LocalDateTime.parse(expireDate + "T" + expireTime);
//
//        Task task = new Task(taskName, taskDescription, expireDateTime);
//
//        try {
//            FileOutputStream fileOut = new FileOutputStream("tasks.obj");
//            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
//            objectOut.writeObject(task);
//            objectOut.close();
//            fileOut.close();
//            JOptionPane.showMessageDialog(this, "Task saved successfully!");
//        } catch (IOException e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Error saving task!");
//        }
//    }
//    private void saveTask() {
//        String taskName = taskNameField.getText();
//        String taskDescription = taskDescriptionField.getText();
//        String expireDate = expireDateField.getText();
//        String expireTime = expireTimeField.getText();
//
//        LocalDateTime expireDateTime = LocalDateTime.parse(expireDate + "T" + expireTime);
//
//        Task task = new Task(taskName, taskDescription, expireDateTime);
//
//        try ( FileOutputStream fileOut = new FileOutputStream("tasks.obj", true);  ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
//
//            objectOut.writeObject(task);
//            JOptionPane.showMessageDialog(this, "Task saved successfully!");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Error saving task!");
//        }
//
//        // Clear the input fields
//        taskNameField.setText("");
//        taskDescriptionField.setText("");
//        expireDateField.setText("");
//        expireTimeField.setText("");
//    }
    private void saveTask() {
        String taskName = taskNameField.getText();
        String taskDescription = taskDescriptionField.getText();
        String expireDate = expireDateField.getText();
        String expireTime = expireTimeField.getText();

        LocalDateTime expireDateTime = LocalDateTime.parse(expireDate + "T" + expireTime);

        Task task = new Task(taskName, taskDescription, expireDateTime);

        try ( FileOutputStream fileOut = new FileOutputStream("tasks.obj");  ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            objectOut.writeObject(task);
            JOptionPane.showMessageDialog(this, "Task saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving task!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TaskInputView();
            }
        });
    }
}
