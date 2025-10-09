/*
 * Author: Ana Umana
 * CMSC 215 Project 4
 * Date: 10/05/2025
 * This file is used see if the input is within the intervals and supports comparisons.
 * 
 */

public class Interval<T extends Comparable<T>> {
    private final T start;
    private final T end;

    //Now start with constructors
    public Interval(T start, T end) {
        if (start.compareTo(end) > 0)
            throw new IllegalArgumentException("Start must be before end");
        this.start = start;
        this.end = end;
    }

    //say true if its within the intervals
    public boolean within(T value) {
        return value.compareTo(start) >= 0 && value.compareTo(end) <= 0;
    }

    public boolean subinterval(Interval<T> other) {
        return other.start.compareTo(this.start) >= 0 && other.end.compareTo(this.end) <= 0;
    }

    public boolean overlaps(Interval<T> other) {
        return this.start.compareTo(other.end) <= 0 && other.start.compareTo(this.end) <= 0;
    }

    //Finally getters
    public T getStarted() { return start; }
    public T getEnd() { return end;} 
}
