package com.brideglabz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {
    InvoiceGenerator invoiceGenerator = null;

    @Before
    public void setUp() throws Exception {
        invoiceGenerator = new InvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTime_shouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenLessDistanceOrTime_shouldReturnTotalFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_shouldReturnInvoiceSummary() {
        Ride[] ride = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceSummary summary = invoiceGenerator.calculateFare(ride);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void givenUserId_ShouldReturnInvoiceSummary() {
        InvoiceSummary invoiceSummary = invoiceGenerator.getInvoice(1);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary.getInvoiceSummary(), invoiceSummary.getInvoiceSummary());
    }

    @Test
    public void givenDistanceAndTime_WhenNormal_ShouldReturnTotalFare() {

        double distance = 2.0;
        int time = 5;
        String type = "normal";
        double fare = invoiceGenerator.calculateFare(distance, time, type);
        Assert.assertEquals(25, fare, 0.0);

    }

    @Test
    public void givenLessDistanceAndTime_WhenNormal_ShouldReturnMinFare() {

        double distance = 0.1;
        int time = 1;
        String type = "normal";
        double fare = invoiceGenerator.calculateFare(distance, time, type);
        Assert.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_WhenNormal_ShouldReturnTotalFare() {

        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        String type = "normal";
        double totalFare = invoiceGenerator.calculateFare(rides, type);
        Assert.assertEquals(30.0, totalFare, 0.0);
    }

    @Test
    public void givenDistanceAndTime_WhenPremium_ShouldReturnTotalFare() {

        double distance = 2.0;
        int time = 5;
        String type = "premium";
        double fare = invoiceGenerator.calculateFare(distance, time, type);
        Assert.assertEquals(40, fare, 0.0);

    }

    @Test
    public void givenLessDistanceAndTime_WhenPremium_ShouldReturnMinFare() {

        double distance = 0.1;
        int time = 1;
        String type = "premium";
        double fare = invoiceGenerator.calculateFare(distance, time, type);
        Assert.assertEquals(20, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_WhenPremium_ShouldReturnTotalFare() {

        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        String type = "premium";
        double totalFare = invoiceGenerator.calculateFare(rides, type);
        Assert.assertEquals(60, totalFare, 0.0);
    }

    @Test
    public void givenMultipleRides_WhenNormal_ShouldReturnInvoiceSummary() {
        String type = "Normal";
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1),
        };
        InvoiceSummary invoiceSummary = invoiceGenerator.calculateTotalFare(rides, type);
        InvoiceSummary expectedInvoices = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoices.getInvoiceSummary(), invoiceSummary.getInvoiceSummary());
    }

    @Test
    public void givenMultipleRides_WhenPremium_ShouldReturnInvoiceSummary() {
        String type = "Premium";
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1),
        };
        InvoiceSummary invoiceSummary = invoiceGenerator.calculateTotalFare(rides, type);
        InvoiceSummary expectedInvoices = new InvoiceSummary(2, 60.0);
        Assert.assertEquals(expectedInvoices.getInvoiceSummary(), invoiceSummary.getInvoiceSummary());
    }
}
