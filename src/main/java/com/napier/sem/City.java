package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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

        /**
         *
         * @param con connection to database
         * @return
         */
        public static City getCityPopulationDescending(Connection con) {
                try {

                        Statement stmt = con.createStatement();
                        // Create string for SQL statement
                        String strSelect =
                                "SELECT ID, Name, CountryCode, District, Population " +
                                        "FROM city " +
                                        "ORDER BY CITY DESC";

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
                        }
                        else
                        return null;

                } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Failed to get city details");
                        return null;
                }
        }

        public static void displayCity(City city)
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

    }

