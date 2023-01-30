package lk.ijse.teafactory.entity;

import java.util.Date;

/**
 * author - kavindi
 * version - 1.0.0 10:02 AM 1/29/2023
 **/
public class OrderDTO {
    private String orderId;
    private Date orderDate;
    private String customerId;

    public OrderDTO() {
    }

    public OrderDTO(String orderId, Date orderDate, String customerId) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerId = customerId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId='" + orderId + '\'' +
                ", orderDate=" + orderDate +
                ", customerId='" + customerId + '\'' +
                '}';
    }


}
