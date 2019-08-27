package DataBase;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;

public class ConnectionDb {
    private static Connection CONNECTION;
    private static String URL = "jdbc:mysql://localhost:3306/example?useSSL=false&serverTimezone=UTC";
    private static String USER = "root";
    private static String PASSWORD = "ilya";

    private ConnectionDb() {
    }

    public static Connection getConnection() {
        if (CONNECTION == null) {
            try {
                CONNECTION = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                System.out.println("Connection Failed! Check output console");
                e.printStackTrace();
                return null;
            }
        }
        return CONNECTION;
    }
}
