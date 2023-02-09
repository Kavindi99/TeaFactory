package lk.ijse.teafactory.model;

/**
 * author - kavindi
 * version - 1.0.0 10:20 AM 1/29/2023
 **/
public class StockDTO {
    private String stockId;
    private String stockName;
    private String sectionCode;

    public StockDTO() {
    }

    public StockDTO(String stockId, String stockName, String sectionCode) {
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
        return "Stock{" +
                "stockId='" + stockId + '\'' +
                ", stockName='" + stockName + '\'' +
                ", sectionCode='" + sectionCode + '\'' +
                '}';
    }

}
