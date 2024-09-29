package model;

public class PgDetail {
    private String pgName;
    private String totalBeds;
    private String pgFor;
    private String commonArea;
    private String propertyManager;
    private String amenities;
    private String pgFees;
    private String pgImg;

    public PgDetail() {
        
    }

    public PgDetail(String pgName, String totalBeds, String pgFor, String commonArea, String propertyManager,
            String amenities, String pgFees) {
        this.pgName = pgName;
        this.totalBeds = totalBeds;
        this.pgFor = pgFor;
        this.commonArea = commonArea;
        this.propertyManager = propertyManager;
        this.amenities = amenities;
        this.pgFees = pgFees;
    }

    public String getPgName() {
        return pgName;
    }

    public void setPgName(String pgName) {
        this.pgName = pgName;
    }

    public String getTotalBeds() {
        return totalBeds;
    }

    public void setTotalBeds(String totalBeds) {
        this.totalBeds = totalBeds;
    }

    public String getPgFor() {
        return pgFor;
    }

    public void setPgFor(String pgFor) {
        this.pgFor = pgFor;
    }

    public String getCommonArea() {
        return commonArea;
    }

    public void setCommonArea(String commonArea) {
        this.commonArea = commonArea;
    }

    public String getPropertyManager() {
        return propertyManager;
    }

    public void setPropertyManager(String propertyManager) {
        this.propertyManager = propertyManager;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public String getPgFees() {
        return pgFees;
    }

    public void setPgFees(String pgFees) {
        this.pgFees = pgFees;
    }

    public String getPgImg() {
        return pgImg;
    }

    public void setPgImg(String pgImg) {
        this.pgImg = pgImg;
    }

    @Override
    public String toString() {
        return "pgDetail [pgName=" + pgName + ", totalBeds=" + totalBeds + ", pgFor=" + pgFor + ", commonArea="
                + commonArea + ", propertyManager=" + propertyManager + ", amenities=" + amenities + ", pgFees="
                + pgFees + ", pgImg=" + pgImg + "]";
    }

}