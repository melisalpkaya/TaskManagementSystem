public class AttendBy {
    private int chiefId;
    private int taskId;

    public AttendBy() {
    }

    public AttendBy(int chiefId, int taskId) {
        this.chiefId = chiefId;
        this.taskId = taskId;
    }

    public int getEmployeeId() {
        return chiefId;
    }

    public void setEmployeeId(int employeeId) {
        this.chiefId = employeeId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public String toString() {
        return "AttendBy{" +
                "ChiefID=" + chiefId +
                ",TaskID=" + taskId +
                '}';
    }
    public Object getByName(String attributeName) {
        switch (attributeName) {
            case "ChiefID":
                return chiefId;
            case "TaskID":
                return taskId;
            default:
                return null;
        }
    }
}
