package edu.sdccd.cisc191.template;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Module_6 {

    // If interface method was successfully passed down to class Burger
    @Test
    void successfullyInheritMethodFromInterface(){
        Burger bburger = new Burger();
        assertEquals(true , bburger.payInCash());
    }
}