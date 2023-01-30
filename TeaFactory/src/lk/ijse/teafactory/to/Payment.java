package lk.ijse.teafactory.to;

/**
 * author - kavindi
 * version - 1.0.0 12:22 AM 12/2/2022
 **/
public class Payment {
    private String paymentId;
    private double total;

    public Payment() {
    }

    public Payment(String paymentId, double total) {
        this.paymentId = paymentId;
        this.total = total;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId='" + paymentId + '\'' +
                ", total=" + total +
                '}';
    }
}
