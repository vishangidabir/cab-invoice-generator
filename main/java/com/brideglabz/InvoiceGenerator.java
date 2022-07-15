package com.brideglabz;

public class InvoiceGenerator {
    
    private static final int COST_PER_TIME = 1;
    private static final double MINIMIM_COST_PER_KILOMETER = 10;
    private static final double MINIMIM_FARE = 5;

    public double calculateFare(double distance, int time) {

        double totalFare =  distance * MINIMIM_COST_PER_KILOMETER + time * COST_PER_TIME;
        return Math.max(totalFare, MINIMIM_FARE);
    }

    public InvoiceSummary calculateFare(Ride[] ride) {
        double totalFare = 0;
        for(Ride rides : ride ){
            totalFare += this.calculateFare(rides.distance, rides.time);
        }
        return new InvoiceSummary(ride.length, totalFare);
    }
}

