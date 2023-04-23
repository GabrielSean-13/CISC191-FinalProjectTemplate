package edu.sdccd.cisc191.template;

import java.util.LinkedList;

// Creates an abstract class that contains the method purchaseItem which will be passed down on the menu items
public abstract class  Drink {
    // Fields will be passed down to classes that extends this class
    double drinkPrice;
    int drinkCalories;

    LinkedList<String> drinkList = new LinkedList<>();
    //Method will be passed down to classes that extends this class
    public abstract boolean drinkChose();
}
