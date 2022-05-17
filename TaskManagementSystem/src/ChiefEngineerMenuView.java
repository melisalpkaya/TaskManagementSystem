import javax.swing.text.View;
import java.util.HashMap;

public class ChiefEngineerMenuView implements ViewInterface {
    Integer choice;

    @Override
    public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
        System.out.println("\nCHIEF ENGINEER MENU");
        System.out.println("--------------\n");
        do {
            System.out.println("1. Show my emploees");
            System.out.println("2. Attend new task");
            System.out.println("3. Attend new subtask for already defined task");
            System.out.println("4. Query the status of the task");
            System.out.println("5. Update task");
            System.out.println("6. Delete task");
            System.out.println("7. Log Out");
            System.out.println();

            choice = getInteger("Enter your choice: ", false);
        }
        while (choice == null || choice < 1 || choice > 7);
        if (choice == 1) {
            operationName = "select.gui2";
            return new ViewData("Employee" + "", operationName, new HashMap<>());
        }
        else if(choice == 2 ){

            operationName = "insert.gui";
            return new ViewData("Task" + "", operationName, new HashMap<>());

        }
        else if(choice == 3 ){

            operationName = "insert2.gui";
            return new ViewData("SubTask" + "", operationName, new HashMap<>());

        }
        else if(choice == 4 ){

            operationName = "select.gui";
            return new ViewData("AttendBy" + "", operationName, new HashMap<>());

        }
        else if(choice == 5 ){

            operationName = "update.gui2";
            return new ViewData("SubTask" + "", operationName, new HashMap<>());

        }
        else if(choice == 6){

            operationName = "delete.gui";
            return new ViewData("Task" + "", operationName, new HashMap<>());

        }
        else if(choice == 7){
            return new ViewData(null,null);
        }


        return new ViewData("ChiefEngineer", null, null);

    }

    @Override
    public String toString() {
        return "ChiefEngineerMenuView{" +
                "choice=" + choice +
                '}';
    }
}
