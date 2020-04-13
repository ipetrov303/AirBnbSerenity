package com.qualityhouse.serenity.entities;


public class VacationDetails {

    private String destination;
    private String currency;
    private int daysFromNow;
    private int periodLength;
    private int adults;
    private int children;


    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getDaysFromNow() {
        return daysFromNow;
    }

    public void setDaysFromNow(int daysFromNow) {
        this.daysFromNow = daysFromNow;
    }

    public int getPeriodLength() {
        return periodLength;
    }

    public void setPeriodLength(int periodLength) {
        this.periodLength = periodLength;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

}
