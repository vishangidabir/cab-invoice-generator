package com.brideglabz;

public class InvoiceSummary {

    private int numOfRides;
    private double totalFare;
    private double averageFare;

    public InvoiceSummary() {

    }

    public InvoiceSummary(int numOfRides, double totalFare) {
        this.numOfRides = numOfRides;
        this.totalFare = totalFare;
    }

    public InvoiceSummary(int numOfRides, double totalFare, String type) {
        this.numOfRides = numOfRides;
        this.totalFare = totalFare;
    }

    public InvoiceSummary getInvoiceSummary() {
        this.averageFare = this.totalFare / this.numOfRides;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return numOfRides == that.numOfRides &&
                Double.compare(that.totalFare, totalFare) == 0 &&
                Double.compare(that.averageFare, averageFare) == 0;
    }

}
