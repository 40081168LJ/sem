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
    public static ArrayList<Language> getLanguages1(Connection con) {

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            // Group By doesn't work with this MySQL table without making changes to the DB, Union used instead
            String strSelect2 =
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

            String strSelect3 =
                    "(SELECT Language AS `Spoken Language`,"
                            + " (SELECT SUM(country.Population) WHERE country.Code = countrylanguage.CountryCode) AS `Population`,"
                            + " (((SELECT SUM(country.Population) WHERE country.Code = countrylanguage.CountryCode)"
                            + " AND countrylanguage.Language = 'Chinese')/(SELECT SUM(Population) FROM country)) AS `Percentage`"
                            + " FROM countrylanguage, country"
                            + " WHERE Language IN ('Chinese')"
                            + " GROUP BY countrylanguage.Language)";

            String strSelect =
            "SELECT (SELECT countrylanguage.Language WHERE countrylanguage.Language = 'Chinese' GROUP BY Language) AS `language`, "
                    + "(SELECT SUM(country.population) FROM country "
                    + "JOIN countrylanguage ON country.Code=countrylanguage.CountryCode "
                    + "WHERE countrylanguage.Language = 'Chinese' "
                    + "GROUP BY Language) as `population`, "
                    + "(SELECT SUM(country.population) FROM country "
                    + "JOIN countrylanguage ON country.Code=countrylanguage.CountryCode "
                    + "WHERE countrylanguage.Language = 'Chinese' "
                    + "GROUP BY Language)/(SELECT SUM(population) FROM country)*100 AS `percentage` "
                    + "FROM countrylanguage "
                    + "UNION "
                    +"SELECT (SELECT countrylanguage.Language WHERE countrylanguage.Language = 'English' GROUP BY Language) AS `language`, "
                    + "(SELECT SUM(country.population) FROM country "
                    + "JOIN countrylanguage ON country.Code=countrylanguage.CountryCode "
                    + "WHERE countrylanguage.Language = 'English' "
                    + "GROUP BY Language) as `population`, "
                    + "(SELECT SUM(country.population) FROM country "
                    + "JOIN countrylanguage ON country.Code=countrylanguage.CountryCode "
                    + "WHERE countrylanguage.Language = 'English' "
                    + "GROUP BY Language)/(SELECT SUM(population) FROM country)*100 AS `percentage` "
                    + "FROM countrylanguage "
                    + "UNION "
                    +"SELECT (SELECT countrylanguage.Language WHERE countrylanguage.Language = 'Hindi' GROUP BY Language) AS `language`, "
                    + "(SELECT SUM(country.population) FROM country "
                    + "JOIN countrylanguage ON country.Code=countrylanguage.CountryCode "
                    + "WHERE countrylanguage.Language = 'Hindi' "
                    + "GROUP BY Language) as `population`, "
                    + "(SELECT SUM(country.population) FROM country "
                    + "JOIN countrylanguage ON country.Code=countrylanguage.CountryCode "
                    + "WHERE countrylanguage.Language = 'Hindi' "
                    + "GROUP BY Language)/(SELECT SUM(population) FROM country)*100 AS `percentage` "
                    + "FROM countrylanguage "
                    + "UNION "
                    +"SELECT (SELECT countrylanguage.Language WHERE countrylanguage.Language = 'Spanish' GROUP BY Language) AS `language`, "
                    + "(SELECT SUM(country.population) FROM country "
                    + "JOIN countrylanguage ON country.Code=countrylanguage.CountryCode "
                    + "WHERE countrylanguage.Language = 'Spanish' "
                    + "GROUP BY Language) as `population`, "
                    + "(SELECT SUM(country.population) FROM country "
                    + "JOIN countrylanguage ON country.Code=countrylanguage.CountryCode "
                    + "WHERE countrylanguage.Language = 'Spanish' "
                    + "GROUP BY Language)/(SELECT SUM(population) FROM country)*100 AS `percentage` "
                    + "FROM countrylanguage "
                    + "UNION "
                    +"SELECT (SELECT countrylanguage.Language WHERE countrylanguage.Language = 'Arabic' GROUP BY Language) AS `language`, "
                    + "(SELECT SUM(country.population) FROM country "
                    + "JOIN countrylanguage ON country.Code=countrylanguage.CountryCode "
                    + "WHERE countrylanguage.Language = 'Arabic' "
                    + "GROUP BY Language) as `population`, "
                    + "(SELECT SUM(country.population) FROM country "
                    + "JOIN countrylanguage ON country.Code=countrylanguage.CountryCode "
                    + "WHERE countrylanguage.Language = 'Arabic' "
                    + "GROUP BY Language)/(SELECT SUM(population) FROM country)*100 AS `percentage` "
                    + "FROM countrylanguage "
                    + "WHERE countrylanguage.Language IN ('Chinese','English','Hindi','Spanish','Arabic') "
                    + "GROUP BY countrylanguage.Language "
                    + "ORDER BY `population` DESC";

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