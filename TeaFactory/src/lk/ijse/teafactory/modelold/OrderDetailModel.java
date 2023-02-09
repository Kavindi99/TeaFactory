package lk.ijse.teafactory.modelold;

import lk.ijse.teafactory.tdm.CartDetail;
import lk.ijse.teafactory.dao.CrudUtil;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * author - kavindi
 * version - 1.0.0 11:42 PM 11/29/2022
 **/
public class OrderDetailModel {
    public static boolean saveOrderDetails(ArrayList<CartDetail> cartDetails) throws SQLException, ClassNotFoundException {
        for (CartDetail cartDetail : cartDetails) {
            if (!save(cartDetail)) {
                return false;
            }
        }
        return true;
    }

    private static boolean save(CartDetail cartDetail) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO OrderDetail VALUES(?, ?, ?, ?)";
        return CrudUtil.execute(sql, cartDetail.getOrderId(), cartDetail.getProductCode(), cartDetail.getQty(), cartDetail.getUnitPrice());
    }
}
