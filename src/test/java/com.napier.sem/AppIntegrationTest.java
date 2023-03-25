package com.napier.sem;

//--------------------------------------------------------------------------------------------------------------------//
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

//--------------------------------------------------------------------------------------------------------------------//
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

    // /** Test connection to database and to test getting world population
    // * Used in additional_info 1 report
    // */
    //TEST REMOVED

    /** Integration test for extract all world countries
     * Author - AOB
     */
    @Test
    public void testGetAllCountries(){
        ArrayList<Country> country = Country.getAllCountries(app.con);
        assertNotNull(country);
    }

    /** Integration test for extract specific continent countries
     * Author - AOB
     */
    @Test
    public void testGetContinentCountries(){
        ArrayList<Country> country = Country.getContinentCountries(app.con);
        assertNotNull(country);
    }

    /** integration test for extract specific region countries
     * Author - AOB
     */
    @Test
    public void testGetRegionCountries() {
        ArrayList<Country> country = Country.getRegionCountries(app.con);
        //validates

        assertNotNull(country);
    }
}
//--------------------------------------------------------------------------------------------------------------------//