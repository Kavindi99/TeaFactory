package lk.ijse.teafactory.dao.custom;

import lk.ijse.teafactory.dao.CrudDAO;
import lk.ijse.teafactory.model.OrderdetailDTO;
import lk.ijse.teafactory.tdm.CartDetail;

import java.util.ArrayList;

public interface OrderDetailDAO extends CrudDAO<OrderdetailDTO> {

    //boolean saveOrderDetails(ArrayList<CartDetail> orderDetails);
}
