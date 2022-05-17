import java.util.HashMap;

public class EngineerMenuView implements ViewInterface{
    Integer choice;

    @Override
    public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {

        System.out.println("\nENGINEER MENU");
        System.out.println("--------------\n");
        do {
            System.out.println("1. Show my attended tasks");
            System.out.println("2. Update attended tasks");
            System.out.println("3. Display my coworkers");
            System.out.println("4. Log Out");
            System.out.println();

            choice = getInteger("Enter your choice: ", false);
        }
        while (choice == null || choice < 1 || choice > 4);
        if(choice == 1){
            operationName = "select.gui";
            return new ViewData("Task" + "", operationName, new HashMap<>());
        }
        else if (choice == 2) {
            operationName = "update.gui";
            return new ViewData("SubTask" + "", operationName, new HashMap<>());
        }

        else if (choice == 3) {
            operationName = "select.gui3";
            return new ViewData("Employee" + "", operationName, new HashMap<>());
        }
        else if(choice == 4){
            return new ViewData(null,null);
        }


        return new ViewData("Engineer", null, null);





    }
}
