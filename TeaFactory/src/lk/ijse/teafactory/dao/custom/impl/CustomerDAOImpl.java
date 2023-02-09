package lk.ijse.teafactory.dao.custom.impl;

import lk.ijse.teafactory.dao.CrudUtil;
import lk.ijse.teafactory.dao.custom.CustomerDAO;
import lk.ijse.teafactory.model.CustomerDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * author - kavindi
 * version - 1.0.0 10:43 AM 1/29/2023
 **/
public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public boolean save(CustomerDTO entity) throws SQLException, ClassNotFoundException {
        System.out.println(entity.getCustomerId()+" "+entity.getCustomerName()+" "+entity.getContact());
        return CrudUtil.execute("INSERT INTO Customer VALUES (?, ?, ?)",entity.getCustomerId(),entity.getCustomerName(),entity.getContact());
    }

    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<CustomerDTO> allCustomers = new ArrayList();
        ResultSet rst = CrudUtil.execute("SELECT * FROM Customer ORDER BY CAST(SUBSTRING(customerID, 2) AS UNSIGNED)");
        while (rst.next()){
            CustomerDTO customer = new CustomerDTO(rst.getString(1),rst.getString(2),rst.getString(3));
            allCustomers.add(customer);
        }
        return allCustomers;
    }

    @Override
    public CustomerDTO search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Customer WHERE customerId = ?", id +"");
        if (rst.next()){
            return new CustomerDTO(id +"",rst.getString(2),rst.getString(3));
        }
       return null;

    }

    @Override
    public boolean update(CustomerDTO entity) throws SQLException, ClassNotFoundException {

        return CrudUtil.execute("UPDATE Customer SET customerName=?, contact=? WHERE customerId=?",entity.getCustomerName(),entity.getContact(),entity.getCustomerId());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {

        return CrudUtil.execute("DELETE FROM Customer  WHERE customerId = ?",id);
    }

}
