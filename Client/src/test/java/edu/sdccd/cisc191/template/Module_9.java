package edu.sdccd.cisc191.template;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class Module_9 {

    @Test
    void correctlyFindsPriceOfStringBurger(){
        HashMap<String, Double> menu = new HashMap<>();
        menu.put("Burger", 5.99);
        assertEquals(5.99, menu.get("Burger"));
    }


}