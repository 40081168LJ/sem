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
     * Integration test for extract all world countries - report 1
     * Author - AOB
     */
    @Test
    public void testGetAllCountries() {
        ArrayList<Country> countries = Country.getAllCountries(app.con);
        assertNotNull(countries);
        assertNotNull(countries.get(0).code);
        assertNotNull(countries.get(0).name);
        assertNotNull(countries.get(0).continent);
        assertNotNull(countries.get(0).region);
        //removed NotNull for population variable as variable never Null
        // assertNotNull(countries.get(0).population);
        assertNotNull(countries.get(0).capital);
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
    /** integration test for getting cities by country ordered desc - report 10
     */
    @Test
    public void getCityByCountry() {
        ArrayList<City> cities = City.getCitiesByCountry("united kingdom", app.con);
        //validates
        assertNotNull(cities);
        assertNotNull(cities.get(0).name);
        assertNotNull(cities.get(0).country);
        assertNotNull(cities.get(0).district);
    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * integration test for extract specific continent countries applies to report 18 as well
     * integration test for extract specific continent countries - report 2
     * Author - AOB
     */
    @Test
    public void testGetContinentCountries() {
        ArrayList<Country> countries = Country.getContinentCountries("Europe", app.con);
        assertNotNull(countries);
        assertNotNull(countries.get(0).code);
        assertNotNull(countries.get(0).name);
        assertNotNull(countries.get(0).continent);
        assertNotNull(countries.get(0).region);
        //removed NotNull for population variable as variable never Null
        //assertNotNull(countries.get(0).population);
        assertNotNull(countries.get(0).capital);
    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * integration test for extract specific continent countries applies to report 18 as well
     * Author - AOB
     */
    @Test
    public void testGetCapitalCities() {
        ArrayList<City> capitalCities = Population.getTopCapitalCitiesByContinent("Africa", app.con);
        assertNotNull(capitalCities);
        assertNotNull(capitalCities.get(0).name);
    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * integration test for extract specific region countries - report 3
     * Author - AOB
     */
    @Test
    public void testGetRegionCountries() {
        ArrayList<Country> countries = Country.getRegionCountries("Middle East", app.con);
        //validates
        assertNotNull(countries);
        assertNotNull(countries.get(0).code);
        assertNotNull(countries.get(0).name);
        assertNotNull(countries.get(0).continent);
        assertNotNull(countries.get(0).region);
        //removed NotNull for population variable as variable never Null
        //assertNotNull(countries.get(0).population);
        assertNotNull(countries.get(0).capital);
    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * integration test for getting countries in descending order - report 4
     * Author - AOB
     */
    @Test
    public void testGetTopPopulatedCountries(){
        ArrayList<Country> countries = Country.getTopPopulatedCountries(1, app.con);
        //validates
        assertNotNull(countries);
        assertNotNull(countries.get(0).code);
        assertNotNull(countries.get(0).name);
        assertNotNull(countries.get(0).continent);
        assertNotNull(countries.get(0).region);
        //removed NotNull for population variable as variable never Null
        //assertNotNull(countries.get(0).population);
        assertNotNull(countries.get(0).capital);
    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * integration test for getting given number of countries in given
     * continent in descending order - report 5
     * Author - AOB
     */
    @Test
    public void testGetTopCountriesInContinent(){
        ArrayList<Country> countries = Country.getTopCountriesInContinent(1, "Asia", app.con);
        //validates
        assertNotNull(countries);
        assertNotNull(countries.get(0).code);
        assertNotNull(countries.get(0).name);
        assertNotNull(countries.get(0).continent);
        assertNotNull(countries.get(0).region);
        //removed NotNull for population variable as variable never Null
        //assertNotNull(countries.get(0).population);
        assertNotNull(countries.get(0).capital);
    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * integration test for getting given number of countries in given
     * region in descending order - report 6
     * Author - AOB
     */
    @Test
    public void testGetTopCountriesInRegion(){
        ArrayList<Country> countries = Country.getTopCountriesInRegion(1, "Middle East", app.con);
        //validates
        assertNotNull(countries);
        assertNotNull(countries.get(0).code);
        assertNotNull(countries.get(0).name);
        assertNotNull(countries.get(0).continent);
        assertNotNull(countries.get(0).region);
        //removed NotNull for population variable as variable never Null
        //assertNotNull(countries.get(0).population);
        assertNotNull(countries.get(0).capital);
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
     * integration test for getting countries by district in descending order - report 11
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
     * integration test for getting all country populations - Report Additional info 4
     */
    @Test
    public void GetCountriesPopulations() {
        ArrayList<Population> populations = Population.getCountryPopulations(app.con);
        assertNotNull(populations);
        assertNotNull(populations.get(0).country);

    }

//----------------------------------------------------------------------------------------------------------------//
    /**
     * integration test for getting cities descending order - report 8
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

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * integration test for getting countries descending order - report 12
     */
    @Test
    public void getTopPopulatedCities() {
        ArrayList<City> cities = City.getTopPopulatedCities(1, app.con);
        //validates
        assertNotNull(cities);
        assertNotNull(cities.get(0).name);
        assertNotNull(cities.get(0).country);
        assertNotNull(cities.get(0).district);
    }

//--------------------------------------------------------------------------------------------------------------------//
    /** integration test to get cities by continent when given continent and number of rows to select - report 13
     */
    @Test
    public void getTopCitiesByContinent() {
        ArrayList<City> cities = City.getTopCitiesByContinent(5,"europe", app.con);
        //validates
        assertNotNull(cities);
        assertNotNull(cities.get(4).name); //checks data in row 5 is in range and not null
        assertNotNull(cities.get(4).country);
        assertNotNull(cities.get(4).district);
    }

//--------------------------------------------------------------------------------------------------------------------//
    /** integration test for getting cities when given by region when given number of rows to select and a region
     */
    @Test
    public void getTopCitiesByRegion() {
        ArrayList<City> cities = City.getTopCitiesByRegion(5, "Caribbean", app.con);
        //validates
        assertNotNull(cities);
        assertNotNull(cities.get(0).name);
        assertNotNull(cities.get(0).country);
        assertNotNull(cities.get(0).district);
    }

//--------------------------------------------------------------------------------------------------------------------//
    /** integration test for getting cities when given by country when given number
     * of rows to select and a country
     * report 15
     */
    @Test
    public void getTopCitiesByCountry() {
        ArrayList<City> cities = City.getTopCitiesByCountry(5, "France",app.con);
        //validates
        assertNotNull(cities);
        assertNotNull(cities.get(0).name);
        assertNotNull(cities.get(0).country);
        assertNotNull(cities.get(0).district);
    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * integration test for getting all district populations - Report Additional info 5
     */
    @Test
    public void GetDistrictPopulations() {
        ArrayList<Population> populations = Population.getDistrictPopulation(app.con);
        assertNotNull(populations);
        assertNotNull(populations.get(0).district);

    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * integration test for getting all Region populations - Report Additional info 3
     */
    @Test
    public void getRegionPopulation() {
        ArrayList<Population> populations = Population.getRegionPopulation(app.con);
        assertNotNull(populations);
        assertNotNull(populations.get(0).region);

    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * integration test for getting cities in the world when given number of rows to select - Report 20
     */
    @Test
    public void getTopCapitalCitiesInTheWorld(){
        ArrayList<City> cities = City.getTopCapitalCitiesInTheWorld(10, app.con);
        assert cities != null;
        assertNotNull(cities.get(0).name);
        assertNotNull(cities.get(0).country);
    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * integration test for getting capital cities descending order - report 18
     */
    @Test
    public void getTopCapitalCitiesByContinent() {
        ArrayList<City> cities = City.getCityPopulationByContinent("Europe", app.con);
        //validates
        assertNotNull(cities);
        assertNotNull(cities.get(0).name);
        assertNotNull(cities.get(0).country);
        assertNotNull(cities.get(0).district);
    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * integration test for getting all capital cities in descending order - report 17
     */
    @Test
    public void getAllCapitalCities() {
        ArrayList<City> cities = City.getAllCapitalCities(app.con);
        //validates
        assertNotNull(cities);
        assertNotNull(cities.get(0).name);
        assertNotNull(cities.get(0).country);
        //removed NotNull for population variable as variable never Null
        //assertNotNull(cities.get(0).population);
    }

//--------------------------------------------------------------------------------------------------------------------//
    /** integration test for getting cities when given number of rows to select
     *  and a district - report 16
     */
    @Test
    public void getTopCitiesByDistrict() {
        ArrayList<City> cities = City.getTopCitiesByDistrict(5, "Noord-Holland",app.con);
        //validates
        assertNotNull(cities);
        assertNotNull(cities.get(0).name);
        assertNotNull(cities.get(0).country);
        assertNotNull(cities.get(0).district);
    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * integration test for getting Country population report styled with % - Report 25
     */
    @Test
    public void getCountryPopulation2(){
        ArrayList<Population> countryPopulation = Population.getCountryPopulation2(app.con);
        assertNotNull(countryPopulation);
        assertNotNull(countryPopulation.get(0).country);
        assertNotNull(countryPopulation.get(0).inCities);
        assertNotNull(countryPopulation.get(0).outCities);
    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * integration test for getting Capital Cities in the Region - Report 19
     */
    @Test
    public void getTopCapitalCitiesInRegion(){
        ArrayList<City> capitalCities = Population.getTopCapitalCitiesInRegion("Caribbean", app.con);
        assertNotNull(capitalCities);
        assertNotNull(capitalCities.get(0).name);
        assertNotNull(capitalCities.get(0).country);
        //assertNotNull(capitalCities.get(0).population);
        Population.displayCapitalCitesInRegion(capitalCities);
    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * integration test for getting Top Populated Capital Cities in the Continent - Report 21
     */
    @Test
    public void getTopCapitalCities2(){
        ArrayList<City> cities3 = City.getTopCapitalCities2(2, "Europe", app.con);
        assertNotNull(cities3);
        assertNotNull(cities3.get(0).name);
        assertNotNull(cities3.get(0).country);
        //assertNotNull(cities3.get(0).population);
        City.displayCapitalCites(cities3);
    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Integration test for getting Displaying Continent Populations - Report 23
     */
    @Test
    public void getContinentPopulation2(){
        ArrayList<Population> population2 = Population.getContinentPopulation2(app.con);
        assertNotNull(population2);
        assertNotNull(population2.get(0).continent);
        //assertNotNull(population2.get(0).population);
        assertNotNull(population2.get(0).inCities);
        assertNotNull(population2.get(0).outCities);
        Population.displayContinentPopulation2(population2);
    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Integration test for getting Displaying Region Populations - Report 24
     */
    @Test
    public void getRegionPopulation2(){
        ArrayList<Population> regionPopulation1 = Population.getRegionPopulation2(app.con);
        assertNotNull(regionPopulation1);
        assertNotNull(regionPopulation1.get(0).region);
        //assertNotNull(regionPopulation1.get(0).population);
        assertNotNull(regionPopulation1.get(0).inCities);
        assertNotNull(regionPopulation1.get(0).outCities);
        Population.displayRegionPopulation2(regionPopulation1);
    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Integration test for getting Displaying Region Populations - Report 32
     */
    @Test
    public void getLanguages1(){
        ArrayList<Language> LanguageReport1 = Language.getLanguages1(app.con);
        assertNotNull(LanguageReport1);
        assertNotNull(LanguageReport1.get(0).countryCode);
        assertNotNull(LanguageReport1.get(0).language);
        assertNotNull(LanguageReport1.get(0).isOfficial);
        //assertNotNull(LanguageReport1.get(0).percentage);
        Language.displayCountryLanguage(LanguageReport1);

    }

//--------------------------------------------------------------------------------------------------------------------//

}

//--------------------------------------------------------------------------------------------------------------------//