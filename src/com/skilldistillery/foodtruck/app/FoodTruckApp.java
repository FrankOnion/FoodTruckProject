package com.skilldistillery.foodtruck.app;
import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {

    private FoodTruck[] fleet = new FoodTruck[5];
    private int numTrucks = 0; // Track the number of trucks added

    public static void main(String[] args) {

        FoodTruckApp app = new FoodTruckApp();
        app.run();
    }

    public void run() {
        Scanner input = new Scanner(System.in);

        // Input loop to gather food truck information
        for (int i = 0; i < fleet.length; i++) {
            System.out.print("Enter the name of the food truck (type 'quit' to exit): ");
            String name = input.nextLine();

            if (name.equalsIgnoreCase("quit")) {
                break;
            }

            System.out.print("Enter the type of food served: ");
            String foodType = input.nextLine();

            System.out.print("Enter the rating (1-5): ");
            double rating = input.nextDouble();
            input.nextLine(); // Consume the newline character

            // Create a new FoodTruck object and add it to the array
            fleet[i] = new FoodTruck(name, foodType, rating);
            numTrucks++;
        }

        // Display the main menu
        int choice;
        do {
            choice = displayMainMenu(input);
            switch (choice) {
                case 1:
                    listAllFoodTrucks();
                    break;
                case 2:
                    displayAverageRating();
                    break;
                case 3:
                    displayHighestRatedTruck();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 4);

        input.close();
    }

    private int displayMainMenu(Scanner input) {
        System.out.println("\nMain Menu:");
        System.out.println("1. List all existing food trucks");
        System.out.println("2. See the average rating of food trucks");
        System.out.println("3. Display the highest-rated food truck");
        System.out.println("4. Quit");
        System.out.print("Please select an option: ");
        return input.nextInt();
    }

    private void listAllFoodTrucks() {
        System.out.println("\nList of Food Trucks:");
        for (int i = 0; i < numTrucks; i++) {
            System.out.println(fleet[i]);
        }
    }

    private void displayAverageRating() {
        double sum = 0.0;
        for (int i = 0; i < numTrucks; i++) {
            sum += fleet[i].getRating();
        }
        double average = numTrucks > 0 ? sum / numTrucks : 0.0;
        System.out.println("\nAverage Rating of Food Trucks: " + average);
    }

    private void displayHighestRatedTruck() {
        if (numTrucks == 0) {
            System.out.println("\nNo food trucks to display.");
            return;
        }

        FoodTruck highestRatedTruck = fleet[0];
        for (int i = 1; i < numTrucks; i++) {
            if (fleet[i].getRating() > highestRatedTruck.getRating()) {
                highestRatedTruck = fleet[i];
            }
        }

        System.out.println("\nHighest-Rated Food Truck:");
        System.out.println(highestRatedTruck);
    }
}
