/*
 * Author: Ana Umana
 * CMSC 215 Project 1
 * Date: 08/24/25
 * 
 * This class is used to find the tallest basketball player whose age is less than or equal to the average of all the players.
 */

 public final class Height {
    private final int feet;
    private final int inches;

    //Constructor to help get the values for inc and feet
    public Height(int feet, int inches) {
        int inchTotal = feet * 12 + inches;
        this.feet = inchTotal / 12;
        this.inches = inchTotal % 12;
    }

    //Now comstructor to go from height to total inches
    public int toInches() {
        return feet * 12 + inches;
    }

    //Finally format the height to be accurate
    @Override
    public String toString() {
        return feet + "' " + inches + "\"";
    }
 }