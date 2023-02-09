package lk.ijse.teafactory.dao.custom.impl;

import lk.ijse.teafactory.dao.custom.OrderDetailDAO;
import lk.ijse.teafactory.model.OrderdetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * author - kavindi
 * version - 1.0.0 8:05 PM 2/8/2023
 **/
public class OrderDetailDAOImpl implements OrderDetailDAO {
    @Override
    public boolean save(OrderdetailDTO entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<OrderdetailDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public OrderdetailDTO search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(OrderdetailDTO entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
