package edu.sdccd.cisc191.template;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Module_10 extends Food{

    //Test if node is successfully added to arraylist passed down from abstract method
    @Test
   void nodeSuccessfullyAdded(){
       foodList.add("Burger");
     assertEquals(1,foodList.size());
    }

//Not needed just passed from Abstracted method Food
    @Override
    public boolean foodChose() {
        return false;
    }
}