import com.napier.sem.*;

//--------------------------------------------------------------------------------------------------------------------//

import java.io.IOException;
import java.util.*;

//--------------------------------------------------------------------------------------------------------------------//
/**
 * The main class, used for menu and report selection
 */
public class Main {

    /**
     * setting quit to false for menu loop below
     */
    static boolean quit = false;

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Created a little Menu selection for each of the 32 types of reports and an exit option.
     */
    public static void main(String[] args) throws IOException {
        // Create new Application
        App con = new App();

        Scanner scanner = new Scanner(System.in);
        // Connect to database
        if (args.length < 1) {
            con.connect("localhost:33060", 30000);
        } else {
            con.connect("db:3306", 30000);
        }

        // Beginning of loop for menu return
        do {
        int swValue;
        System.out.println("<|************************************************************************************|>");
        System.out.println("<|                                                                                    |>");
        System.out.println("<|                                 REPORTS ELECTION                                   |>");
        System.out.println("<|                                                                                    |>");
        System.out.println("<|       The below is a list of avaiable Reports,that can be viewed. To view a        |>");
        System.out.println("<|       Report simply input the report number (to the left of the Report Name)       |>");
        System.out.println("<|       which will select the report and display its contents.                       |>");
        System.out.println("<|                                                                                    |>");
        System.out.println("<|       Report List :                                                                |>");
        System.out.println("<|                                                                                    |>");
        System.out.println("<|       1.Report 1                2.Report 2                3.Report 3               |>");
        System.out.println("<|       4.Report 4                5.Report 5                6.Report 6               |>");
        System.out.println("<|       7.Report 7                8.Report 8                9.Report 9               |>");
        System.out.println("<|       10.Report 10              11.Report 11              12.Report 12             |>");
        System.out.println("<|       13.Report 13              14.Report 14              15.Report 15             |>");
        System.out.println("<|       16.Report 16              17.Report 17              18.Report 18             |>");
        System.out.println("<|       19.Report 19              20.Report 20              21.Report 21             |>");
        System.out.println("<|       22.Report 22              23.Report 23              24.Report 24             |>");
        System.out.println("<|       25.Report 25              26.Additional Info 1      27.Additional Info 2     |>");
        System.out.println("<|       28.Additional Info 3      29.Additional Info 4      30.Additional Info 5     |>");
        System.out.println("<|       31.Additional Info 6      32.Languages 1                                     |>");
        System.out.println("<|                                                                                    |>");
        System.out.println("<|                               33.Exit Report Program                               |>");
        System.out.println("<|                                                                                    |>");
        System.out.println("<|************************************************************************************|>");
        System.out.println("<|                                                                                    |>");
        swValue = Keyin.inInt("<| Please, Select a Report to view:");

//--------------------------------------------------------------------------------------------------------------------//
            /**
             Switch construct, Each case represents a Report.
             */
            switch (swValue) {

                /**
                 * Below code is used to display report 1 results
                 */
                case 1:{
                    System.out.println("Report 1 Selected, Displaying all Countries and population details...");
                    System.out.println("<|************************************************************************************|>");
                    // Extract country information
                    ArrayList<Country> countries = Country.getAllCountries(con.con);
                    // Print table of countries in the world
                    Country.printCountries(countries);
                    System.out.println("<|************************************************************************************|>");
                    System.out.println("Report 1 Finished, Returning to Main Menu...");
                    break;}

                /**
                 * Below code is used to display report 2 results
                 */
                case 2:{
                    System.out.println("Report 2 Selected");
                    System.out.println("please select a continent");
                    String continent = scanner.nextLine();
                    System.out.println("<|************************************************************************************|>");
                    // Extract country by continent information
                    ArrayList<Country> countries1 = Country.getContinentCountries(continent, con.con);
                    // Print table of countries in a continent e.g. Asia
                    Country.printCountries(countries1);
                    System.out.println("<|************************************************************************************|>");
                    System.out.println("Report 2 Finished, Returning to Main Menu...");
                    break;}

                /**
                 * Below code is used to display report 3 results
                 */
                case 3:{
                    System.out.println("Report 3 Selected");
                    System.out.println("please select a region");
                    String region1 = scanner.nextLine();
                    System.out.println("<|************************************************************************************|>");
                    // Extract country by region information
                    ArrayList<Country> countries2 = Country.getRegionCountries(region1, con.con);
                    // Print table of All the countries in a region organised by largest population to smallest.
                    Country.printCountries(countries2);
                    System.out.println("<|************************************************************************************|>");
                    System.out.println("Report 3 Finished, Returning to Main Menu...");
                    break;}

                /**
                 * Below code is used to display report 4 results
                 */
                case 4:{
                    System.out.println("Report 4 Selected");
                    System.out.println("please select the number of rows to display top populated countries");
                    int num = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("<|************************************************************************************|>");
                    // Getting top n countries
                    ArrayList<Country> countries3 = Country.getTopPopulatedCountries(num, con.con);
                    // Display top n countries
                    Country.printCountries(countries3);
                    System.out.println("<|************************************************************************************|>");
                    System.out.println("Report 4 Finished, Returning to Main Menu...");
                    break;}

                /**
                 * Below code is used to display report 5 results
                 */
                case 5:{
                    System.out.println("Report 5 Selected");
                    System.out.println("please select the continent to select from");
                    String continent1 = scanner.nextLine();
                    System.out.println("please select the number of rows to display top populated countries");
                    int num1 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("<|************************************************************************************|>");
                    // Getting top n countries in continent
                    ArrayList<Country> countries4 = Country.getTopCountriesInContinent(num1, continent1, con.con);
                    // Display top n countries in continent
                    Country.printCountries(countries4);
                    System.out.println("<|************************************************************************************|>");
                    System.out.println("Report 5 Finished, Returning to Main Menu...");
                    break;}

                /**
                 * Below code is used to dislay report 6 results
                 */
                case 6:{
                    System.out.println("Report 6 Selected");
                    System.out.println("please select the region to select from");
                    String continent2 = scanner.nextLine();
                    System.out.println("please select the number of rows to display top populated countries");
                    int num2 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("<|************************************************************************************|>");
                    // Getting top n countries in continent
                    ArrayList<Country> countries5 = Country.getTopCountriesInRegion(num2, continent2, con.con);
                    // Display top n countries in continent
                    Country.printCountries(countries5);
                    System.out.println("<|************************************************************************************|>");
                    System.out.println("Report 6 Finished, Returning to Main Menu...");
                    break;}

                /**
                 * Below code is used to display report 7 results
                 */
                case 7:{
                    System.out.println("Report 7 Selected");
                    System.out.println("Report 7 Selected, Displaying Countries with Languages... ");
                    System.out.println("<|************************************************************************************|>");
                    // Show all conuntry by language, greatest to smallest who speak it (Percentage)
                    ArrayList<City> cities = City.getCityPopulation(con.con);
                    // Print out countries languages
                    City.displayCites(cities);
                    System.out.println("<|************************************************************************************|>");
                    System.out.println("Report 7 Finished, Returning to Main Menu...");
                    break;}

                /**
                 * Below code is ued to display report 8 results
                 */
                case 8: {
                    System.out.println("Report 8 Selected");
                    System.out.println("please select a continent");
                    String continent = scanner.nextLine();
                    System.out.println("<|************************************************************************************|>");
                    // Getting city population by continent
                    ArrayList<City> cities = City.getCityPopulationByContinent(continent, con.con);
                    // Display city population
                    City.displayCites(cities);
                    System.out.println("<|************************************************************************************|>");
                    System.out.println("Report 8 Finished, Returning to Main Menu...");
                    break;}

                /**
                 * Below code is used to display report 9 results
                 */
                case 9: {
                    System.out.println("Report 9 Selected");
                    System.out.println("please select a region");
                    String region = scanner.nextLine();
                    System.out.println("<|************************************************************************************|>");
                    // Getting city population by region
                    ArrayList<City> cities = City.getCityPopulationByRegion(region, con.con);
                    // Display world population
                    City.displayCites(cities);
                    System.out.println("<|************************************************************************************|>");
                    System.out.println("Report 9 Finished, Returning to Main Menu...");
                    break;}

                /**
                 * Below code is used to display report 10 results
                 */
                case 10:{
                    System.out.println("Report 10 Selected");
                    System.out.println("please select a country");
                    String country = scanner.nextLine();
                    System.out.println("<|************************************************************************************|>");
                    // Getting city population by country
                    ArrayList<City> cities = City.getCitiesByCountry(country, con.con);
                    // Display world population
                    City.displayCites(cities);
                    System.out.println("<|************************************************************************************|>");
                    System.out.println("Report 10 Finished, Returning to Main Menu...");
                    break;}

                /**
                 * Below code is used to display report 11 results
                 */
                case 11:{
                    System.out.println("Report 11 Selected");
                    System.out.println("please select a district");
                    String district = scanner.nextLine();
                    System.out.println("<|************************************************************************************|>");
                    // Getting city population by continent
                    ArrayList<City> cities = City.getCityPopulationByDistrict(district, con.con);
                    // Display world population
                    City.displayCites(cities);
                    System.out.println("<|************************************************************************************|>");
                    System.out.println("Report 11 Finished, Returning to Main Menu...");
                    break;}

                /**
                 * Below code is used to display report 12 results
                 */
                case 12:{
                    System.out.println("Report 12 Selected");
                    System.out.println("please select the number of rows to display top populated cities");
                    int rows = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("<|************************************************************************************|>");
                    // Getting city population by continent
                    ArrayList<City> cities = City.getTopPopulatedCities(rows, con.con);
                    // Display world population
                    City.displayCites(cities);
                    System.out.println("<|************************************************************************************|>");
                    System.out.println("Report 12 Finished, Returning to Main Menu...");
                    break;}

                /**
                 * Below code is used to display report 13 results
                 */
                case 13:{
                    System.out.println("Report 13 Selected");
                    // Get continent and number of rows to select
                    System.out.println("please select the the continent to select from");
                    String continent = scanner.nextLine();
                    System.out.println("please select the number of rows to display top populated cities");
                    int rows = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("<|************************************************************************************|>");
                    // Getting city population by continent
                    ArrayList<City> cities = City.getTopCitiesByContinent(rows, continent, con.con);
                    // Display city population by continent
                    City.displayCites(cities);
                    System.out.println("<|************************************************************************************|>");
                    System.out.println("Report 13 Finished, Returning to Main Menu...");
                    break;}

                /**
                 * Below code is used to display report 14 results
                 */
                case 14:{
                    System.out.println("Report 14 Selected");
                    // Get continent and number of rows to select
                    System.out.println("please select the the region to select from");
                    String region = scanner.nextLine();
                    System.out.println("please select the number of rows to display top populated cities");
                    int rows = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("<|************************************************************************************|>");
                    // Getting city population by region
                    ArrayList<City> cities = City.getTopCitiesByRegion(rows, region, con.con);
                    // Display world population
                    City.displayCites(cities);
                    System.out.println("<|************************************************************************************|>");
                    System.out.println("Report 14 Finished, Returning to Main Menu...");
                    break;}

                /**
                 * Below code is used to display report 15 results
                 */
                case 15:{
                    System.out.println("Report 15 Selected");
                    // Get country and number of rows to select
                    System.out.println("please select the country to select from");
                    String country = scanner.nextLine();
                    System.out.println("please select the number of rows to display top populated cities");
                    int num15 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("<|************************************************************************************|>");
                    // Getting city population by country
                    ArrayList<City> cities1 = City.getTopCitiesByCountry(num15, country, con.con);
                    // Display world population
                    City.displayCites(cities1);
                    System.out.println("<|************************************************************************************|>");
                    System.out.println("Report 15 Finished, Returning to Main Menu...");
                    break;}

                /**
                 * Below code is used to display report 16 results
                 */
                case 16:{
                    System.out.println("Report 16 Selected");
                    // Get country and number of rows to select
                    System.out.println("please select the district to select from");
                    String district16 = scanner.nextLine();
                    System.out.println("please select the number of rows to display top populated cities");
                    int num16 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("<|************************************************************************************|>");
                    // Getting city population by continent
                    ArrayList<City> cities16 = City.getTopCitiesByDistrict(num16, district16, con.con);
                    // Display world population
                    City.displayCites(cities16);
                    System.out.println("<|************************************************************************************|>");
                    System.out.println("Report 16 Finished, Returning to Main Menu...");
                    break;}

                /**
                 * Below code is used to display report 17 results
                 */
                case 17:{
                    System.out.println("Report 17 Selected. Displaying All Capital Cities in the world.");
                    System.out.println("<|************************************************************************************|>");
                    // Extract city information
                    ArrayList<City> cities17 = City.getAllCapitalCities(con.con);
                    // Print table of cities in the world
                    City.displayCapitalCites(cities17);
                    System.out.println("<|************************************************************************************|>");
                    System.out.println("Report 17 Finished, Returning to Main Menu...");
                    break;}

                /**
                 * Below code is used to display report 18 results
                 */
                case 18:{
                    System.out.println("Report 18 Selected. Displaying all Capital Cities in a continent");
                    System.out.println("please select the the continent to select from");
                    String continentPop = scanner.nextLine();
                    System.out.println("<|************************************************************************************|>");
                    // Getting capital cities by continent
                    ArrayList<City> capitalCities = Population.getCapitalCitiesByContinent(continentPop, con.con);
                    // Display capital cities by continent
                    City.displayCapitalCites(capitalCities);
                    System.out.println("<|************************************************************************************|>");
                    System.out.println("Report 18 Finished, Returning to Main Menu...");
                    break;}

                /**
                 * Below code is used to display report 19 results
                 */
                case 19:{
                    System.out.println("Report 19 Selected");
                    System.out.println("Report 19 Selected, Displaying Capital Cities in the Region...");
                    // Get region
                    System.out.println("please select the region to select from:");
                    String regionPop = scanner.nextLine();
                    System.out.println("Report 19 Selected, Displaying...");
                    System.out.println("<|************************************************************************************|>");
                    // Getting capital city by region
                    ArrayList<City> capitalCities = Population.getTopCapitalCitiesInRegion(regionPop, con.con);
                    // Display capital cities by region
                    Population.displayCapitalCitesInRegion(capitalCities);
                    System.out.println("<|************************************************************************************|>");
                    System.out.println("Report 19 Finished, Returning to Main Menu...");
                    break;}

                /**
                 * Below code is used to display report 20 results
                 */
                case 20:{
                    System.out.println("Report 20 Selected");
                    System.out.println("Report 20 Selected, Displaying Top Populated Capital Cities in the World...");
                    // Get number of rows to select
                    System.out.println("please select the number of rows to display top populated Captial Cities:");
                    int rows3 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Report 20 Selected, Displaying...");
                    System.out.println("<|************************************************************************************|>");
                    // Getting city population by continent
                    ArrayList<City> capitalCities2 = City.getTopCapitalCitiesInTheWorld(rows3, con.con);
                    // Display world population
                    City.displayCapitalCites(capitalCities2);
                    System.out.println("<|************************************************************************************|>");
                    System.out.println("Report 20 Finished, Returning to Main Menu...");
                    break;}

                /**
                 *  Below code is used to display report 21 results
                 */
                case 21:{
                    System.out.println("Report 21 Selected, Displaying Top Populated Capital Cities in the Continent...");
                    // Get continent and number of rows to select
                    System.out.println("please select the the continent to select from:");
                    String continent = scanner.nextLine();
                    // Get number of rows to select
                    System.out.println("please select the number of rows to display top populated Captial Cities:");
                    int rows2 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Report 21 Selected, Displaying...");
                    System.out.println("<|************************************************************************************|>");
                    // Getting city population by continent
                    ArrayList<City> cities3 = City.getTopCapitalCities2(rows2, continent, con.con);
                    // Display world population
                    City.displayCapitalCites(cities3);
                    System.out.println("<|************************************************************************************|>");
                    System.out.println("Report 21 Finished, Returning to Main Menu...");
                    break;}

                /**
                 *  Below code is used to display report 22 results
                 */
                case 22:{
                    System.out.println("Report 22 Selected");
                    System.out.println("Report 22 Selected, Displaying Top Populated Capital Cities in the Region...");
                    // Get region and number of rows to select
                    System.out.println("please select the the region to select from:");
                    String region = scanner.nextLine();
                    // Get number of rows to select
                    System.out.println("please select the number of rows to display top populated Captial Cities:");
                    int rows = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Report 22 Selected, Displaying...");
                    System.out.println("<|************************************************************************************|>");
                    // Getting city population by region
                    ArrayList<City> cities2 = City.getTopCapitalCities(rows, region, con.con);
                    // Display world population
                    City.displayCapitalCites(cities2);
                    System.out.println("<|************************************************************************************|>");
                    System.out.println("Report 22 Finished, Returning to Main Menu...");
                    break;}

                /**
                 * Below code is used to display report 23 results
                 */
                case 23:{
                    System.out.println("Report 23 Selected");
                    System.out.println("Report 23 Selected, Displaying Continent Populations...");
                    System.out.println("<|************************************************************************************|>");
                    // Extract Continent Populations
                    ArrayList<Population> population2 = Population.getContinentPopulation2(con.con);
                    // Print table of Regions and their populations
                    Population.displayContinentPopulation2(population2);
                    System.out.println("<|************************************************************************************|>");
                    System.out.println("Report 23 Finished, Returning to Main Menu...");
                    break;}

                /**
                 * Below code is used to display report 24 results
                 */
                case 24:{
                    System.out.println("Report 24 Selected");
                    System.out.println("Report 24 Selected, Displaying Region Populations...");
                    System.out.println("<|************************************************************************************|>");
                    // Extract Region Populations
                    ArrayList<Population> regionPopulation1 = Population.getRegionPopulation2(con.con);
                    // Print table of Regions and their populations
                    Population.displayRegionPopulation2(regionPopulation1);
                    System.out.println("<|************************************************************************************|>");
                    System.out.println("Report 24 Finished, Returning to Main Menu...");
                    break;}

                /**
                 * Below code is used to display report 25 results
                 */
                case 25:{
                    System.out.println("Report 25 Selected");
                    System.out.println("Report 25 Selected, Displaying Country Populations...");
                    System.out.println("<|************************************************************************************|>");
                    // Extract countries Populations
                    ArrayList<Population> countryPopulation = Population.getCountryPopulation2(con.con);
                    // Print table of countries and their populations
                    Population.displayCountryPopulation2(countryPopulation);
                    System.out.println("<|************************************************************************************|>");
                    System.out.println("Report 25 Finished, Returning to Main Menu...");
                    break;}

                /**
                 * Below code is used to display report 26 results
                 */
                case 26:{
                    System.out.println("Report Additional Info 1 Selected");
                    System.out.println("<|************************************************************************************|>");
                    // Getting world population
                    Population populationreport1 = Population.getPopulation(con.con);
                    // Display world population
                    Population.displayPopulation(populationreport1);
                    System.out.println("<|************************************************************************************|>");
                    System.out.println("Report Additional Info 1 Finished, Returning to Main Menu...");
                    break;}

                /**
                 * Below code is used to display report 27 results
                 */
                case 27:{
                    System.out.println("Report Additional Info 2 Selected");
                    System.out.println("<|************************************************************************************|>");
                    // Getting Continent population
                    ArrayList<Population> population = Population.getContinentPopulation(con.con);
                    // Display world population
                    Population.displayContinentPopulations(population);
                    System.out.println("<|************************************************************************************|>");
                    System.out.println("Report Additional Info 2 Finished, Returning to Main Menu...");
                    break;}

                /**
                 * Below code is used to display report 28 results
                 */
                case 28:{
                    System.out.println("Report Additional Info 3 Selected");
                    System.out.println("<|************************************************************************************|>");
                    // Getting Region population
                    ArrayList<Population> population = Population.getRegionPopulation(con.con);
                    // Display world population
                    Population.displayRegionPopulation(population);
                    System.out.println("<|************************************************************************************|>");
                    System.out.println("Report Additional Info 3 Finished, Returning to Main Menu...");
                    break;}

                /**
                 * Below code is used to display report 29 results
                 */
                case 29:{
                    System.out.println("Report Additional Info 4 Selected");
                    System.out.println("<|************************************************************************************|>");
                    // Getting Continent population
                    ArrayList<Population> population = Population.getCountryPopulations(con.con);
                    // Display world population
                    Population.displayCountryPopulations(population);
                    System.out.println("<|************************************************************************************|>");
                    System.out.println("Report Additional Info 4 Finished, Returning to Main Menu...");
                    break;}

                /**
                 * Below code is used to display report 30 results
                 */
                case 30:{
                    System.out.println("Report Additional Info 5 Selected");
                    System.out.println("<|************************************************************************************|>");
                    // Getting Continent population
                    ArrayList<Population> population = Population.getDistrictPopulation(con.con);
                    // Display world population
                    Population.displayDistrictPopulations(population);
                    System.out.println("<|************************************************************************************|>");
                    System.out.println("Report Additional Info 5 Finished, Returning to Main Menu...");
                    break;}

                /**
                 * Below code is used to display report 31 results
                 */
                case 31:{
                    System.out.println("Report Additional Info 6 Selected");
                    System.out.println("<|************************************************************************************|>");
                    // Getting City population
                    ArrayList<Population> population = Population.getcityPopulation(con.con);
                    // Display City population
                    Population.displayCityPopulations(population);
                    System.out.println("<|************************************************************************************|>");
                    System.out.println("Report Languages 2 Finished, Returning to Main Menu...");
                    break;}

                /**
                 * Below code is used to display report 32 results
                 */
                case 32:{
                    System.out.println("Report Languages 1 Selected, Displaying Countries with Languages... ");
                    System.out.println("<|************************************************************************************|>");
                    // Show all conuntry by language, greatest to smallest who speak it (Percentage)
                    ArrayList<Language> languageReport = Language.getLanguages(con.con);
                    // Print out countries languages
                    Language.displayCountryLanguage(languageReport);
                    System.out.println("<|************************************************************************************|>");
                    System.out.println("Report Languages 1 Finished, Returning to Main Menu...");
                    break;}

                /**
                 * Exits the program after report has been displayed
                 */
                case 33:{
                    System.out.println("Exit Report Program Selected, Have a nice day!");
                    quit = true;
                    break;}
                default:
                    System.out.println("Invalid Input, try again...");
                    break;
            }
        } while (!quit);
        con.disconnect();
        System.out.println("Goodbye User...");
    }

