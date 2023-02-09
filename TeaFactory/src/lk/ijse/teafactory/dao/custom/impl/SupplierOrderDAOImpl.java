package lk.ijse.teafactory.dao.custom.impl;

import lk.ijse.teafactory.dao.custom.SupplierOrderDAO;
import lk.ijse.teafactory.model.SupplierOrderDTO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * author - kavindi
 * version - 1.0.0 10:00 PM 2/8/2023
 **/
public class SupplierOrderDAOImpl implements SupplierOrderDAO {
    @Override
    public boolean save(SupplierOrderDTO entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<SupplierOrderDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public SupplierOrderDTO search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(SupplierOrderDTO entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
