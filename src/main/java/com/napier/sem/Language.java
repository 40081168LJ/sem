package com.napier.sem;

//--------------------------------------------------------------------------------------------------------------------//
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

//--------------------------------------------------------------------------------------------------------------------//
public class Language {
    /** Code of the Country */
    public String countryCode;

    /** Language */
    public String language;

    /** Official language of the country */
    public String isOfficial;

    /** Percentage of speakers of a language in the country */
    public double percentage;

//--------------------------------------------------------------------------------------------------------------------//
    /** This is for Report Languages 1, Finally, the organisation has asked if it is possible to provide the number
     * of people who speak the following languages from the greatest number to smallest,
     * including the percentage of the world population for: 'Chinese','English','Hindi','Spanish','Arabic'
     * @param con
     * @return Returns the above
     */
    public static ArrayList<Language> getLanguages1(Connection con) {

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            // Group By doesn't work with this MySQL table without making changes to the DB, Union used instead
            String strSelect =
                    "(SELECT CountryCode, Language, IsOfficial, Percentage"
                            + " FROM countrylanguage"
                            + " WHERE Language IN ('Chinese')"
                            + " ORDER BY Percentage DESC)"
                            + " UNION"
                            + " (SELECT CountryCode, Language, IsOfficial, Percentage"
                            + " FROM countrylanguage"
                            + " WHERE Language IN ('English')"
                            + " ORDER BY Percentage DESC)"
                            + " UNION"
                            + " (SELECT CountryCode, Language, IsOfficial, Percentage"
                            + " FROM countrylanguage"
                            + " WHERE Language IN ('Hindi')"
                            + " ORDER BY Percentage DESC)"
                            + " UNION"
                            + " (SELECT CountryCode, Language, IsOfficial, Percentage"
                            + " FROM countrylanguage"
                            + " WHERE Language IN ('Spanish')"
                            + " ORDER BY Percentage DESC)"
                            + " UNION"
                            + " (SELECT CountryCode, Language, IsOfficial, Percentage"
                            + " FROM countrylanguage"
                            + " WHERE Language IN ('Arabic')"
                            + " ORDER BY Percentage DESC)";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract Language information
            ArrayList<Language> Languages1 = new ArrayList<>();

            //Return new language if valid.
            //Check one is returned
            while (rset.next()) {
                Language countryLanguage1 = new Language();
                countryLanguage1.countryCode = rset.getString("CountryCode");
                countryLanguage1.language = rset.getString("Language");
                countryLanguage1.isOfficial = rset.getString("IsOfficial");
                countryLanguage1.percentage = rset.getInt("Percentage");
                Languages1.add(countryLanguage1);
            }
            return Languages1;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("Failed to get Language Information");
            return null;
        }
    }
//--------------------------------------------------------------------------------------------------------------------//
    /**Display Country Language where Language = 'Chinese','English','Hindi','Spanish','Arabic'
     *@param Languages1
     */
    public static void displayCountryLanguage(ArrayList<Language> Languages1) {
        if (Languages1 == null)
        {
            System.out.println("No Countries with the Languages " +
                    "('Chinese','English','Hindi','Spanish','Arabic') can be found.");
            return;
        }
        //Print header
        System.out.printf("\n %s %s %s %s%n", "Country Code", "Language", "Is Official", "Percentage");

        for (Language countryLanguage1 : Languages1)
        {
            if (countryLanguage1 == null)
                continue;
            String language1_string =
                    String.format("%s %s %s %s", countryLanguage1.countryCode, countryLanguage1.language,
                            countryLanguage1.isOfficial, countryLanguage1.percentage);
            System.out.println(language1_string);
        }
    }
}
//--------------------------------------------------------------------------------------------------------------------//