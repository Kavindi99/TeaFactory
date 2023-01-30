package lk.ijse.teafactory.to;

/**
 * author - kavindi
 * version - 1.0.0 5:58 PM 11/28/2022
 **/
public class Employee {
    private String employeeId;
    private String employeeName;
    private String employeeAddress;
    private String jobRole;

    public Employee() {
    }

    public Employee(String employeeId, String employeeName, String employeeAddress, String jobRole) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeAddress = employeeAddress;
        this.jobRole = jobRole;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", employeeAddress='" + employeeAddress + '\'' +
                ", jobRole='" + jobRole + '\'' +
                '}';
    }
}
