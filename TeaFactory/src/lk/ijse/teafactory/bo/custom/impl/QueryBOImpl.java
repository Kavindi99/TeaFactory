package lk.ijse.teafactory.bo.custom.impl;

import lk.ijse.teafactory.bo.custom.QueryBO;
import lk.ijse.teafactory.dao.custom.OrderDAO;
import lk.ijse.teafactory.dao.custom.OrderDetailDAO;
import lk.ijse.teafactory.dao.custom.ProductDAO;
import lk.ijse.teafactory.dao.custom.QueryDAO;
import lk.ijse.teafactory.dao.custom.impl.OrderDAOImpl;
import lk.ijse.teafactory.dao.custom.impl.OrderDetailDAOImpl;
import lk.ijse.teafactory.dao.custom.impl.ProductDAOImpl;
import lk.ijse.teafactory.dao.custom.impl.QueryDAOImpl;
import lk.ijse.teafactory.db.DBConnection;
import lk.ijse.teafactory.model.OrderDTO;
import lk.ijse.teafactory.model.OrderdetailDTO;
import lk.ijse.teafactory.model.PlaceOrderDTO;
import lk.ijse.teafactory.model.ProductDTO;
import lk.ijse.teafactory.tdm.CartDetail;
import lk.ijse.teafactory.tdm.PlaceOrder;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * author - kavindi
 * version - 1.0.0 11:25 PM 2/8/2023
 **/
public class QueryBOImpl implements QueryBO {

    QueryDAO queryDAO = new QueryDAOImpl();

   /* public boolean placeOrder(PlaceOrderDTO placeOrderDTO) throws SQLException, ClassNotFoundException {

        return queryDAO.;

    }*/

    public  boolean placeOrder(PlaceOrderDTO placeOrderDTO) throws SQLException, ClassNotFoundException {
        ProductDAO productDAO = new ProductDAOImpl();
        OrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();
        try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);
            OrderDAO orderDAO = new OrderDAOImpl();

            boolean isOrderAdded = orderDAO.save(new OrderDTO(placeOrderDTO.getOrderId(), LocalDate.now(), placeOrderDTO.getCustomerId()));
            if (isOrderAdded) {
                boolean isUpdated = updateQty(placeOrderDTO.getOrderDetails());
                if (isUpdated) {
                    boolean isOrderDetailAdded = saveOrderDetails(placeOrderDTO.getOrderDetails());
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

    public  boolean updateQty(ArrayList<CartDetail> cartDetails) throws SQLException, ClassNotFoundException {
        ProductDAO productDAO = new ProductDAOImpl();

        for (CartDetail cartDetail : cartDetails) {
            if (productDAO.update(new ProductDTO(cartDetail.getProductCode(),cartDetail.getDescription(),cartDetail.getUnitPrice(),cartDetail.getQty()))) {
                return false;
            }
        }
        return true;
    }

    public  boolean saveOrderDetails(ArrayList<CartDetail> cartDetails) throws SQLException, ClassNotFoundException {
        OrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();

        for (CartDetail cartDetail : cartDetails) {
            if (!orderDetailDAO.save(new OrderdetailDTO(cartDetail.getOrderId(),cartDetail.getProductCode(),cartDetail.getQty(),cartDetail.getUnitPrice()))) {
                return false;
            }
        }
        return true;
    }

}
