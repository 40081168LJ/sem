package com.napier.sem;
/**********************************************************************************************************************/
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
/**********************************************************************************************************************/
/**
 *used to interact with the MySQL database
 */
public class App {
    /**
     * Connection to MySQL database.
     */
    public Connection con;

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
                System.out.println("Successfully disconnected from database");
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }
/**********************************************************************************************************************/
    /**
     * connects to the datab base and gets a employee and displays the employee
     * @param args
     */
    public static void main(String[] args) throws IOException {
        /*****************************************************************/
        // Create new Application
        App con = new App();
        /*****************************************************************/
        // Connect to database
        if (args.length < 1) {
            con.connect("localhost:33060", 30000);
        } else {
            con.connect("db:3306", 30000);
        }
        /*****************************************************************/
        // REPORT 1
        // Extract country information
        ArrayList<Country> countries = con.getAllCountries();
        // Print table of countries in the world
        con.printCountries(countries);
        /*****************************************************************/
        // REPORT 2
        // Extract country by continent information
        ArrayList<Country> countries1 = con.getContinentCountries();
        // Print table of countries in a continent e.g. Asia
        con.printCountries(countries1);
        /*****************************************************************/
        // REPORT 3
        // Extract country by region information
        ArrayList<Country> countries2 = con.getRegionCountries();
        // Print table of countries in a region e.g. Western Europe
        con.printCountries(countries2);
        /*****************************************************************/
        // LANGUAGE REPORT 1
        // Show all conuntry where language = Chinese

        /*****************************************************************/

        /*****************************************************************/
        // Disconnect from database
        con.disconnect();
        /*****************************************************************/
    }
/**********************************************************************************************************************/
    /** Extract all countries in the world, order by population descending
     * Author - AOB
     * @return
     */
    public ArrayList<Country> getAllCountries() {
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
            ArrayList<Country> countries = new ArrayList<Country>();

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
/**********************************************************************************************************************/
    /** Extract all countries in specified continent, ordered by population
     * Author - AOB
     * @return
     */
    public ArrayList<Country> getContinentCountries() {
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
            ArrayList<Country> countries = new ArrayList<Country>();

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
/**********************************************************************************************************************/
    /** Extract countries in specified region, order by population descending
     * Author - AOB
     * @return
     */
    public ArrayList<Country> getRegionCountries() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, " +
                            "country.Population, city.Name "
                            + "FROM country, city "
                            + "WHERE country.Capital = city.ID AND country.Region = 'Western Europe' "
                            + "ORDER BY country.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract Country information
            ArrayList<Country> countries = new ArrayList<Country>();

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
/**********************************************************************************************************************/
    /** Print table of countries extracted
     * Author - AOB
     * @param countries
     */
    //Print list of countries in the world
    public void printCountries(ArrayList<Country> countries)
    {
        if (countries == null)
        {
            System.out.println("No countries");
            return;
        }
        //Print header
        System.out.println(String.format("\n %s %s %s %s %s %s", "Code", "Name", "Continent",
                "Region", "Population", "Capital"));

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
/**********************************************************************************************************************/
    /**
     * @param Code
     * @return
     */
    public Language getLanguages1(String Code) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            //CreatestringforSQLstatement
            String strSelect =
                    "SELECT CountryCode, Language, IsOfficial, Percentage"
                            + "FROM countrylanguage"
                            + "WHERE Language = " + "'Chinese'";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            //Return new language if valid.
            //Check one is returned
            if (rset.next()) {
                Language countryLanguage1 = new Language();
                countryLanguage1.countryCode = rset.getString("CountryCode");
                countryLanguage1.language = rset.getString("Language");
                countryLanguage1.isOfficial = rset.getString("IsOfficial");
                countryLanguage1.percentage = rset.getInt("Percentage");
                return countryLanguage1;
            } else
                return null;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("FailedtogetLanguageInformatoion");
        }
        return null;
    }
/**********************************************************************************************************************/
    /**
     *Display Country Language where Language = Chinese
     *@paramcountryLanguage1
     */
    public void displayCountryLanguage1(Language countryLanguage1) {
        if (countryLanguage1 != null) {
            System.out.println(
                    countryLanguage1.countryCode + "\n"
                            + countryLanguage1.language + "\n"
                            + countryLanguage1.isOfficial + "\n"
                            + countryLanguage1.percentage + "\n");
        }
    }
/**********************************************************************************************************************/
    public void connect(String location, int delay) {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(delay);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location
                                + "/world?allowPublicKeyRetrieval=true&useSSL=false",
                        "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }
/**********************************************************************************************************************/
}

