package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.napier.sem.*;
/**
 * city object
 **/
public class City {
        /** ID column */
        public int iD;

        /**  City name string column  */
        public String name;

        /** Country Code sting column  */
        public String countryCode;

        /** District string column */
        public String district;

        /** Population int column */

        public int population;

        /**  Country string column */
        public String country;

        public static ArrayList<City> getCityPopulationByContinent(String continent, Connection con) {
                try {
                        Statement stmt = con.createStatement();
                        // Create string for SQL statement
                        String strSelect =
                                "SELECT city.Name, country.Name, city.District, city.Population " +
                                        "FROM city " +
                                        "JOIN country " +
                                        "ON city.countrycode = country.Code " +
                                        "WHERE country.continent " + "LIKE \"%" + continent + "%\" " +
                                        "ORDER BY city.population DESC";
                        // Execute SQL statement
                        ResultSet rset = stmt.executeQuery(strSelect);

                        // Extract city information
                        ArrayList<City> cities = new ArrayList<>();

                        //adds each city to cities
                        while (rset.next()) {
                                City city = new City();
                                city.name = rset.getString("city.Name");
                                city.country = rset.getString("country.Name");
                                city.district = rset.getString("city.District");
                                city.population = rset.getInt("city.Population");
                                cities.add(city);
                        }
                        return cities;
                } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Failed to get city details");
                        return null;
                }

        }
        /**Display cities when given a list of cities
         *@param cities
         */
        public static void displayCites (ArrayList <City> cities) {
                if (cities == null) {
                        System.out.println("no cities have been found");
                        return;
                }
                //Print header
                System.out.printf("\n %s %s %s %s%n", "City Name", "City Country", "City District", "City Population");

                for (City city : cities) {
                        if (city == null)
                                continue;
                        String citiesString =
                                String.format("%s %s %s %s ", city.name, city.country, city.district,
                                        city.population);

                        System.out.println(citiesString);
                }
        }
}

