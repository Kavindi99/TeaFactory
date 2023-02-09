package lk.ijse.teafactory.modelold;

import lk.ijse.teafactory.tdm.Order;
import lk.ijse.teafactory.dao.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * author - kavindi
 * version - 1.0.0 11:41 PM 11/29/2022
 **/
public class OrderModel {
    public static boolean save(Order order) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Orders VALUES(?, ?, ?)";
        return CrudUtil.execute(sql, order.getOrderId(), order.getDate(), order.getCustomerId());
    }

    public static String generateNextOrderId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT orderId FROM Orders ORDER BY orderId DESC LIMIT 1";
        ResultSet result = CrudUtil.execute(sql);

      //  return CrudUtil.execute(sql);

       if (result.next()) {
           return generateNextOrderId(result.getString(1));
        }
       return generateNextOrderId(null);
    }

    private static String generateNextOrderId(String currentOrderId) {
        if (currentOrderId != null) {
            String[] split = currentOrderId.split("O00");
            int orderId = Integer.parseInt(split[1]);
            orderId += 1;
            return "O00" + orderId;
        }
        return "O001";
    }

}
