package lk.ijse.teafactory.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.teafactory.util.Navigation;
import lk.ijse.teafactory.util.Routes;

import java.io.IOException;

/**
 * author - kavindi
 * version - 1.0.0 2:44 AM 11/22/2022
 **/
public class IncomeReportFormController {
    public AnchorPane pane;
    public JFXButton btnEmployees;
    public JFXButton btnStocks;
    public JFXButton btnIncomeReport;
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

}
