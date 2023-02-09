package lk.ijse.teafactory.model;

/**
 * author - kavindi
 * version - 1.0.0 10:23 AM 1/29/2023
 **/
public class SupplierDTO {
    private String supplierId;
    private String supplierName;
    private String description;
    private int qauntity;

    public SupplierDTO() {
    }

    public SupplierDTO(String supplierId, String supplierName, String description, int qauntity) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.description = description;
        this.qauntity = qauntity;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQauntity() {
        return qauntity;
    }

    public void setQauntity(int qauntity) {
        this.qauntity = qauntity;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId='" + supplierId + '\'' +
                ", supplierName='" + supplierName + '\'' +
                ", description='" + description + '\'' +
                ", qauntity=" + qauntity +
                '}';
    }

}
