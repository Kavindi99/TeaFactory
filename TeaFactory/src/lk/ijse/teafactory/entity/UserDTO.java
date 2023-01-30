package lk.ijse.teafactory.entity;

/**
 * author - kavindi
 * version - 1.0.0 10:36 AM 1/29/2023
 **/
public class UserDTO {
    private String jobRole;
    private String userName;
    private String password;
    private String sectionCode;

    public UserDTO() {
    }

    public UserDTO(String jobRole, String userName, String password, String sectionCode) {
        this.jobRole = jobRole;
        this.userName = userName;
        this.password = password;
        this.sectionCode = sectionCode;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(String sectionCode) {
        this.sectionCode = sectionCode;
    }

    @Override
    public String toString() {
        return "User{" +
                "jobRole='" + jobRole + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", sectionCode='" + sectionCode + '\'' +
                '}';
    }

}
