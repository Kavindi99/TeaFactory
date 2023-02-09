package lk.ijse.teafactory.dao.custom.impl;

import lk.ijse.teafactory.dao.CrudUtil;
import lk.ijse.teafactory.dao.custom.SupplierDAO;
import lk.ijse.teafactory.model.CustomerDTO;
import lk.ijse.teafactory.model.SupplierDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * author - kavindi
 * version - 1.0.0 9:27 PM 2/7/2023
 **/
public class SupplierDAOImpl implements SupplierDAO {

    @Override
    public boolean save(SupplierDTO entity) throws SQLException, ClassNotFoundException {
        System.out.println(entity.getSupplierId()+" "+entity.getSupplierName()+" "+entity.getDescription()+""+entity.getQauntity());
        return CrudUtil.execute("INSERT INTO Supplier VALUES (?, ?, ?,?)",entity.getSupplierId(),entity.getSupplierName(),entity.getDescription(),entity.getQauntity());

    }

    @Override
    public ArrayList<SupplierDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<SupplierDTO> allSuppliers = new ArrayList();
        ResultSet rst = CrudUtil.execute("SELECT * FROM Supplier ORDER BY CAST(SUBSTRING(supplierID, 2) AS UNSIGNED)");
        while (rst.next()){
            SupplierDTO supplier = new SupplierDTO(rst.getString(1),rst.getString(2),rst.getString(3),rst.getInt(4));
            allSuppliers.add(supplier);
        }
        return allSuppliers;
    }

    @Override
    public SupplierDTO search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Supplier WHERE supplierId = ?", id +"");
        if (rst.next()){
            return new SupplierDTO(id +"",rst.getString(2),rst.getString(3),rst.getInt(4));
        }
        return null;
    }

    @Override
    public boolean update(SupplierDTO entity) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Supplier SET supplierName=?, description=?, qty=? WHERE customerId=?",entity.getSupplierName(),entity.getDescription(),entity.getQauntity(),entity.getSupplierId());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM Supplier  WHERE supplierId = ?",id);
    }
}
