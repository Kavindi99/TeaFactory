package lk.ijse.teafactory.modelold;

import lk.ijse.teafactory.tdm.Customer;
import lk.ijse.teafactory.dao.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * author - kavindi
 * version - 1.0.0 11:05 AM 11/25/2022
 **/
public class CustomerModel {
    public static boolean save(Customer customer) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Customer VALUES (?, ?, ?)";
        return CrudUtil.execute(sql, customer.getCustomerId(), customer.getCustomerName(), customer.getContact());
    }

    public static Customer search(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Customer WHERE customerId = ?";
        ResultSet result = CrudUtil.execute(sql,id);

        if(result.next()){
            return new Customer(
                    result.getString(1),
                    result.getString(2),
                    result.getInt(3)
            );
        }
        return null;
    }

    public static boolean update (Customer customer, String customerId) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Customer SET customerName=?, contact=? WHERE customerId=?";
        return CrudUtil.execute(sql, customer.getCustomerName(), customer.getContact(),customerId);
    }

    public static ArrayList loadCustomerIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT customerID FROM Customer";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> idList = new ArrayList<>();

        while (result.next()){
            idList.add(result.getString(1));
        }
        return idList;
    }

    public static ArrayList<Customer> getCustomerData() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> customersData = new ArrayList<>();

        ResultSet rs = CrudUtil.execute("SELECT * FROM Customer ORDER BY CAST(SUBSTRING(customerID, 2) AS UNSIGNED)");
        while (rs.next()){
            customersData.add(new Customer(rs.getString("customerId"),
                    rs.getString("customerName"),
                    rs.getInt("contact")));
        }
        return customersData;
    }

    public static boolean delete (Customer customer, String customerId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM Customer  WHERE customerId = ?";
        return CrudUtil.execute(sql,customer.getCustomerId());
    }

}

