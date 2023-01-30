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
import lk.ijse.teafactory.model.AdminStockModel;
import lk.ijse.teafactory.model.CustomerModel;
import lk.ijse.teafactory.to.AdminStock;
import lk.ijse.teafactory.to.Customer;
import lk.ijse.teafactory.util.Navigation;
import lk.ijse.teafactory.util.Routes;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * author - kavindi
 * version - 1.0.0 3:06 AM 11/22/2022
 **/
public class AdminStockFormController implements Initializable {
    public AnchorPane pane;
    public JFXButton btnSuppliers;
    public JFXButton btnProducts;
    public JFXButton btnCustomers;
    public JFXButton btnOrders;
    public JFXButton btnStocks;
    public JFXTextField txtStockId;
    public JFXTextField txtStockName;
    public JFXTextField txtSectionCode;
    public JFXButton btnAdd;
    public JFXTextField txtSearch;
    public JFXButton btnSearch;
    public TableView tblAdminStocks;
    public TableColumn colStockId;
    public TableColumn colStockName;
    public TableColumn colSectionCode;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;
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

    public void txtStockIdOnAction(ActionEvent actionEvent) {
        String stockId = txtStockId.getText();
        try {
            AdminStock adminStock = AdminStockModel.search(stockId);
            if (adminStock != null){
                fillData(adminStock);
            }
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    public void btnAddOnAction(ActionEvent actionEvent) {
        String stockId = txtStockId.getText();
        String stockName = txtStockName.getText();
        String sectionCode = txtSectionCode.getText();

        AdminStock adminStock = new AdminStock(stockId,stockName,sectionCode);
        try {
            boolean isAdded = AdminStockModel.save(adminStock);

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Details Added!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void txtSearchOnAction(ActionEvent actionEvent) {
        String stockId = txtStockId.getText();
        try {
            AdminStock adminStock = AdminStockModel.search(stockId);
            if (adminStock != null){
                fillData(adminStock);
            }
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
        String stockId = txtSearch.getText();
        try{
            AdminStock adminStock = AdminStockModel.search(stockId);
            if (adminStock != null){
                fillData(adminStock);
            }
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    private void fillData(AdminStock adminStock) {
        txtStockId.setText(adminStock.getStockId());
        txtStockName.setText(adminStock.getStockName());
        txtSectionCode.setText(adminStock.getSectionCode());

    }

    public void RowClicked(MouseEvent mouseEvent) {
        AdminStock clickedAdminStock = (AdminStock) tblAdminStocks.getSelectionModel().getSelectedItem();
        txtStockId.setText(String.valueOf(clickedAdminStock.getStockId()));
        txtStockName.setText(String.valueOf(clickedAdminStock.getStockName()));
        txtSectionCode.setText(String.valueOf(clickedAdminStock.getSectionCode()));
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String stockId = txtStockId.getText();
        String stockName = txtStockName.getText();
        String sectionCode = txtSectionCode.getText();

        try{
            AdminStock adminStock = new AdminStock(stockId,stockName,sectionCode);
            boolean isUpdated = AdminStockModel.update(adminStock, stockId);
            if (isUpdated){
                new Alert(Alert.AlertType.CONFIRMATION, "Stock Updated Successfully!").show();
            }else {
                new Alert(Alert.AlertType.WARNING, "Stock not Updated!").show();
            }
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }


        ObservableList<AdminStock> currentTableData = tblAdminStocks.getItems();
        String currentStockId = txtStockId.getText();

        for(AdminStock adminStock : currentTableData){
            if(adminStock.getStockId() == currentStockId){
                adminStock.setStockName(txtStockName.getText());
                adminStock.setSectionCode(txtSectionCode.getText());

                tblAdminStocks.setItems(currentTableData);
                tblAdminStocks.refresh();
                break;
            }
        }
    }

    ObservableList<AdminStock> stockList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colStockId.setCellValueFactory(new PropertyValueFactory<>("stockId"));
        colStockName.setCellValueFactory(new PropertyValueFactory<>("stockName"));
        colSectionCode.setCellValueFactory(new PropertyValueFactory<>("sectionCode"));

        //Search bar
        txtSearch.textProperty()
                .addListener((observable, oldValue, newValue) ->{
                    loadAllStocks(newValue);
                });
        loadAllStocks("");
    }

    private void loadAllStocks(String text) {
        ObservableList<AdminStock> stockList = FXCollections.observableArrayList();

        try{
            ArrayList<AdminStock> stocksData = AdminStockModel.getStockData();
            for (AdminStock adminStock :stocksData){
                if(adminStock.getStockId().contains(text) || adminStock.getStockName().contains(text)){
                    AdminStock as = new AdminStock(adminStock.getStockId(), adminStock.getStockName(), adminStock.getSectionCode());
                    stockList.add(as);
                }
            }
        }catch(SQLException | ClassNotFoundException e){
            System.out.println(e);
        }

        tblAdminStocks.setItems(stockList);
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String stockId = txtStockId.getText();
        String stockName = txtStockName.getText();
        String sectionCode = txtSectionCode.getText();

        try{
            AdminStock adminStock = new AdminStock(stockId,stockName,sectionCode);
            boolean isDeleted = AdminStockModel.delete(adminStock, stockId);
            if (isDeleted){
                new Alert(Alert.AlertType.CONFIRMATION, "Stock Deleted Successfully!").show();
            }else {
                new Alert(Alert.AlertType.WARNING, "Stock not Deleted!").show();
            }
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }

        int selectedID = tblAdminStocks.getSelectionModel().getSelectedIndex();
        tblAdminStocks.getItems().remove(selectedID);
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        txtStockId.setText("");
        txtStockName.setText("");
        txtSectionCode.setText("");
    }


}
