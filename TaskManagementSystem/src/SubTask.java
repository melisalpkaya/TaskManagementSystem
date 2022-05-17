import java.util.Date;
import java.text.SimpleDateFormat;


public class SubTask {
    private int taskId;
    private int subTaskId;
    private String taskName;
    private String description;
    private String status;
    private String priority;
    private String creationDate;
    private String deadline;

    public SubTask() {
    }

    public SubTask(int taskId, int subTaskId, String taskName, String description, String status, String priority, String creationDate, String deadline) {
        this.taskId = taskId;
        this.subTaskId = subTaskId;
        this.taskName = taskName;
        this.description = description;
        this.status = status;
        this.creationDate = creationDate;
        this.priority = priority;
        this.deadline = deadline;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getSubTaskId() {
        return subTaskId;
    }

    public void setSubTaskId(int subTaskId) {
        this.subTaskId = subTaskId;
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

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public Object getByName(String attributeName) {
        switch (attributeName) {
            case "TaskID":
                return taskId;
            case "SubTaskID":
                return subTaskId;
            case "TaskName":
                return taskName;
            case "Description":
                return description;
            case "Status":
                return status;
            case "CreationDate":
                return creationDate;
            case "Priority":
                return priority;
            case "Deadline":
                return deadline;
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        return "SubTask{" +
                "taskId=" + taskId +
                ", subTaskId=" + subTaskId +
                ", taskName='" + taskName + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", priority='" + priority + '\'' +
                ", creationDate=" + creationDate +
                ", deadline=" + deadline +
                '}';
    }
}


