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
import lk.ijse.teafactory.dao.custom.CustomerDAO;
import lk.ijse.teafactory.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.teafactory.model.CustomerDTO;
import lk.ijse.teafactory.modelold.CustomerModel;
import lk.ijse.teafactory.tdm.Customer;
import lk.ijse.teafactory.util.Navigation;
import lk.ijse.teafactory.util.Routes;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * author - kavindi
 * version - 1.0.0 2:46 AM 11/22/2022
 **/
public class CustomerFormController implements Initializable {
    public AnchorPane pane;
    public JFXButton btnSuppliers;
    public JFXButton btnProducts;
    public JFXButton btnCustomers;
    public JFXButton btnOrders;
    public JFXButton btnStocks;
    public JFXButton btnAddCustomer;
    public JFXButton btnSearchCustomer;
    public JFXTextField txtCustomerId;
    public JFXTextField txtCustomerName;
    public JFXTextField txtContact;
    public JFXTextField txtSearch;
    public JFXButton btnUpdateCustomer;
    public TableView tblCustomer;
    public TableColumn colCustomerId;
    public TableColumn colCustomerName;
    public TableColumn colContact;
    public JFXButton btnDeleteCustomer;
    public JFXButton btnClear;
    public JFXButton btnLogin;

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN, pane);
    }

    public void btnSuppliersOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.SUPPLIER, pane);
    }

    public void btnProductsOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PRODUCT, pane);
    }

    public void btnCustomersOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.CUSTOMER, pane);
    }

    public void btnOrdersOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ORDER, pane);
    }

    public void btnStocksOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ADMIN_STOCK, pane);
    }

    public void btnAddCustomerOnAction(ActionEvent actionEvent) {
        String customerId = txtCustomerId.getText();
        String customerName = txtCustomerName.getText();
       // int contact = Integer.parseInt(txtContact.getText());
        String contact = txtContact.getText();


        /*Pattern pattern = Pattern.compile("(C0)([1-9]{1,2})");
        Matcher matcher = pattern.matcher(txtCustomerId.getText());

        boolean isMatchedId = matcher.matches();
        if(!isMatchedId){
            new Alert(Alert.AlertType.WARNING,"Invalid Customer ID").show();
        }
*/
//        Customer customer = new Customer(customerId,customerName,contact);
        try {
//            boolean isAdded = CustomerModel.save(customer);
            CustomerDAO customerDAO = new CustomerDAOImpl();
            boolean isAdded = customerDAO.save(new CustomerDTO(customerId, customerName, contact));

        if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Customer Added!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

//        ObservableList<Customer> customers = tblCustomer.getItems();
//        customers.add(customer);
//        tblCustomer.setItems(customers);

    }

//

    private void fillData(CustomerDTO customer) {
        txtCustomerId.setText(customer.getCustomerId());
        txtCustomerName.setText(customer.getCustomerName());
        txtContact.setText(String.valueOf(customer.getContact()));

    }

    public void btnUpdateCustomerOnAction(ActionEvent actionEvent) {
        String customerId = txtCustomerId.getText();
        String customerName = txtCustomerName.getText();
       // int contact = Integer.parseInt(txtContact.getText());
        String contact = txtContact.getText();

        try{
         //   Customer customer = new Customer(customerId,customerName,contact);
         //   boolean isUpdated = CustomerModel.update(customer, customerId);

            CustomerDAO customerDAO = new CustomerDAOImpl();
            boolean isUpdated = customerDAO.update(new CustomerDTO(customerId, customerName, contact));

            if (isUpdated){
                new Alert(Alert.AlertType.CONFIRMATION, "Customer Updated Successfully!").show();
            }else {
                new Alert(Alert.AlertType.WARNING, "Customer not Updated!").show();
            }
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }


        ObservableList<Customer> currentTableData = tblCustomer.getItems();
        String currentCustomerId = txtCustomerId.getText();

        for(Customer customer : currentTableData){
            if(customer.getCustomerId() == currentCustomerId){
                customer.setCustomerName(txtCustomerName.getText());
                customer.setContact(Integer.parseInt(txtContact.getText()));

                tblCustomer.setItems(currentTableData);
                tblCustomer.refresh();
                break;
            }
        }
    }

    ObservableList<Customer> customerList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));

        //Search bar
        txtSearch.textProperty()
                .addListener((observable, oldValue, newValue) ->{
                    loadAllCustomers(newValue);
                });
        loadAllCustomers("");
    }

    private void loadAllCustomers(String text) {
        ObservableList<Customer> customerList = FXCollections.observableArrayList();

        try{
            ArrayList<Customer> customersData = CustomerModel.getCustomerData();
            for (Customer customer:customersData){
                if(customer.getCustomerId().contains(text) || customer.getCustomerName().contains(text)){
                    Customer c = new Customer(customer.getCustomerId(), customer.getCustomerName(), customer.getContact());
                    customerList.add(c);
                }
            }
        }catch(SQLException | ClassNotFoundException e){
            System.out.println(e);
        }

        tblCustomer.setItems(customerList);
    }

    public void btnDeleteCustomerOnAction(ActionEvent actionEvent) {
        String customerId = txtCustomerId.getText();
        String customerName = txtCustomerName.getText();
        int contact = Integer.parseInt(txtContact.getText());

        try{
           /* Customer customer = new Customer(customerId,customerName,contact);
            boolean isDeleted = CustomerModel.delete(customer, customerId);*/

            CustomerDAO customerDAO = new CustomerDAOImpl();
            boolean isDeleted = customerDAO.delete(customerId);

            if (isDeleted){
                new Alert(Alert.AlertType.CONFIRMATION, "Customer Deleted Successfully!").show();
            }else {
                new Alert(Alert.AlertType.WARNING, "Customer not Deleted!").show();
            }
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }

        int selectedID = tblCustomer.getSelectionModel().getSelectedIndex();
        tblCustomer.getItems().remove(selectedID);

    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        txtCustomerId.setText("");
        txtCustomerName.setText("");
        txtContact.setText("");
    }

    public void RowClicked(MouseEvent mouseEvent) {
        Customer clickedCustomer = (Customer) tblCustomer.getSelectionModel().getSelectedItem();
        txtCustomerId.setText(String.valueOf(clickedCustomer.getCustomerId()));
        txtCustomerName.setText(String.valueOf(clickedCustomer.getCustomerName()));
        txtContact.setText(String.valueOf(clickedCustomer.getContact()));

    }

    public void txtCustomerIdOnAction(ActionEvent actionEvent) {
        String customerId = txtCustomerId.getText();
        try {
        //    Customer customer = CustomerModel.search(customerId);
            CustomerDAO customerDAO = new CustomerDAOImpl();
            CustomerDTO search = customerDAO.search(customerId);

            if (search != null){
                fillData(search);
            }else {
                new Alert(Alert.AlertType.ERROR,"Empty Result..!").show();
            }
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    public void txtSearchOnAction(ActionEvent actionEvent) {
        String customerId = txtCustomerId.getText();
        try {
          //  Customer customer = CustomerModel.search(customerId);
            CustomerDAO customerDAO = new CustomerDAOImpl();
            CustomerDTO search = customerDAO.search(customerId);

            if (search != null){
                fillData(search);
            }else {
                new Alert(Alert.AlertType.ERROR,"Empty Result..!").show();
            }
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }

    }

    public void btnSearchCustomersOnAction(ActionEvent actionEvent) {
        String customerId = txtSearch.getText();
        CustomerDAO customerDAO = new CustomerDAOImpl();
        try {
            CustomerDTO search = customerDAO.search(customerId);
            if (search != null){
                fillData(search);
            }else if ((search == null)){
                new Alert(Alert.AlertType.ERROR,"Empty Result..!").show();
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
