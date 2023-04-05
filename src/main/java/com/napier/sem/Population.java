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

    /**
     * Stores District
     */

    public String district;

    /**
     * Stores Region
     */

    public String region;

//--------------------------------------------------------------------------------------------------------------------//

    /**
     * Create an SQL Statement to get world population
     * Used in additional_info 1 report
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
     * @param population stores population
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
     * @param con connection to database
     * @return returns populations or null if fail
     */

    public static ArrayList<Population> getContinentPopulation(String continentPop, Connection con) {
        try {

            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "(SELECT Continent, SUM(Population)"
                            + " FROM country"
                            + " WHERE Continent LIKE \"%" + continentPop + "%\" "
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
     * @param populations stores population
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
     * @param con connection to database
     * @return returns population or null if fail
     */
    public static ArrayList<Population> getcityPopulation(String cityPop, Connection con) {
        try {

            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "(SELECT Name, SUM(Population)"
                            + " FROM city"
                            + " WHERE Name LIKE \"%" + cityPop + "%\" "
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
     * @param populations stores population
     */
    public static void displayCityPopulations(ArrayList<Population> populations) {
        if (populations == null) {
            System.out.println("Populations of cities could not be displayed");
            return;
        }

        //Print header
        System.out.printf("\n $s $s%n", "city ", "Population");
        // TODO: Warning flagged here: "Too many arguments for format string (found 2, expected 0)"

        for (Population population : populations) {
            if (population == null)
                continue;
            String cityString =
                    String.format("%s %s ", population.city, population.population);

            System.out.println(cityString);
        }
    }


//--------------------------------------------------------------------------------------------------------------------//

    /**
     * Used to get Country Populations
     * @param con connection to database
     * @return returns populations or null if fails
     */
    public static ArrayList<Population> getCountryPopulations(String countryPop, Connection con) {
        try {

            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "(SELECT Name, SUM(Population)"
                            + " FROM country"
                            + " WHERE Name LIKE \"%" + countryPop + "%\" "
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

    /**
     * Used to display populations of countries
     * @param populations used to store populations
     */
    public static void displayCountryPopulations(ArrayList<Population> populations) {
        if (populations == null) {
            System.out.println("Populations of countries could not be displayed");
            return;

        }
        //Print header
        System.out.printf("\n %s %S%n", "Country", "Population");

        for (Population population : populations) {
            if (population == null)
                continue;
            String countriesString =
                    String.format("%s %S ", population.country, population.population);

            System.out.println(countriesString);
        }


    }


//--------------------------------------------------------------------------------------------------------------------//

    /**
     * Used to get populations of districts used in report 30 - Additional info 5
     * @param con database connection
     * @return returns populations
     */
    public static ArrayList<Population> getDistrictPopulation(String districtPop, Connection con) {
        try {

            Statement stmt = con.createStatement();

            //Create string for sql statement
            String strSelect =
                    "(SELECT District, SUM(Population)"
                            + " FROM city"
                            + " WHERE Region LIKE \"%" + districtPop + "%\" "
                            + " GROUP BY District)";

            //Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            //Extract population information
            ArrayList<Population> populations = new ArrayList<>();

            //Get values to be displayed
            while (rset.next()) {

                Population population = new Population();
                population.population = rset.getLong("SUM(Population)");
                population.district = rset.getString("District");
                populations.add(population);
            }
            return populations;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get populations of Districts.");
            return null;
        }

    }


//--------------------------------------------------------------------------------------------------------------------//

    /**
     * Used to display districts populations. Used in report 30 Additional info 5
     * @param populations Used to store populations
     */
    public static void displayDistrictPopulations(ArrayList<Population> populations) {
        if (populations == null) {
            System.out.println("Populations of Districts could not be displayed");
            return;
        }
        //Print header
        System.out.printf("\n %s %s%n", "District", "Population");

        for (Population population : populations) {
            if (population == null)
                continue;
            String DistrictsString =
                    String.format("%s %s ", population.district, population.population);

            System.out.println(DistrictsString);
        }

    }


//--------------------------------------------------------------------------------------------------------------------//

    /**
     * Used to get populations of Regions used in report 38 - Additional info 3
     * @param con database connection
     * @return returns populations
     */
    public static ArrayList<Population> getRegionPopulation(String regionPop, Connection con) {
        try {

            Statement stmt = con.createStatement();

            //Create string for sql statement
            String strSelect =
                    "(SELECT Region, SUM(Population)"
                            + " FROM country"
                            + " WHERE Region LIKE \"%" + regionPop + "%\" "
                            + " GROUP BY Region)";

            //Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            //Extract population information
            ArrayList<Population> populations = new ArrayList<>();

            //Get values to be displayed
            while (rset.next()) {

                Population population = new Population();
                population.population = rset.getLong("SUM(Population)");
                population.region = rset.getString("Region");
                populations.add(population);
            }
            return populations;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get populations of Regions.");
            return null;
        }

    }


//--------------------------------------------------------------------------------------------------------------------//

    /**
     * Used to display Region populations. Used in report 24 Additional info 3
     * @param populations Used to store populations
     */
    public static void displayRegionPopulation(ArrayList<Population> populations) {
        if (populations == null) {
            System.out.println("Populations of Regions could not be displayed");
            return;
        }
        //Print header
        System.out.printf("\n %s %s%n", "Region", "Population");

        for (Population population : populations) {
            if (population == null)
                continue;
            String regionsString =
                    String.format("%s %s ", population.region, population.population);

            System.out.println(regionsString);
        }

    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Gets population of each Continent.
     * Used for report 23
     * @param con connection to database
     * @return returns populations or null if fail
     */

    public static ArrayList<Population> getContinentPopulation2(Connection con) {
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
     * Displays population of each continent for Report 23
     * @param populations stores population
     */
    public static void displayContinentPopulation2(ArrayList<Population> populations) {
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

}

//--------------------------------------------------------------------------------------------------------------------//

