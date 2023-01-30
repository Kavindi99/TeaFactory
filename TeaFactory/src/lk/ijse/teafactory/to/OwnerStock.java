package lk.ijse.teafactory.to;

/**
 * author - kavindi
 * version - 1.0.0 1:37 AM 11/29/2022
 **/
public class OwnerStock {
    private String stockId;
    private String stockName;
    private String sectionCode;

    public OwnerStock() {
    }

    public OwnerStock(String stockId, String stockName, String sectionCode) {
        this.stockId = stockId;
        this.stockName = stockName;
        this.sectionCode = sectionCode;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(String sectionCode) {
        this.sectionCode = sectionCode;
    }

    @Override
    public String toString() {
        return "OwnerStock{" +
                "stockId='" + stockId + '\'' +
                ", stockName='" + stockName + '\'' +
                ", sectionCode='" + sectionCode + '\'' +
                '}';
    }
}
