/*
 * Author: Ana Umana
 * CMSC 215 Project 2
 * Date: 09/07/2025
 *
 * Represents a graduate student (Masters or Doctorate).
 * Only Masters students are eligible for honor society consideration.
 */

public class Graduate extends Student {
    private final String degree;

    public Graduate(String name, int creditHours, int qualityPoints, String degree) {
        super(name, creditHours, qualityPoints);
        this.degree = degree;
    }

    @Override
    public boolean eligibleForHonorSociety() {
        return super.eligibleForHonorSociety() &&
               degree.equalsIgnoreCase("Masters");
    }

    @Override
    public String toString() {
        return super.toString() + " (" + degree + ")";
    }
}
