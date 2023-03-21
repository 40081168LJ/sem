import com.napier.sem.App;
import com.napier.sem.Language;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LanguageTests
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    /**UNIT TEST FOR POPULATION OF "China/Chinese"
     *Finally, the organisation has asked if it is possible to provide the number of people who speak the following:
     *The following languages from the largest number to smallest, including the percentage of the world population:
     */

    @Test
    void displayCountryLanguage()
    {
        Language countryLanguageTest1 = new Language();
        app.displayCountryLanguage(countryLanguageTest1);
    }


}
