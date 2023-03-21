import com.napier.sem.App;
import com.napier.sem.Population;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class UnitTests
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    /**
     * tests passing an empty object
     */
    @Test
    void DisplayWorldPopulationTestEmpty()
    {
        Population population = new Population();
        app.displayPopulation(population);
    }
    /**
     * tests passing expected values
     */
    @Test
    void DisplayWorldPopulation()
    {
        Population population = new Population();
        population.population = 23123122;
        app.displayPopulation(population);
    }
}
