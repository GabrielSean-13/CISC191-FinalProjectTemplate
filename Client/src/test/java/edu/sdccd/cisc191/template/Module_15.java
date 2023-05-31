package edu.sdccd.cisc191.template;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Module_15 {
// Test to see if loop was printed by stream
    @Test
    void MenuPrintedWithAPI() {
        Client test = new Client();
        assertEquals(true, test.printMenu() );
    }
}