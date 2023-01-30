package lk.ijse.teafactory.model;

import lk.ijse.teafactory.db.DBConnection;
import lk.ijse.teafactory.to.Order;
import lk.ijse.teafactory.to.PlaceOrder;

import java.sql.SQLException;
import java.time.LocalDate;

/**
 * author - kavindi
 * version - 1.0.0 11:42 PM 11/29/2022
 **/
public class PlaceOrderModel {
    public static boolean placeOrder(PlaceOrder placeOrder) throws SQLException, ClassNotFoundException {
        try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);
            boolean isOrderAdded = OrderModel.save(new Order(placeOrder.getOrderId(), LocalDate.now(), placeOrder.getCustomerId()));
            if (isOrderAdded) {
                boolean isUpdated = ProductModel.updateQty(placeOrder.getOrderDetails());
                if (isUpdated) {
                    boolean isOrderDetailAdded = OrderDetailModel.saveOrderDetails(placeOrder.getOrderDetails());
                    if (isOrderDetailAdded) {
                        DBConnection.getInstance().getConnection().commit();
                        return true;
                    }
                }
            }
            DBConnection.getInstance().getConnection().rollback();
            return false;
        } finally {
            DBConnection.getInstance().getConnection().setAutoCommit(true);
        }
    }

}
