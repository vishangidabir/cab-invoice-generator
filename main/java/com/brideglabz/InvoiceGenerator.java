package com.brideglabz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvoiceGenerator {

    public static Map<String, List<Ride>> account = new HashMap<>();
    public static final double MINIMUM_COST_PER_KILOMETER_PREMIUM = 15;
    public static final double COST_PER_TIME_PREMIUM = 2;
    public static final double MINIMUM_FARE_PREMIUM = 20;
    private static int COST_PER_TIME = 1;
    private static double MINIMIM_COST_PER_KILOMETER = 10;
    private static double MINIMUM_FARE = 5;

    public double calculateFare(double distance, int time) {

        double totalFare = distance * MINIMIM_COST_PER_KILOMETER + time * COST_PER_TIME;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    public InvoiceSummary calculateFare(Ride[] ride) {
        double totalFare = 0;
        for (Ride rides : ride) {
            totalFare += this.calculateFare(rides.distance, rides.time);
        }
        return new InvoiceSummary(ride.length, totalFare);
    }

    public InvoiceSummary getInvoice(int userId) {
        Map<Integer, Ride[]> map = new HashMap<>();
        Ride[] rides1 = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        Ride[] rides2 = {new Ride(5.0, 10),
                new Ride(1, 1)
        };
        map.put(1, rides1);
        map.put(2, rides2);

        for (Map.Entry<Integer, Ride[]> entry : map.entrySet()) {
            if (userId == entry.getKey()) {
                System.out.println(entry.getKey());
                Ride[] ridesArray = entry.getValue();
                return calculateFare(ridesArray);
            }
        }
        return null;
    }

    public double calculateFare(double distance, int time, String type) {

        if (type.equalsIgnoreCase("Normal")) {
            double totalFare = distance * MINIMIM_COST_PER_KILOMETER + time * COST_PER_TIME;
            return Math.max(totalFare, MINIMUM_FARE);
        } else if (type.equalsIgnoreCase("Premium")) {
            double totalFare = distance * MINIMUM_COST_PER_KILOMETER_PREMIUM + time * COST_PER_TIME_PREMIUM;
            return Math.max(totalFare, MINIMUM_FARE_PREMIUM);
        } else {
            System.out.println("Please Enter Proper Customer Type");
            return 0.0;
        }
    }

    public double calculateFare(Ride[] rides, String type) {
        double totalFare = 0.0;
        if (type.equalsIgnoreCase("Normal")) {
            for (Ride ride : rides) {
                totalFare += calculateFare(ride.getDistance(), ride.getTime(), type);
            }
            return totalFare;

        } else if (type.equalsIgnoreCase("Premium")) {
            for (Ride ride : rides) {
                totalFare += calculateFare(ride.getDistance(), ride.getTime(), type);

            }
            return totalFare;
        } else
            System.out.println("Please Enter Proper Customer Type");
        return 0.0;
    }

    public InvoiceSummary calculateTotalFare(Ride[] rides, String type) {
        double totalFare = 0.0;
        if (type.equalsIgnoreCase("Normal")) {
            for (Ride ride : rides) {
                totalFare += calculateFare(ride.getDistance(), ride.getTime(), type);
            }
        } else if (type.equalsIgnoreCase("Premium")) {
            for (Ride ride : rides) {
                totalFare += calculateFare(ride.getDistance(), ride.getTime(), type);
            }
        }
        return new InvoiceSummary(rides.length, totalFare);
    }
}