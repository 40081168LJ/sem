package com.napier.sem;
/**********************************************************************************************************************/
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
/**********************************************************************************************************************/
/**
 *used to interact with the MySQL database
 */
public class App {
    /**
     * Connection to MySQL database.
     */
    public Connection con;

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
                System.out.println("Successfully disconnected from database");
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }
/**********************************************************************************************************************/
    /**
     * connects to the datab base and gets a employee and displays the employee
     * @param args
     */
    public static void main(String[] args) throws IOException {
        /*****************************************************************/
        // Create new Application
        App con = new App();
        /*****************************************************************/
        // Connect to database
        if (args.length < 1) {
            con.connect("localhost:33060", 30000);
        } else {
            con.connect("db:3306", 30000);
        }
        // Disconnect from database
        con.disconnect();
        /*****************************************************************/
    }

    public void connect(String location, int delay) {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(delay);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location
                                + "/world?allowPublicKeyRetrieval=true&useSSL=false",
                        "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }
/**********************************************************************************************************************/
}

