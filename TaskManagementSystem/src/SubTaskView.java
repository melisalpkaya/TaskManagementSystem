import java.sql.ResultSet;
import java.util.*;

public class SubTaskView implements ViewInterface{
    public static SubTask st = new SubTask();

    @Override
    public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
        switch (operationName) {
            //
            case "insert": return insertOperation(modelData); // chief eng sub task ekleme devam
            case "insert.gui": return insertGUI(modelData);//chief new task ekledikten sonra sub task ekleme
            case "insert2": return insert2Operation(modelData);//hali hazırda taska sub task ekleme devam works on'a git
            case "insert2.gui": return insert2GUI(modelData);//hali hazırda olan taska sub task ekleme
            case "update.gui": return updateGUI(modelData); // engineer task status update etmek için
            case "update": return updateOperation(modelData); // engineer task status update devam
            case "update2": return updateOperation2(modelData);//chief eng geri dön
            case "update.gui2": return updateGUI2(modelData);// chief eng taskların bilgilerini update etmek icin

        }

        return new ViewData("Engineer", "");
    }
    ViewData updateOperation(ModelData modelData) throws Exception {
        System.out.println("Number of updated rows is " + modelData.recordCount);

        return new ViewData("Engineer", "");
    }
    ViewData updateGUI(ModelData modelData) throws Exception {
        System.out.println("Fields to update:");
        String status = getString("Status : ", true);


        System.out.println();

        Map<String, Object> updateParameters = new HashMap<>();
        if (status != null) updateParameters.put("Status", status);


        Map<String, Object> parameters = new HashMap<>();
        parameters.put("updateParameters", updateParameters);
        parameters.put("whereParameters", getWhereParameters2());

        return new ViewData("SubTask", "update", parameters);
    }
    ViewData updateOperation2(ModelData modelData) throws Exception {
        System.out.println("Number of updated rows is " + modelData.recordCount);

        return new ViewData("ChiefEngineer", "");
    }
    ViewData updateGUI2(ModelData modelData) throws Exception {
        System.out.println("Fields to update:");

        String taskName = getString("TaskName : ", true);
        String description = getString("Description : ", true);
        String status = getString("Status : ", true);
        String creationDate = getString("CreationDate : ", true);
        String priority = getString("Priority : ", true);
        String deadLine = getString("Deadline : ", true);

        System.out.println();

        Map<String, Object> updateParameters = new HashMap<>();

        if (taskName != null) updateParameters.put("TaskName", taskName);
        if (description != null) updateParameters.put("Description", description);
        if (status != null) updateParameters.put("Status", status);
        if (creationDate != null) updateParameters.put("CreationDate", creationDate);
        if (priority != null) updateParameters.put("Priority", priority);
        if (deadLine != null) updateParameters.put("Deadline", deadLine);


        Map<String, Object> parameters = new HashMap<>();
        parameters.put("updateParameters", updateParameters);
        parameters.put("whereParameters", getWhereParameters2());

        return new ViewData("SubTask", "update2", parameters);
    }

    private ViewData insertGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fieldNames", "TaskID, SubTaskID, TaskName, Description, Status, CreationDate, Priority, Deadline");

        List<Object> rows = new ArrayList<>();

        Integer taskId,subTaskId;
        String taskName, description, status,priority, creationDate, deadLine;

            System.out.println("Create a new subtask:");
            taskId = TaskView.task.getTaskId();
            taskName = TaskView.task.getTaskName();
            subTaskId = getInteger("SubTaskID : ", true);
            description = getString("Description : ", true);
            status = getString("Status : ", true);
            priority = getString("Priority : ", true);
            System.out.println("Please use this format : yyyy-MM-dd");
            creationDate = getString("CreationDate:",true);
            System.out.println("Please use this format : yyyy-MM-dd");
            deadLine = getString("Deadline: ",true);

            System.out.println();

            if (taskId != null && subTaskId != null && taskName != null && description != null && status != null && priority != null && creationDate != null && deadLine != null) {
                st.setTaskId(taskId);
                st.setSubTaskId(subTaskId);
                st.setTaskName(taskName);
                st.setDescription(description);
                st.setStatus(status);
                st.setPriority(priority);
                st.setCreationDate(creationDate);
                st.setDeadline(deadLine);
                rows.add(st);
            }

        System.out.println("----------");
        parameters.put("rows", rows);

        return new ViewData("SubTask", "insert", parameters);
    }
    private ViewData insert2GUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fieldNames", "TaskID, SubTaskID, TaskName, Description, Status, CreationDate, Priority, Deadline");

        List<Object> rows = new ArrayList<>();

        Integer taskId,subTaskId;
        String taskName, description, status,priority, creationDate, deadLine;


            System.out.println("Create a new subtask for already defined task:");
            taskId = getInteger("TaskID : ", true);
            taskName = getString("TaskName : ", true);
            subTaskId = getInteger("SubTaskID : ", true);
            description = getString("Description : ", true);
            status = getString("Status : ", true);
            priority = getString("Priority : ", true);
            System.out.println("Please use this format : yyyy-MM-dd");
            creationDate = getString("CreationDate:",true);
            System.out.println("Please use this format : yyyy-MM-dd");
            deadLine = getString("Deadline: ",true);

            System.out.println();

            if (taskId != null && subTaskId != null && taskName != null && description != null && status != null && priority != null && creationDate != null && deadLine != null) {
                st.setTaskId(taskId);
                st.setSubTaskId(subTaskId);
                st.setTaskName(taskName);
                st.setDescription(description);
                st.setStatus(status);
                st.setPriority(priority);
                st.setCreationDate(creationDate);
                st.setDeadline(deadLine);
                rows.add(st);
            }
        System.out.println("----------");
        parameters.put("rows", rows);

        return new ViewData("SubTask", "insert2", parameters);
    }

    private ViewData insertOperation(ModelData modelData) throws Exception {
        System.out.println("Number of inserted rows is " + modelData.recordCount);

        return new ViewData("WorksOn", "insert.gui");
    }
    private ViewData insert2Operation(ModelData modelData) throws Exception {
        System.out.println("Number of inserted rows is " + modelData.recordCount);

        return new ViewData("WorksOn", "insert2.gui");
    }

    Map<String, Object> getWhereParameters() throws Exception {


        Integer EmployeeID = EmployeeView.employee.getEmployeeID();


        Map<String, Object> whereParameters = new HashMap<>();

        if (EmployeeID != null ) whereParameters.put("EmployeeID ", EmployeeID);


        return whereParameters;
    }
    Map<String, Object> getWhereParameters2() throws Exception {
        //engineer update ederken kullanıyor
       System.out.println("Filter conditions:");


        Integer taskId = getInteger("TaskID : ", true);
        Integer subTaskId = getInteger("SubTaskID : ", true);

        Map<String, Object> whereParameters = new HashMap<>();


        if (taskId != null) whereParameters.put("TaskID", taskId);
        if (subTaskId != null) whereParameters.put("SubTaskID", subTaskId);

        return whereParameters;
    }

}
