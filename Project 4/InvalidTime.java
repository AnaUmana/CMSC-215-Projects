/*
 * Author: Ana Umana
 * CMSC 215 Project 4
 * Date: 10/05/2025
 * this class will be the invalid time exceptions.
 * 
 */

public class InvalidTime extends Exception {
    private final String message;

    public InvalidTime(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
