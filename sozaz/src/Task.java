
import java.io.Serializable;
import java.time.LocalDateTime;

public class Task implements Serializable {

    private String taskName;
    private String taskDescription;
    private LocalDateTime expireDateTime;

    public Task(String taskName, String taskDescription, LocalDateTime expireDateTime) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.expireDateTime = expireDateTime;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDateTime getExpireDateTime() {
        return expireDateTime;
    }

    public void setExpireDateTime(LocalDateTime expireDateTime) {
        this.expireDateTime = expireDateTime;
    }
}
