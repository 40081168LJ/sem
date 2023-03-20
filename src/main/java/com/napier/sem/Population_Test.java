package com.napier.sem;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit Test to test worldPopulation is not null
 */
public class Population_Test {

    @Test
    /**
     * Test getting world population
     */
    public void testGetWorldPopulation() {

        App con = new App();
        con.connect();
        int worldPopulation = con.getPopulation();
        con.disconnect();
        assertNotEquals(-1, worldPopulation);


    }

}