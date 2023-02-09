package lk.ijse.teafactory.bo.custom;

import lk.ijse.teafactory.bo.SuperBO;
import lk.ijse.teafactory.model.CustomerDTO;
import lk.ijse.teafactory.model.StockDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StockBO extends SuperBO {
    public boolean save(StockDTO dto) throws SQLException, ClassNotFoundException;
    public ArrayList<StockDTO> getAll () throws SQLException , ClassNotFoundException;
    public StockDTO search (String id) throws SQLException , ClassNotFoundException;
    public boolean update(StockDTO dto) throws  SQLException , ClassNotFoundException;
    public boolean delete(String id) throws  SQLException , ClassNotFoundException;
}
