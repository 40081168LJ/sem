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
     * reports 1,2,3,4,5,6
     * Author - AOB
     */
    @Test
    void printCountriesTestNull() {
        Country.printCountries(null);
    }

//--------------------------------------------------------------------------------------------------------------------//

    /**
     * Unit test for print extracted list of countries if empty
     * reports 1,2,3,4,5,6
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
     * reports 1,2,3,4,5,6
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
     * reports 1,2,3,4,5,6
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
     * tests displaying cities with an empty object - report 7, 8, 9, 15, 16
     */
    @Test
    void DisplayCitiesTestEmpty() {
        ArrayList<City> city = new ArrayList<>();
        City.displayCites(city);
    }

//--------------------------------------------------------------------------------------------------------------------//

    /**
     * tests passing city expected values - report 7, 8, 9, 15, 16
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
     * Test to display countries expected population - Report Additional info 4
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


//--------------------------------------------------------------------------------------------------------------------//

    /**
     * Test to display Districts expected population - Report Additional info 5
     */

    @Test
    void DisplayDistrictPopulation() {
        ArrayList<Population> countries = new ArrayList<>();
        Population population = new Population();
        population.country = "Kabol";
        population.population = 1780000;
        countries.add(population);

        Population.displayCountryPopulations(countries);

    }


//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Test to display Region expected population - Report Additional info 3
     */

    @Test
    void DisplayRegionPopulation() {
        ArrayList<Population> countries = new ArrayList<>();
        Population population = new Population();
        population.country = "Caribbean";
        population.population = 38140000;
        countries.add(population);

        Population.displayCountryPopulations(countries);

    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Test to display expected population of the highest populated city in the world - Report 20
     */

    @Test
    void displayCapitalCities(){
        ArrayList<City> cities = new ArrayList<>();
        City city = new City();
        city.name = "Seoul";
        city.country = "South Korea";
        city.population = 9981619;
        cities.add(city);

        //TODO: CHECK THIS AS YOU ARE NOT CALLING "cities" BELOW
        City.getTopCapitalCitiesInTheWorld(1, app.con);
    }


//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Test to display continent expected population - Report 18, Report 17
     */
    @Test
    void DisplayCapitalCities() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City();
        city.name = "Cairo";
        city.country = "Egypt";
        city.population = 6789479;
        cities.add(city);

        City.displayCapitalCites(cities);
    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
    * Test to display Continent population report styled with % - Report 23
    */
    @Test
    void displayContinentPopulation2(){
        ArrayList<Population> populations = new ArrayList<>();
        Population population = new Population();
        population.continent = "Asia";
        population.population = 900937599;
        population.inCities = "0.0774%";
        population.outCities = "99.9226%";

        populations.add(population);

        Population.displayContinentPopulation2(populations);
    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Test to display Region population report styled with % - Report 24
     */
    @Test
    void getRegionPopulation2(){
        ArrayList<Population> populations = new ArrayList<>();
        Population population = new Population();
        population.region = "Southern and Central Asia";
        population.population = 363665421;
        population.inCities = "0.0571%";
        population.outCities = "99.9429%";

        populations.add(population);

        Population.displayRegionPopulation2(populations);
    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Test to display country population report styled with % - Report 25
     */
    @Test
    void getCountryPopulation2(){
        ArrayList<Population> populations = new ArrayList<>();
        Population population = new Population();
        population.country = "spain";
        population.population = 363665421;
        population.inCities = "0.0571%";
        population.outCities = "99.9429%";

        populations.add(population);

        Population.displayCountryPopulation2(populations);
    }

//--------------------------------------------------------------------------------------------------------------------//

    /**
     * Unit test for print extracted list of capital cities if null
     * report 17
     * Author - AOB
     */

    @Test
    void displayCapitalCitiesTestNull() {
        City.displayCapitalCites(null);
    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Unit test for print extracted list of capital cities if empty
     * report 17
     * Author - AOB
     */

    @Test
    void displayCapitalCitiesTestEmpty() {
        ArrayList<City> cities = new ArrayList<>();
        City.displayCapitalCites(cities);
    }


//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Unit test for print extracted list of capital cities if array item is null
     * report 17
     * Author - AOB
     */

    @Test
    void displayCapitalCitiesTestContainsNull() {
        ArrayList<City> cities = new ArrayList<>();
        cities.add(null);
        City.displayCapitalCites(cities);
    }

//--------------------------------------------------------------------------------------------------------------------//

}

//--------------------------------------------------------------------------------------------------------------------//