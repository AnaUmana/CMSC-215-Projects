/*
 * Author: Ana Umana
 * CMSC 215 Project 4
 * Date: 10/05/2025
 * 
 * 
 */
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.*;

public class Project4 extends JFrame {
    private JTextField start1Field, end1Field, start2Field, end2Field, checkTimeField;
    private JButton compareButton, checkButton;
    private JLabel resultLabel;

    public Project4() {
        setTitle("Time Interval Checker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 230);
        setLocationRelativeTo(null);
        setResizable(false);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        //Headers
        gbc.gridx = 1; gbc.gridy = 0;
        panel.add(new JLabel("Start Time"), gbc);
        gbc.gridx = 2;
        panel.add(new JLabel("End Time"), gbc);

        //Interval 1
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Time Interval 1"), gbc);
        gbc.gridx = 1;
        start1Field = new JTextField(10);
        panel.add(start1Field, gbc);
        gbc.gridx = 2;
        end1Field = new JTextField(10);
        panel.add(end1Field, gbc);

        //Interval 2
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Time Interval 2"), gbc);
        gbc.gridx = 1;
        start2Field = new JTextField(10);
        panel.add(start2Field, gbc);
        gbc.gridx = 2;
        end2Field = new JTextField(10);
        panel.add(end2Field, gbc);

        //Compare button
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 3;
        compareButton = new JButton("Compare Intervals");
        panel.add(compareButton, gbc);

        //Time to check
        gbc.gridwidth = 1; gbc.gridy = 4; gbc.gridx = 0;
        panel.add(new JLabel("Time to Check"), gbc);
        gbc.gridx = 1;
        checkTimeField = new JTextField(10);
        panel.add(checkTimeField, gbc);

        //Check button
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 3;
        checkButton = new JButton("Check Time");
        panel.add(checkButton, gbc);

        // Result
        gbc.gridy = 6;
        resultLabel = new JLabel(" ");
        panel.add(resultLabel, gbc);

        add(panel);

        compareButton.addActionListener(e -> {
            try {
                LocalTime s1 = LocalTime.parse(start1Field.getText().toUpperCase(), formatter);
                LocalTime e1 = LocalTime.parse(end1Field.getText().toUpperCase(), formatter);
                LocalTime s2 = LocalTime.parse(start2Field.getText().toUpperCase(), formatter);
                LocalTime e2 = LocalTime.parse(end2Field.getText().toUpperCase(), formatter);

                if (e1.isBefore(s1) || e2.isBefore(s2)) {
                    resultLabel.setText("End time cannot be before start time.");
                } else if (s1.isBefore(e2) && s2.isBefore(e1)) {
                    resultLabel.setText("Intervals overlap.");
                } else {
                    resultLabel.setText("Intervals do not overlap.");
                }
            } catch (DateTimeParseException ex) {
                resultLabel.setText("Invalid time format. Use h:mm AM/PM");
            }
        });

        checkButton.addActionListener(e -> {
            try {
                LocalTime s1 = LocalTime.parse(start1Field.getText().toUpperCase(), formatter);
                LocalTime e1 = LocalTime.parse(end1Field.getText().toUpperCase(), formatter);
                LocalTime s2 = LocalTime.parse(start2Field.getText().toUpperCase(), formatter);
                LocalTime e2 = LocalTime.parse(end2Field.getText().toUpperCase(), formatter);
                LocalTime check = LocalTime.parse(checkTimeField.getText().toUpperCase(), formatter);

                boolean in1 = !check.isBefore(s1) && !check.isAfter(e1);
                boolean in2 = !check.isBefore(s2) && !check.isAfter(e2);

                String formattedCheck = check.format(formatter);

                if (in1 && in2) {
                    resultLabel.setText("Both intervals contain the time " + formattedCheck);
                } else if (in1) {
                    resultLabel.setText("Only interval 1 contains the time " + formattedCheck);
                } else if (in2) {
                    resultLabel.setText("Only interval 2 contains the time " + formattedCheck);
                } else {
                    resultLabel.setText("Neither interval contains the time " + formattedCheck);
                }

            } catch (DateTimeParseException ex) {
                resultLabel.setText("Invalid time format. Use h:mm AM/PM");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Project4().setVisible(true));
    }
}