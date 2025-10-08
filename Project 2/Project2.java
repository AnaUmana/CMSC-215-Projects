/*
 * Author: Ana Umana
 * CMSC 215 Project 2
 * Date: 09/07/2025
 * 
 * The main class will now run all the classes together 
 */


import java.io.*;
import java.util.*;

public class Project2 {
    @SuppressWarnings({"ConvertToTryWithResources", "UseSpecificCatch"})
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        double gpaSum = 0.0;
        int count = 0;

         try {
            // Get the folder where the compiled .class file is located
            String path = Project2.class.getProtectionDomain()
                                         .getCodeSource()
                                         .getLocation()
                                         .toURI()
                                         .getPath();

            // Build the File object for students.txt in the same folder
            File file = new File(path, "students.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(" ");
                String lastField = parts[parts.length - 1];
                int qualityPoints = Integer.parseInt(parts[parts.length - 2]);
                int creditHours = Integer.parseInt(parts[parts.length - 3]);

                // Build name from all parts except the last three
                StringBuilder nameBuilder = new StringBuilder();
                for (int i = 0; i < parts.length - 3; i++) {
                    if (i > 0) nameBuilder.append(" ");
                    nameBuilder.append(parts[i]);
                }
                String name = nameBuilder.toString();

                Student student;
                if (lastField.equalsIgnoreCase("Freshman") ||
                    lastField.equalsIgnoreCase("Sophomore") ||
                    lastField.equalsIgnoreCase("Junior") ||
                    lastField.equalsIgnoreCase("Senior")) {
                    student = new Undergraduate(name, creditHours, qualityPoints, lastField);
                } else {
                    student = new Graduate(name, creditHours, qualityPoints, lastField);
                }

                students.add(student);
                gpaSum += student.gpa();
                count++;
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: students.txt file not found in the program folder.");
            return;
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            return;
        }

        double avgGpa = gpaSum / count;
        double threshold = (avgGpa + 4.0) / 2.0;
        Student.setGpaThreshold(threshold);

        System.out.printf("Honor Society GPA Threshold: %.2f%n", threshold);
        System.out.println("Eligible Students:");
        for (Student s : students) {
            if (s.eligibleForHonorSociety()) {
                System.out.println(s);
            }
        }
    }
}