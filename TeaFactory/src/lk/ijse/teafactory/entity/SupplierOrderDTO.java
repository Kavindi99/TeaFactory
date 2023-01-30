package lk.ijse.teafactory.entity;

import java.util.Date;

/**
 * author - kavindi
 * version - 1.0.0 10:27 AM 1/29/2023
 **/
public class SupplierOrderDTO {
    private String supplierOrderId;
    private String description;
    private Date supOrderDate;
    private String supplierId;

    public SupplierOrderDTO() {
    }

    public SupplierOrderDTO(String supplierOrderId, String description, Date supOrderDate, String supplierId) {
        this.supplierOrderId = supplierOrderId;
        this.description = description;
        this.supOrderDate = supOrderDate;
        this.supplierId = supplierId;
    }

    public String getSupplierOrderId() {
        return supplierOrderId;
    }

    public void setSupplierOrderId(String supplierOrderId) {
        this.supplierOrderId = supplierOrderId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getSupOrderDate() {
        return supOrderDate;
    }

    public void setSupOrderDate(Date supOrderDate) {
        this.supOrderDate = supOrderDate;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    @Override
    public String toString() {
        return "SupplierOrder{" +
                "supplierOrderId='" + supplierOrderId + '\'' +
                ", description='" + description + '\'' +
                ", supOrderDate=" + supOrderDate +
                ", supplierId='" + supplierId + '\'' +
                '}';
    }

}
