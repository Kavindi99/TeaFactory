package lk.ijse.teafactory.dao;

import lk.ijse.teafactory.db.DBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * author - kavindi
 * version - 1.0.0 11:12 AM 11/25/2022
 **/
public class CrudUtil {
    public static <T>T execute(String sql, Object...args) throws SQLException, ClassNotFoundException {
        PreparedStatement pstm = DBConnection.getInstance().getConnection()
                .prepareStatement(sql);

        for (int i = 0; i < args.length; i++) {
            pstm.setObject((i+1), args[i]);
        }

        if(sql.startsWith("SELECT") || sql.startsWith("select")) {
            return (T) pstm.executeQuery();
        }
        return (T)(Boolean)(pstm.executeUpdate() > 0);
    }
}
