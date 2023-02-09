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
import lk.ijse.teafactory.modelold.SupplierModel;
import lk.ijse.teafactory.tdm.Supplier;
import lk.ijse.teafactory.util.Navigation;
import lk.ijse.teafactory.util.Routes;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * author - kavindi
 * version - 1.0.0 2:55 AM 11/22/2022
 **/
public class SupplierFormControllerController implements Initializable{
    public AnchorPane pane;
    public JFXButton btnSuppliers;
    public JFXButton btnProducts;
    public JFXButton btnCustomers;
    public JFXButton btnOrders;
    public JFXButton btnStocks;
    public JFXTextField txtSupplierId;
    public JFXTextField txtSupplierName;
    public JFXTextField txtDescription;
    public JFXTextField txtQty;
    public JFXButton btnAddSupplier;
    public JFXTextField txtSearch;
    public JFXButton btnSearchSupplier;
    public TableView tblSupplier;
    public TableColumn colSupplierId;
    public TableColumn colSupplierName;
    public TableColumn colDescription;
    public TableColumn colQty;
    public JFXButton btnUpdateSupplier;
    public JFXButton btnDeleteSupplier;
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

    public void btnAddSupplierOnAction(ActionEvent actionEvent) {
        String supplierId = txtSupplierId.getText();
        String supplierName = txtSupplierName.getText();
        String description = txtDescription.getText();
        int qty = Integer.parseInt(txtQty.getText());

        Supplier supplier = new Supplier(supplierId,supplierName,description,qty);
        try {
            boolean isAdded = SupplierModel.save(supplier);

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Supplier Added!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ObservableList<Supplier> suppliers = tblSupplier.getItems();
        suppliers.add(supplier);
        tblSupplier.setItems(suppliers);

    }


    public void btnSearchSupplierOnAction(ActionEvent actionEvent) {
        String supplierId = txtSearch.getText();
        try{
            Supplier supplier = SupplierModel.search(supplierId);
            if (supplier != null){
                fillData(supplier);
            }
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    private void fillData(Supplier supplier) {
        txtSupplierId.setText(supplier.getSupplierId());
        txtSupplierName.setText(supplier.getSupplierName());
        txtDescription.setText(supplier.getDescription());
        txtQty.setText(String.valueOf(supplier.getQty()));

    }

    public void btnUpdateSupplierOnAction(ActionEvent actionEvent) {
        String supplierId = txtSupplierId.getText();
        String  supplierName = txtSupplierName.getText();
        String  description = txtDescription.getText();
        int qty = Integer.parseInt(txtQty.getText());

        try{
            Supplier supplier = new Supplier(supplierId,supplierName,description,qty);
            boolean isUpdated = SupplierModel.update(supplier, supplierId);
            if (isUpdated){
                new Alert(Alert.AlertType.CONFIRMATION, "Supplier Updated Successfully!").show();
            }else {
                new Alert(Alert.AlertType.WARNING, "Supplier not Updated!").show();
            }
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }

        ObservableList<Supplier> currentTableData = tblSupplier.getItems();
        String currentSupplierId = txtSupplierId.getText();

        for(Supplier supplier : currentTableData){
            if(supplier.getSupplierId() == currentSupplierId){
                supplier.setSupplierName(txtSupplierName.getText());
                supplier.setDescription(txtDescription.getText());
                supplier.setQty(Integer.parseInt(txtQty.getText()));

                tblSupplier.setItems(currentTableData);
                tblSupplier.refresh();
                break;
            }
        }
    }

    ObservableList<Supplier> supplierList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colSupplierId.setCellValueFactory(new PropertyValueFactory<>("supplierId"));
        colSupplierName.setCellValueFactory(new PropertyValueFactory<>("supplierName"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));

        //Search bar
        txtSearch.textProperty()
                .addListener((observable, oldValue, newValue) ->{
                    loadAllSuppliers(newValue);
                });
        loadAllSuppliers("");
    }

    private void loadAllSuppliers(String text) {
        ObservableList<Supplier> supplierList = FXCollections.observableArrayList();

        try{
            ArrayList<Supplier> suppliersData = SupplierModel.getSupplierData();
            for (Supplier supplier:suppliersData){
                if(supplier.getSupplierId().contains(text) || supplier.getSupplierName().contains(text)){
                    Supplier s = new Supplier(supplier.getSupplierId(), supplier.getSupplierName(),supplier.getDescription(), supplier.getQty());
                    supplierList.add(s);
                }
            }
        }catch(SQLException | ClassNotFoundException e){
            System.out.println(e);
        }

        tblSupplier.setItems(supplierList);
    }

    public void btnDeleteSupplierOnAction(ActionEvent actionEvent) {
        String supplierId = txtSupplierId.getText();
        String supplierName = txtSupplierName.getText();
        String description = txtDescription.getText();
        int qty = Integer.parseInt(txtQty.getText());

        try{
            Supplier supplier = new Supplier(supplierId,supplierName,description,qty);
            boolean isDeleted = SupplierModel.delete(supplier, supplierId);
            if (isDeleted){
                new Alert(Alert.AlertType.CONFIRMATION, "Supplier Deleted Successfully!").show();
            }else {
                new Alert(Alert.AlertType.WARNING, "Supplier not Deleted!").show();
            }
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }

        int selectedID = tblSupplier.getSelectionModel().getSelectedIndex();
        tblSupplier.getItems().remove(selectedID);
    }

    public void btnclearOnAction(ActionEvent actionEvent) {
        txtSupplierId.setText("");
        txtSupplierName.setText("");
        txtDescription.setText("");
        txtQty.setText("");
    }

    public void txtSupplierIdOnAction(ActionEvent actionEvent) {
        String supplierId = txtSupplierId.getText();
        try {
            Supplier supplier = SupplierModel.search(supplierId);
            if (supplier != null){
                fillData(supplier);
            }
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    public void txtSearchOnAction(ActionEvent actionEvent) {
        String supplierId = txtSupplierId.getText();
        try {
            Supplier supplier = SupplierModel.search(supplierId);
            if (supplier != null){
                fillData(supplier);
            }
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    public void RowClicked(MouseEvent mouseEvent) {
        Supplier clickedSupplier = (Supplier) tblSupplier.getSelectionModel().getSelectedItem();
        txtSupplierId.setText(String.valueOf(clickedSupplier.getSupplierId()));
        txtSupplierName.setText(String.valueOf(clickedSupplier.getSupplierName()));
        txtDescription.setText(String.valueOf(clickedSupplier.getDescription()));
        txtQty.setText(String.valueOf(clickedSupplier.getQty()));
    }

}

