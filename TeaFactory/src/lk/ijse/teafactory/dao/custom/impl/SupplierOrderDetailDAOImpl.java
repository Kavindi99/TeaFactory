package lk.ijse.teafactory.dao.custom.impl;

import lk.ijse.teafactory.dao.custom.SupplierOrderDetailDAO;
import lk.ijse.teafactory.model.SupplierOrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * author - kavindi
 * version - 1.0.0 10:02 PM 2/8/2023
 **/
public class SupplierOrderDetailDAOImpl implements SupplierOrderDetailDAO {
    @Override
    public boolean save(SupplierOrderDetailDTO entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<SupplierOrderDetailDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public SupplierOrderDetailDTO search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(SupplierOrderDetailDTO entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
