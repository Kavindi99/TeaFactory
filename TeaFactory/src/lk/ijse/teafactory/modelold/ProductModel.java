package lk.ijse.teafactory.modelold;

import lk.ijse.teafactory.tdm.CartDetail;
import lk.ijse.teafactory.tdm.Product;
import lk.ijse.teafactory.dao.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * author - kavindi
 * version - 1.0.0 4:08 PM 11/27/2022
 **/
public class ProductModel {
    public static boolean save(Product product) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Product VALUES (?, ?, ?,?)";
        return CrudUtil.execute(sql, product.getProductCode(), product.getDescription(), product.getUnitPrice(),product.getQtyOnHand());
    }

    public static Product search(String productCode) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Product WHERE productCode = ?";
        ResultSet result = CrudUtil.execute(sql,productCode);

        if(result.next()){
            return new Product(
                    result.getString(1),
                    result.getString(2),
                    result.getDouble(3),
                    result.getInt(4)
            );
        }
        return null;
    }

    public static boolean update(Product product, String productCode) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Product SET description=?, unitPrice=? , qtyOnHand=? WHERE productCode=?";
        return CrudUtil.execute(sql, product.getDescription(), product.getUnitPrice(),product.getQtyOnHand() , productCode);
    }

    public static boolean updateQty(ArrayList<CartDetail> cartDetails) throws SQLException, ClassNotFoundException {
        for (CartDetail cartDetail : cartDetails) {
            if (!updateQty(new Product(cartDetail.getProductCode(), cartDetail.getDescription(), cartDetail.getUnitPrice(), cartDetail.getQty()))) {
                return false;
            }
        }
        return true;
    }

    private static boolean updateQty(Product product) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Product SET qtyOnHand = qtyOnHand - ? WHERE productCode = ?";
        return CrudUtil.execute(sql, product.getQtyOnHand(), product.getProductCode());
    }



    public static ArrayList loadProductCodes() throws SQLException, ClassNotFoundException {
        String sql = "SELECT productCode FROM Product";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> codeList = new ArrayList<>();

        while (result.next()){
            codeList.add(result.getString(1));
        }
        return codeList;
    }

    public static ArrayList<Product> getProductData() throws SQLException, ClassNotFoundException {
        ArrayList<Product> productsData = new ArrayList<>();

        ResultSet rs = CrudUtil.execute("SELECT * FROM Product ORDER BY CAST(SUBSTRING(productCode, 3) AS UNSIGNED)");
        while (rs.next()){
            productsData.add(new Product(rs.getString("productCode"),
                    rs.getString("description"),
                    rs.getDouble("unitPrice"),
                    rs.getInt("qtyOnHand")));

        }
        return productsData;
    }

    public static boolean delete (Product product, String productCode) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM Product  WHERE productCode = ?";
        return CrudUtil.execute(sql,product.getProductCode());
    }

}
