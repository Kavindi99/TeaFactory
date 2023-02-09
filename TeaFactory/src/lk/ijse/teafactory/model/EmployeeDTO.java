package lk.ijse.teafactory.model;

/**
 * author - kavindi
 * version - 1.0.0 9:51 AM 1/29/2023
 **/
public class EmployeeDTO {
    private String employeeId;
    private String employeeName;
    private String employeeAddress;
    private String jobRole;

    public EmployeeDTO() {
    }

    public EmployeeDTO(String employeeId, String employeeName, String employeeAddress, String jobRole) {
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
