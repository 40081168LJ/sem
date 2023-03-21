package com.napier.sem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *used to interact with the MySQL database
 */
public class App {
    /**
     * Connection to MySQL database.
     */
    public Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect() {
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
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world", "root", "example");
                System.out.println("Successfully connected to database");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

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

    /**
     * connects to the database and gets a employee and displays the employee
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // Get city
        City city = a.getCity(1);
        // Display results
        a.displayCity(city);

        // Disconnect from database
        a.disconnect();

    }


    public City getCity(int ID) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT ID, Name, CountryCode, District, Population "
                            + "FROM city ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Check one is returned
            if (rset.next()) {
                City city = new City();
                city.iD = rset.getInt("id");
                city.name = rset.getString("name");
                city.countryCode = rset.getString("countrycode");
                city.district = rset.getString("district");
                city.population = rset.getInt("population");
                return city;
            } else
                return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }
    public void displayCity(City city)
    {
        if (city != null)
        {
            System.out.println("ID: " + city.iD + " "
                            + "City Name: " + city.name + " "
                            + "City Country Code: " + city.countryCode + "\n"
                            + "City District: " + city.district + "\n"
                            + "City Population: " + city.population + "\n"
                            + "City Country: " + city.country + "\n");
        }
    }

    /** Languages SQL
     * Author - LJ
     */
    public Language getLanguage(String Code)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT CountryCode, Language, IsOfficial, Percentage "
                            + "FROM countrylanguage "
                            + "WHERE CountryCode = " + "CountryCode";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new city if valid.
            // Check one is returned
            if (rset.next())
            {
                Language countryLanguage2 = new Language();
                countryLanguage2.countryCode = rset.getString("CountryCode");
                countryLanguage2.language = rset.getString("Language");
                countryLanguage2.isOfficial = rset.getString("IsOfficial");
                countryLanguage2.percentage = rset.getInt("Percentage");
                return countryLanguage2;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get language details");
            return null;
        }
    }
    public void displayCountryLanguage(Language countryLanguage2)
    {
        if (countryLanguage2 != null)
        {
            System.out.println(
                    countryLanguage2.countryCode + "\n"
                            + countryLanguage2.language + "\n"
                            + countryLanguage2.isOfficial + "\n"
                            + countryLanguage2.percentage + "\n");
        }
    }
}