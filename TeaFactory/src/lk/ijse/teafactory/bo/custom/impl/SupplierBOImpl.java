package lk.ijse.teafactory.bo.custom.impl;

import lk.ijse.teafactory.bo.custom.SupplierBO;
import lk.ijse.teafactory.dao.DAOFactory;
import lk.ijse.teafactory.dao.custom.CustomerDAO;
import lk.ijse.teafactory.dao.custom.SupplierDAO;
import lk.ijse.teafactory.model.CustomerDTO;
import lk.ijse.teafactory.model.SupplierDTO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * author - kavindi
 * version - 1.0.0 10:58 PM 2/8/2023
 **/
public class SupplierBOImpl implements SupplierBO {
   SupplierDAO supplierDAO= (SupplierDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SUPPLIER);

    @Override
    public boolean save(SupplierDTO dto) throws SQLException, ClassNotFoundException {
        return supplierDAO.save(new SupplierDTO(dto.getSupplierId(),dto.getSupplierName(),dto.getDescription(),dto.getQauntity()));
    }

    @Override
    public ArrayList<SupplierDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<SupplierDTO> allSuppliers = new ArrayList();
        ArrayList<SupplierDTO> all= supplierDAO.getAll();

        for(SupplierDTO s : all){
            allSuppliers.add(new SupplierDTO(s.getSupplierId(),s.getSupplierName(),s.getDescription(),s.getQauntity()));
        }

        return allSuppliers;
    }

    @Override
    public SupplierDTO search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(SupplierDTO dto) throws SQLException, ClassNotFoundException {
        return supplierDAO.update(new SupplierDTO(dto.getSupplierId(),dto.getSupplierName(),dto.getDescription(),dto.getQauntity()));
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return supplierDAO.delete(id);
    }
}
