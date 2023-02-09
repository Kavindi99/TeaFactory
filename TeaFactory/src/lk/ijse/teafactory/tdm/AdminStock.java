package lk.ijse.teafactory.tdm;

/**
 * author - kavindi
 * version - 1.0.0 12:06 AM 11/29/2022
 **/
public class AdminStock {
    private String stockId;
    private String stockName;
    private String sectionCode;

    public AdminStock() {
    }

    public AdminStock(String stockId, String stockName, String sectionCode) {
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
        return "AdminStock{" +
                "stockId='" + stockId + '\'' +
                ", stockName='" + stockName + '\'' +
                ", sectionCode='" + sectionCode + '\'' +
                '}';
    }
}
