package com.napier.sem;

//--------------------------------------------------------------------------------------------------------------------//
import java.sql.*;

//--------------------------------------------------------------------------------------------------------------------//
/**
 * Class to calculate world population
 */
public class Population {

    /**
     * stores population
     */
    public long population;

//--------------------------------------------------------------------------------------------------------------------//
    /**
     * Create an SQL Statement to get world population
     * *  Used in additional_info 1 report
     **/
    public static Population getPopulation(Connection con){
        try{
            Statement stmt = con.createStatement();
            String strSelect = "SELECT SUM(population) as `popTotal` FROM country";
            // Execute SQL Statement and return population
            ResultSet rset = stmt.executeQuery(strSelect);
            Population pop = new Population();
            rset.next();
            pop.population = rset.getLong("popTotal");
            return pop;
        } catch (Exception e)    {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world population for: Report additional info 1 ");
            return null;    }
    }

//--------------------------------------------------------------------------------------------------------------------//

    /**
     * Displays world population
     */
    public static void displayPopulation(Population population){
        if (population != null)    {
            System.out.println("World Population : "+ population.population);
        }
    }

}

//--------------------------------------------------------------------------------------------------------------------//
