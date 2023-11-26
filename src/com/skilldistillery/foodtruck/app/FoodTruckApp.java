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

        // Display the list of entered food trucks
        System.out.println("\nList of Entered Food Trucks:");
        for (int i = 0; i < numTrucks; i++) {
            System.out.println(fleet[i]);
        }

        input.close();
    }
}
