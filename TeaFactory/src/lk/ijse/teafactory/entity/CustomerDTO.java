package lk.ijse.teafactory.entity;

/**
 * author - kavindi
 * version - 1.0.0 9:32 AM 1/29/2023
 **/
public class CustomerDTO {
   private String customerId;
   private String customerName;
   private String contact;



   public CustomerDTO(String customerId, String customerName, String contact) {
      this.customerId = customerId;
      this.customerName = customerName;
      this.contact = contact;
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

   public String getContact() {
      return contact;
   }

   public void setContact(String contact) {
      this.contact = contact;
   }

   @Override
   public String toString() {
      return "customer{" +
              "customerId='" + customerId + '\'' +
              ", customerName='" + customerName + '\'' +
              ", contact='" + contact + '\'' +
              '}';
   }


}
