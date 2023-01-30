package lk.ijse.teafactory.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import lk.ijse.teafactory.db.DBConnection;
import lk.ijse.teafactory.util.Navigation;
import lk.ijse.teafactory.util.Routes;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

/**
 * author - kavindi
 * version - 1.0.0 11:14 PM 11/20/2022
 **/
public class AdminDashboardFormController {
    public AnchorPane pane;
    public JFXButton btnSuppliers;
    public JFXButton btnProducts;
    public JFXButton btnCustomers;
    public JFXButton btnOrders;
    public JFXButton btnStocks;
    public JFXButton btnLogin;
    public JFXButton btnCustomer;
    public JFXButton btnOrder;
    public JFXButton btnProduct;

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

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN, pane);
    }

    public void btnCustomerOnAction(ActionEvent actionEvent) {
        InputStream resource = this.getClass().getResourceAsStream("/lk/ijse/teafactory/view/report/CustomerReport.jrxml");
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(resource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException | SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.toString()).show();
        }
    }

    public void btnOrderOnAction(ActionEvent actionEvent) {
        /*InputStream resource = this.getClass().getResourceAsStream("/lk/ijse/teafactory/view/report/OrderReport.jrxml");
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(resource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException | SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.toString()).show();
        }*/
    }

    public void btnProductOnAction(ActionEvent actionEvent) {
        /*InputStream resource = this.getClass().getResourceAsStream("/lk/ijse/teafactory/view/report/ProductReport.jrxml");
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(resource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException | SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.toString()).show();
        }*/
    }
}
