package com.skilldistillery.foodtruck.entities;

public class FoodTruck {

    // Fields
    private String name;
    private String foodType;
    private double rating;

    // Constructors
    public FoodTruck(String name, String foodType, double rating) {
        this.name = name;
        this.foodType = foodType;
        this.rating = rating;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    // Override toString method to display truck details
    @Override
    public String toString() {
        return "Name: " + name + "\nFood Type: " + foodType + "\nRating: " + rating;
    }
}
