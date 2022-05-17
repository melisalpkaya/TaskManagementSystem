import java.sql.SQLOutput;
import java.text.ParseException;
import java.util.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskView implements ViewInterface{
    public static Task task = new Task();

    @Override
    public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
        switch (operationName) {
            //
            case "select": return selectOperation(modelData); // engineer taskları gösterme
            case "select.gui": return selectGUI(modelData); // engineer show my tasks
            case "insert": return insertOperation(modelData); // chief eng new task olusturma devam
            case "insert.gui": return insertGUI(modelData);//chief eng new task olusturma
            case "delete.gui": return deleteGUI(modelData);// chief eng task silcek
            case "delete": return deleteOperation(modelData);//chief eng menuye dondu
        }

        return new ViewData("Engineer", "");
    }
    ViewData deleteOperation(ModelData modelData) throws Exception {
        System.out.println("Number of deleted rows is " + modelData.recordCount);

        return new ViewData("ChiefEngineer", "");
    }
    ViewData deleteGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters2());

        return new ViewData("Task", "delete", parameters);
    }

    private ViewData insertGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fieldNames", "TaskID, TaskName, TaskType");

        List<Object> rows = new ArrayList<>();

        Integer taskId;
        String taskName, taskType;

            System.out.println("Create Task:");
            taskId = getInteger("TaskID : ", true);
            taskName = getString("Task Name : ", true);
            taskType = getString("Task Type : ", true);


            if (taskId != null && taskName != null && taskType != null) {
                task.setTaskId(taskId);
                task.setTaskName(taskName);
                task.setTaskType(taskType);
                rows.add(task);
            }


        parameters.put("rows", rows);

        return new ViewData("Task", "insert", parameters);
    }

    private ViewData selectOperation(ModelData modelData) throws Exception{
        ResultSet resultSet = modelData.resultSet;

        if (resultSet != null) {
            while (resultSet.next()) {
                // Retrieve by column name
                int EmployeeID = resultSet.getInt("EmployeeID");
                int taskId = resultSet.getInt("TaskID");
                int subtaskId = resultSet.getInt("SubTaskID");
                String description = resultSet.getString("Description");
                String status = resultSet.getString("Status");
                String priority = resultSet.getString("Priority");

                System.out.println("My attended tasks: \n");
                // Display values
                System.out.println("EmployeeID \t TaskID \t SubTaskID \t\t Description \t\t\t\t Status \t Priority \t ");
                System.out.println("---------- \t ------ \t --------- \t\t ----------- \t\t\t\t ------ \t ------- \t");
                System.out.print(EmployeeID + "\t\t\t");
                System.out.print(taskId+ "\t\t\t");
                System.out.print(subtaskId+ "\t\t");
                System.out.print(description + "\t\t");
                System.out.print(status+ "\t\t");
                System.out.print(priority+ "\t");
                System.out.println("\n");


            }
            resultSet.close();
        }
        return new ViewData("Task", "");


    }
    ViewData insertOperation(ModelData modelData) throws Exception {
        System.out.println("Number of inserted rows is " + modelData.recordCount);


        return new ViewData("SubTask", "insert.gui");
    }
    Map<String, Object> getWhereParameters() throws Exception {

        // selectGUI kullanıyor
        Integer EmployeeID = EmployeeView.employee.getEmployeeID();


        Map<String, Object> whereParameters = new HashMap<>();

        if (EmployeeID != null ) whereParameters.put("EmployeeID ", EmployeeID);


        return whereParameters;
    }
    Map<String, Object> getWhereParameters2() throws Exception {

        System.out.println("Filter conditions:");


        Integer taskId = getInteger("TaskID : ", true);

        Map<String, Object> whereParameters = new HashMap<>();


        if (taskId != null) whereParameters.put("TaskID", taskId);

        return whereParameters;
    }
    ViewData selectGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Task", "select", parameters);
    }


    @Override
    public String toString() {
        return "Task View";
    }
}
