/*
 * Author: Ana Umana
 * CMSC 215 Project 3
 * Date: 09/20/2025
 * 
 * GUI interface for a road trip cost estimator.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Project3 extends JFrame {

    //Fields used
     private JTextField distanceField, gasCostField, mileageField, hotelField, foodField, daysField, attractionsField;
     private JComboBox<String> distanceUnits, gasCostUnits, mileageUnits;
    private JTextField resultField;

    public Project3() {
        setTitle("Road Trip Cost Estimator");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(9, 3, 5, 5));

        // Distance
        add(new JLabel("Distance:"));
        distanceField = new JTextField();
        add(distanceField);
        distanceUnits = new JComboBox<>(new String[]{"Miles", "Kilometers"});
        add(distanceUnits);

        // Gas cost
        add(new JLabel("Gas Cost:"));
        gasCostField = new JTextField();
        add(gasCostField);
        gasCostUnits = new JComboBox<>(new String[]{"$/Gallon", "$/Liter"});
        add(gasCostUnits);

        // Mileage
        add(new JLabel("Gas Mileage:"));
        mileageField = new JTextField();
        add(mileageField);
        mileageUnits = new JComboBox<>(new String[]{"MPG", "Km/L"});
        add(mileageUnits);

        // Hotel cost
        add(new JLabel("Hotel Cost (per day):"));
        hotelField = new JTextField();
        add(hotelField);
        add(new JLabel(""));

        // Food cost
        add(new JLabel("Food Cost (per day):"));
        foodField = new JTextField();
        add(foodField);
        add(new JLabel(""));

        // Number of days
        add(new JLabel("Number of Days:"));
        daysField = new JTextField();
        add(daysField);
        add(new JLabel(""));

        // Attractions cost
        add(new JLabel("Attractions Cost:"));
        attractionsField = new JTextField();
        add(attractionsField);
        add(new JLabel(""));

        // Calculate button
        JButton calcButton = new JButton("Calculate");
        add(calcButton);

        // Result field
        add(new JLabel("Total Trip Cost:"));
        resultField = new JTextField();
        resultField.setEditable(false);
        add(resultField);

        // Action listener
        calcButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateTripCost();
            }
        });
    }

    private void calculateTripCost() {
        try {
            // get inputs
            double distance = Double.parseDouble(distanceField.getText());
            double gasCost = Double.parseDouble(gasCostField.getText());
            double mileage = Double.parseDouble(mileageField.getText());
            double hotel = Double.parseDouble(hotelField.getText());
            double food = Double.parseDouble(foodField.getText());
            int days = Integer.parseInt(daysField.getText());
            double attractions = Double.parseDouble(attractionsField.getText());

            // change the units
            if (distanceUnits.getSelectedItem().equals("Miles") &&
                mileageUnits.getSelectedItem().equals("Km/L")) {
                // convert miles to km
                distance *= TripCost.KILOMETERS_PER_MILE;
            }

            if (distanceUnits.getSelectedItem().equals("Kilometers") &&
                mileageUnits.getSelectedItem().equals("MPG")) {
                // convert km to miles
                distance /= TripCost.KILOMETERS_PER_MILE;
            }

            // Now make mileage and gas cost compatible
            if (mileageUnits.getSelectedItem().equals("MPG") &&
                gasCostUnits.getSelectedItem().equals("$/Liter")) {
                // convert $/L → $/Gallon
                gasCost *= TripCost.LITERS_PER_GALLON;
            }

            if (mileageUnits.getSelectedItem().equals("Km/L") &&
                gasCostUnits.getSelectedItem().equals("$/Gallon")) {
                // convert $/Gallon → $/L
                gasCost /= TripCost.LITERS_PER_GALLON;
            }

            TripCost trip = new TripCost(distance, gasCost, mileage, hotel, food, days, attractions);
            double total = trip.computeTotalCost();

            // result
            resultField.setText(String.format("$%.2f", total));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Project3().setVisible(true);
        });
    }
}

