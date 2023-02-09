package lk.ijse.teafactory.dao.custom.impl;

import lk.ijse.teafactory.dao.CrudUtil;
import lk.ijse.teafactory.dao.custom.StockDAO;
import lk.ijse.teafactory.model.CustomerDTO;
import lk.ijse.teafactory.model.StockDTO;
import lk.ijse.teafactory.model.SupplierDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * author - kavindi
 * version - 1.0.0 9:40 PM 2/8/2023
 **/
public class StockDAOImpl implements StockDAO {
    @Override
    public boolean save(StockDTO entity) throws SQLException, ClassNotFoundException {
        System.out.println(entity.getStockId()+" "+entity.getStockName()+" "+entity.getSectionCode());
        return CrudUtil.execute("INSERT INTO Customer VALUES (?, ?, ?)",entity.getStockId(),entity.getStockName(),entity.getSectionCode());
    }

    @Override
    public ArrayList<StockDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<StockDTO> allStocks = new ArrayList();
        ResultSet rst = CrudUtil.execute("SELECT * FROM Stock ORDER BY CAST(SUBSTRING(stockId, 2) AS UNSIGNED)");
        while (rst.next()){
            StockDTO stock = new StockDTO(rst.getString(1),rst.getString(2),rst.getString(3));
            allStocks.add(stock);
        }
        return allStocks;
    }

    @Override
    public StockDTO search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Stock WHERE stockId = ?", id +"");
        if (rst.next()){
            return new StockDTO(id +"",rst.getString(2),rst.getString(3));
        }
        return null;
    }

    @Override
    public boolean update(StockDTO entity) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Stock SET stockName=?, sectionCode=? WHERE stockId=?",entity.getStockName(),entity.getSectionCode(),entity.getSectionCode());

    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM Stock  WHERE stockId = ?",id);
    }
}
