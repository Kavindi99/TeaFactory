package lk.ijse.teafactory.modelold;

import lk.ijse.teafactory.tdm.OwnerStock;
import lk.ijse.teafactory.dao.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * author - kavindi
 * version - 1.0.0 1:37 AM 11/29/2022
 **/

public class OwnerStockModel {
    public static boolean save(OwnerStock ownerStock) throws SQLException, ClassNotFoundException {

         String sql = "INSERT INTO Stock VALUES (?, ?, ?)";
        return CrudUtil.execute(sql, ownerStock.getStockId(), ownerStock.getStockName(), ownerStock.getSectionCode());
    }

    public static OwnerStock search(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Stock WHERE stockId = ?";
        ResultSet result = CrudUtil.execute(sql,id);

        if(result.next()){
            return new OwnerStock(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3)
            );
        }
        return null;
    }

    public static boolean update (OwnerStock ownerStock, String stockId) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Stock SET stockName=?, sectionCode=? WHERE stockId=?";
        return CrudUtil.execute(sql,ownerStock.getStockName(), ownerStock.getSectionCode(),stockId);
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

    public static ArrayList<OwnerStock> getStockData() throws SQLException, ClassNotFoundException {
        ArrayList<OwnerStock> stocksData = new ArrayList<>();

        ResultSet rs = CrudUtil.execute("SELECT * FROM Stock ORDER BY CAST(SUBSTRING(stockId, 2) AS UNSIGNED)");
        while (rs.next()){
            stocksData.add(new OwnerStock(rs.getString("stockId"),
                    rs.getString("stockName"),
                    rs.getString("sectionCode")));
        }
        return stocksData;
    }

    public static boolean delete (OwnerStock ownerStock, String stockId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM Stock  WHERE stockId = ?";
        return CrudUtil.execute(sql,ownerStock.getStockId());
    }
}

