package lk.ijse.teafactory.tdm;

/**
 * author - kavindi
 * version - 1.0.0 4:05 PM 11/27/2022
 **/
public class Product {
    private String productCode;
    private String description;
    private double unitPrice;
    private int qtyOnHand;

    public Product() {
    }

    public Product(String productCode, String description, double unitPrice, int qtyOnHand) {
        this.productCode = productCode;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qtyOnHand = qtyOnHand;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getDescription() {
        return description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setDescription(String description) {
        this.description = description;
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
