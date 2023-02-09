package lk.ijse.teafactory.dao.custom;

import lk.ijse.teafactory.dao.CrudDAO;
import lk.ijse.teafactory.model.ProductDTO;
import lk.ijse.teafactory.tdm.CartDetail;

import java.util.ArrayList;

public interface ProductDAO extends CrudDAO<ProductDTO> {

   // boolean updateQty(ArrayList<CartDetail> orderDetails);
}
