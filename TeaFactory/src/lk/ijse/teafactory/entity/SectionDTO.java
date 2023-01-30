package lk.ijse.teafactory.entity;

/**
 * author - kavindi
 * version - 1.0.0 10:16 AM 1/29/2023
 **/
public class SectionDTO {
    private String sectionCode;
    private String sectionName;
    private String productCode;

    public SectionDTO() {
    }

    public SectionDTO(String sectionCode, String sectionName, String productCode) {
        this.sectionCode = sectionCode;
        this.sectionName = sectionName;
        this.productCode = productCode;
    }

    public String getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(String sectionCode) {
        this.sectionCode = sectionCode;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Override
    public String toString() {
        return "Section{" +
                "sectionCode='" + sectionCode + '\'' +
                ", sectionName='" + sectionName + '\'' +
                ", productCode='" + productCode + '\'' +
                '}';
    }


}
