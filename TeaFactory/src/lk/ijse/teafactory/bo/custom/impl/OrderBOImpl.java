package lk.ijse.teafactory.bo.custom.impl;

import lk.ijse.teafactory.bo.custom.OrderBO;
import lk.ijse.teafactory.dao.DAOFactory;
import lk.ijse.teafactory.dao.custom.CustomerDAO;
import lk.ijse.teafactory.dao.custom.OrderDAO;
import lk.ijse.teafactory.model.CustomerDTO;
import lk.ijse.teafactory.model.OrderDTO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * author - kavindi
 * version - 1.0.0 10:57 PM 2/8/2023
 **/
public class OrderBOImpl implements OrderBO {
    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);

    @Override
    public boolean save(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return orderDAO.save(new OrderDTO(dto.getOrderId(),dto.getOrderDate(),dto.getCustomerId()));
    }

    @Override
    public ArrayList<OrderDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<OrderDTO> allOrders = new ArrayList();
        ArrayList<OrderDTO> all= orderDAO.getAll();

        for(OrderDTO o : all){
            allOrders.add(new OrderDTO(o.getOrderId(),o.getOrderDate(),o.getCustomerId()));
        }

        return allOrders;
    }

    @Override
    public OrderDTO search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return orderDAO.update(new OrderDTO(dto.getOrderId(),dto.getOrderDate(),dto.getCustomerId()));
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return orderDAO.delete(id);
    }
}
