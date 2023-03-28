package com.napier.sem;

//--------------------------------------------------------------------------------------------------------------------//
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;


//--------------------------------------------------------------------------------------------------------------------//
/** Unit tests for reports
 * Author - AOB
 */
public class AppTest {
    static App app;

//--------------------------------------------------------------------------------------------------------------------//

    @BeforeAll
    static void init() {
        app = new App();
    }

//--------------------------------------------------------------------------------------------------------------------//

    /**
     * tests passing an empty object
     */
    @Test
    void DisplayWorldPopulationTestEmpty() {
        Population population = new Population();
        Population.displayPopulation(population);
    }

//--------------------------------------------------------------------------------------------------------------------//

    /**
     * tests passing expected values
     */
    @Test
    void DisplayWorldPopulation() {
        Population population = new Population();
        population.population = 23123122;
        Population.displayPopulation(population);
    }

//--------------------------------------------------------------------------------------------------------------------//

    /**
     * Unit test for print extracted list of countries if null
     * Author - AOB
     */
    @Test
    void printCountriesTestNull() {
        Country.printCountries(null);
    }

//--------------------------------------------------------------------------------------------------------------------//

    /**
     * Unit test for print extracted list of countries if empty
     * Author - AOB
     */
    @Test
    void printCountriesTestEmpty() {
        ArrayList<Country> countries = new ArrayList<>();
        Country.printCountries(countries);
    }

//--------------------------------------------------------------------------------------------------------------------//

    /**
     * Unit test for print extracted list of countries if array item is null
     * Author - AOB
     */
    @Test
    void printCountriesTestContainsNull() {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(null);
        Country.printCountries(countries);
    }

//--------------------------------------------------------------------------------------------------------------------//

    /**
     * Unit test for extract list of countries with country object variables present
     * Author - AOB
     */
    @Test
    void printCountries() {
        ArrayList<Country> countries = new ArrayList<>();
        Country country = new Country();
        country.code = "FRA";
        country.name = "France";
        country.continent = "Europe";
        country.region = "Western Europe";
        country.population = 55000;
        country.capital = "Paris";
        countries.add(country);
        Country.printCountries(countries);
    }


//--------------------------------------------------------------------------------------------------------------------//

    /**
     * tests displaying cities with an empty object - report 7
     */
    @Test
    void DisplayCitiesTestEmpty() {
        ArrayList<City> city = new ArrayList<>();
        City.displayCites(city);
    }

//--------------------------------------------------------------------------------------------------------------------//

    /**
     * tests passing city expected values - report 7
     */
    @Test
    void DisplayCities() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City();
        city.name = "testCity";
        city.district = "testDistrict";
        city.country = "TestCountry";
        city.population = 123;
        cities.add(city);

        City.displayCites(cities);
    }


//--------------------------------------------------------------------------------------------------------------------//

    /**
     * test to display continents with 0 population - Report Additional info 2
     */

    @Test
    void printContinentsTestEmpty() {
        ArrayList<Population> populations = new ArrayList<>();
        Population.displayContinentPopulations(populations);
    }


//--------------------------------------------------------------------------------------------------------------------//

    /**
     * Test to make sure Kabul prints expected population - report Additional info 6
     */

    @Test
    void DisplayCityPopulation() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City();
        city.name = "Kabul";
        city.population = 1780000;
        cities.add(city);

        City.displayCites(cities);

    }


//--------------------------------------------------------------------------------------------------------------------//

    /**
     * Test to display countries with 0 population - Report Additional info 4
     */

    @Test
    void DisplayCountryPopulation() {
        ArrayList<Population> countries = new ArrayList<>();
        Population population = new Population();
        population.country = "Aruba";
        population.population = 103000;
        countries.add(population);

        Population.displayCountryPopulations(countries);

    }
}

//--------------------------------------------------------------------------------------------------------------------//

