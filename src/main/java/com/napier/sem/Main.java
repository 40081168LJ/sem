import com.napier.sem.App;
import com.napier.sem.Country;
import com.napier.sem.Language;
import com.napier.sem.Population;

//--------------------------------------------------------------------------------------------------------------------//
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;

//--------------------------------------------------------------------------------------------------------------------//
/**
 * The main class, used for menu and report selection
 */
public class Main {

    // setting quit for menu loop below
    static boolean quit = false;

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Created a little Menu selection for each of the 36 types of reports and an exit option.
     */
    public static void main(String[] args) throws IOException {
        // Create new Application
        App con = new App();

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
        System.out.println("<|                                  REPORTSELECTION                                   |>");
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
                case 1:
                    System.out.println("Report 1 Selected, Displaying all Countries and population detials...");
                    System.out.println("<|************************************************************************************|>");
                    // Extract country information
                    ArrayList<Country> countries = Country.getAllCountries(con.con);
                    // Print table of countries in the world
                    Country.printCountries(countries);
                    System.out.println("<|************************************************************************************|>");
                    System.out.println("Report 1 Finished, Returning to Main Menu...");
                    break;
                case 2:
                    System.out.println("Report 2 Selected, Displaying Countries by Continent = Asia...");
                    System.out.println("<|************************************************************************************|>");
                    // Extract country by continent information
                    ArrayList<Country> countries1 = Country.getContinentCountries(con.con);
                    // Print table of countries in a continent e.g. Asia
                    Country.printCountries(countries1);
                    System.out.println("<|************************************************************************************|>");
                    System.out.println("Report 2 Finished, Returning to Main Menu...");
                    break;
                case 3:
                    System.out.println("Report 3 Selected");
                    break;
                case 4:
                    System.out.println("Report 4 Selected");
                    break;
                case 5:
                    System.out.println("Report 5 Selected");
                    break;
                case 6:
                    System.out.println("Report 6 Selected");
                    break;
                case 7:
                    System.out.println("Report 7 Selected");
                    break;
                case 8:
                    System.out.println("Report 8 Selected");
                    break;
                case 9:
                    System.out.println("Report 9 Selected");
                    break;
                case 10:
                    System.out.println("Report 10 Selected");
                    break;
                case 11:
                    System.out.println("Report 11 Selected");
                    break;
                case 12:
                    System.out.println("Report 12 Selected");
                    break;
                case 13:
                    System.out.println("Report 13 Selected");
                    break;
                case 14:
                    System.out.println("Report 14 Selected");
                    break;
                case 15:
                    System.out.println("Report 15 Selected");
                    break;
                case 16:
                    System.out.println("Report 16 Selected");
                    break;
                case 17:
                    System.out.println("Report 17 Selected");
                    break;
                case 18:
                    System.out.println("Report 18 Selected");
                    break;
                case 19:
                    System.out.println("Report 19 Selected");
                    break;
                case 20:
                    System.out.println("Report 20 Selected");
                    break;
                case 21:
                    System.out.println("Report 21 Selected");
                    break;
                case 22:
                    System.out.println("Report 22 Selected");
                    break;
                case 23:
                    System.out.println("Report 23 Selected");
                    break;
                case 24:
                    System.out.println("Report 24 Selected");
                    System.out.println("Report 24 Selected, Displaying Region Populations...");
                    System.out.println("<|************************************************************************************|>");
                    // TODO: FIX THIS SQL AS THE GROUP BY IS NOT WORKING
                    // Extract Region Populations
                    ArrayList<Country> regionPopulation1 = Population.getRegionPopulation(con.con);
                    // Print table of Regions and their populations
                    Population.displayRegionPopulation(regionPopulation1);
                    System.out.println("<|************************************************************************************|>");
                    System.out.println("Report 24 Finished, Returning to Main Menu...");
                    break;
                case 25:
                    System.out.println("Report 25 Selected");
                    break;
                case 26:
                    System.out.println("Report Additional Info 1 Selected");
                    System.out.println("<|************************************************************************************|>");
                    // Getting world population
                    Population populationreport1 = Population.getPopulation(con.con);
                    // Display world population
                    Population.displayPopulation(populationreport1);
                    System.out.println("<|************************************************************************************|>");
                    System.out.println("Report Additional Info 1 Finished, Returning to Main Menu...");
                    break;
                case 27:
                    System.out.println("Report Additional Info 2 Selected");
                    break;
                case 28:
                    System.out.println("Report Additional Info 3 Selected");
                    break;
                case 29:
                    System.out.println("Report Additional Info 4 Selected");
                    break;
                case 30:
                    System.out.println("Report Additional Info 5 Selected");
                    break;
                case 31:
                    System.out.println("Report Additional Info 6 Selected");
                    break;
                case 32:
                    System.out.println("Report Languages 1 Selected, Displaying Countries with Languages... ");
                    System.out.println("<|************************************************************************************|>");
                    // Show all conuntry by language, greatest to smallest who speak it (Percentage)
                    ArrayList<Language> LanguageReport1 = Language.getLanguages1(con.con);
                    // Print out countries languages
                    Language.displayCountryLanguage1(LanguageReport1);
                    System.out.println("<|************************************************************************************|>");
                    System.out.println("Report Languages 1 Finished, Returning to Main Menu...");
                    break;
                case 33:
                    System.out.println("Exit Report Program Selected, Have a nice day!");
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid Input, try again...");
                    break;
            }
        } while (!quit);
        con.disconnect();
        System.out.println("Goodbye...");
    }

//--------------------------------------------------------------------------------------------------------------------//
    static class Keyin {
        /**
         *SupportMethods
         *Method to display th euser's prompt string
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
                    dummy = System.in.read();
            } catch (java.io.IOException e) {
                System.out.println("Input error");
            }
        }

//--------------------------------------------------------------------------------------------------------------------//
        /**
         * For input turnin into string
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
