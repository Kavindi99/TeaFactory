package lk.ijse.teafactory.model;

/**
 * author - kavindi
 * version - 1.0.0 10:04 AM 1/29/2023
 **/
public class PaymentDTO {
    private String paymentId;
    private double totalPrice;

    public PaymentDTO() {
    }

    public PaymentDTO(String paymentId, double totalPrice) {
        this.paymentId = paymentId;
        this.totalPrice = totalPrice;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId='" + paymentId + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }

}
