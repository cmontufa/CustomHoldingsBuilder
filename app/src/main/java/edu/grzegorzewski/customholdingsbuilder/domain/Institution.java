package edu.grzegorzewski.customholdingsbuilder.domain;

/**
 * Created by Christopher Montufar on 11/26/16.
 */
public class Institution {

    private String name;
    private String id;
    private String institutionId;
    private String supplier;
    private String daysToRespond;
    private String loanDaysToRespond;
    private String copyDaysToRespond;
    private String symbol;
    private String country;
    private String location;
    private Float loanFees;
    private Float copyFees;
    private String sourceState;
    private String targetState;
    private Integer zone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getDaysToRespond() {
        return daysToRespond;
    }

    public void setDaysToRespond(String daysToRespond) {
        this.daysToRespond = daysToRespond;
    }

    public String getLoanDaysToRespond() {
        return loanDaysToRespond;
    }

    public void setLoanDaysToRespond(String loanDaysToRespond) {
        this.loanDaysToRespond = loanDaysToRespond;
    }

    public String getCopyDaysToRespond() {
        return copyDaysToRespond;
    }

    public void setCopyDaysToRespond(String copyDaysToRespond) {
        this.copyDaysToRespond = copyDaysToRespond;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Float getLoanFees() {
        return loanFees;
    }

    public void setLoanFees(Float loanFees) {
        this.loanFees = loanFees;
    }

    public Float getCopyFees() {
        return copyFees;
    }

    public void setCopyFees(Float copyFees) {
        this.copyFees = copyFees;
    }

    public String getSourceState() {
        return sourceState;
    }

    public void setSourceState(String sourceState) {
        this.sourceState = sourceState;
    }

    public String getTargetState() {
        return targetState;
    }

    public void setTargetState(String targetState) {
        this.targetState = targetState;
    }

    public Integer getZone() {
        return zone;
    }

    public void setZone(Integer zone) {
        this.zone = zone;
    }

    @Override
    public String toString() {
        return "Institution [instituion_id=" + id + ", name=" + name + ", supplier="
                + supplier  + ", days_to_respond=" + daysToRespond  + ", loan_days_to_respond=" + loanDaysToRespond +
                ", copy_days_to_respond=" + copyDaysToRespond  + ", symbol=" + symbol  + ", country=" + country +
                ", location=" + location  + ", loan_fees=" + loanFees  + ", copy_fees=" + copyFees  + ", source_state=" + sourceState +
                ", zone=" + zone + "]";
    }

}
