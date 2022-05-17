import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeView implements ViewInterface {

   public static Employee employee = new Employee();

    @Override
    public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {

        switch(operationName) {
            //case "select": return selectOperation(modelData);
            case "select": return selectOperation(modelData); // employeelerin görüntülenmesi chief eng kullanıyor, chief eng dönüyor
            case "select1": return selectOperation1(modelData); // ceo kullanıyor

            case "select2": return selectOperation2(modelData); //login ekranından sonra kim olduğuna karar veren kısım
            case "select4": return selectOperation4(modelData);// eng coworkers görüntüleme


            case "select.gui": return selectGUI(modelData); //email ve şifre için gerekli daha sonra select2
            case "select.gui2": return selectGUI2(modelData);// chief eng çalışanları görüntüleme
            case "select.gui3": return selectGUI3(modelData); // eng coworkers görüntüleme

        }

        return new ViewData("Login", "");
    }
    ViewData selectOperation(ModelData modelData) throws Exception {
        ResultSet resultSet = modelData.resultSet;

        if (resultSet != null) {
            while (resultSet.next()) {
                // Retrieve by column name
                int EmployeeID = resultSet.getInt("EmployeeID");
                String Name = resultSet.getString("Name");
                String Surname = resultSet.getString("Surname");
                String Department = resultSet.getString("Department");
                String JobTitle = resultSet.getString("JobTitle");

                // Display values
                System.out.print(EmployeeID + "\t");
                System.out.print(Name + "\t");
                System.out.print(Surname + "\t");
                System.out.println(Department + "  " +JobTitle);

            }
            resultSet.close();
        }

        return new ViewData("ChiefEngineer", "");
    }
    ViewData selectOperation1(ModelData modelData) throws Exception {
        ResultSet resultSet = modelData.resultSet;
        if (resultSet != null) {
            while (resultSet.next()) {
                // Retrieve by column name
                int EmployeeID = resultSet.getInt("EmployeeID");
                String Name = resultSet.getString("Name");
                String Surname = resultSet.getString("Surname");
                String Department = resultSet.getString("Department");
                String JobTitle = resultSet.getString("JobTitle");
                // Display values
                System.out.print(EmployeeID + "\t");
                System.out.print(Name + "\t");
                System.out.print(Surname + "\t");
                System.out.println(Department + "  " + JobTitle);

            }
            resultSet.close();

        }
        return new ViewData("Ceo", "");
    }

    ViewData selectOperation2(ModelData modelData) throws Exception {
        ResultSet resultSet = modelData.resultSet;

            while (resultSet.next()) {
                // Retrieve by column name
                int EmployeeID = resultSet.getInt("EmployeeID");
                String Name = resultSet.getString("Name");
                String Surname = resultSet.getString("Surname");
                String Email = resultSet.getString("Email");
                String Password = resultSet.getString("Password");
                String Department = resultSet.getString("Department");
                String JobTitle = resultSet.getString("JobTitle");
                employee.setName(Name);
                employee.setEmployeeID(EmployeeID);
                employee.setSurname(Surname);
                employee.setEmail(Email);
                employee.setPassword(Password);
                employee.setDepartment(Department);
                employee.setJobTitle(JobTitle);


                // Display values
                System.out.print("WELCOME " + employee.getName() + "\t");

                if(JobTitle.equals("Chief Engineer                                    ") )
                {
                    return new ViewData("ChiefEngineer", "");
                }
                else if(JobTitle.equals("CEO                                               ")){
                    return new ViewData("Ceo", "");
                }
                else if(JobTitle.equals("Engineer                                          ")){
                    return new ViewData("Engineer", "");
                }

            }
            resultSet.close();
        //}

        return new ViewData("Login", "");
    }
    ViewData selectOperation4(ModelData modelData) throws Exception {
        ResultSet resultSet = modelData.resultSet;

        if (resultSet != null) {
            while (resultSet.next()) {
                // Retrieve by column name
                String Name = resultSet.getString("Name");
                String Surname = resultSet.getString("Surname");
                String Department = resultSet.getString("Department");
                String PhoneNumber = resultSet.getString("PhoneNumber");
                String Email = resultSet.getString("Email");

                // Display values

                System.out.print(Name + " " + Surname + "\t");
                System.out.print("\t"+Department + "\t");
                System.out.print(PhoneNumber + "\t");
                System.out.println(Email + "\t");

            }
            resultSet.close();
        }

        return new ViewData("Engineer", "");
    }


    Map<String, Object> getWhereParameters() throws Exception {

        String Email = getString("Email:", false);
        String Password = getString("Password:", false);

        Map<String, Object> whereParameters = new HashMap<>();

       if (Email != null ) whereParameters.put("Email ", Email);
       if (Password != null ) whereParameters.put("Password", Password);

       return whereParameters;
    }
    Map<String, Object> getWhereParameters2() throws Exception {

        String Department =employee.getDepartment();
        Map<String, Object> whereParameters = new HashMap<>();
        if (Department != null ) whereParameters.put("Department", Department);

        return whereParameters;
    }
    Map<String, Object> getWhereParameters3() throws Exception {
        System.out.println("Which department do you want to see the employees in?\n");

        String Department = getString("Department:",false);

        Map<String, Object> whereParameters = new HashMap<>();

        if (Department!= null ) whereParameters.put("Department", Department);


        return whereParameters;
    }


    ViewData selectGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Employee", "select2", parameters);
    }

    ViewData selectGUI2(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters2());

        return new ViewData("Employee", "select", parameters);
    }
    ViewData selectGUI3(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters3());

        return new ViewData("Employee", "select4", parameters);
    }

    @Override
    public String toString() {
        return "Employee View";
    }

}
