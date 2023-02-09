package lk.ijse.teafactory.model;

/**
 * author - kavindi
 * version - 1.0.0 10:07 AM 1/29/2023
 **/
public class ProductDTO {
    private String productCode;
    private String description;
    private double unitPrice;
    private int qtyOnHand;

    public ProductDTO() {
    }

    public ProductDTO(String productCode, String description, double unitPrice, int qtyOnHand) {
        this.productCode = productCode;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qtyOnHand = qtyOnHand;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
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

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode='" + productCode + '\'' +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                ", qtyOnHand=" + qtyOnHand +
                '}';
    }


}
