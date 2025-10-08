/*
 * Author: Ana Umana
 * CMSC 215 Project 2
 * Date: 09/07/2025
 * 
 * This class will have the student's name, credit hours earned and quality points.
 */


public class Student {
    private final String name;
    private final int creditHours;
    private final int qualityPoints;
    private static double gpaThreshold;

    public Student(String name, int creditHours, int qualityPoints) {
        this.name = name;
        this.creditHours = creditHours;
        this.qualityPoints = qualityPoints; // ✅ fixed typo
    }

    public double gpa() {
        return (double) qualityPoints / creditHours;
    }

    public boolean eligibleForHonorSociety() {
        return gpa() >= gpaThreshold;
    }

    public static void setGpaThreshold(double threshold) {
        gpaThreshold = threshold;
    }

    @Override
    public String toString() {
        return name + " - GPA: " + String.format("%.2f", gpa());
    }
}
