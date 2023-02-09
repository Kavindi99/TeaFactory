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
import lk.ijse.teafactory.modelold.OwnerStockModel;
import lk.ijse.teafactory.tdm.OwnerStock;
import lk.ijse.teafactory.util.Navigation;
import lk.ijse.teafactory.util.Routes;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * author - kavindi
 * version - 1.0.0 2:41 AM 11/22/2022
 **/
public class OwnerStockFormController implements Initializable {
    public AnchorPane pane;
    public JFXButton btnEmployees;
    public JFXButton btnStocks;
    public JFXButton btnIncomeReport;
    public JFXTextField txtStockId;
    public JFXTextField txtStockName;
    public JFXTextField txtSectionCode;
    public JFXButton btnAdd;
    public JFXTextField txtSearch;
    public JFXButton btnSearch;
    public TableView tblOwnerStocks;
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

    public void btnEmployeesOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.EMPLOYEE, pane);
    }

    public void btnStocksOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.OWNER_STOCK, pane);
    }

    public void btnIncomeReportOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.INCOME_REPORT, pane);
    }

    public void txtStockIdOnAction(ActionEvent actionEvent) {

    }

    public void btnAddOnAction(ActionEvent actionEvent) {
        String stockId = txtStockId.getText();
        String stockName = txtStockName.getText();
        String sectionCode = txtSectionCode.getText();

        OwnerStock ownerStock = new OwnerStock(stockId,stockName,sectionCode);
        try {
            boolean isAdded = OwnerStockModel.save(ownerStock);

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
            OwnerStock ownerStock = OwnerStockModel.search(stockId);
            if (ownerStock != null){
                fillData(ownerStock);
            }
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
        String stockId = txtSearch.getText();
        try{
            OwnerStock ownerStock = OwnerStockModel.search(stockId);
            if (ownerStock != null){
                fillData(ownerStock);
            }
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    private void fillData(OwnerStock ownerStock) {
        txtStockId.setText(ownerStock.getStockId());
        txtStockName.setText(ownerStock.getStockName());
        txtSectionCode.setText(ownerStock.getSectionCode());

    }

    public void RowClicked(MouseEvent mouseEvent) {
        OwnerStock clickedOwnerStock = (OwnerStock) tblOwnerStocks.getSelectionModel().getSelectedItem();
        txtStockId.setText(String.valueOf(clickedOwnerStock.getStockId()));
        txtStockName.setText(String.valueOf(clickedOwnerStock.getStockName()));
        txtSectionCode.setText(String.valueOf(clickedOwnerStock.getSectionCode()));
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String stockId = txtStockId.getText();
        String stockName = txtStockName.getText();
        String sectionCode = txtSectionCode.getText();

        try{
            OwnerStock ownerStock = new OwnerStock(stockId,stockName,sectionCode);
            boolean isUpdated = OwnerStockModel.update(ownerStock, stockId);
            if (isUpdated){
                new Alert(Alert.AlertType.CONFIRMATION, "Stock Updated Successfully!").show();
            }else {
                new Alert(Alert.AlertType.WARNING, "Stock not Updated!").show();
            }
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }

        ObservableList<OwnerStock> currentTableData = tblOwnerStocks.getItems();
        String currentStockId = txtStockId.getText();

        for(OwnerStock ownerStock : currentTableData){
            if(ownerStock.getStockId() == currentStockId){
                ownerStock.setStockName(txtStockName.getText());
                ownerStock.setSectionCode(txtSectionCode.getText());

                tblOwnerStocks.setItems(currentTableData);
                tblOwnerStocks.refresh();
                break;
            }
        }
    }

    ObservableList<OwnerStock> stockList = FXCollections.observableArrayList();

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
        ObservableList<OwnerStock> stockList = FXCollections.observableArrayList();

        try{
            ArrayList<OwnerStock> stocksData = OwnerStockModel.getStockData();
            for (OwnerStock ownerStock :stocksData){
                if(ownerStock.getStockId().contains(text) || ownerStock.getStockName().contains(text)){
                    OwnerStock os = new OwnerStock(ownerStock.getStockId(), ownerStock.getStockName(), ownerStock.getSectionCode());
                    stockList.add(os);
                }
            }
        }catch(SQLException | ClassNotFoundException e){
            System.out.println(e);
        }

        tblOwnerStocks.setItems(stockList);
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String stockId = txtStockId.getText();
        String stockName = txtStockName.getText();
        String sectionCode = txtSectionCode.getText();

        try{
            OwnerStock ownerStock = new OwnerStock(stockId,stockName,sectionCode);
            boolean isDeleted = OwnerStockModel.delete(ownerStock, stockId);
            if (isDeleted){
                new Alert(Alert.AlertType.CONFIRMATION, "Stock Deleted Successfully!").show();
            }else {
                new Alert(Alert.AlertType.WARNING, "Stock not Deleted!").show();
            }
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }

        int selectedID = tblOwnerStocks.getSelectionModel().getSelectedIndex();
        tblOwnerStocks.getItems().remove(selectedID);
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        txtStockId.setText("");
        txtStockName.setText("");
        txtSectionCode.setText("");
    }

}
