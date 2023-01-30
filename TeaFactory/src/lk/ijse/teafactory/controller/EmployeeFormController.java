package lk.ijse.teafactory.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.teafactory.model.CustomerModel;
import lk.ijse.teafactory.model.EmployeeModel;
import lk.ijse.teafactory.to.Customer;
import lk.ijse.teafactory.to.Employee;
import lk.ijse.teafactory.util.Navigation;
import lk.ijse.teafactory.util.Routes;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * author - kavindi
 * version - 1.0.0 2:06 AM 11/22/2022
 **/
public class EmployeeFormController implements Initializable {
    public AnchorPane pane;
    public JFXButton btnEmployees;
    public JFXButton btnStocks;
    public JFXButton btnIncomeReport;
    public JFXTextField txtEmployeeId;
    public JFXTextField txtEmployeeName;
    public JFXTextField txtEmployeeAddress;
    public JFXTextField txtJobRole;
    public JFXButton btnAddEmployee;
    public JFXTextField txtSearch;
    public JFXButton btnSearchEmployee;
    public TableView tblEmployee;
    public TableColumn colEmployeeId;
    public TableColumn colEmployeeName;
    public TableColumn colEmployeeAddress;
    public TableColumn colJobRole;
    public JFXButton btnUpdateEmployee;
    public JFXButton btnDeleteEmployee;
    public JFXButton btnClear;
    public JFXButton btnLogin;

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN, pane);
    }

    public void btnEmployeesOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.EMPLOYEE, pane);
    }

    public void btnStocksOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.OWNER_STOCK, pane);
    }

    public void btnIncomeReportOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.INCOME_REPORT, pane);
    }

    public void txtEmployeeIdOnAction(ActionEvent actionEvent) {
        String employeeId = txtEmployeeId.getText();
        try {
            Employee employee = EmployeeModel.search(employeeId);
            if (employee != null){
                fillData(employee);
            }
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    public void btnAddEmployeeOnAction(ActionEvent actionEvent) {
        String employeeId = txtEmployeeId.getText();
        String employeeName = txtEmployeeName.getText();
        String employeeAddress = txtEmployeeAddress.getText();
        String jobRole = txtJobRole.getText();

        Employee employee = new Employee(employeeId,employeeName,employeeAddress,jobRole);
        try {
            boolean isAdded = EmployeeModel.save(employee);

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Employee Added!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ObservableList<Employee> employees = tblEmployee.getItems();
        employees.add(employee);
        tblEmployee.setItems(employees);
    }


    public void txtSearchOnAction(ActionEvent actionEvent) {
        String employeeId = txtEmployeeId.getText();
        try {
            Employee employee = EmployeeModel.search(employeeId);
            if (employee != null){
                fillData(employee);
            }
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }

    }

    public void btnSearchEmployeeOnAction(ActionEvent actionEvent) {
        String employeeId = txtSearch.getText();
        try{
            Employee employee = EmployeeModel.search(employeeId);
            if (employee != null){
                fillData(employee);
            }
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    private void fillData(Employee employee) {
        txtEmployeeId.setText(employee.getEmployeeId());
        txtEmployeeName.setText(employee.getEmployeeName());
        txtEmployeeAddress.setText(employee.getEmployeeAddress());
        txtJobRole.setText(employee.getJobRole());

    }

    public void RowClicked(MouseEvent mouseEvent) {
        Employee clickedEmployee = (Employee) tblEmployee.getSelectionModel().getSelectedItem();
        txtEmployeeId.setText(String.valueOf(clickedEmployee.getEmployeeId()));
        txtEmployeeName.setText(String.valueOf(clickedEmployee.getEmployeeName()));
        txtEmployeeAddress.setText(String.valueOf(clickedEmployee.getEmployeeAddress()));
        txtJobRole.setText(String.valueOf(clickedEmployee.getJobRole()));
    }

    public void btnUpdateEmployeeOnAction(ActionEvent actionEvent) {
        String employeeId = txtEmployeeId.getText();
        String employeeName = txtEmployeeName.getText();
        String employeeAddress = txtEmployeeAddress.getText();
        String jobRole = txtJobRole.getText();


        try{
            Employee employee = new Employee(employeeId,employeeName,employeeAddress,jobRole);
            boolean isUpdated = EmployeeModel.update(employee, employeeId);
            if (isUpdated){
                new Alert(Alert.AlertType.CONFIRMATION, "Employee Updated Successfully!").show();
            }else {
                new Alert(Alert.AlertType.WARNING, "Employee not Updated!").show();
            }
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }

        ObservableList<Employee> currentTableData = tblEmployee.getItems();
        String currentEmployeeId = txtEmployeeId.getText();

        for(Employee employee : currentTableData){
            if(employee.getEmployeeId() == currentEmployeeId){
                employee.setEmployeeName(txtEmployeeName.getText());
                employee.setEmployeeAddress(txtEmployeeAddress.getText());
                employee.setJobRole(txtJobRole.getText());

                tblEmployee.setItems(currentTableData);
                tblEmployee.refresh();
                break;
            }
        }

    }

    ObservableList<Employee> employeeList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colEmployeeId.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        colEmployeeName.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        colEmployeeAddress.setCellValueFactory(new PropertyValueFactory<>("employeeAddress"));
        colJobRole.setCellValueFactory(new PropertyValueFactory<>("jobRole"));

        //Search bar
        txtSearch.textProperty()
                .addListener((observable, oldValue, newValue) ->{
                    loadAllEmployees(newValue);
                });
        loadAllEmployees("");
    }

    private void loadAllEmployees(String text) {
        ObservableList<Employee> employeeList = FXCollections.observableArrayList();

        try{
            ArrayList<Employee> employeesData = EmployeeModel.getEmployeeData();
            for (Employee employee:employeesData){
                if(employee.getEmployeeId().contains(text) || employee.getEmployeeName().contains(text)){
                    Employee e = new Employee(employee.getEmployeeId(), employee.getEmployeeName(),employee.getEmployeeAddress() ,employee.getJobRole());
                    employeeList.add(e);
                }
            }
        }catch(SQLException | ClassNotFoundException e){
            System.out.println(e);
        }

        tblEmployee.setItems(employeeList);
    }


    public void btnDeleteEmployeeOnAction(ActionEvent actionEvent) {
        String employeeId = txtEmployeeId.getText();
        String employeeName = txtEmployeeName.getText();
        String employeeAddress = txtEmployeeAddress.getText();
        String jobRole = txtJobRole.getText();

        try{
            Employee employee = new Employee(employeeId,employeeName,employeeAddress,jobRole);
            boolean isDeleted = EmployeeModel.delete(employee, employeeId);
            if (isDeleted){
                new Alert(Alert.AlertType.CONFIRMATION, "Employee Deleted Successfully!").show();
            }else {
                new Alert(Alert.AlertType.WARNING, "Employee not Deleted!").show();
            }
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }

        int selectedID = tblEmployee.getSelectionModel().getSelectedIndex();
        tblEmployee.getItems().remove(selectedID);
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        txtEmployeeId.setText("");
        txtEmployeeName.setText("");
        txtEmployeeAddress.setText("");
        txtJobRole.setText("");
    }

}
