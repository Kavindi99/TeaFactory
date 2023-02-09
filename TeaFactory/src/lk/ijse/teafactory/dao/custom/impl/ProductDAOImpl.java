package lk.ijse.teafactory.dao.custom.impl;

import lk.ijse.teafactory.dao.CrudUtil;
import lk.ijse.teafactory.dao.custom.ProductDAO;
import lk.ijse.teafactory.model.CustomerDTO;
import lk.ijse.teafactory.model.ProductDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * author - kavindi
 * version - 1.0.0 11:46 PM 2/7/2023
 **/
public class ProductDAOImpl implements ProductDAO {
    @Override
    public boolean save(ProductDTO entity) throws SQLException, ClassNotFoundException {
        System.out.println(entity.getProductCode()+" "+entity.getDescription()+" "+entity.getUnitPrice()+""+entity.getQtyOnHand());
        return CrudUtil.execute("INSERT INTO Product VALUES (?, ?, ?,?)",entity.getProductCode(),entity.getDescription(),entity.getUnitPrice(),entity.getQtyOnHand());
    }

    @Override
    public ArrayList<ProductDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<ProductDTO> allProducts = new ArrayList();
        ResultSet rst = CrudUtil.execute("SELECT * FROM Product ORDER BY CAST(SUBSTRING(productCode, 2) AS UNSIGNED)");
        while (rst.next()){
            ProductDTO product = new ProductDTO(rst.getString(1),rst.getString(2),rst.getDouble(3),rst.getInt(4));
            allProducts.add(product);
        }
        return allProducts;
    }

    @Override
    public ProductDTO search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Product WHERE productCode = ?", id +"");
        if (rst.next()){
            return new ProductDTO(id +"",rst.getString(2),rst.getDouble(3),rst.getInt(4));
        }
        return null;
    }

    @Override
    public boolean update(ProductDTO entity) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Product SET description=?, unitPrice=?, qtyOnHand = ?  WHERE productCode=?",entity.getDescription(),entity.getUnitPrice(),entity.getQtyOnHand(),entity.getProductCode());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM Product  WHERE productCode = ?",id);
    }
}
