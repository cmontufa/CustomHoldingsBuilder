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
    private String loanFees;
    private String copyFees;
    private String searchParams;

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

    public String getLoanFees() {
        return loanFees;
    }

    public void setLoanFees(String loanFees) {
        this.loanFees = loanFees;
    }

    public String getCopyFees() {
        return copyFees;
    }

    public void setCopyFees(String copyFees) {
        this.copyFees = copyFees;
    }

    public String getSearchParams() {
        return searchParams;
    }

    public void setSearchParams(String searchParams) {
        this.searchParams = searchParams;
    }

    @Override
    public String toString() {
        return "Institution [instituion_id=" + id + ", name=" + name + ", supplier="
                + supplier  + ", days_to_respond=" + daysToRespond  + ", loan_days_to_respond=" + loanDaysToRespond +
                ", copy_days_to_respond=" + copyDaysToRespond  + ", symbol=" + symbol  + ", country=" + country +
                ", location=" + location  + ", loan_fees=" + loanFees  + ", copy_fees=" + copyFees  + ", search_params=" + searchParams +"]";
    }

}
