package com.napier.sem;

//--------------------------------------------------------------------------------------------------------------------//

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

//--------------------------------------------------------------------------------------------------------------------//
/** Unit tests for reports
 * Author - AOB
 * Class created to store unit tests
 */
public class AppTest {

    /**
     * Sets app to static
     */
    static App app;

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Before all the unit test take place setting up app
     * Author - SL
     */
    @BeforeAll
    static void init() {
        app = new App();
    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Tests passing an empty object to display world population method
     * Reports - Additional Info 1
     * Author - AG
     */
    @Test
    void displayWorldPopulationTestEmpty() {
        Population population = new Population();
        Population.displayPopulation(population);
    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Tests passing expected values to display world population method
     * Reports - Additional Info 1
     * Author - AG
     */
    @Test
    void displayWorldPopulation() {
        Population population = new Population();
        population.population = 23123122;
        Population.displayPopulation(population);
    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Unit test for print extracted list of countries if null
     * Reports - 1, 2, 3, 4, 5, 6
     * Author - AOB
     */
    @Test
    void printCountriesTestNull() {
        Country.printCountries(null);
    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Unit test for print extracted list of countries if empty
     * Reports - 1, 2, 3, 4, 5, 6
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
     * Reports - 1, 2, 3, 4, 5, 6
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
     * Reports - 1, 2, 3, 4, 5, 6
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
     * Tests displaying cities with an empty object
     * Reports - 7, 8, 9, 10, 11, 12, 13, 14, 15, 16
     * Author - SL
     */
    @Test
    void displayCitiesTestEmpty() {
        ArrayList<City> city = new ArrayList<>();
        City.displayCites(city);
    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Tests passing city expected values
     * Reports - 7, 8, 9, 10, 11, 12, 13, 14, 15, 16
     * Author - Shaun
     */
    @Test
    void displayCities() {
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
     * Test to display continents with 0 population
     * Reports - Additional info 2
     * Author - AG
     */
    @Test
    void printContinentsTestEmpty() {
        ArrayList<Population> populations = new ArrayList<>();
        Population.displayContinentPopulations(populations);
    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Test to make sure a city e.g. Kabul prints expected population
     * Reports - Additional info 6
     * Author - AG
     */
    @Test
    void displayCityPopulation() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City();
        city.name = "Kabul";
        city.population = 1780000;
        cities.add(city);

        City.displayCites(cities);

    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Test to display countries expected population
     * Reports - Additional info 4
     * Author - AG
     */
    @Test
    void displayCountryPopulation() {
        ArrayList<Population> countries = new ArrayList<>();
        Population population = new Population();
        population.country = "Aruba";
        population.population = 103000;
        countries.add(population);

        Population.displayCountryPopulations(countries);

    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Test to display Districts expected population
     * Reports - Additional info 5
     * Author - AG
     */
    @Test
    void displayDistrictPopulation() {
        ArrayList<Population> countries = new ArrayList<>();
        Population population = new Population();
        population.country = "Kabol";
        population.population = 1780000;
        countries.add(population);

        Population.displayCountryPopulations(countries);

    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Test to display Region expected population
     * Reports - Additional info 3
     * Author - AG
     */
    @Test
    void displayRegionPopulation() {
        ArrayList<Population> countries = new ArrayList<>();
        Population population = new Population();
        population.country = "Caribbean";
        population.population = 38140000;
        countries.add(population);

        Population.displayCountryPopulations(countries);

    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Test to display continent expected population
     * Reports - 17, 18, 20, 21, 22
     * Author - AG
     */
    @Test
    void displayCapitalCities() {
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
     * Test to display Continent population report styled with %
     * Reports - 23
     * Author - LJ
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
     * Test to display Region population report styled with %
     * Reports - 24
     * Author - LJ
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
     * Test to display country population report styled with %
     * Report 25
     * Author - SL
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
     * Reports - 17, 18, 20, 21, 22
     * Author - AOB
     */
    @Test
    void displayCapitalCitiesTestNull() {
        City.displayCapitalCites(null);
    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Unit test for print extracted list of capital cities if empty
     * Reports - 17, 18, 20, 21, 22
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
     * Reports - 17, 18, 20, 21, 22
     * Author - AOB
     */
    @Test
    void displayCapitalCitiesTestContainsNull() {
        ArrayList<City> cities = new ArrayList<>();
        cities.add(null);
        City.displayCapitalCites(cities);
    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Test to display region capital city expected population
     * Reports - 19
     * Author - AG
     */
    @Test
    void displayCapitalCitiesInRegion() {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City();
        city.region = "Caribbean";
        city.name = "La Habana";
        city.country = "Cuba";
        city.population = 2256000;
        cities.add(city);

        Population.displayCapitalCitesInRegion(cities);
    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Test to display expected population of the highest populated city in the world
     * Reports - 30
     * Author - LJ
     */
    @Test
    void displayDistrictPopulations(){
        ArrayList<Population> population = new ArrayList<>();
        Population populationTest = new Population();
        populationTest.district = "testDistrict";
        populationTest.population = 6969;
        population.add(populationTest);

        Population.displayDistrictPopulations(population);
    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Test to display expected population of the highest populated city in the world
     * Reports - 31
     * Author - LJ
     */
    @Test
    void displayCityPopulations(){
        ArrayList<Population> population = new ArrayList<>();
        Population populationTest = new Population();
        populationTest.population = 6969;
        populationTest.city = "TestCity";
        population.add(populationTest);
        Population.displayCityPopulations(population);

    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Test to display expected population of the highest populated city in the world
     * Reports - 32 - Expected Values
     * Author - LJ
     */
    @Test
    void displayCountryLanguage(){
        ArrayList<Language> languageReports = new ArrayList<>();
        Language languageReport = new Language();
        languageReport.population = 69696969;
        languageReport.language = "LanguageTest";
        languageReport.percentage = 69;
        languageReports.add(languageReport);
        Language.displayCountryLanguage(languageReports);

    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Test to display expected population of the highest populated city in the world, if empty
     * Reports - 32 - Empty Object
     * Author - LJ
     */
    @Test
    void displayCountryLanguageEmpty(){
        ArrayList<Language> languageReports = new ArrayList<>();
        Language languageReport = new Language();
        languageReports.add(languageReport);
        Language.displayCountryLanguage(languageReports);

    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Test to display expected population of the highest populated city in the world
     * Reports - 32 - Null Value
     * Author - LJ
     */
    @Test
    void displayCountryLanguageNull(){
        ArrayList<Language> languageReports = new ArrayList<>();
        languageReports.add(null);
        Language.displayCountryLanguage(languageReports);

    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Test to display expected population of the highest populated city in the world
     * Reports - 32 - If Language1 is passed Null
     * Author - LJ
     */
    @Test
    void displayCountryLanguageIfNull(){
        Language.displayCountryLanguage(null);

    }
    @Test
    void displayCountryLanguageIfNullPrntLn(){
        String output = "TEST OUTPUT";
        System.out.println(output);
        ArrayList<Language> languageReports = new ArrayList<>();
        languageReports.add(null);
        Language.displayCountryLanguage(languageReports);
    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Test to check System prints out lines as expected
     * PrintLn Test
     * Author - LJ
     */
    @Test
    void systemOutPrintln(){
            String output = "TEST OUTPUT";
            System.out.println(output);
        }

//--------------------------------------------------------------------------------------------------------------------//

}

//--------------------------------------------------------------------------------------------------------------------//