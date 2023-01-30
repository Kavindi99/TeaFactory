package lk.ijse.teafactory.dao.custom.impl;

import lk.ijse.teafactory.dao.CrudUtil;
import lk.ijse.teafactory.dao.custom.EmployeeDAO;
import lk.ijse.teafactory.entity.CustomerDTO;
import lk.ijse.teafactory.entity.EmployeeDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * author - kavindi
 * version - 1.0.0 3:12 PM 1/29/2023
 **/
public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public boolean save(EmployeeDTO entity) throws SQLException, ClassNotFoundException {
        System.out.println(entity.getEmployeeId()+" "+entity.getEmployeeName()+" "+entity.getEmployeeAddress()+""+entity.getJobRole());
        return CrudUtil.execute("INSERT INTO Employee VALUES (?, ?, ?)",entity.getEmployeeId(),entity.getEmployeeName(),entity.getEmployeeAddress(),entity.getJobRole());

    }

    @Override
    public ArrayList<EmployeeDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<EmployeeDTO> allEmployees = new ArrayList();
        ResultSet rst = CrudUtil.execute("SELECT * FROM Employee ORDER BY CAST(SUBSTRING(customerID, 2) AS UNSIGNED)");
        while (rst.next()){
            EmployeeDTO employee = new EmployeeDTO(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4));
            allEmployees.add(employee);
        }
        return allEmployees;

    }

    @Override
    public EmployeeDTO search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Employee WHERE employeeId = ?", id +"");
        if (rst.next()){
            return new EmployeeDTO(id +"",rst.getString(2),rst.getString(3),rst.getString(4));
        }
        return null;

    }

    @Override
    public boolean update(EmployeeDTO entity) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Employee SET employeeName=?,employeeAddress=? , jobRole =? WHERE employeeId=?",entity.getEmployeeName(),entity.getEmployeeAddress(),entity.getJobRole(),entity.getEmployeeId());

    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {

        return CrudUtil.execute("DELETE FROM Employee  WHERE employeeId = ?",id);
    }
}
