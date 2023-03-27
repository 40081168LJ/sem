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

    /**
     * Stores Continent
     */
    public String continent;

    /**
     * Stores City
     */

    public String city;

    /**
     * Stores country
     */

    public String country;


//--------------------------------------------------------------------------------------------------------------------//

    /**
     * Create an SQL Statement to get world population
     * *  Used in additional_info 1 report
     **/
    public static Population getPopulation(Connection con) {
        try {
            Statement stmt = con.createStatement();
            String strSelect = "SELECT SUM(population) as `popTotal` FROM country";
            // Execute SQL Statement and return population
            ResultSet rset = stmt.executeQuery(strSelect);
            Population pop = new Population();
            rset.next();
            pop.population = rset.getLong("popTotal");
            return pop;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world population for: Report additional info 1 ");
            return null;
        }
    }

//--------------------------------------------------------------------------------------------------------------------//

    /**
     * Displays world population
     *
     * @param population
     */
    public static void displayPopulation(Population population) {
        if (population != null) {
            System.out.println("World Population : " + population.population);
        }
    }


//--------------------------------------------------------------------------------------------------------------------//

    /**
     * Gets population of each Continent.
     * Used for additional report 2
     *
     * @param con
     * @return
     */

    public static ArrayList<Population> getContinentPopulation(Connection con) {
        try {

            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "(SELECT Continent, SUM(Population)"
                            + " FROM country"
                            + " GROUP BY Continent)";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract Language information
            ArrayList<Population> populations = new ArrayList<>();

            //
            while (rset.next()) {

                Population population = new Population();
                population.population = rset.getLong("SUM(Population)");
                population.continent = rset.getString("Continent");
                populations.add(population);
            }
            return populations;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get populations of Continents.");
            return null;
        }
    }


//--------------------------------------------------------------------------------------------------------------------//

    /**
     * Displays population of each continent
     *
     * @param populations
     */
    public static void displayContinentPopulations(ArrayList<Population> populations) {
        if (populations == null) {
            System.out.println("Populations of continents could now be displayed");
            return;
        }
        //Print header
        System.out.printf("\n %s %s%n", "Continent", "Population");

        for (Population population : populations) {
            if (population == null)
                continue;
            String continentsString =
                    String.format("%s %s ", population.continent, population.population);

            System.out.println(continentsString);
        }
    }


//--------------------------------------------------------------------------------------------------------------------//

    /**
     * Used to get population of a city. Used in Additional info 6 - report 31
     *
     * @param con
     * @return
     */
    public static ArrayList<Population> getcityPopulation(Connection con) {
        try {

            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "(SELECT Name, SUM(Population)"
                            + " FROM city"
                            + " GROUP BY Name)";

            // Execute population information
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract population information
            ArrayList<Population> populations = new ArrayList<>();

            //Get values to be displayed
            while (rset.next()) {

                Population population = new Population();
                population.population = rset.getLong("SUM(Population)");
                population.city = rset.getString("Name");
                populations.add(population);
            }
            return populations;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get populations of cities.");
            return null;
        }

    }


//--------------------------------------------------------------------------------------------------------------------//

    /**
     * Displays City Populations
     *
     * @param populations
     */
    public static void displayCityPopulations(ArrayList<Population> populations) {
        if (populations == null) {
            System.out.println("Populations of cities could not be displayed");
            return;
        }

        //Print header
        System.out.printf("\n $s $s%n", "city: ", "Population");

        for (Population population : populations) {
            if (population == null)
                continue;
            String cityString =
                    String.format("%s %s ", population.city, population.population);

            System.out.println(cityString);
        }
    }


//--------------------------------------------------------------------------------------------------------------------//

    public static ArrayList<Population> getCountryPopulations(Connection con) {
        try {

            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "(SELECT Name, SUM(Population)"
                            + " FROM country"
                            + " GROUP BY Name)";

            // Execute population information
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract population information
            ArrayList<Population> populations = new ArrayList<>();

            //Get values to be displayed
            while (rset.next()) {

                Population population = new Population();
                population.population = rset.getLong("SUM(Population)");
                population.country = rset.getString("Name");
                populations.add(population);
            }
            return populations;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get populations of countries.");
            return null;
        }

    }


//--------------------------------------------------------------------------------------------------------------------//

    public static void displayCountryPopulations(ArrayList<Population> populations) {
        if (populations == null) {
            System.out.println("Populations of countries could not be displayed");
            return;

        }
        //Print header
        System.out.printf("\n %s %S%n", "City", "Population");

        for (Population population : populations) {
            if (population == null)
                continue;
            String countriesString =
                    String.format("%s %S ", population.country, population.population);

            System.out.println(countriesString);
        }


    }

}