package lk.ijse.teafactory.bo.custom.impl;

import lk.ijse.teafactory.bo.custom.EmployeeBO;
import lk.ijse.teafactory.dao.DAOFactory;
import lk.ijse.teafactory.dao.custom.EmployeeDAO;
import lk.ijse.teafactory.model.CustomerDTO;
import lk.ijse.teafactory.model.EmployeeDTO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * author - kavindi
 * version - 1.0.0 10:10 PM 2/8/2023
 **/
public class EmployeeBOImpl implements EmployeeBO {
    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);

    @Override
    public boolean save(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return employeeDAO.save(new EmployeeDTO(dto.getEmployeeId(),dto.getEmployeeName(),dto.getEmployeeAddress(),dto.getJobRole()));
    }

    @Override
    public ArrayList<EmployeeDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<EmployeeDTO> allEmployees = new ArrayList();
        ArrayList<EmployeeDTO> all= employeeDAO.getAll();

        for(EmployeeDTO e : all){
            allEmployees.add(new EmployeeDTO(e.getEmployeeId(),e.getEmployeeName(),e.getEmployeeAddress(),e.getJobRole()));
        }

        return allEmployees;
    }

    @Override
    public EmployeeDTO search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return employeeDAO.update(new EmployeeDTO(dto.getEmployeeId(),dto.getEmployeeName(),dto.getEmployeeAddress(),dto.getJobRole()));
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.delete(id);
    }
}
