package lk.ijse.teafactory.tdm;

import java.sql.Date;
import java.time.LocalDate;

/**
 * author - kavindi
 * version - 1.0.0 11:19 PM 11/29/2022
 **/
public class Order {
    private String orderId;
    private LocalDate date;
    private String customerId;

    public Order(String string, Date date, String rstString) {
    }

    public Order(String orderId, LocalDate date, String customerId) {
        this.orderId = orderId;
        this.date = date;
        this.customerId = customerId;
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

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", date=" + date +
                ", customerId='" + customerId + '\'' +
                '}';
    }

}
