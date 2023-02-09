package lk.ijse.teafactory.dao.custom.impl;

import lk.ijse.teafactory.dao.custom.OwnerStockDAO;
import lk.ijse.teafactory.model.StockDTO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * author - kavindi
 * version - 1.0.0 7:58 PM 1/31/2023
 **/
public class OwnerStockDAOImpl implements OwnerStockDAO {


    @Override
    public boolean save(StockDTO entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<StockDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public StockDTO search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(StockDTO entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
