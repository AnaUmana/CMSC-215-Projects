/*
 * Author: Ana Umana
 * CMSC 215 Project 4
 * Date: 10/05/2025
 * This class will have the time in a specific format
 * 
 */

public class Time implements Comparable<Time> {
    private final int hours;
    private final int minutes;
    private final String meridian;

    //Constructors
    public Time(int hours, int minutes, String meridian) throws InvalidTime {
        if(hours < 1 || hours > 12)
            throw new InvalidTime("Hour must be between 1 and 12");
        if (minutes < 0 || minutes > 59)
            throw new InvalidTime("Minutes must be between 0 and 59");
        if (!meridian.equalsIgnoreCase("AM") && !meridian.equalsIgnoreCase("PM"))
            throw new InvalidTime("Meridian must be AM or PM");

        this.hours = hours;
        this.minutes = minutes;
        this.meridian = meridian.toUpperCase();
    }

     public Time(String timeStr) throws InvalidTime {
        try {
            timeStr = timeStr.trim();
            String[] parts = timeStr.split(" ");
            if (parts.length != 2)
                throw new InvalidTime("Invalid time format, must include AM/PM");

            String[] hm = parts[0].split(":");
            int h = Integer.parseInt(hm[0]);
            int m = Integer.parseInt(hm[1]);
            String mer = parts[1];

            if (h < 1 || h > 12)
                throw new InvalidTime("Hour must be between 1 and 12");
            if (m < 0 || m > 59)
                throw new InvalidTime("Minutes must be between 0 and 59");
            if (!mer.equalsIgnoreCase("AM") && !mer.equalsIgnoreCase("PM"))
                throw new InvalidTime("Meridian must be AM or PM");

            this.hours = h;
            this.minutes = m;
            this.meridian = mer.toUpperCase();
        } catch (NumberFormatException e) {
            throw new InvalidTime("Hours and minutes must be numeric");
        }
    }

    @Override
    public int compareTo(Time other) {
        int this24 = to24Hour();
        int other24 = other.to24Hour();

        if (this24 != other24)
            return Integer.compare(this24, other24);
        return Integer.compare(this.minutes, other.minutes);
    }

    private int to24Hour() {
        int h = hours;
        if (meridian.equals("AM") && h == 12) h = 0;
        if (meridian.equals("PM") && h != 12) h += 12;
        return h;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d %s", hours, minutes, meridian);
    }
    
}
