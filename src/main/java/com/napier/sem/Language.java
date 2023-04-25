package com.napier.sem;

//--------------------------------------------------------------------------------------------------------------------//
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

//--------------------------------------------------------------------------------------------------------------------//

/**
 * Class creation for language reports
 */
public class Language {
    /** Code of the Country */
    public String countryCode;

    /** Language */
    public String language;

    /** Official language of the country */
    public String isOfficial;

    /** Percentage of speakers of a language in the country */
    public double percentage;

    public int population;

//--------------------------------------------------------------------------------------------------------------------//
    /** This is for Report Languages 1, Finally, the organisation has asked if it is possible to provide the number
     * of people who speak the following languages from the greatest number to smallest,
     * including the percentage of the world population for: 'Chinese','English','Hindi','Spanish','Arabic'
     * @param con connection to the database
     * @return Returns the above
     */
    public static ArrayList<Language> getLanguages(Connection con) {

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

             //creates the query as a string to be executed
            String strSelect =
                    "(SELECT DISTINCT (SELECT countrylanguage.Language WHERE countrylanguage.Language IN ('Chinese') GROUP BY Language) AS `language`, "
                            + "(SELECT SUM(country.population) FROM country "
                            + "JOIN countrylanguage ON country.Code=countrylanguage.CountryCode "
                            + "WHERE countrylanguage.Language IN ('Chinese') "
                            + "GROUP BY countrylanguage.Language) as `population`, "
                            + "((SELECT SUM(country.population) FROM country "
                            + "JOIN countrylanguage ON country.Code=countrylanguage.CountryCode "
                            + "WHERE countrylanguage.Language IN ('Chinese') GROUP BY countrylanguage.Language "
                            + ")/(SELECT SUM(population) FROM country)*100) AS `percentage` "
                            + "FROM countrylanguage "
                            + "WHERE countrylanguage.Language IN ('Chinese'))"
                            + "UNION "
                            + "(SELECT DISTINCT (SELECT countrylanguage.Language WHERE countrylanguage.Language IN ('English') GROUP BY Language) AS `language`, "
                            + "(SELECT SUM(country.population) FROM country "
                            + "JOIN countrylanguage ON country.Code=countrylanguage.CountryCode "
                            + "WHERE countrylanguage.Language IN ('English') "
                            + "GROUP BY countrylanguage.Language) as `population`, "
                            + "((SELECT SUM(country.population) FROM country "
                            + "JOIN countrylanguage ON country.Code=countrylanguage.CountryCode "
                            + "WHERE countrylanguage.Language IN ('English') GROUP BY countrylanguage.Language "
                            + ")/(SELECT SUM(population) FROM country)*100) AS `percentage` "
                            + "FROM countrylanguage "
                            + "WHERE countrylanguage.Language IN ('English'))"
                            + "UNION "
                            + "(SELECT DISTINCT (SELECT countrylanguage.Language WHERE countrylanguage.Language IN ('Arabic') GROUP BY Language) AS `language`, "
                            + "(SELECT SUM(country.population) FROM country "
                            + "JOIN countrylanguage ON country.Code=countrylanguage.CountryCode "
                            + "WHERE countrylanguage.Language IN ('Arabic') "
                            + "GROUP BY countrylanguage.Language) as `population`, "
                            + "((SELECT SUM(country.population) FROM country "
                            + "JOIN countrylanguage ON country.Code=countrylanguage.CountryCode "
                            + "WHERE countrylanguage.Language IN ('Arabic') GROUP BY countrylanguage.Language "
                            + ")/(SELECT SUM(population) FROM country)*100) AS `percentage` "
                            + "FROM countrylanguage "
                            + "WHERE countrylanguage.Language IN ('Arabic'))"
                            + "UNION "
                            + "(SELECT DISTINCT (SELECT countrylanguage.Language WHERE countrylanguage.Language IN ('Spanish') GROUP BY Language) AS `language`, "
                            + "(SELECT SUM(country.population) FROM country "
                            + "JOIN countrylanguage ON country.Code=countrylanguage.CountryCode "
                            + "WHERE countrylanguage.Language IN ('Spanish') "
                            + "GROUP BY countrylanguage.Language) as `population`, "
                            + "((SELECT SUM(country.population) FROM country "
                            + "JOIN countrylanguage ON country.Code=countrylanguage.CountryCode "
                            + "WHERE countrylanguage.Language IN ('Spanish') GROUP BY countrylanguage.Language "
                            + ")/(SELECT SUM(population) FROM country)*100) AS `percentage` "
                            + "FROM countrylanguage "
                            + "WHERE countrylanguage.Language IN ('Spanish'))"
                            + "UNION "
                            + "(SELECT DISTINCT (SELECT countrylanguage.Language WHERE countrylanguage.Language IN ('Hindi') GROUP BY Language) AS `language`, "
                            + "(SELECT SUM(country.population) FROM country "
                            + "JOIN countrylanguage ON country.Code=countrylanguage.CountryCode "
                            + "WHERE countrylanguage.Language IN ('Hindi') "
                            + "GROUP BY countrylanguage.Language) as `population`, "
                            + "((SELECT SUM(country.population) FROM country "
                            + "JOIN countrylanguage ON country.Code=countrylanguage.CountryCode "
                            + "WHERE countrylanguage.Language IN ('Hindi') GROUP BY countrylanguage.Language "
                            + ")/(SELECT SUM(population) FROM country)*100) AS `percentage` "
                            + "FROM countrylanguage "
                            + "WHERE countrylanguage.Language IN ('Hindi')) "
                            + "ORDER BY population DESC";


            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract Language information
            ArrayList<Language> languages = new ArrayList<>();

            //Return new language if valid.
            //Check one is returned
            while (rset.next()) {
                Language countryLanguage1 = new Language();
                countryLanguage1.language = rset.getString("language");
                countryLanguage1.population = rset.getInt("population");
                countryLanguage1.percentage = rset.getDouble("percentage");
                languages.add(countryLanguage1);
            }
            return languages;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("Failed to get Language Information");
            return null;
        }
    }
//--------------------------------------------------------------------------------------------------------------------//
    /**Display Country Language where Language = 'Chinese','English','Hindi','Spanish','Arabic'
     *@param languages list of languages
     */
    public static void displayCountryLanguage(ArrayList<Language> languages) {
        if (languages == null)
        {
            System.out.println("No Countries with the Languages " +
                    "('Chinese','English','Hindi','Spanish','Arabic') can be found.");
            return;
        }
        //Print header
        System.out.printf("\n %s %s %s%n", "Language", "Population", "Percentage");

        for (Language countryLanguage1 : languages)
        {
            if (countryLanguage1 == null)
                continue;
            String languageString =
                    String.format("%s %s %s",countryLanguage1.language, countryLanguage1.population,
                            countryLanguage1.percentage);
            System.out.println(languageString);
        }
    }
}
//--------------------------------------------------------------------------------------------------------------------//