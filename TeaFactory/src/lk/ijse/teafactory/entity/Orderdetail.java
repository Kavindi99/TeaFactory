package lk.ijse.teafactory.entity;

/**
 * author - kavindi
 * version - 1.0.0 9:55 AM 1/29/2023
 **/
public class Orderdetail {
    private String orderId;
    private String productCode;
    private int qauntity;
    private double  unitPrice;

    public Orderdetail() {
    }

    public Orderdetail(String orderId, String productCode, int qauntity, double unitPrice) {
        this.orderId = orderId;
        this.productCode = productCode;
        this.qauntity = qauntity;
        this.unitPrice = unitPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getQauntity() {
        return qauntity;
    }

    public void setQauntity(int qauntity) {
        this.qauntity = qauntity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Orderdetail{" +
                "orderId='" + orderId + '\'' +
                ", productCode='" + productCode + '\'' +
                ", qauntity=" + qauntity +
                ", unitPrice=" + unitPrice +
                '}';
    }


}
