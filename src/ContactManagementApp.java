import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContactManagementApp {
    final static String folder = "data";
    final static String fileName = "contacts.txt";
    static String nameTableHeader = "Name";
    static String phonenumberTableHeader = "Phone Number";

    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {

        Path dataDirectory = Paths.get(folder);
        Path dataFile = Paths.get(folder, fileName);
        String userContinue;
        String userInput;
        boolean userOpt = true;

        try {
            if (!Files.exists(dataDirectory)) {
                Files.createDirectories(dataDirectory);
            }
            if (!Files.exists(dataFile)) {
                Files.createFile(dataFile);
            }
            Path filepath = Paths.get("data", "contacts.txt");
//            Files.write(filepath, ListString);
        } catch(IOException e) {
            e.printStackTrace();
        }


        System.out.printf("Welcome to your Contact Management Application!%n");

        while (userOpt){
            System.out.printf("1. View Contacts.%n2. Add a new contact.%n3. Search a contact by name.%n4. Delete an existing contact.%n5. Exit application.%n");
            System.out.printf("Enter an option (1, 2, 3, 4 or 5):%n");
            userInput = sc.nextLine();

            switch (userInput){
                case "1":
                    System.out.printf("%-18s | %s%n", nameTableHeader, phonenumberTableHeader);
                    System.out.println("---------------------------");
                    Contact.printContacts();
                    break;
                case "2":
                    Contact.addContact();
                    break;
                case "3":
                    Contact.searchContact();
                    break;
                case "4":
                    Contact.deleteContact();
                    break;
                case "5":
                    System.out.println("Thank you for using our Contact Management System! Here is your finalized contact list:");
                    Contact.printContacts();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option selected - please select again!");
                    break;
             }

            System.out.printf("Continue using our application? (y/n)%n");
            userContinue = sc.nextLine();

           if (userContinue.equalsIgnoreCase("y" )|| userContinue.equalsIgnoreCase("yes")){
               userOpt = true;
           } else {
               userOpt = false;
           }
        }

        System.out.printf("Thank you for using our Contact Management System! Please use our application again soon! OR ELSE!!");

    }
}
