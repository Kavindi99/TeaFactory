package lk.ijse.teafactory.model;

/**
 * author - kavindi
 * version - 1.0.0 10:00 AM 1/29/2023
 **/
public class BillPaymentDTO {
    private String billPaymentId;
    private double totalPrice;

    public BillPaymentDTO() {
    }

    public BillPaymentDTO(String billPaymentId, double totalPrice) {
        this.billPaymentId = billPaymentId;
        this.totalPrice = totalPrice;
    }

    public String getBillPaymentId() {
        return billPaymentId;
    }

    public void setBillPaymentId(String billPaymentId) {
        this.billPaymentId = billPaymentId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "BillPayment{" +
                "billPaymentId='" + billPaymentId + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }


}
