package lk.ijse.teafactory.to;

/**
 * author - kavindi
 * version - 1.0.0 11:28 PM 11/29/2022
 **/
public class CartDetail {
    private String orderId;
    private String productCode;
    private int qty;
    private String description;
    private double unitPrice;
    private String paymentId;


    public CartDetail() {
    }



    public CartDetail(String orderId, String productCode, int qty, String description, double unitPrice) {
        this.orderId = orderId;
        this.productCode = productCode;
        this.qty = qty;
        this.description = description;
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

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "CartDetail{" +
                "orderId='" + orderId + '\'' +
                ", productCode='" + productCode + '\'' +
                ", qty=" + qty +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
