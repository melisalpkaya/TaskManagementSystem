import java.util.HashMap;

public class CeoMenuView implements ViewInterface{
    Integer choice;

    @Override
    public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
        System.out.println("\nCEO MENU");
        System.out.println("--------------\n");
        do {
            System.out.println("1. Show All Employees");
            System.out.println("2. QUIT ");
            System.out.println();

            choice = getInteger("Enter your choice: ", false);
        }
        while (choice == null || choice < 1 || choice > 2);

        if (choice == 1) {
            operationName = "select1";
            return new ViewData("Employee" + "", operationName, new HashMap<>());
        }
        else if(choice == 2){
            return new ViewData(null,null);
        }


        return new ViewData("Ceo", null, null);
    }
}
