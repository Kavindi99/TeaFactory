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
import lk.ijse.teafactory.modelold.ProductModel;
import lk.ijse.teafactory.tdm.Product;
import lk.ijse.teafactory.util.Navigation;
import lk.ijse.teafactory.util.Routes;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * author - kavindi
 * version - 1.0.0 3:17 AM 11/22/2022
 **/
public class ProductFormController implements Initializable {
    public AnchorPane pane;
    public JFXButton btnSuppliers;
    public JFXButton btnProducts;
    public JFXButton btnCustomers;
    public JFXButton btnOrders;
    public JFXButton btnStocks;
    public JFXButton btnAddProduct;
    public JFXButton btnSearchProduct;
    public JFXButton btnUpdateProduct;
    public JFXButton btnDeleteProduct;
    public JFXTextField txtProductCode;
    public JFXTextField txtUnitPrice;
    public JFXTextField txtDescription;
    public JFXTextField txtSearch;
    public TableView tblProduct;
    public TableColumn colProductCode;
    public TableColumn colDescription;
    public TableColumn colUnitPrice;
    public JFXButton btnClear;
    public JFXTextField txtQtyOnHand;
    public TableColumn colQtyOnHand;
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

    public void btnAddProductOnAction(ActionEvent actionEvent) {
        String productCode = txtProductCode.getText();
        String description = txtDescription.getText();
        double unitPrice = Double.parseDouble(txtUnitPrice.getText());
        int qtyOnHand = Integer.parseInt(txtQtyOnHand.getText());

        Product product = new Product(productCode,description,unitPrice, qtyOnHand);
        try {
            boolean isAdded = ProductModel.save(product);

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Product Added!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ObservableList<Product> products = tblProduct.getItems();
        products.add(product);
        tblProduct.setItems(products);
    }

    private void fillData(Product product) {
        txtProductCode.setText(product.getProductCode());
        txtDescription.setText(product.getDescription());
        txtUnitPrice.setText(String.valueOf(product.getUnitPrice()));
        txtQtyOnHand.setText(String.valueOf(product.getQtyOnHand()));

    }

    public void btnSearchProductOnAction(ActionEvent actionEvent) {
        String productCode = txtSearch.getText();
        try{
            Product product = ProductModel.search(productCode);
            if (product != null){
                fillData(product);
            }
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    public void btnUpdateProductOnAction(ActionEvent actionEvent) {
        String productCode = txtProductCode.getText();
        String description = txtDescription.getText();
        double unitPrice = Double.parseDouble(txtUnitPrice.getText());
        int qtyOnHand = Integer.parseInt(txtQtyOnHand.getText());

        try{
            Product product = new Product(productCode,description,unitPrice,qtyOnHand);
            boolean isUpdated = ProductModel.update(product, productCode);
            if (isUpdated){
                new Alert(Alert.AlertType.CONFIRMATION, "Product Updated Successfully!").show();
            }else {
                new Alert(Alert.AlertType.WARNING, "Product not Updated!").show();
            }
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }

        ObservableList<Product> currentTableData = tblProduct.getItems();
        String currentProductCode = txtProductCode.getText();

        for(Product product : currentTableData){
            if(product.getProductCode() == currentProductCode){
                product.setDescription(txtDescription.getText());
                product.setUnitPrice(Integer.parseInt(txtUnitPrice.getText()));
                product.setQtyOnHand(Integer.parseInt(txtQtyOnHand.getText()));

                tblProduct.setItems(currentTableData);
                tblProduct.refresh();
                break;
            }
        }
    }
     ObservableList<Product> productList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colProductCode.setCellValueFactory(new PropertyValueFactory<>("productCode"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colQtyOnHand.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));

        //Search bar
        txtSearch.textProperty()
                .addListener((observable, oldValue, newValue) ->{
                    loadAllProducts(newValue);
                });
        loadAllProducts("");
    }

    private void loadAllProducts(String text) {
        ObservableList<Product> productList = FXCollections.observableArrayList();

        try{
            ArrayList<Product> productsData = ProductModel.getProductData();
            for (Product product:productsData){
                if(product.getProductCode().contains(text) || product.getDescription().contains(text)){
                    Product p = new Product(product.getProductCode(), product.getDescription(),product.getUnitPrice(),product.getQtyOnHand());
                    productList.add(p);
                }
            }
        }catch(SQLException | ClassNotFoundException e){
            System.out.println(e);
        }

        tblProduct.setItems(productList);
    }

    public void btnDeleteProductOnAction(ActionEvent actionEvent) {
        String productCode = txtProductCode.getText();
        String description = txtDescription.getText();
        double unitPrice = Double.parseDouble(txtUnitPrice.getText());
        int qtyOnHand = Integer.parseInt(txtQtyOnHand.getText());

        try{
            Product product = new Product(productCode,description,unitPrice,qtyOnHand);
            boolean isDeleted = ProductModel.delete(product, productCode);
            if (isDeleted){
                new Alert(Alert.AlertType.CONFIRMATION, "Product Deleted Successfully!").show();
            }else {
                new Alert(Alert.AlertType.WARNING, "product not Deleted!").show();
            }
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }

        int selectedID = tblProduct.getSelectionModel().getSelectedIndex();
        tblProduct.getItems().remove(selectedID);

    }


    public void RowClicked(MouseEvent mouseEvent) {
        Product clickedProduct = (Product) tblProduct.getSelectionModel().getSelectedItem();
        txtProductCode.setText(String.valueOf(clickedProduct.getProductCode()));
        txtDescription.setText(String.valueOf(clickedProduct.getDescription()));
        txtUnitPrice.setText(String.valueOf(clickedProduct.getUnitPrice()));
        txtQtyOnHand.setText(String.valueOf(clickedProduct.getQtyOnHand()));
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        txtProductCode.setText("");
        txtDescription.setText("");
        txtUnitPrice.setText("");
        txtQtyOnHand.setText("");
    }

    public void txtSearchOnAction(ActionEvent actionEvent) {
        String productCode = txtProductCode.getText();
        try {
            Product product = ProductModel.search(productCode);
            if (product != null){
                fillData(product);
            }
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    public void txtProductCodeOnAction(ActionEvent actionEvent) {
        String productCode = txtProductCode.getText();
        try {
            Product product = ProductModel.search(productCode);
            if (product != null){
                fillData(product);
            }
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

}
