import java.util.Scanner;

public class Main {

    public static void printMenu(String[] options){
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choose the report you wish to see, select option : ");
    }

    public static void main(String[] args) {
        String[] options = {
                "1- Option 1",
                "2- Option 2",
                "3- Option 3",
                "4- Exit Report Program",
        };

        Scanner scanner = new Scanner(System.in);
        int option;
        while (true){
            printMenu(options);
            option = scanner.nextInt();
        }
    }
}