package lk.ijse.teafactory.bo.custom;

import lk.ijse.teafactory.bo.SuperBO;
import lk.ijse.teafactory.model.EmployeeDTO;
import lk.ijse.teafactory.model.OrderDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderBO extends SuperBO {
    public boolean save(OrderDTO dto) throws SQLException, ClassNotFoundException;
    public ArrayList<OrderDTO> getAll () throws SQLException , ClassNotFoundException;
    public OrderDTO search (String id) throws SQLException , ClassNotFoundException;
    public boolean update(OrderDTO dto) throws  SQLException , ClassNotFoundException;
    public boolean delete(String id) throws  SQLException , ClassNotFoundException;
}
