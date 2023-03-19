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
     * connects to the datab base and gets a employee and displays the employee
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();



        //Extract country information
        ArrayList<Country> countries = a.getAllCountries();

        //Test Test Test
        a.printCountries(countries);

        // Disconnect from database
        a.disconnect();

    }




    public ArrayList<Country> getAllCountries() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country "
                            + "ORDER BY population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract Country information
            ArrayList<Country> countries = new ArrayList<Country>();

            while (rset.next()) {
                Country country = new Country();
                country.code = rset.getString("code");
                country.name = rset.getString("name");
                country.continent = rset.getString("continent");
                country.region = rset.getString("region");
                country.population = rset.getInt("population");
                country.capital = rset.getString("capital");
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    //Print list of countries in the world
    public void printCountries(ArrayList<Country> countries)
    {   //Print header
        System.out.println(String.format("%s %s %s %s %s %s", "Code", "Name", "Continent",
                "Region", "Population", "Capital"));

        for (Country country : countries)
        {
            String country_string =
                    String.format("%s %s %s %s %s %s", country.code, country.name, country.continent,
                    country.region, country.population, country.capital);
            System.out.println(country_string);
        }
    }

}
