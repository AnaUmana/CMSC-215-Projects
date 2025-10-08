/*
 * Author: Ana Umana
 * CMSC 215 Project 2
 * Date: 09/07/2025
 * 
 * This class will see if the student is a freshman, sophmore, junior, or senior. But only looks for the Freshman and sophmores
 */


public class Undergraduate extends Student {
    private final String year;

    public Undergraduate(String name, int creditHours, int qualityPoints, String year) {
        super(name, creditHours, qualityPoints);
        this.year = year;
    }

    @Override
    public boolean eligibleForHonorSociety() {
        return super.eligibleForHonorSociety() &&
               (year.equalsIgnoreCase("Junior") || year.equalsIgnoreCase("Senior"));
    }

    @Override
    public String toString() {
        return super.toString() + " (" + year + ")";
    }
}