package lk.ijse.teafactory.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.teafactory.model.CustomerModel;
import lk.ijse.teafactory.model.OrderModel;
import lk.ijse.teafactory.model.PlaceOrderModel;
import lk.ijse.teafactory.model.ProductModel;
import lk.ijse.teafactory.to.CartDetail;
import lk.ijse.teafactory.to.Customer;
import lk.ijse.teafactory.to.PlaceOrder;
import lk.ijse.teafactory.to.Product;
import lk.ijse.teafactory.util.Navigation;
import lk.ijse.teafactory.util.Routes;
import lk.ijse.teafactory.view.tm.PlaceOrderTM;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * author - kavindi
 * version - 1.0.0 3:04 AM 11/22/2022
 **/
public class OrderFormController implements Initializable {
    public AnchorPane pane;
    public JFXButton btnSuppliers;
    public JFXButton btnProducts;
    public JFXButton btnCustomers;
    public JFXButton btnOrders;
    public JFXButton btnStocks;
    public Label lblOrderId;
    public Label lblOrderDate;
    public Label lblCustomerId;
    public JFXComboBox cmbCustomerId;
    public Label lblCustomerName;
    public Label lblProductCode;
    public JFXComboBox cmbProductCode;
    public Label lblDescription;
    public Label lblUnitPrice;
    public Label lblQty;
    public JFXTextField txtQty;
    public JFXButton btnPlaceOrder;
    public JFXButton btnAddedCart;
    public TableView <PlaceOrderTM>tblPlaceOrder;
    public TableColumn colProductCode;
    public TableColumn colDescription;
    public TableColumn colQty;
    public TableColumn colUnitPrice;
    public TableColumn colTotal;
    public TableColumn colAction;
    public Label lblQtyOnHand;
    public JFXButton btnLogin;
    public Label lblOrderId1;
    public Label lblOrderDate1;
    public Label lblCustomerName1;
    public Label lblDescription1;
    public Label lblUnitPrice1;
    public Label lblQtyOnHand1;
    public TableColumn colPaymentId;

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

    private ObservableList<PlaceOrderTM> obList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadOrderDate();
        loadCustomerIds();
        loadNextOrderId();
        loadProductCodes();
        setCellValueFactory();
    }



    public void btnAddtoCartOnAction(ActionEvent actionEvent) {
        String productCode = String.valueOf(cmbProductCode.getValue());
        int qty = Integer.parseInt(txtQty.getText());
        String desc = lblDescription1.getText();
        double unitPrice = Double.parseDouble(lblUnitPrice1.getText());
        double total = unitPrice * qty;
        Button btnDelete = new Button("Delete");

        txtQty.setText("");

        if (!obList.isEmpty()) {
            L1:
            /* check same item has been in table. If so, update that row instead of adding new row to the table */
            for (int i = 0; i < tblPlaceOrder.getItems().size(); i++) {
                if (colProductCode.getCellData(i).equals(productCode)) {
                    qty += (int) colQty.getCellData(i);
                    total = unitPrice * qty;

                    obList.get(i).setQty(qty);
                    obList.get(i).setTotal(total);
                    tblPlaceOrder.refresh();
                    return;
                }
            }
        }

        /* set delete button to some action before it put on obList */
        btnDelete.setOnAction((e) -> {
            ButtonType ok = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure ?", ok, no);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.orElse(no) == ok) {
                PlaceOrderTM tm = tblPlaceOrder.getSelectionModel().getSelectedItem();
                /*
                netTot = Double.parseDouble(txtNetTot.getText());
                netTot = netTot - tm.getTotalPrice();
                */

                tblPlaceOrder.getItems().removeAll(tblPlaceOrder.getSelectionModel().getSelectedItem());
            }
        });
        obList.add(new PlaceOrderTM(productCode, desc, qty, unitPrice, total, btnDelete));
        tblPlaceOrder.setItems(obList);
    }

    public void btnPlaceOrderOnAction(ActionEvent actionEvent) {
        String orderId = lblOrderId1.getText();
        String customerId = String.valueOf(cmbCustomerId.getValue());

        ArrayList<CartDetail> cartDetails = new ArrayList<>();

        /* load all cart items' to orderDetails arrayList */
        for (int i = 0; i < tblPlaceOrder.getItems().size(); i++) {
            /* get each row details to (PlaceOrderTm)tm in each time and add them to the orderDetails */
            PlaceOrderTM tm = obList.get(i);
            cartDetails.add(new CartDetail(orderId, tm.getProductCode(), tm.getQty(), tm.getDescription(), tm.getUnitPrice()));
        }

        PlaceOrder placeOrder = new PlaceOrder(customerId, orderId, cartDetails);
        try {
            boolean isPlaced = PlaceOrderModel.placeOrder(placeOrder);
            if (isPlaced) {
                /* to clear table */
                obList.clear();
                loadNextOrderId();
                new Alert(Alert.AlertType.CONFIRMATION, "Order Placed!").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Order Not Placed!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadNextOrderId() {
        /*try {
           ResultSet set= OrderModel.generateNextOrderId();
            if (set.next()){
                if (set.next()) {
                    String[] O00 = set.getString(1).split("O00");
                    int id = Integer.parseInt(O00[1]);
                    id++;
                    lblOrderId1.setText("O00" + id);


                } else {
                    lblOrderId1.setText("O001");

                }

            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }*/

        try {
            String orderId = OrderModel.generateNextOrderId();
            lblOrderId1.setText(orderId);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadOrderDate() {
        lblOrderDate1.setText(String.valueOf(LocalDate.now()));
    }

    private void loadCustomerIds() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> idList = CustomerModel.loadCustomerIds();

            for (String id : idList) {
                observableList.add(id);
            }
            cmbCustomerId.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadProductCodes() {
        try {
            ArrayList<String> productList = ProductModel.loadProductCodes();
            ObservableList<String> observableList = FXCollections.observableArrayList(productList);

            cmbProductCode.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {
        colProductCode.setCellValueFactory(new PropertyValueFactory("productCode"));
        colDescription.setCellValueFactory(new PropertyValueFactory("description"));
        colQty.setCellValueFactory(new PropertyValueFactory("qty"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory("unitPrice"));
        colTotal.setCellValueFactory(new PropertyValueFactory("total"));
        colAction.setCellValueFactory(new PropertyValueFactory("btnDelete"));
    }


    public void cmbProductCodeOnAction(ActionEvent actionEvent) {
        String productCode = String.valueOf(cmbProductCode.getValue());
        try {
            Product product = ProductModel.search(productCode);
            fillItemFields(product);
            txtQty.requestFocus();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void fillItemFields(Product product) {
        lblDescription1.setText(product.getDescription());
        lblUnitPrice1.setText(String.valueOf(product.getUnitPrice()));
        lblQtyOnHand1.setText(String.valueOf(product.getQtyOnHand()));
    }

    public void cmbCustomerIdOnAction(ActionEvent actionEvent) {
        String customerId = String.valueOf(cmbCustomerId.getValue());
        try {
            Customer customer = CustomerModel.search(customerId);
            lblCustomerName1.setText(customer.getCustomerName());
            txtQty.requestFocus();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
