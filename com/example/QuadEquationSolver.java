package com.example;

import java.util.Scanner;

/**
 * A game that solves quadratic equations for not just 0 but every value of y.
 * 
 * @author Tamer
 * @version 1.0
 * @since 2024-03-20
 */

public class QuadEquationSolver {

    // ANSI escape codes for colored text
    // Background
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    // Reset
    public static final String ANSI_RESET = "\u001B[0m";
    // Colors
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    // Method to calculate quadratic roots
    public static Double[] calculateQuadraticRoots(Double a, Double b, Double c) {
        // Find Discriminant to make sure that no negative roots occur.
        double discriminant = b * b - 4 * a * c;
        // Check if Discriminant is Positive
        if (discriminant >= 0) {
            // Calculate roots
            double firstRoot = (-b + Math.sqrt(discriminant)) / (2 * a);
            double secondRoot = (-b - Math.sqrt(discriminant)) / (2 * a);
            // Return roots as array
            return new Double[]{firstRoot, secondRoot};
        } else {
            // No real roots
            return null;
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Display introductory message
        System.out.println(ANSI_BLACK_BACKGROUND + ANSI_RED + "\n\n\n\n\n\n\n\n\n\nThis program calculates the roots of a quadratic equation (f(x) = ax^2 + bx + c)!" + ANSI_RESET);
        // Prompt user to continue or quit
        System.out.println("Enter 'q' to quit, any other key to continue.");
        String quitResponse = sc.nextLine();
        // Loop until user decides to quit
        while (!quitResponse.equals("q")) {
            try {
                // Input coefficients and equated value
                // Output to Console, ask for a, and get input.
                System.out.print(ANSI_YELLOW + "Enter the value of a: " + ANSI_RESET);
                double a = sc.nextDouble();
                // Output to Console, ask for b, and get input.
                System.out.print(ANSI_YELLOW + "Enter the value of b: " + ANSI_RESET);
                double b = sc.nextDouble();
                // Output to Console, ask for c, and get input.
                System.out.print(ANSI_YELLOW + "Enter the value of c: " + ANSI_RESET);
                double c = sc.nextDouble();
                // What is the y value of the equation set to? Get input..
                System.out.print(ANSI_YELLOW + "What is the equation equated to? (value of f(x)): " + ANSI_RESET);
                double equatedTo = sc.nextDouble();
                c += -equatedTo; // Adjusting for equation equated to value
                // Check if the equation is quadratic
                if (a == 0d) {
                    System.out.println("Your equation must be a quadratic equation where (a) cannot equal zero.");
                    break;
                }
                // Calculate roots
                Double[] roots = calculateQuadraticRoots(a, b, c);
                if (roots != null) {
                    // Display roots
                    System.out.println(ANSI_GREEN + "The roots of the equation " + a + "x^2 + " + b + "x + " + c
                            + " are:" + ANSI_RESET);
                    for (Double root : roots) {
                        System.out.println(root);
                    }
                } else {
                    // No real roots
                    System.out.println(ANSI_RED + "No real Solutions" + ANSI_RESET);
                }
                // Prompt user to continue or quit
                System.out.println(
                        "\n\n\n\n\n\n\n" + ANSI_RED + "Enter 'q' to quit, any other key to continue." + ANSI_RESET);
                sc.nextLine(); // Consume newline left-over
                quitResponse = sc.nextLine(); // Read user response

            } catch (Exception e) {
                // Handle exceptions
                System.out.println("Error: " + e.getMessage());
                break;
            }

        }
        sc.close(); // Close scanner
    }
}
