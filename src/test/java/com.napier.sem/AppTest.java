package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/** Unit tests for reports
 * Author - AOB
 */
public class AppTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    /**
     * tests passing an empty object
     */
    @Test
   void DisplayWorldPopulationTestEmpty()
    {
        Population population = new Population();
        Population.displayPopulation(population);
    }
    /**
     * tests passing expected values
     */
    @Test
    void DisplayWorldPopulation()
    {
        Population population = new Population();
        population.population = 23123122;
        Population.displayPopulation(population);
    }

    /** Unit test for print extracted list of countries if null
     * Author - AOB
     */
    @Test
    void printCountriesTestNull()
    {
        app.printCountries(null);
    }

    /** Unit test for print extracted list of countries if empty
     * Author - AOB
     */
    @Test
    void printCountriesTestEmpty()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.printCountries(countries);
    }

    /** Unit test for print extracted list of countries if array item is null
     * Author - AOB
     */
    @Test
    void printCountriesTestContainsNull()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(null);
        app.printCountries(countries);
    }

    /** Unit test for extract list of countries with country object variables present
     * Author - AOB
     */
    @Test
    void printCountries()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        Country country = new Country();
        country.code = "FRA";
        country.name = "France";
        country.continent = "Europe";
        country.region = "Western Europe";
        country.population = 55000;
        country.capital = "Paris";
        countries.add(country);
        app.printCountries(countries);
    }
}
