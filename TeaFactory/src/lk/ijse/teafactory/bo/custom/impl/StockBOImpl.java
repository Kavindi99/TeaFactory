package lk.ijse.teafactory.bo.custom.impl;

import lk.ijse.teafactory.bo.custom.StockBO;
import lk.ijse.teafactory.dao.DAOFactory;
import lk.ijse.teafactory.dao.custom.CustomerDAO;
import lk.ijse.teafactory.dao.custom.StockDAO;
import lk.ijse.teafactory.model.CustomerDTO;
import lk.ijse.teafactory.model.StockDTO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * author - kavindi
 * version - 1.0.0 11:02 PM 2/8/2023
 **/
public class StockBOImpl implements StockBO {
    StockDAO stockDAO = (StockDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STOCK);

    @Override
    public boolean save(StockDTO dto) throws SQLException, ClassNotFoundException {
        return stockDAO.save(new StockDTO(dto.getStockId(),dto.getStockName(),dto.getSectionCode()));
    }

    @Override
    public ArrayList<StockDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<StockDTO> allStocks = new ArrayList();
        ArrayList<StockDTO> all= stockDAO.getAll();

        for(StockDTO s : all){
            allStocks.add(new StockDTO(s.getStockId(),s.getStockName(),s.getSectionCode()));
        }

        return allStocks;
    }

    @Override
    public StockDTO search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(StockDTO dto) throws SQLException, ClassNotFoundException {
        return stockDAO.update(new StockDTO(dto.getStockId(),dto.getStockName(),dto.getSectionCode()));
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return stockDAO.delete(id);
    }
}
