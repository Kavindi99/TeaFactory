package lk.ijse.teafactory.to;

/**
 * author - kavindi
 * version - 1.0.0 11:04 AM 11/25/2022
 **/
public class Customer {
    private String customerId;
    private String customerName;
    private int contact;

    public Customer() {
    }

    public Customer(String customerId, String customerName, int contact) {
        this.setCustomerId(customerId);
        this.setCustomerName(customerName);
        this.setContact(contact);
    }


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", contact=" + contact +
                '}';
    }

}
