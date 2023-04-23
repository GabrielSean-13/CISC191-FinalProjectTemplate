package edu.sdccd.cisc191.template;

import java.io.Serializable;

// Receives Method of Menu and implements the method of Receipt
//Implements Serializable in order to make the class Serializable and save objects from the class to disks
public class Sprite extends Drink implements Order, Serializable {
    // Method simply displays that you purchased this item
    @Override
    public boolean drinkChose() {
        drinkPrice = 0.99;
        drinkCalories = 139;
        System.out.println("Thank you for choosing our Sprite!");
        return true;
    }

    // Method simply displays a receipt that includes the price and calories
    @Override
    public boolean payInCash() {
        drinkList.add("Sprite");
        drinkChose();
        System.out.println(" The total is "+ "$" + drinkPrice + " and includes " + drinkCalories +" calories, paid in cash");
        System.out.println("Number of Sprite ordered " + drinkList.size());
        return true;
    }




}
