package lk.ijse.teafactory.bo.custom;

import lk.ijse.teafactory.bo.SuperBO;
import lk.ijse.teafactory.model.CustomerDTO;
import lk.ijse.teafactory.model.SupplierDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SupplierBO extends SuperBO {
    public boolean save(SupplierDTO dto) throws SQLException, ClassNotFoundException;
    public ArrayList<SupplierDTO> getAll () throws SQLException , ClassNotFoundException;
    public SupplierDTO search (String id) throws SQLException , ClassNotFoundException;
    public boolean update(SupplierDTO dto) throws  SQLException , ClassNotFoundException;
    public boolean delete(String id) throws  SQLException , ClassNotFoundException;
}
