package lk.ijse.teafactory.bo.custom;

import lk.ijse.teafactory.bo.SuperBO;
import lk.ijse.teafactory.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
    public boolean save(CustomerDTO dto) throws SQLException, ClassNotFoundException;
    public ArrayList<CustomerDTO> getAll () throws SQLException , ClassNotFoundException;
    public CustomerDTO search (String id) throws SQLException , ClassNotFoundException;
    public boolean update(CustomerDTO dto) throws  SQLException , ClassNotFoundException;
    public boolean delete(String id) throws  SQLException , ClassNotFoundException;
}