    //--------------------------------------------------------------------------------------------------------------------//

    /**
     * Class creation to store user inputs
     */
    static class Keyin {
        /**
         *SupportMethods
         *Method to display the user's prompt string
         *@param prompt
         */
        public static void printPrompt(String prompt) {
            System.out.print(prompt + "");
            System.out.flush();
        }

        /**
         * Method to make sure no data is available in the input stream
         */
        public static void inputFlush() throws IOException {
            int dummy;
            int bAvail;

            try {
                while ((System.in.available()) != 0)
                    System.in.read();
            } catch (java.io.IOException e) {
                System.out.println("Input error");
            }
        }

//--------------------------------------------------------------------------------------------------------------------//
        /**
         * For input turn into string
         *@return
         */
        public static String inString() {
            int aChar;
            String s = "";
            boolean finished = false;

            while (!finished) {
                try {
                    aChar = System.in.read();
                    if (aChar < 0 || (char) aChar == '\n')
                        finished = true;
                    else if((char) aChar != '\r')
                        s = s + (char) aChar;// Enter into string
                } catch (java.io.IOException e) {
                    System.out.println("Input error");
                    finished = true;
                }
            }
            return s;
        }

//--------------------------------------------------------------------------------------------------------------------//
        /**
         * For checking the input from the user is a integer and can be used to call a report
         *@param prompt
         *@return
         */
        public static int inInt(String prompt) throws IOException {
            while (true) {
                inputFlush();
                printPrompt(prompt);
                try {
                    return Integer.valueOf(inString().trim()).intValue();
                }
                /**
                 Catch for invalid input, i.e. if anthing but one of the cases above is used.
                 */
                catch (NumberFormatException e) {
                    System.out.println("Invalid Input, Please use an integer");
                    /**
                     Uses"\033[3m"to put the text into italics.
                     */
                    System.out.println("\033[3m Please use a Report number to view the Report \033[0m");
                }
            }
        }

//--------------------------------------------------------------------------------------------------------------------//

    }

//--------------------------------------------------------------------------------------------------------------------//

}

//--------------------------------------------------------------------------------------------------------------------//