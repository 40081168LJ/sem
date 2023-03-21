import com.napier.sem.App;
import com.napier.sem.Population;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Unit Test to test worldPopulation is not null
 */
public class IntegrationTests {

    static App app;
    @BeforeAll
    static void init()
    {
        app = new App();
        // Connect to database
        app.connect("localhost:33060", 30000);

    }

    /**
     * Test connection to database and to test getting world population
     * Used in additional_info 1 report
     */
    @Test
    public void GetWorldPopulation() {
        Population pop = app.getPopulation();
        //validates
        assertNotEquals(0, pop.population );
    }

}