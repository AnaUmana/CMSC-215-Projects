/*
 * Author: Ana Umana
 * CMSC 215 Project 1
 * Date: 08/24/25
 * 
 * This final class will collect all the given information, get the average age and find who is the tallest.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Project1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {  // <-- FIXED HERE
            ArrayList<Player> players = new ArrayList<>();
            int ageTotal = 0;

            //Start the loop
            while (true) {
                System.out.print("Enter player's name, age, and height in feet and inches: ");
                String line = scanner.nextLine().trim();

                if (line.isEmpty()) {
                    break;
                }

                //This will be used to try and prevent error
                String[] parts = line.split("\\s+");
                if (parts.length != 4) {
                    System.out.println("Invalid input. Please enter: Name Age Feet Inches");
                    continue;
                }

                String name = parts[0];
                int age = Integer.parseInt(parts[1]);
                int feet = Integer.parseInt(parts[2]);
                int inches = Integer.parseInt(parts[3]);

                Height height = new Height(feet, inches);
                Player player = new Player(name, height, age);
                players.add(player);

                ageTotal += age;
            }

            // This code will output if no player was input into the list
            if (players.isEmpty()) {
                System.out.println("No player data entered.");
                return;
            }

            //Average age
            double averageAge = (double) ageTotal / players.size();
            System.out.printf("Average age of players: %.2f%n", averageAge);

            //Finally finding the Tallest
            Player tallest = null;
            for (Player p : players) {
                if (p.getAge() <= averageAge) {
                    if (tallest == null || p.getHeight().toInches() > tallest.getHeight().toInches()) {
                        tallest = p;
                    }
                }
            }

            if (tallest != null) {
                System.out.println("Tallest player whose age is less than the average is:");
                System.out.println(tallest);
            } else {
                System.out.println("No player has age less than or equal to the average.");
            }
        } // <-- scanner is auto-closed here
    }
}
