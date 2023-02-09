package lk.ijse.teafactory.model;

/**
 * author - kavindi
 * version - 1.0.0 10:30 AM 1/29/2023
 **/
public class SupplierOrderDetail {
   private double sellingPrice;
   private int qautity;
   private String sellingOrderId;
   private String stockId;
   private String billPaymentId;

    public SupplierOrderDetail() {
    }

    public SupplierOrderDetail(double sellingPrice, int qautity, String sellingOrderId, String stockId, String billPaymentId) {
        this.sellingPrice = sellingPrice;
        this.qautity = qautity;
        this.sellingOrderId = sellingOrderId;
        this.stockId = stockId;
        this.billPaymentId = billPaymentId;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getQautity() {
        return qautity;
    }

    public void setQautity(int qautity) {
        this.qautity = qautity;
    }

    public String getSellingOrderId() {
        return sellingOrderId;
    }

    public void setSellingOrderId(String sellingOrderId) {
        this.sellingOrderId = sellingOrderId;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public String getBillPaymentId() {
        return billPaymentId;
    }

    public void setBillPaymentId(String billPaymentId) {
        this.billPaymentId = billPaymentId;
    }

    @Override
    public String toString() {
        return "SupplierOrderDetail{" +
                "sellingPrice=" + sellingPrice +
                ", qautity=" + qautity +
                ", sellingOrderId='" + sellingOrderId + '\'' +
                ", stockId='" + stockId + '\'' +
                ", billPaymentId='" + billPaymentId + '\'' +
                '}';
    }

}
