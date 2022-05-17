public class WorksOn {
    private int taskId;
    private int subTaskId;
    private int employeeId;

    public WorksOn() {
    }

    public WorksOn(int taskId, int subTaskId, int employeeId) {
        this.taskId = taskId;
        this.subTaskId = subTaskId;
        this.employeeId = employeeId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getSubTaskId() {
        return subTaskId;
    }

    public void setSubTaskId(int subTaskId) {
        this.subTaskId = subTaskId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "WorksOn{" +
                "taskId=" + taskId +
                ", subTaskId=" + subTaskId +
                ", employeeId=" + employeeId +
                '}';
    }
    public Object getByName(String attributeName) {
        switch (attributeName) {
            case "TaskID":
                return taskId;
            case "SubTaskID":
                return subTaskId;
            case "EmployeeID":
                return employeeId;
            default:
                return null;
        }
    }

}
