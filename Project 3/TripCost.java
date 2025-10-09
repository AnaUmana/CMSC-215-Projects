/*
 * Author: Ana Umana
 * CMSC 215 Project 3
 * Date: 09/20/2025
 * 
 * Is the immutable class that computes the total.
 */



public final class TripCost {

    public static final double KILOMETERS_PER_MILE = 1.609347;
    public static final double LITERS_PER_GALLON = 3.78541178;
    public static final double MILES_PER_GALLON_PER_KPL = LITERS_PER_GALLON / KILOMETERS_PER_MILE;

    //immutable items
    private final double distantMiles;
    private final double gasCostPerGallon;
    private final double milageMpg;
    private final double hotelCost;
    private final double foodCost;
    private final int numDays;
    private final double attractions;

    //This is a constructor that will be able to store all trip data
    public TripCost(double distanceMiles, double gasCostPerGallon, double mileageMpg, double hotelCost, double foodCost, int numDays, double attractions) {
        this.distantMiles = distanceMiles;
        this.gasCostPerGallon = gasCostPerGallon;
        this.milageMpg = mileageMpg;
        this.hotelCost = hotelCost;
        this.foodCost = foodCost;
        this.numDays = numDays;
        this.attractions = attractions;
    }

    //Now computes the cost to output it
    public double computeTotalCost() {
        double fuelCost = (distantMiles / milageMpg) * gasCostPerGallon;
        double livingCost = (hotelCost + foodCost) * numDays;
        return fuelCost + livingCost + attractions;
    }
}
