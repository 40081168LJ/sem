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

    /**
     * the name of city
     */

    public String name;

    /**
     * Stores Population inside Cities
     */

    public String inCities;

    /**
     * Stores Population outside Cities
     */
    public String outCities;

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
            while (rset.next()) {
                pop.population = rset.getLong("popTotal");
            }
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
     * @param populations stores population
     */
    public static void displayCityPopulations(ArrayList<Population> populations) {
        if (populations == null) {
            System.out.println("Populations of cities could not be displayed");
            return;
        }

        //Print header
        System.out.printf("\n %s %s%n", "city ", "Population");

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
    public static ArrayList<Population> getDistrictPopulation(Connection con) {
        try {

            Statement stmt = con.createStatement();

            //Create string for sql statement
            String strSelect =
                    "(SELECT District, SUM(Population)"
                            + " FROM city"
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
            String districtsString =
                    String.format("%s %s ", population.district, population.population);

            System.out.println(districtsString);
        }

    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Used to get populations of Regions used in report 28 - Additional info 3
     * @param con database connection
     * @return returns populations
     */
    public static ArrayList<Population> getRegionPopulation(Connection con) {
        try {

            Statement stmt = con.createStatement();

            //Create string for sql statement
            String strSelect =
                    "(SELECT Region, SUM(Population)"
                            + " FROM country"
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
     * Used to display Region populations. Used in Additional info 3
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
     * Used to display Region populations. Used in report 24
     * @param populations Used to store populations
     */
    public static void displayRegionPopulation2(ArrayList<Population> populations) {
        if (populations == null) {
            System.out.println("Populations of Region(s) could not be displayed");
            return;
        }
        //Print header
        System.out.printf("\n %s %s %s %s%n", "Region", "Population", "Out Cities", "In Cities");

        for (Population population : populations) {
            if (population == null)
                continue;
            String regionsString =
                    String.format("%s %s %s %s ", population.region, population.population, population.inCities, population.outCities);

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
                    "(SELECT country.Continent, SUM(country.Population),"
                            + " CONCAT((SUM(city.population)/SUM(country.Population)*100), '%'),"
                            + " CONCAT(((SUM(country.Population)-SUM(city.Population))/SUM(country.Population)*100), '%')"
                            + " FROM country, city"
                            + " WHERE city.CountryCode = country.Code"
                            + " GROUP BY country.Continent)";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract Language information
            ArrayList<Population> populations = new ArrayList<>();

            //
            while (rset.next()) {

                Population population = new Population();
                population.continent = rset.getString("country.Continent");
                population.population = rset.getLong("SUM(country.Population)");
                population.inCities = rset.getString("CONCAT((SUM(city.population)/SUM(country.Population)*100), '%')");
                population.outCities = rset.getString("CONCAT(((SUM(country.Population)-SUM(city.Population))/SUM(country.Population)*100), '%')");
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
            System.out.println("Populations of continents could not be displayed");
            return;
        }
        //Print header, Name, Population, Living in Cities  as %, Living outside of Cities as %
        System.out.printf("\n %s %s %s %s%n", "Name", "Population", "Out Cities", "In Cities");

        for (Population population : populations) {
            if (population == null)
                continue;
            String continentsString =
                    String.format("%s %s %s %s ", population.continent, population.population, population.inCities, population.outCities);

            System.out.println(continentsString);
        }
    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Gets population of each Region.
     * Used for report 24
     * @param con connection to database
     * @return returns populations or null if fail
     */
    public static ArrayList<Population> getCountryPopulation2(Connection con) {
        try {

            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "(SELECT country.Name, country.Population,"
                            + " CONCAT((SUM(city.population)/country.Population*100), '%'),"
                            + " CONCAT(((country.Population-SUM(city.Population))/country.Population*100), '%')"
                            + " FROM country, city"
                            + " WHERE city.CountryCode = country.Code"
                            + " GROUP BY country.Code)";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract Language information
            ArrayList<Population> populations = new ArrayList<>();

            //
            while (rset.next()) {

                Population population = new Population();
                population.country = rset.getString("country.Name");
                population.population = rset.getLong("country.Population");
                population.inCities = rset.getString("CONCAT((SUM(city.population)/country.Population*100), '%')");
                population.outCities = rset.getString("CONCAT(((country.Population-SUM(city.Population))/country.Population*100), '%')");
                populations.add(population);
            }
            return populations;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get populations of Countries.");
            return null;
        }
    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Used to display Region populations. Used in report 24
     * @param populations Used to store populations
     */
    public static void displayCountryPopulation2(ArrayList<Population> populations) {
        if (populations == null) {
            System.out.println("Populations of the cities in the selected country could not be displayed");
            return;
        }
        //Print header
        System.out.printf("\n %s %s %s %s%n", "Country", "Population", "Out Cities", "In Cities");

        for (Population population : populations) {
            if (population == null)
                continue;
            String countryString =
                    String.format("%s %s %s %s ", population.country, population.population, population.inCities, population.outCities);

            System.out.println(countryString);
        }

    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Gets population of each Region.
     * Used for report 24
     * @param con connection to database
     * @return returns populations or null if fail
     */
    public static ArrayList<Population> getRegionPopulation2(Connection con) {
        try {

            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "(SELECT country.Region, SUM(country.Population),"
                            + " CONCAT((SUM(city.population)/SUM(country.Population)*100), '%'),"
                            + " CONCAT(((SUM(country.Population)-SUM(city.Population))/SUM(country.Population)*100), '%')"
                            + " FROM country, city"
                            + " WHERE city.CountryCode = country.Code"
                            + " GROUP BY country.Region)";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract Language information
            ArrayList<Population> populations = new ArrayList<>();

            //
            while (rset.next()) {

                Population population = new Population();
                population.region = rset.getString("country.Region");
                population.population = rset.getLong("SUM(country.Population)");
                population.inCities = rset.getString("CONCAT((SUM(city.population)/SUM(country.Population)*100), '%')");
                population.outCities = rset.getString("CONCAT(((SUM(country.Population)-SUM(city.Population))/SUM(country.Population)*100), '%')");
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
     * Used to get capitalCities from Continent - report 18
     * @param continentPop stores continent population
     * @param con connection to database
     * @return returns capitalCities
     */
    public static ArrayList<City> getCapitalCitiesByContinent(String continentPop, Connection con) {
        try {
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.Population " +
                            "FROM country " +
                            "JOIN city " +
                            "ON city.countrycode = country.Code " +
                            "WHERE city.id IN (SELECT Capital FROM country)" +
                            "AND country.Continent LIKE \"%" + continentPop + "%\" " +
                            "ORDER BY city.population DESC ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract city information
            ArrayList<City> capitalCities = new ArrayList<>();

            //adds each city to cities
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("city.Name");
                city.country = rset.getString("country.Name");
                city.population = rset.getInt("city.Population");
                capitalCities.add(city);
            }
            return capitalCities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital city details");
            return null;
        }
    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Gets top populated capital cities in a region - Used in report 19
     * @param regionPop stores region
     * @param con Database Connection
     * @return return capital cities
     */
    public static ArrayList<City> getTopCapitalCitiesInRegion( String regionPop, Connection con) {
        try {
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.Population " +
                            "FROM city " +
                            "JOIN country " +
                            "ON city.countrycode = country.Code " +
                            "WHERE city.id IN (SELECT Capital FROM country)" +
                            "AND country.region LIKE \"%" + regionPop + "%\" " +
                            "ORDER BY city.population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract city information
            ArrayList<City> capitalCities = new ArrayList<>();

            //adds each city to cities
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("city.Name");
                city.country = rset.getString("country.Name");
                city.population = rset.getInt("city.Population");
                capitalCities.add(city);
            }
            return capitalCities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital city details");
            return null;
        }
    }

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Displays Capital Cities In a Region Used in Report 19
     * @param capitalCities stores capital cities
     */
    public static void displayCapitalCitesInRegion(ArrayList<City> capitalCities) {
        if (capitalCities == null)
        {
            System.out.println("no cities have been found");
            return;
        }
        //Print header
        System.out.printf("\n %s %s %s%n", "Name", "Country", "Population");

        for (City city : capitalCities)
        {
            if (city == null)
                continue;
            String citiesString =
                    String.format("%s %s %s ", city.name, city.country, city.population);

            System.out.println(citiesString);
        }
    }
}