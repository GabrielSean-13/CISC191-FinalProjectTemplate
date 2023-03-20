package edu.sdccd.cisc191.template;
// Creates an abstract class that contains the method purchaseItem which will be passed down on the menu items
 public abstract class  Menu {
     // Fields will be passed down to classes that extends this class
double price;
int calories;

//Method will be passed down to classes that extends this class
public abstract boolean purchaseItem();
    }

