package com.napier.sem;

//--------------------------------------------------------------------------------------------------------------------//
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

//--------------------------------------------------------------------------------------------------------------------//
/**
 * city object
 **/
public class City {

        /**  City name string column  */
        public String name;

        /** District string column */
        public String district;

        /** Population int column */
        public int population;

        /**  Country string column */
        public String country;

        /** Stores region */
        public String region;

//--------------------------------------------------------------------------------------------------------------------//
        /**
         * gets Report 7
         * @param con connection to database
         * @return returns a list of cities or null if fails
         */
        public static ArrayList<City> getCityPopulation(Connection con) {
                try {

                        Statement stmt = con.createStatement();
                        // Create string for SQL statement
                        String strSelect =
                                "SELECT city.Name, country.Name, city.District, city.Population " +
                                        "FROM city " +
                                        "JOIN country " +
                                        "ON city.countrycode = country.Code " +
                                        "ORDER BY city.population DESC";

                        // Execute SQL statement
                        ResultSet rset = stmt.executeQuery(strSelect);

                        // Extract Language information
                        ArrayList<City> cities = new ArrayList<>();

                        //Return new language if valid.
                        //Check one is returned
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

//--------------------------------------------------------------------------------------------------------------------//
        /**
         * gets the top populated cities with the number of rows selected given by user. - report 12
         * @param selected the number of rows to be selected inputted by user
         * @param con connection to database
         * @return returns null if fail or a list of cities
         */
        public static ArrayList<City> getTopPopulatedCities(int selected, Connection con) {
                try {
                        Statement stmt = con.createStatement();
                        // Create string for SQL statement
                        String strSelect =
                                "SELECT city.Name, country.Name, city.District, city.Population " +
                                        "FROM city " +
                                        "JOIN country " +
                                        "ON city.countrycode = country.Code " +
                                        "ORDER BY city.population DESC " +
                                        "LIMIT " + selected;
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

//--------------------------------------------------------------------------------------------------------------------//
        /**
         * gets the cities of a single region when given a region. - report 9
         * @param region The region used to select cities from
         * @param con connection to database
         * @return returns null if fail or a list of cities
         */
        public static ArrayList<City> getCityPopulationByRegion(String region, Connection con) {
                try {
                        Statement stmt = con.createStatement();
                        // Create string for SQL statement
                        String strSelect =
                                "SELECT city.Name, country.Name, city.District, city.Population " +
                                        "FROM city " +
                                        "JOIN country " +
                                        "ON city.countrycode = country.Code " +
                                        "WHERE country.Region " + "LIKE \"%" + region + "%\" " +
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

//--------------------------------------------------------------------------------------------------------------------//
        /**
         * gets the cities of a single district when given a district. - report 11
         * @param district The district used to select cities from
         * @param con connection to database
         * @return returns null if fail or a list of cities
         */
        public static ArrayList<City> getCityPopulationByDistrict(String district, Connection con) {
                try {
                        Statement stmt = con.createStatement();
                        // Create string for SQL statement
                        String strSelect =
                                "SELECT city.Name, country.Name, city.District, city.Population " +
                                        "FROM city " +
                                        "JOIN country " +
                                        "ON city.countrycode = country.Code " +
                                        "WHERE city.district " + "LIKE \"%" + district + "%\" " +
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

//--------------------------------------------------------------------------------------------------------------------//
        /**
         * gets the top populated cities with the number of rows selected and continent given by user. - report 14
         * @param selected the number of rows to be selected inputted by user
         * @param region the region to select rows from
         * @param con connection to database
         * @return returns null if fail or a list of cities
         */
        public static ArrayList<City> getTopCitiesByRegion(int selected, String region, Connection con) {
                try {
                        Statement stmt = con.createStatement();
                        // Create string for SQL statement
                        String strSelect =
                                "SELECT city.Name, country.Name, city.District, city.Population " +
                                        "FROM city " +
                                        "JOIN country " +
                                        "ON city.countrycode = country.Code " +
                                        "WHERE country.region LIKE \"%" + region + "%\" " +
                                        "ORDER BY city.population DESC " +
                                        "LIMIT " + selected;
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

//--------------------------------------------------------------------------------------------------------------------//
        /**
         * gets the top populated cities with the number of rows selected and continent given by user. - report 12
         * @param selected the number of rows to be selected inputted by user
         * @param continent the continent to select rows from
         * @param con connection to database
         * @return returns null if fail or a list of cities
         */
        public static ArrayList<City> getTopCitiesByContinent(int selected, String continent, Connection con) {
                try {
                        Statement stmt = con.createStatement();
                        // Create string for SQL statement
                        String strSelect =
                                "SELECT city.Name, country.Name, city.District, city.Population " +
                                        "FROM city " +
                                        "JOIN country " +
                                        "ON city.countrycode = country.Code " +
                                        "WHERE country.continent LIKE \"%" + continent + "%\" " +
                                        "ORDER BY city.population DESC " +
                                        "LIMIT " + selected;
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

//--------------------------------------------------------------------------------------------------------------------//
        /**
         * gets the top populated cities with the number of rows selected and country given
         * by user - report 15
         * @param selected the number of rows to be selected inputted by user
         * @param country the country to select rows from
         * @param con connection to database
         * @return returns null if fail or a list of cities
         */

        public static ArrayList<City> getTopCitiesByCountry(int selected, String country, Connection con) {
                try {
                        Statement stmt = con.createStatement();
                        // Create string for SQL statement
                        String strSelect =
                                "SELECT city.Name, country.Name, city.District, city.Population " +
                                        "FROM city " +
                                        "JOIN country " +
                                        "ON city.countrycode = country.Code " +
                                        "WHERE country.name LIKE \"%" + country + "%\" " +
                                        "ORDER BY city.population DESC " +
                                        "LIMIT " + selected;
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
//--------------------------------------------------------------------------------------------------------------------//
        /**
         * gets the cities of a single continent when given a continent. - report 10
         * @param country The country used to select cities from
         * @param con connection to database
         * @return returns null if fail or a list of cities
         */
        public static ArrayList<City> getCitiesByCountry(String country, Connection con) {
                try {
                        Statement stmt = con.createStatement();
                        // Create string for SQL statement
                        String strSelect =
                                "SELECT city.Name, country.Name, city.District, city.Population " +
                                        "FROM city " +
                                        "JOIN country " +
                                        "ON city.countrycode = country.Code " +
                                        "WHERE country.name " + "LIKE \"%" + country + "%\" " +
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


//--------------------------------------------------------------------------------------------------------------------//
        /**Display cities when given a list of cities - report 7
         *@param cities a list of the city object to display
         */
        public static void displayCites(ArrayList<City> cities) {
                if (cities == null)
                {
                        System.out.println("no cities have been found");
                        return;
                }
                //Print header
                System.out.printf("\n %s %s %s %s%n", "Name", "Country", "District", "Population");

                for (City city : cities)
                {
                        if (city == null)
                                continue;
                        String citiesString =
                                String.format("%s %s %s %s ", city.name, city.country, city.district,
                                        city.population);

                        System.out.println(citiesString);
                }
        }

//--------------------------------------------------------------------------------------------------------------------//
        /**
         * gets the cities of a single continent when given a continent. - report 8
         * @param continent The continent used to select cities from
         * @param con connection to database
         * @return returns null if fail or a list of cities
         */
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

//--------------------------------------------------------------------------------------------------------------------//
        /**
         * gets the top populated capital cities with the number of rows selected and region given by user.
         * Report 22
         * @param selected the number of rows to be selected inputted by user
         * @param con connection to database
         * @param region region selected by user
         * @return returns null if fail or a list of cities
         */
        public static ArrayList<City> getTopCapitalCities(int selected, String region, Connection con) {
                try {
                        Statement stmt = con.createStatement();
                        // Create string for SQL statement
                        String strSelect =
                                "SELECT city.Name, country.Name, city.Population " +
                                        "FROM city " +
                                        "JOIN country " +
                                        "ON city.countrycode = country.Code " +
                                        "WHERE city.id IN (SELECT Capital FROM country)" +
                                        "AND country.region LIKE \"%" + region + "%\" " +
                                        "ORDER BY city.population DESC " +
                                        "LIMIT " + selected;
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
                        System.out.println("Failed to get city details");
                        return null;
                }
        }

//--------------------------------------------------------------------------------------------------------------------//
        /**Display cities when given a list of cities - report 7, report 18, report 17
         *@param capitalCities a list of the city object to display
         */
        public static void displayCapitalCites(ArrayList<City> capitalCities) {
                if (capitalCities == null)
                {
                        System.out.println("no capital cities have been found");
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

//--------------------------------------------------------------------------------------------------------------------//
        /**
         * gets the top populated capital cities with the number of rows selected and continent given by user.
         * Report 21
         * @param selected the number of rows to be selected inputted by user
         * @param con connection to database
         * @param continent region selected by user
         * @return returns null if fail or a list of cities
         */
        public static ArrayList<City> getTopCapitalCities2(int selected, String continent, Connection con) {
                try {
                        Statement stmt = con.createStatement();
                        // Create string for SQL statement
                        String strSelect =
                                "SELECT city.Name, country.Name, city.Population " +
                                        "FROM city " +
                                        "JOIN country " +
                                        "ON city.countrycode = country.Code " +
                                        "WHERE city.id IN (SELECT Capital FROM country)" +
                                        "AND country.continent LIKE \"%" + continent + "%\" " +
                                        "ORDER BY city.population DESC " +
                                        "LIMIT " + selected;
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
                        System.out.println("Failed to get city details");
                        return null;
                }
        }


//--------------------------------------------------------------------------------------------------------------------//
        /**
         * gets the top populated cities with the number of rows selected and district given by user. - report 16
         * @param selected the number of rows to be selected inputted by user
         * @param district the country to select rows from
         * @param con connection to database
         * @return returns null if fail or a list of cities
         */

        public static ArrayList<City> getTopCitiesByDistrict(int selected, String district, Connection con) {
                try {
                        Statement stmt = con.createStatement();
                        // Create string for SQL statement
                        String strSelect =
                                "SELECT city.Name, country.Name, city.District, city.Population " +
                                        "FROM city " +
                                        "JOIN country " +
                                        "ON city.countrycode = country.Code " +
                                        "WHERE city.district LIKE \"%" + district + "%\" " +
                                        "ORDER BY city.population DESC " +
                                        "LIMIT " + selected;
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


//--------------------------------------------------------------------------------------------------------------------//

        /**
         * Extract all capital cities in the world, order by population descending
         * Author - AOB
         *
         * @return All capital cities
         */

        public static ArrayList<City> getAllCapitalCities(Connection con) {
                try {
                        Statement stmt = con.createStatement();
                        // Create string for SQL statement
                        String strSelect =
                                "SELECT city.Name, country.Name, city.Population " +
                                        "FROM city " +
                                        "JOIN country " +
                                        "ON city.countrycode = country.Code " +
                                        "WHERE city.id IN (SELECT Capital FROM country)" +
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
                        System.out.println("Failed to get city details");
                        return null;
                }

        }

//--------------------------------------------------------------------------------------------------------------------//
        /**
         * gets the top populated capital cities within the world and the number of rows selected and given by user.
         * Report 20
         * @param selected the number of rows to be selected inputted by user
         * @param con connection to database
         * @return returns null if fail or a list of cities
         */
        public static ArrayList<City> getTopCapitalCitiesInTheWorld(int selected, Connection con) {
                try {
                        Statement stmt = con.createStatement();
                        // Create string for SQL statement
                        String strSelect =
                                "SELECT city.Name, country.Name, city.Population " +
                                        "FROM city " +
                                        "JOIN country " +
                                        "ON city.countrycode = country.Code " +
                                        "WHERE city.id IN (SELECT Capital FROM country)" +
                                        "ORDER BY city.population DESC " +
                                        "LIMIT " + selected;
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
                        System.out.println("Failed to get city details");
                        return null;
                }
        }
}