package lk.ijse.teafactory.bo.custom;

import lk.ijse.teafactory.bo.SuperBO;
import lk.ijse.teafactory.model.CustomerDTO;
import lk.ijse.teafactory.model.EmployeeDTO;
import lk.ijse.teafactory.tdm.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeBO extends SuperBO {
    public boolean save(EmployeeDTO dto) throws SQLException, ClassNotFoundException;
    public ArrayList<EmployeeDTO> getAll () throws SQLException , ClassNotFoundException;
    public EmployeeDTO search (String id) throws SQLException , ClassNotFoundException;
    public boolean update(EmployeeDTO dto) throws  SQLException , ClassNotFoundException;
    public boolean delete(String id) throws  SQLException , ClassNotFoundException;
}
