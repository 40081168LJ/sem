import com.napier.sem.App;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.*;

/**
 * The main class, used for menu and report selection
 */
public class Main {

    /**
    Created a little Menu selection for each of the 36 types of reports and an exit option.
     */
    public static void main(String[] args) {
        App a = new App();

        if(args.length < 1){
            a.connect("localhost:33060", 30000);
        }else{
            a.connect(args[0], Integer.parseInt(args[1]));
        }

        int swValue;
        System.out.println("<|************************************************************************************|>");
        System.out.println("<|                                                                                    |>");
        System.out.println("<|                                  REPORT SELECTION                                  |>");
        System.out.println("<|                                                                                    |>");
        System.out.println("<|       The below is a list of avaiable Reports, that can be viewed. To view a       |>");
        System.out.println("<|       Report simply input the report number (to the left of the Report Name)       |>");
        System.out.println("<|       which will select the report and display its contents.                       |>");
        System.out.println("<|                                                                                    |>");
        System.out.println("<|                     Report List:                                                   |>");
        System.out.println("<|                                                                                    |>");
        System.out.println("<|            1.  Report 1                          19. Report 19                     |>");
        System.out.println("<|            2.  Report 2                          20. Report 20                     |>");
        System.out.println("<|            3.  Report 3                          21. Report 21                     |>");
        System.out.println("<|            4.  Report 4                          22. Report 22                     |>");
        System.out.println("<|            5.  Report 5                          23. Report 23                     |>");
        System.out.println("<|            6.  Report 6                          24. Report 24                     |>");
        System.out.println("<|            7.  Report 7                          25. Report 25                     |>");
        System.out.println("<|            8.  Report 8                          26. Additional Info 1             |>");
        System.out.println("<|            9.  Report 9                          27. Additional Info 2             |>");
        System.out.println("<|            10. Report 10                         28. Additional Info 3             |>");
        System.out.println("<|            11. Report 11                         29. Additional Info 4             |>");
        System.out.println("<|            12. Report 12                         30. Additional Info 5             |>");
        System.out.println("<|            13. Report 13                         31. Additional Info 6             |>");
        System.out.println("<|            14. Report 14                         32. Languages 1                   |>");
        System.out.println("<|            15. Report 15                         33. Languages 2                   |>");
        System.out.println("<|            16. Report 16                         34. Languages 3                   |>");
        System.out.println("<|            17. Report 17                         35. Languages 4                   |>");
        System.out.println("<|            18. Report 18                         36. Languages 5                   |>");
        System.out.println("<|                                                                                    |>");
        System.out.println("<|            37. Exit Report Program                                                 |>");
        System.out.println("<|                                                                                    |>");
        System.out.println("<|************************************************************************************|>");
        System.out.println("<|                                                                                    |>");
        swValue = Keyin.inInt("<| Please, Select Report to view : ");

        /**
         Switch construct, Each case represents a Report.
         TODO: Could be used to them call each report method as needed ?
         TODO: Would also need to loop back to the menu after a report is selected or at least an option to exit/menu
         */
        switch (swValue) {
            case 1:
                System.out.println("Report 1 Selected"); break;
            case 2:
                System.out.println("Report 2 Selected"); break;
            case 3:
                System.out.println("Report 3 Selected"); break;
            case 4:
                System.out.println("Report 4 Selected"); break;
            case 5:
                System.out.println("Report 5 Selected"); break;
            case 6:
                System.out.println("Report 6 Selected"); break;
            case 7:
                System.out.println("Report 7 Selected"); break;
            case 8:
                System.out.println("Report 8 Selected"); break;
            case 9:
                System.out.println("Report 9 Selected"); break;
            case 10:
                System.out.println("Report 10 Selected"); break;
            case 11:
                System.out.println("Report 11 Selected"); break;
            case 12:
                System.out.println("Report 12 Selected"); break;
            case 13:
                System.out.println("Report 13 Selected"); break;
            case 14:
                System.out.println("Report 14 Selected"); break;
            case 15:
                System.out.println("Report 15 Selected"); break;
            case 16:
                System.out.println("Report 16 Selected"); break;
            case 17:
                System.out.println("Report 17 Selected"); break;
            case 18:
                System.out.println("Report 18 Selected"); break;
            case 19:
                System.out.println("Report 19 Selected"); break;
            case 20:
                System.out.println("Report 20 Selected"); break;
            case 21:
                System.out.println("Report 21 Selected"); break;
            case 22:
                System.out.println("Report 22 Selected"); break;
            case 23:
                System.out.println("Report 23 Selected"); break;
            case 24:
                System.out.println("Report 24 Selected"); break;
            case 25:
                System.out.println("Report 25 Selected"); break;
            case 26:
                System.out.println("Report Additional Info 1 Selected"); break;
            case 27:
                System.out.println("Report Additional Info 2 Selected"); break;
            case 28:
                System.out.println("Report Additional Info 3 Selected"); break;
            case 29:
                System.out.println("Report Additional Info 4 Selected"); break;
            case 30:
                System.out.println("Report Additional Info 5 Selected"); break;
            case 31:
                System.out.println("Report Additional Info 6 Selected"); break;
            case 32:
                System.out.println("Report Languages 1 Selected"); break;
            case 33:
                System.out.println("Report Languages 2 Selected"); break;
            case 34:
                System.out.println("Report Languages 3 Selected"); break;
            case 35:
                System.out.println("Report Languages 4 Selected"); break;
            case 36:
                System.out.println("Report Languages 5 Selected"); break;
            case 37:
                System.out.println("Exit Report Program Selected, Have a nice day!");
                a.disconnect(); break;
            default:
                System.out.println("Invalid Input, try again...");
                break;
            /**   /\
             * This break is not really necessary but good practice, TODO: look at removing if needed?
             */
        }
    }
}

class Keyin {
    /**
     * Support Methods
     * Method to display the user's prompt string
     * @param prompt
     */
    public static void printPrompt(String prompt) {
        System.out.print(prompt + " ");
        System.out.flush();
    }

    /**
     * Method to make sure no data is available in the input stream
     */
    public static void inputFlush() {
        int dummy;
        int bAvail;

        try {
            while ((System.in.available()) != 0)
                dummy = System.in.read();
        } catch (java.io.IOException e) {
            System.out.println("Input error");
        }
    }

    /**
     * Used in "inInt"
     * @return
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
                else if ((char) aChar != '\r')
                    s = s + (char) aChar; // Enter into string
            }

            catch (java.io.IOException e) {
                System.out.println("Input error");
                finished = true;
            }
        }
        return s;
    }

    /**
     * For checking the input from the user is a integer and can be used to call a report
     * @param prompt
     * @return
     */
    public static int inInt(String prompt) {
        while (true) {
            inputFlush();
            printPrompt(prompt);
            try {
                return Integer.valueOf(inString().trim()).intValue();
            }
            /**
            Catch for invalid input, i.e if anthing but one of the cases above is used.
             */
            catch (NumberFormatException e) {
                System.out.println("Invalid Input. Please use an integer");
                /**
                Uses "\033[3m" to put the text into italics.
                 */
                System.out.println("\033[3mPlease use a Report number to view the Report\033[0m");
            }
        }
    }

}

