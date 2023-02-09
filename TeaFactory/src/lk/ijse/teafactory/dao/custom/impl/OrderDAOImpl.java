package lk.ijse.teafactory.dao.custom.impl;

import lk.ijse.teafactory.dao.CrudUtil;
import lk.ijse.teafactory.model.OrderDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * author - kavindi
 * version - 1.0.0 11:41 AM 1/29/2023
 **/
public class OrderDAOImpl{

    public boolean save(OrderDTO entity) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Order VALUES (?, ?, ?)",entity.getOrderId(),entity.getOrderDate(),entity.getCustomerId());
    }


    public ArrayList<OrderDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    public OrderDTO search(String id) throws SQLException, ClassNotFoundException {
       return null;
    }


    public boolean update(OrderDTO entity) throws SQLException, ClassNotFoundException {
       return true;
    }


    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return true;
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
