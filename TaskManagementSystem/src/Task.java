import java.util.Date;

public class Task {
    private int taskId;
    private String taskName;
    private String taskType;

    public Task() {
    }

    public Task(int taskId, String taskName, String taskType) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskType = taskType;
    }


    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskType() {
        return taskType;
    }

    public Object getByName(String attributeName) {
        switch (attributeName) {
            case "TaskID":
                return taskId;
            case "TaskName":
                return taskName;
            case "TaskType":
                return taskType;
            default:
                return null;
        }
    }
}
