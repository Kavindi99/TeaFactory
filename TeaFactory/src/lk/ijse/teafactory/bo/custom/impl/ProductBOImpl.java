package lk.ijse.teafactory.bo.custom.impl;

import lk.ijse.teafactory.bo.custom.ProductBO;
import lk.ijse.teafactory.dao.DAOFactory;
import lk.ijse.teafactory.dao.custom.ProductDAO;
import lk.ijse.teafactory.model.CustomerDTO;
import lk.ijse.teafactory.model.ProductDTO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * author - kavindi
 * version - 1.0.0 10:13 PM 2/8/2023
 **/
public class ProductBOImpl implements ProductBO {

    ProductDAO productDAO = (ProductDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PRODUCT);


    @Override
    public boolean save(ProductDTO dto) throws SQLException, ClassNotFoundException {
        return productDAO.save(new ProductDTO(dto.getProductCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand()));
    }

    @Override
    public ArrayList<ProductDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<ProductDTO> allProducts = new ArrayList();
        ArrayList<ProductDTO> all= productDAO.getAll();

        for(ProductDTO p : all){
            allProducts.add(new ProductDTO(p.getProductCode(),p.getDescription(),p.getUnitPrice(),p.getQtyOnHand()));
        }

        return allProducts;
    }

    @Override
    public ProductDTO search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(ProductDTO dto) throws SQLException, ClassNotFoundException {
        return productDAO.update(new ProductDTO(dto.getProductCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand()));
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return productDAO.delete(id);
    }
}
