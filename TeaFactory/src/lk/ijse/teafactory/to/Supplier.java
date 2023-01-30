package lk.ijse.teafactory.to;

/**
 * author - kavindi
 * version - 1.0.0 8:11 PM 11/27/2022
 **/
public class Supplier {
    private String supplierId;
    private String supplierName;
    private String description;
    private int qty;

    public Supplier() {
    }

    public Supplier(String supplierId, String supplierName, String description, int qty) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.description = description;
        this.qty = qty;
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

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId='" + supplierId + '\'' +
                ", supplierName='" + supplierName + '\'' +
                ", description='" + description + '\'' +
                ", qty=" + qty +
                '}';
    }
}
