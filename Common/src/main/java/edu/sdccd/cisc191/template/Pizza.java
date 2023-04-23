package edu.sdccd.cisc191.template;

import java.io.Serializable;

// Receives Method of Menu and implements the method of Receipt
//Implements Serializable in order to make the class Serializable and save objects from the class to disks
public class Pizza extends Food implements Order, Serializable {
    // Method simply displays that you purchased this item
    @Override
    public boolean foodChose() {
        foodPrice = 7.99;
        foodCalories = 500;
        System.out.println("Thank you for choosing our Pizza!");
       return true;
    }

    // Method simply displays a receipt that includes the price and calories
    @Override
    public boolean payInCash() {
        foodList.add("Pizza");
        foodChose();
        System.out.println(" The total is "+ "$" + foodPrice + " and includes " + foodCalories +" calories, paid in cash");
        System.out.println("Number of Pizza ordered is " + foodList.size());
        return true;
    }
}
