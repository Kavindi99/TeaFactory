package lk.ijse.teafactory.modelold;

import lk.ijse.teafactory.tdm.Supplier;
import lk.ijse.teafactory.dao.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * author - kavindi
 * version - 1.0.0 8:12 PM 11/27/2022
 **/
public class SupplierModel {
    public static boolean save(Supplier supplier) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Supplier VALUES (?, ?, ?, ?)";
        return CrudUtil.execute(sql, supplier.getSupplierId(), supplier.getSupplierName(), supplier.getDescription(), supplier.getQty());
    }

    public static Supplier search(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Supplier WHERE supplierId = ?";
        ResultSet result = CrudUtil.execute(sql,id);

        if(result.next()){
            return new Supplier(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getInt(4)
            );
        }
        return null;
    }

    public static boolean update (Supplier supplier, String supplierId) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Supplier SET supplierName=?,description=?, Qauntity=? WHERE supplierId=?";
        return CrudUtil.execute(sql, supplier.getSupplierName(), supplier.getDescription(),supplier.getQty(),supplierId);
    }

    public static ArrayList loadSupplierIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT supplierID FROM Supplier";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> idList = new ArrayList<>();

        while (result.next()){
            idList.add(result.getString(1));
        }
        return idList;
    }

    public static ArrayList<Supplier> getSupplierData() throws SQLException, ClassNotFoundException {
        ArrayList<Supplier> suppliersData = new ArrayList<>();

        ResultSet rs = CrudUtil.execute("SELECT * FROM Supplier ORDER BY CAST(SUBSTRING(supplierID, 3) AS UNSIGNED)");
        while (rs.next()){
            suppliersData.add(new Supplier(rs.getString("supplierId"),
                    rs.getString("supplierName"),
                    rs.getString("description"),
                    rs.getInt("qauntity")));
        }
        return suppliersData;
    }

    public static boolean delete (Supplier supplier, String supplierId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM Supplier  WHERE supplierId = ?";
        return CrudUtil.execute(sql,supplier.getSupplierId());
    }

}
