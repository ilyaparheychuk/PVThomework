import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class DBOperations {

    private static String SELECT_USER_BY_ID = "SELECT login, password FROM example WHERE id = ?";

    public UserData getAccessData(int byID){
        UserData data = null;
        try{
            Connection connection = ConnectionDb.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1, byID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                data = new UserData(resultSet.getString(1), resultSet.getString(2));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }


}
