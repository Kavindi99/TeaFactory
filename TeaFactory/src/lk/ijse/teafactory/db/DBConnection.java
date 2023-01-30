package lk.ijse.teafactory.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * author - kavindi
 * version - 1.0.0 11:11 AM 11/25/2022
 **/
public class DBConnection {
    private static DBConnection dbConnection;
    private Connection connection;

    private DBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/teafactory?allowPublicKeyRetrieval=true&useSSL=false", "root", "1234");
    }

    public static DBConnection getInstance() throws SQLException, ClassNotFoundException {
        return (null == dbConnection) ? dbConnection = new DBConnection() : dbConnection;
    }

    public Connection getConnection() {
        return connection;
    }
}
