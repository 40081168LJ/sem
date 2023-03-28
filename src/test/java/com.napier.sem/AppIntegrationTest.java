package com.napier.sem;

//--------------------------------------------------------------------------------------------------------------------//
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

//--------------------------------------------------------------------------------------------------------------------//
/**
 * Integration Test to test reports
 */
public class AppIntegrationTest {
    /**
     * Test connection to database
     * Used in all reports
     */
    static App app;

    @BeforeAll
    static void init() {
        app = new App();
        // Connect to database
        app.connect("localhost:33060", 30000);
    }
    @AfterAll
    public static void cleanUp(){
        app.disconnect();
    }

//--------------------------------------------------------------------------------------------------------------------//

    /**
     * Integration test for extract all world countries
     * Author - AOB
     */
    @Test
    public void testGetAllCountries() {
        ArrayList<Country> country = Country.getAllCountries(app.con);
        assertNotNull(country);
    }

//--------------------------------------------------------------------------------------------------------------------//

    /**
     * integration test for extract specific continent countries
     * Author - AOB
     */
    @Test
    public void testGetContinentCountries() {
        ArrayList<Country> country = Country.getContinentCountries(app.con);
        assertNotNull(country);
    }

//--------------------------------------------------------------------------------------------------------------------//

    /**
     * integration test for extract specific region countries
     * Author - AOB
     */
    @Test
    public void testGetRegionCountries() {
        ArrayList<Country> country = Country.getRegionCountries(app.con);
        //validates

        assertNotNull(country);
    }

//--------------------------------------------------------------------------------------------------------------------//

    /**
     * Test connection to database and to test getting world population
     * Used in additional_info 1 report
     */
    @Test
    public void GetWorldPopulation() {
        Population pop = Population.getPopulation(app.con);
        //validates
        assertNotNull(pop);
        assertNotEquals(0, pop.population);
    }


//--------------------------------------------------------------------------------------------------------------------//

    /**
     * integration test for getting cities descending order - report 7
     */
    @Test
    public void GetCityPopulation() {
        ArrayList<City> cities = City.getCityPopulation(app.con);
        //validates
        assertNotNull(cities);
        assertNotNull(cities.get(0).name);
        assertNotNull(cities.get(0).country);
        assertNotNull(cities.get(0).district);
    }
//--------------------------------------------------------------------------------------------------------------------//
    /** integration test for getting countries by district in descending order - report 11
     */
    @Test
    public void getCityByDistrict() {
        ArrayList<City> cities = City.getCityPopulationByDistrict("Noord-Holland",app.con);
        //validates
        assertNotNull(cities);
        assertNotNull(cities.get(0).name);
        assertNotNull(cities.get(0).country);
        assertNotNull(cities.get(0).district);
    }
//--------------------------------------------------------------------------------------------------------------------//
    /** integration test for getting countries descending order - report 9
     */
    @Test
    public void getCityByRegion() {
        ArrayList<City> cities = City.getCityPopulationByRegion("Caribbean", app.con);
        //validates not null
        assertNotNull(cities);
        assertNotNull(cities.get(0).name);
        assertNotNull(cities.get(0).country);
        assertNotNull(cities.get(0).district);
    }
//--------------------------------------------------------------------------------------------------------------------//


    /**
     * integration test for getting continents with not null population - report Additional info 2
     */

    @Test
    public void printContinentsPopulationTestEmpty() {
        ArrayList<Population> populations = Population.getContinentPopulation(app.con);

        assertNotNull(populations);
        assertNotNull(populations.get(0).continent);

    }


//--------------------------------------------------------------------------------------------------------------------//

    /**
     * integration test for getting all city populations - Report Additional info 6
     */

    @Test
    public void printCitiesPopulations() {
        ArrayList<Population> populations = Population.getcityPopulation(app.con);
        assertNotNull(populations);
        assertNotNull(populations.get(0).city);


    }


//--------------------------------------------------------------------------------------------------------------------//

    /**
     *  integration test for getting all country populations - Report Additional info 4
     */
    @Test
    public void printCountriesPopulations() {
        ArrayList<Population> populations = Population.getcityPopulation(app.con);
        assertNotNull(populations);
        assertNotNull(populations.get(0).country);


    }

    //----------------------------------------------------------------------------------------------------------------//

    /**
     * integration test for getting cities descending order - report 7
     */
    @Test
    public void GetCityPopulationByContinent() {
        ArrayList<City> cities = City.getCityPopulationByContinent("Europe", app.con);
        //validates
        assertNotNull(cities);
        assertNotNull(cities.get(0).name);
        assertNotNull(cities.get(0).country);
        assertNotNull(cities.get(0).district);
    }
}