package lk.ijse.teafactory.modelold;

import lk.ijse.teafactory.tdm.AdminStock;
import lk.ijse.teafactory.dao.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * author - kavindi
 * version - 1.0.0 12:06 AM 11/29/2022
 **/
public class AdminStockModel {
    public static boolean save(AdminStock adminStock) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Stock VALUES (?, ?, ?)";
        return CrudUtil.execute(sql, adminStock.getStockId(), adminStock.getStockName(), adminStock.getSectionCode());
    }

    public static AdminStock search(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Stock WHERE stockId = ?";
        ResultSet result = CrudUtil.execute(sql,id);

        if(result.next()){
            return new AdminStock(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3)
            );
        }
        return null;
    }

    public static boolean update (AdminStock adminStock, String stockId) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Stock SET stockName=?, sectionCode=? WHERE stockId=?";
        return CrudUtil.execute(sql,adminStock.getStockName(), adminStock.getSectionCode(),stockId);
    }

    public static ArrayList loadStockIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT stockId FROM Stock";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> idList = new ArrayList<>();

        while (result.next()){
            idList.add(result.getString(1));
        }
        return idList;
    }

    public static ArrayList<AdminStock> getStockData() throws SQLException, ClassNotFoundException {
        ArrayList<AdminStock> stocksData = new ArrayList<>();

        ResultSet rs = CrudUtil.execute("SELECT * FROM Stock ORDER BY CAST(SUBSTRING(stockId, 2) AS UNSIGNED)");
        while (rs.next()){
            stocksData.add(new AdminStock(rs.getString("stockId"),
                    rs.getString("stockName"),
                    rs.getString("sectionCode")));
        }
        return stocksData;
    }

    public static boolean delete (AdminStock adminStock, String stockId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM Stock  WHERE stockId = ?";
        return CrudUtil.execute(sql,adminStock.getStockId());
    }

}
