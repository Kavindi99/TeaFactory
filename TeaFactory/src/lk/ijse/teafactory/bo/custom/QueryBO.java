package lk.ijse.teafactory.bo.custom;

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
import lk.ijse.teafactory.modelold.OrderDetailModel;
import lk.ijse.teafactory.modelold.OrderModel;
import lk.ijse.teafactory.modelold.ProductModel;
import lk.ijse.teafactory.tdm.CartDetail;
import lk.ijse.teafactory.tdm.Order;
import lk.ijse.teafactory.tdm.PlaceOrder;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public interface QueryBO  {
    public  boolean placeOrder(PlaceOrderDTO placeOrderDTO) throws SQLException, ClassNotFoundException;

    public  boolean updateQty(ArrayList<CartDetail> cartDetails) throws SQLException, ClassNotFoundException;

    public  boolean saveOrderDetails(ArrayList<CartDetail> cartDetails) throws SQLException, ClassNotFoundException;

}
