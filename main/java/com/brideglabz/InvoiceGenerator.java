package com.brideglabz;

public class InvoiceGenerator {
    private static final int COST_PER_TIME = 1;
    private static final double MINIMIM_COST_PER_KILOMETER = 10;

    public double calculateFare(double distance, int time) {

        return distance * MINIMIM_COST_PER_KILOMETER + time * COST_PER_TIME;
    }
}
