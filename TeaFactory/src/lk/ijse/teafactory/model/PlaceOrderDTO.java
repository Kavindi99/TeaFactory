package lk.ijse.teafactory.model;

import javafx.scene.control.Button;
import lk.ijse.teafactory.tdm.CartDetail;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * author - kavindi
 * version - 1.0.0 10:28 PM 11/29/2022
 **/
public class PlaceOrderDTO {
    private String productCode;
    private String description;
    private int qty;
    private double unitPrice;
    private double total;
    private Button btnDelete;

    private String orderId;
    private LocalDate date;
    private String customerId;

    private ArrayList<CartDetail> orderDetails = new ArrayList<>();

    public PlaceOrderDTO() {
    }

   /* public PlaceOrderDTO(String productCode, String description, int qty, double unitPrice, double total, Button btnDelete) {
        this.productCode = productCode;
        this.description = description;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.total = total;
        this.btnDelete = btnDelete;
    }*/

    public PlaceOrderDTO(String productCode, String description, int qty, double unitPrice, double total, Button btnDelete, String orderId, LocalDate date, String customerId, ArrayList<CartDetail> orderDetails) {
        this.productCode = productCode;
        this.description = description;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.total = total;
        this.btnDelete = btnDelete;
        this.orderId = orderId;
        this.date = date;
        this.customerId = customerId;
        this.orderDetails = orderDetails;
    }

    /*public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Button getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }*/

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Button getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public ArrayList<CartDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(ArrayList<CartDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "PlaceOrderDTO{" +
                "productCode='" + productCode + '\'' +
                ", description='" + description + '\'' +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                ", total=" + total +
                ", btnDelete=" + btnDelete +
                ", orderId='" + orderId + '\'' +
                ", date=" + date +
                ", customerId='" + customerId + '\'' +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
