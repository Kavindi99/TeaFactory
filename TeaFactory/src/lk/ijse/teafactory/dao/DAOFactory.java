package lk.ijse.teafactory.dao;

import lk.ijse.teafactory.dao.custom.impl.CustomerDAOImpl;

/**
 * author - kavindi
 * version - 1.0.0 11:38 AM 1/29/2023
 **/
public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        CUSTOMER,ITEM,ORDER,ORDER_DETAILS,QUERY_DAO
    }

    public SuperDAO getDAO(DAOTypes types){
        switch (types) {
            case CUSTOMER:
                return new CustomerDAOImpl();
          /*  case ITEM:
                return new ItemDAOImpl();
            case ORDER:
                return new OrderDAOImpl();
            case ORDER_DETAILS:
                return new OrderDetailsDAOImpl();
            case QUERY_DAO:
                return new QueryDAOImpl();*/
            default:
                return null;
        }
    }
}
