package edu.sdccd.cisc191.template;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Module_4_5 {
    //If you are able to successfully create a object from the class and use its class method
 @Test
    void objectSuccessfullyCreatedAndAbtractedMethod(){
     Burger burger = new Burger();
     assertEquals(true , burger.foodChose());

    }
}