import java.util.HashMap;
import java.util.*;

public class LoginView implements ViewInterface{
    @Override
    public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
        System.out.println("WELCOME TO MBSOFT !");
        System.out.println("*******************");

        Integer choice;
        do {
            System.out.println("1. LOGIN");
            System.out.println("2. QUIT");
            choice = getInteger("Enter your choice : ", false);
        }
        while (choice == null || choice < 1 || choice > 2);

        if (choice == 1) {
            operationName = "select.gui";
            return new ViewData("Employee" + "", operationName, new HashMap<>());
        }
        else if(choice == 2){
            return new ViewData(null,null);
        }
        return new ViewData("Login", null, null);
    }

    @Override
    public String toString() {
        return "Login View";
    }

}
