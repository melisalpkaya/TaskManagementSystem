import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorksOnView implements ViewInterface{

    @Override
    public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
        switch (operationName) {
            //
            case "insert": return insertOperation(modelData);// sub task atama devam
            case "insert.gui": return insertGUI(modelData); // sub task ekledikten sonra kime atacayacagını secme
            case "insert2": return insert2Operation(modelData);//hali hazır olan taska sub task ekledikten sonra kişiye atama devam chief eng menusune dondu
            case "insert2.gui": return insert2GUI(modelData);//hali hazır olan taska sub task ekledikten sonra kişiye atama
        }

        return new ViewData("Engineer", "");
    }


    private ViewData insertOperation(ModelData modelData) throws Exception {
        System.out.println("Number of inserted rows is " + modelData.recordCount);

        return new ViewData("AttendBy", "insert.gui");
    }
    private ViewData insert2Operation(ModelData modelData) throws Exception {
        System.out.println("Number of inserted rows is " + modelData.recordCount);

        return new ViewData("ChiefEngineer", "");
    }

    Map<String, Object> getWhereParameters() throws Exception {


        Integer EmployeeID = EmployeeView.employee.getEmployeeID();


        Map<String, Object> whereParameters = new HashMap<>();

        if (EmployeeID != null ) whereParameters.put("EmployeeID ", EmployeeID);


        return whereParameters;
    }


    private ViewData insertGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fieldNames", "TaskID, SubTaskID, EmployeeID");

        List<Object> rows = new ArrayList<>();

        Integer taskId,subTaskId,employeeId;


            System.out.println("Enter the id of the employee you want to assign");
            taskId = SubTaskView.st.getTaskId();
            employeeId = getInteger("EmployeeID:",true);
            subTaskId = SubTaskView.st.getSubTaskId();


            System.out.println();

            if (taskId != null && subTaskId != null && employeeId != null) {
                rows.add(new WorksOn(taskId, subTaskId,employeeId));
            }

        System.out.println("----------");
        parameters.put("rows", rows);

        return new ViewData("WorksOn", "insert", parameters);
    }
    private ViewData insert2GUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fieldNames", "TaskID, SubTaskID, EmployeeID");

        List<Object> rows = new ArrayList<>();

        Integer taskId,subTaskId,employeeId;

            System.out.println("Enter the id of the employee you want to assign");
            taskId = SubTaskView.st.getTaskId();
            employeeId = getInteger("EmployeeID:",true);
            subTaskId = SubTaskView.st.getSubTaskId();


            System.out.println();

            if (taskId != null && subTaskId != null && employeeId != null) {
                rows.add(new WorksOn(taskId, subTaskId,employeeId));
            }

        System.out.println("----------");
        parameters.put("rows", rows);

        return new ViewData("WorksOn", "insert2", parameters);
    }



}
