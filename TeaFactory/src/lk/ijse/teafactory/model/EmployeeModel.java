package lk.ijse.teafactory.model;

import lk.ijse.teafactory.to.Employee;
import lk.ijse.teafactory.dao.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * author - kavindi
 * version - 1.0.0 5:59 PM 11/28/2022
 **/
public class EmployeeModel {
    public static boolean save(Employee employee) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Employee VALUES (?, ?, ?,?)";
        return CrudUtil.execute(sql, employee.getEmployeeId(), employee.getEmployeeName(), employee.getEmployeeAddress() ,  employee.getJobRole());
    }

    public static Employee search(String employeeId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Employee WHERE employeeId = ?";
        ResultSet result = CrudUtil.execute(sql,employeeId);

        if(result.next()){
            return new Employee(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4)
            );
        }
        return null;
    }

    public static boolean update (Employee employee, String employeeId) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Employee SET EmployeeName=?, EmployeeAddress=?, jobRole=? WHERE employeeId=?";
        return CrudUtil.execute(sql, employee.getEmployeeName(), employee.getEmployeeAddress(),employee.getJobRole(),employeeId);
    }

    public static ArrayList loadEmployeeIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT employeeID FROM Employee";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> idList = new ArrayList<>();

        while (result.next()){
            idList.add(result.getString(1));
        }
        return idList;
    }

    public static ArrayList<Employee> getEmployeeData() throws SQLException, ClassNotFoundException {
        ArrayList<Employee> employeesData = new ArrayList<>();

        ResultSet rs = CrudUtil.execute("SELECT * FROM Employee ORDER BY CAST(SUBSTRING(employeeID, 3) AS UNSIGNED)");
        while (rs.next()){
            employeesData.add(new Employee(rs.getString("employeeId"),
                    rs.getString("employeeName"),
                    rs.getString("employeeAddress"),
                    rs.getString("jobRole")));
        }
        return employeesData;
    }

    public static boolean delete (Employee employee, String employeeId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM Employee  WHERE employeeId = ?";
        return CrudUtil.execute(sql,employee.getEmployeeId());
    }

}
