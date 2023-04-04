package com.napier.sem;

//--------------------------------------------------------------------------------------------------------------------//
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

//--------------------------------------------------------------------------------------------------------------------//
/**
 * country object
 * */

public class Country {

    /** Country Code sting column  */
    public String code;

    /**  Country name string column  */
    public String name;

    /** Continent string column */
    public String continent;

    /** Region string column */
    public String region;

    /** Population int column */

    public int population;

    /** Capital string column */
    public String capital;

//--------------------------------------------------------------------------------------------------------------------//
    /** Extract all countries in the world, order by population descending
     * Author - AOB
     * @return All Countries
     */
    public static ArrayList<Country> getAllCountries(Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, " +
                            "country.Population, city.Name "
                            + "FROM country, city "
                            + "WHERE country.Capital = city.ID "
                            + "ORDER BY country.Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract Country information
            ArrayList<Country> countries = new ArrayList<>();

            while (rset.next()) {
                Country country = new Country();
                country.code = rset.getString("country.Code");
                country.name = rset.getString("country.Name");
                country.continent = rset.getString("country.Continent");
                country.region = rset.getString("country.Region");
                country.population = rset.getInt("country.Population");
                country.capital = rset.getString("city.Name");
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }
//--------------------------------------------------------------------------------------------------------------------//
    /** Extract all countries in specified continent, ordered by population
     * Author - AOB
     * @return Get all Countries from Continent "Asia"
     */
    public static ArrayList<Country> getContinentCountries(Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, " +
                            "country.Population, city.Name "
                            + "FROM country, city "
                            + "WHERE country.Capital = city.ID AND country.Continent = 'Asia' "
                            + "ORDER BY country.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract Country information
            ArrayList<Country> countries = new ArrayList<>();

            while (rset.next()) {
                Country country = new Country();
                country.code = rset.getString("country.Code");
                country.name = rset.getString("country.Name");
                country.continent = rset.getString("country.Continent");
                country.region = rset.getString("country.Region");
                country.population = rset.getInt("country.Population");
                country.capital = rset.getString("city.Name");
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }
//--------------------------------------------------------------------------------------------------------------------//
    /** Extract countries in specified region, order by population descending
     * Author - AOB
     * @return Get all Countries within user input region
     */
    public static ArrayList<Country> getRegionCountries(String region, Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, " +
                            "country.Population, city.Name "
                            + "FROM country "
                            + "JOIN city "
                            + "ON country.Capital = city.ID "
                            + "WHERE country.Region " + "LIKE \"%" + region + "%\" "
                            + "ORDER BY country.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract Country information
            ArrayList<Country> countries = new ArrayList<>();

            while (rset.next()) {
                Country country = new Country();
                country.code = rset.getString("country.Code");
                country.name = rset.getString("country.Name");
                country.continent = rset.getString("country.Continent");
                country.region = rset.getString("country.Region");
                country.population = rset.getInt("country.Population");
                country.capital = rset.getString("city.Name");
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

//--------------------------------------------------------------------------------------------------------------------//
/**
 * gets the top populated countries with the number of rows selected given by user. - report 4
 * @param selected the number of rows to be selected inputted by user
 * @param con connection to database
 * @return returns null if fail or a list of countries
 */

    public static ArrayList<Country> getTopPopulatedCountries(int selected, Connection con){
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, " +
                            "country.Population, city.Name "
                            + "FROM country, city "
                            + "WHERE country.Capital = city.ID "
                            + "ORDER BY country.Population DESC "
                            + "LIMIT " + selected;

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract Country information
            ArrayList<Country> countries = new ArrayList<>();

            while (rset.next()) {
                Country country = new Country();
                country.code = rset.getString("country.Code");
                country.name = rset.getString("country.Name");
                country.continent = rset.getString("country.Continent");
                country.region = rset.getString("country.Region");
                country.population = rset.getInt("country.Population");
                country.capital = rset.getString("city.Name");
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }

    }

//--------------------------------------------------------------------------------------------------------------------//
    /** Print table of countries extracted
     * Author - AOB
     * @param countries list of countries to display
     */
    //Print list of countries in the world
    public static void printCountries(ArrayList<Country> countries)
    {
        if (countries == null)
        {
            System.out.println("No countries");
            return;
        }
        //Print header
        System.out.printf("\n %s %s %s %s %s %s%n", "Code", "Name", "Continent",
                "Region", "Population", "Capital");

        for (Country country : countries)
        {
            if (country == null)
                continue;
            String country_string =
                    String.format("%s %s %s %s %s %s", country.code, country.name, country.continent,
                            country.region, country.population, country.capital);
            System.out.println(country_string);
        }
    }
}
//--------------------------------------------------------------------------------------------------------------------//