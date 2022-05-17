import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public class AttendByModel implements ModelInterface{
    @Override
    public ResultSet select(Map<String, Object> whereParameters) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT ");
        sql.append(" A.ChiefID, A.TaskID, St.SubTaskID, St.TaskName," +
                " St.Description, St.Status, St.CreationDate,St.Deadline, St.Priority, W.EmployeeID\n");
        sql.append(" FROM AttendBy AS A INNER JOIN SubTask AS St ON A.TaskID = St.TaskID");
        sql.append(" INNER JOIN WorksOn AS W ON W.TaskID  = A.TaskID AND W.SubTaskID = St.SubTaskID");


        List<Map.Entry<String, Object>> whereParameterList = DatabaseUtilities.createWhereParameterList(whereParameters);
        sql.append(DatabaseUtilities.prepareWhereStatement(whereParameterList));

        sql.append("ORDER BY A.TaskID");


        //System.out.println(sql.toString() + "\n");


        // execute constructed SQL statement
        Connection connection = DatabaseUtilities.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
        DatabaseUtilities.setWhereStatementParameters(preparedStatement, whereParameterList);
        ResultSet result = preparedStatement.executeQuery();

        return result;
    }

    @Override
    public int insert(String fieldNames, List<Object> rows) throws Exception {
        // construct SQL statement
        StringBuilder sql = new StringBuilder();
        sql.append(" INSERT INTO AttendBy (" + fieldNames + ") " );
        sql.append(" VALUES ");

        String[] fieldList = fieldNames.split(",");

        int rowCount = 0;
        for (int i=0; i<rows.size(); i++) {
            if (rows.get(i) instanceof AttendBy) {
                rowCount++;

                AttendBy a = (AttendBy) rows.get(i);



                sql.append("(");
                for (int j=0; j<fieldList.length; j++) {
                    String fieldName = fieldList[j].trim();

                    sql.append(DatabaseUtilities.formatField(a.getByName(fieldName)));

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
    public int update(Map<String, Object> updateParameters, Map<String, Object> whereParameters) throws Exception {
        return 0;
    }

    @Override
    public int update2(Map<String, Object> updateParameters, Map<String, Object> whereParameters) throws Exception {
        return 0;
    }

    @Override
    public int delete(Map<String, Object> whereParameters) throws Exception {
        return 0;
    }

    @Override
    public ResultSet select2(Map<String, Object> whereParameters) throws Exception {
        return null;
    }

    @Override
    public ResultSet select1(Map<String, Object> whereParameters) throws Exception {
        return null;
    }

    @Override
    public ResultSet select4(Map<String, Object> whereParameters) throws Exception {
        return null;
    }
}
