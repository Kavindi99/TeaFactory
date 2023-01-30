package lk.ijse.teafactory.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * author - kavindi
 * version - 1.0.0 9:40 PM 11/24/2022
 **/
public class Navigation {
    private static AnchorPane pane;

    public static void navigate (Routes route ,AnchorPane pane ) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage) Navigation.pane.getScene().getWindow();

        switch (route) {
            case LOGIN:
                window.setTitle("Login Form");
                initUI("LoginForm.fxml");
                break;
            case ADMIN_DASHBOARD:
                window.setTitle("Admin Dashboard Form");
                initUI("AdminDashboardForm.fxml");
                break;
            case OWNER_DASHBOARD:
                window.setTitle("Owner DashBoard Form");
                initUI("OwnerDashboardForm.fxml");
                break;
            case ADMIN_STOCK:
                window.setTitle("Admin Stock Form");
                initUI("AdminStockForm.fxml");
                break;
            case CUSTOMER:
                window.setTitle("Customer Form");
                initUI("CustomerForm.fxml");
                break;
            case EMPLOYEE:
                window.setTitle("Employee Form");
                initUI("EmployeeForm.fxml");
                break;
            case ORDER:
                window.setTitle("Order Form");
                initUI("OrderForm.fxml");
                break;
            case PRODUCT:
                window.setTitle("Product Form");
                initUI("ProductForm.fxml");
                break;
            case SUPPLIER:
                window.setTitle("Supplier Form");
                initUI("SupplierForm.fxml");
                break;
            case OWNER_STOCK:
                window.setTitle("Owner Stock Form");
                initUI("OwnerStockForm.fxml");
                break;
            case INCOME_REPORT:
                window.setTitle("Income Report");
                initUI("IncomeReportForm.fxml");
                break;
            default:
                new Alert(Alert.AlertType.ERROR, "Not suitable UI found!").show();
        }
    }
    private static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class
                .getResource("/lk/ijse/teafactory/view/" + location)));
    }
}
