package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Integration Test to test reports
 */
public class AppIntegrationTest {

    static App app;
    @BeforeAll
    static void init()
    {
        app = new App();
        // Connect to database
        app.connect("localhost:33060", 30000);

    }

    /**
     * Test connection to database and to test getting world population
     * Used in additional_info 1 report
     */

    /** Integration test for extract all world countries
     * Author - AOB
     */
    @Test
    public void testGetAllCountries(){
        ArrayList<Country> country = app.getAllCountries();
        assertNotNull(country);
    }

    /** integration test for extract specific continent countries
     * Author - AOB
     */
    @Test
    public void testGetContinentCountries(){
        ArrayList<Country> country = app.getContinentCountries();
        assertNotNull(country);
    }

    /** integration test for extract specific region countries
     * Author - AOB
     */
    @Test
    public void testGetRegionCountries() {
        ArrayList<Country> country = app.getRegionCountries();
        //validates

        assertNotNull(country);
    }
}

/**
 * Unit Test to test worldPopulation is not null
 */
class IntegrationTests {

    static App app;
    @BeforeAll
    static void init()
    {
        app = new App();
        // Connect to database
        app.connect("localhost:33060", 30000);

    }

    /**
     * Test connection to database and to test getting world population
     * Used in additional_info 1 report
     */
    @Test
    public void GetWorldPopulation() {
        Population pop = Population.getPopulation(app.con);
        //validates
        assertNotEquals(0, pop.population );
    }

}
