package com.napier.sem;

//--------------------------------------------------------------------------------------------------------------------//
import java.sql.*;
import java.util.ArrayList;

//--------------------------------------------------------------------------------------------------------------------//
/**
 * Class to calculate world population
 */
public class Population {

    /**
     * stores population
     */
    public long population;

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Create an SQL Statement to get world population
     * Used in additional_info 1 report
     **/
    public static Population getPopulation(Connection con){
        try{
            Statement stmt = con.createStatement();
            String strSelect = "SELECT SUM(population) as `popTotal` FROM country";
            // Execute SQL Statement and return population
            ResultSet rset = stmt.executeQuery(strSelect);
            Population pop = new Population();
            rset.next();
            pop.population = rset.getLong("popTotal");
            return pop;
        } catch (Exception e)    {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world population for: Report additional info 1 ");
            return null;    }
    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Create an SQL Statement to get Population by Region
     */
    public static ArrayList<Country> getRegionPopulation(Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Continent, country.Region, country.Name," +
                            " SUM(country.Population) AS 'Total Population'"
                            + " FROM country"
                            + " GROUP BY country.Continent, country.Region, country.Name"
                            + " ORDER BY country.Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract Country information
            ArrayList<Country> countries = new ArrayList<>();

            while (rset.next()) {
                Country country = new Country();
                country.continent = rset.getString("country.Continent");
                country.region = rset.getString("country.Region");
                country.name = rset.getString("country.Name");
                country.population = rset.getInt("country.Population");

                countries.add(country);
            }
            return countries;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Region Population details");
            return null;
        }
    }

//--------------------------------------------------------------------------------------------------------------------//

    /**
     * Displays world population
     * @param population
     */
    public static void displayPopulation(Population population){
        if (population != null)    {
            System.out.println("World Population : "+ population.population);
        }
    }


//--------------------------------------------------------------------------------------------------------------------//
/**
 * Create an SQL Statement to get Population by Region
  */
public static void displayRegionPopulation(ArrayList<Country> countries)
{
    if (countries == null)
    {
        System.out.println("No Region Populations to display");
        return;
    }
    //Print header
    System.out.printf("\n %s %s %s %s %n", "Continent", "Region", "Name", "Population");

    for (Country country : countries)
    {
        if (country == null)
            continue;
        String country_string =
                String.format("%s %s %s %s", country.continent, country.region, country.name, country.population);
        System.out.println(country_string);
    }
}

}

//--------------------------------------------------------------------------------------------------------------------//
