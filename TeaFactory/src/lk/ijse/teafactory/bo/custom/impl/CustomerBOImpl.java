package lk.ijse.teafactory.bo.custom.impl;

import lk.ijse.teafactory.bo.custom.CustomerBO;
import lk.ijse.teafactory.dao.DAOFactory;
import lk.ijse.teafactory.dao.custom.CustomerDAO;
import lk.ijse.teafactory.entity.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * author - kavindi
 * version - 1.0.0 11:37 AM 1/29/2023
 **/
public class CustomerBOImpl implements CustomerBO {
     CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);


     @Override
     public boolean save(CustomerDTO dto) throws SQLException, ClassNotFoundException {
          return customerDAO.save(new CustomerDTO(dto.getCustomerId(),dto.getCustomerName(),dto.getContact()));
     }

     @Override
     public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
          ArrayList<CustomerDTO> allCustomers = new ArrayList();
          ArrayList<CustomerDTO> all= customerDAO.getAll();

          for(CustomerDTO c : all){
                    allCustomers.add(new CustomerDTO(c.getCustomerId(),c.getCustomerName(),c.getContact()));
          }

          return allCustomers;
     }

     @Override
     public CustomerDTO search(String id) throws SQLException, ClassNotFoundException {
          return null;
     }

     @Override
     public boolean update(CustomerDTO dto) throws SQLException, ClassNotFoundException {
          return customerDAO.update(new CustomerDTO(dto.getCustomerId(),dto.getCustomerName(),dto.getContact()));
     }

     @Override
     public boolean delete(String id) throws SQLException, ClassNotFoundException {
          return customerDAO.delete(id);
     }
}
