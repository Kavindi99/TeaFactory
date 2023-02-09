package lk.ijse.teafactory.bo.custom;

import lk.ijse.teafactory.bo.SuperBO;
import lk.ijse.teafactory.model.CustomerDTO;
import lk.ijse.teafactory.model.ProductDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductBO extends SuperBO {
    public boolean save(ProductDTO dto) throws SQLException, ClassNotFoundException;
    public ArrayList<ProductDTO> getAll () throws SQLException , ClassNotFoundException;
    public ProductDTO search (String id) throws SQLException , ClassNotFoundException;
    public boolean update(ProductDTO dto) throws  SQLException , ClassNotFoundException;
    public boolean delete(String id) throws  SQLException , ClassNotFoundException;
}
