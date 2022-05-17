import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AttendByView implements ViewInterface{
    @Override
    public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
        switch (operationName) {
            //
            case "select": return selectOperation(modelData);//chief eng atadığı taskların durumunu sorgulama devam chief eng dönüyor
            case "select.gui": return selectGUI(modelData);//chief eng atadığı taskların durumunu sorgulama
            case "insert": return insertOperation(modelData);//chief eng menuye geri dondur
            case "insert.gui": return insertGUI(modelData); // atama sonrası kimin atadıgını alma arkaplanda
        }
        return new ViewData("Engineer", "");
    }

    private ViewData selectOperation(ModelData modelData) throws Exception {
        ResultSet resultSet = modelData.resultSet;

        if (resultSet != null) {
            while (resultSet.next()) {
                // Retrieve by column name
                int EmployeeID = resultSet.getInt("ChiefID");
                int taskId = resultSet.getInt("TaskID");
                int subtaskId = resultSet.getInt("SubTaskID");
                String taskName = resultSet.getString("TaskName");
                String description = resultSet.getString("Description");
                String status = resultSet.getString("Status");
                String creationDate = resultSet.getString("CreationDate");
                String deadline = resultSet.getString("Deadline");
                String priority = resultSet.getString("Priority");
                int employeeID = resultSet.getInt("EmployeeID");


                System.out.println("My assigned tasks: \n");
                // Display values
                System.out.println("My Id \t\t TaskID \t SubTaskID \t\t TaskName \t\t\t\t Description \t\t\t\t Status \t CreationDate \t Deadline \t\t\t Priority \t\t EmployeeID ");
                System.out.println("---------- \t ------ \t --------- \t\t ----------- \t\t\t ------------- \t\t\t\t------- \t\t-------\t\t------------\t\t----------\t\t----------");
                System.out.print(EmployeeID + "\t\t\t");
                System.out.print(taskId+ "\t\t\t");
                System.out.print(subtaskId+ "\t\t\t");
                System.out.print(taskName+ "\t\t\t");
                System.out.print(description + "\t\t\t");
                System.out.print(status+ "\t\t");
                System.out.print(creationDate+ "\t\t");
                System.out.print(deadline+ "\t\t");
                System.out.print(priority+ "\t\t\t");
                System.out.print(employeeID+ "\t");
                System.out.println("\n");


            }
            resultSet.close();
        }
        return new ViewData("ChiefEngineer", "");
    }

    private ViewData insertOperation(ModelData modelData) throws Exception {
        System.out.println("Successfull!");
        System.out.println("Number of inserted rows is " + modelData.recordCount);


        return new ViewData("ChiefEngineer", "");
    }

    Map<String, Object> getWhereParameters() throws Exception {

        Integer chiefId = EmployeeView.employee.getEmployeeID();


        Map<String, Object> whereParameters = new HashMap<>();

        if (chiefId != null ) whereParameters.put("ChiefID", chiefId);


        return whereParameters;
    }

    private ViewData selectGUI(ModelData modelData) throws Exception{
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("AttendBy", "select", parameters);
    }

    private ViewData insertGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fieldNames", "ChiefID, TaskID");

        List<Object> rows = new ArrayList<>();

        Integer taskId,chiefId;


            taskId = TaskView.task.getTaskId();
        chiefId = EmployeeView.employee.getEmployeeID();


            System.out.println();

           if (taskId != null &&  chiefId != null)

                rows.add(new AttendBy(chiefId,taskId));

        System.out.println("----------");
        parameters.put("rows", rows);

        return new ViewData("AttendBy", "insert", parameters);
    }


}
