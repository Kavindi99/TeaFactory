package lk.ijse.teafactory.dao.custom.impl;


import lk.ijse.teafactory.dao.custom.OrderDAO;
import lk.ijse.teafactory.db.DBConnection;

import java.sql.SQLException;
import java.time.LocalDate;

import lk.ijse.teafactory.model.OrderDTO;
import lk.ijse.teafactory.model.PlaceOrderDTO;
import lk.ijse.teafactory.modelold.OrderDetailModel;
import lk.ijse.teafactory.modelold.OrderModel;
import lk.ijse.teafactory.modelold.ProductModel;
import lk.ijse.teafactory.tdm.Order;
import lk.ijse.teafactory.tdm.PlaceOrder;

/**
 * author - kavindi
 * version - 1.0.0 10:32 PM 2/7/2023
 **/
public class QueryDAOImpl implements QueryDAO{

    public static boolean placeOrder(PlaceOrderDTO placeOrderDTO) throws SQLException, ClassNotFoundException {
       ProductDAO productDAO = new ProductDAOImpl();
       OrerDetailDAO orderDAO = new OrderDetailDAOImpl();
        try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);
            OrderDAO orderDAO = (OrderDAO) new OrderDAOImpl();
            boolean isOrderAdded = orderDAO.save(new OrderDTO(placeOrderDTO.getOrderId(), LocalDate.now(), placeOrderDTO.getCustomerId()));
            if (isOrderAdded) {
                boolean isUpdated = productDAO.updateQty(placeOrderDTO.getOrderDetails());
                if (isUpdated) {
                    boolean isOrderDetailAdded = orderDetailDAO.saveOrderDetails(placeOrderDTO.getOrderDetails());
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
