import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.*;
import java.sql.*;

public class EmployeeModel implements ModelInterface{
    @Override
    public ResultSet select(Map<String, Object> whereParameters) throws Exception {
        // construct SQL statement
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT ");
        sql.append("EmployeeID, Name, Surname, Department, JobTitle");
        sql.append(" FROM Employee ");

        List<Map.Entry<String, Object>> whereParameterList = DatabaseUtilities.createWhereParameterList(whereParameters);
        sql.append(DatabaseUtilities.prepareWhereStatement(whereParameterList));

        sql.append("ORDER BY EmployeeID");
        //System.out.println(sql.toString() + "\n");


        // execute constructed SQL statement
        Connection connection = DatabaseUtilities.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
        DatabaseUtilities.setWhereStatementParameters(preparedStatement, whereParameterList);
        ResultSet result = preparedStatement.executeQuery();

        return result;
    }



    @Override
    public int insert(String fieldNames, List<Object> rows) throws Exception
    {
        // construct SQL statement
        StringBuilder sql = new StringBuilder();
        sql.append(" INSERT INTO Employee (" + fieldNames + ") " );
        sql.append(" VALUES ");

        String[] fieldList = fieldNames.split(",");

        int rowCount = 0;
        for (int i=0; i<rows.size(); i++) {
            if (rows.get(i) instanceof Employee) {
                rowCount++;

                Employee employee = (Employee) rows.get(i);

                sql.append("(");
                for (int j=0; j<fieldList.length; j++) {
                    String fieldName = fieldList[j].trim();
                    sql.append(DatabaseUtilities.formatField(employee.getByName(fieldName)));
                    if (j < fieldList.length - 1) {
                        sql.append(", ");
                    }
                }
                sql.append(")");

                if (i < rows.size() - 1) {
                    sql.append(", ");
                }
            }
        }
        //System.out.println(sql.toString());


        // execute constructed SQL statement
        if (rowCount > 0) {
            Connection connection = DatabaseUtilities.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
            rowCount = preparedStatement.executeUpdate();
            preparedStatement.close();
        }

        return rowCount;
    }

    @Override
    public int insert2(String fieldNames, List<Object> rows) throws Exception {
        return 0;
    }

    @Override
    public int update(Map<String,Object> updateParameters, Map<String,Object> whereParameters) throws Exception
    {
        // construct SQL statement
        StringBuilder sql = new StringBuilder();
        sql.append(" UPDATE Employee SET ");
        int appendCount = 0;
        for (Map.Entry<String, Object> entry : updateParameters.entrySet()) {
            sql.append(entry.getKey() + " = " + DatabaseUtilities.formatField(entry.getValue()));
            if (++appendCount < updateParameters.size()) {
                sql.append(", ");
            }
        }
        List<Map.Entry<String, Object>> whereParameterList = DatabaseUtilities.createWhereParameterList(whereParameters);
        sql.append(DatabaseUtilities.prepareWhereStatement(whereParameterList));
        //System.out.println(sql.toString());


        // execute constructed SQL statement
        Connection connection = DatabaseUtilities.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
        DatabaseUtilities.setWhereStatementParameters(preparedStatement, whereParameterList);
        int rowCount = preparedStatement.executeUpdate();
        preparedStatement.close();

        return rowCount;
    }

    @Override
    public int update2(Map<String, Object> updateParameters, Map<String, Object> whereParameters) throws Exception {
        return 0;
    }

    @Override
    public int delete(Map<String,Object> whereParameters) throws Exception
    {
        // construct SQL statement
        StringBuilder sql = new StringBuilder();
        sql.append(" DELETE FROM Employee ");

        List<Map.Entry<String, Object>> whereParameterList = DatabaseUtilities.createWhereParameterList(whereParameters);
        sql.append(DatabaseUtilities.prepareWhereStatement(whereParameterList));
        //System.out.println(sql.toString());


        // execute constructed SQL statement
        Connection connection = DatabaseUtilities.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
        DatabaseUtilities.setWhereStatementParameters(preparedStatement, whereParameterList);
        int rowCount = preparedStatement.executeUpdate();
        preparedStatement.close();

        return rowCount;
    }

    @Override
    public ResultSet select2(Map<String, Object> whereParameters) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT ");
        //sql.append("EmployeeID, Name, Surname, Department, JobTitle ");
        sql.append("EmployeeID, Name, Surname, Department, JobTitle, Email, Password ");
        sql.append(" FROM Employee " );


        List<Map.Entry<String, Object>> whereParameterList = DatabaseUtilities.createWhereParameterList(whereParameters);
        sql.append(DatabaseUtilities.prepareWhereStatement(whereParameterList));

        //sql.append("ORDER BY EmployeeID");
        //System.out.println(sql.toString() + "\n");


        // execute constructed SQL statement
        Connection connection = DatabaseUtilities.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
        DatabaseUtilities.setWhereStatementParameters(preparedStatement, whereParameterList);

        ResultSet result = preparedStatement.executeQuery();
        //System.out.println("select 2de miyiz");
        return result;

    }


    @Override
    public ResultSet select1(Map<String, Object> whereParameters) throws Exception {
        // construct SQL statement
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT ");
        sql.append("EmployeeID, Name, Surname, Department, JobTitle");
        sql.append(" FROM Employee ");

        List<Map.Entry<String, Object>> whereParameterList = DatabaseUtilities.createWhereParameterList(whereParameters);
        sql.append(DatabaseUtilities.prepareWhereStatement(whereParameterList));

        sql.append("ORDER BY EmployeeID");
        //System.out.println(sql.toString() + "\n");


        // execute constructed SQL statement
        Connection connection = DatabaseUtilities.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
        DatabaseUtilities.setWhereStatementParameters(preparedStatement, whereParameterList);
        ResultSet result = preparedStatement.executeQuery();

        return result;

    }

    @Override
    public ResultSet select4(Map<String, Object> whereParameters) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT ");
        sql.append("Name, Surname, Department, JobTitle,Email,PhoneNumber");
        sql.append(" FROM Employee ");

        List<Map.Entry<String, Object>> whereParameterList = DatabaseUtilities.createWhereParameterList(whereParameters);
        sql.append(DatabaseUtilities.prepareWhereStatement(whereParameterList));

        //sql.append("ORDER BY EmployeeID");

        Connection connection = DatabaseUtilities.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
        DatabaseUtilities.setWhereStatementParameters(preparedStatement, whereParameterList);
        ResultSet result = preparedStatement.executeQuery();

        return result;
    }


    @Override
    public String toString() {
        return "Employee Model";
    }


}
