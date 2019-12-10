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
//    static Contact kenHowell = new Contact("Ken Howell", 2103153119);
//static Contact kellseyNeagley = new Contact("Kellsey Neagley", 2103810439);
//
//    static List<Contact> testList = Arrays.asList(kenHowell, kellseyNeagley);

    public static void main(String[] args) {

        Path dataDirectory = Paths.get(folder);
        Path dataFile = Paths.get(folder, fileName);
        String userContinue;
        String userInput;
        boolean userOpt = true;

        Contact kenHowell = new Contact("Ken Howell", "2103153119");
        Contact kellseyNeagley = new Contact("Kellsey Neagley", "2103810439");


//        System.out.printf("%-24s, hello!", kellseyNeagley.getName());

        List<String> ListString = Arrays.asList(kenHowell.getName() + " | " + kenHowell.getContactNumber(), kellseyNeagley.getName() + " | " + kellseyNeagley.getContactNumber());

        try {
            if (!Files.exists(dataDirectory)) {
                Files.createDirectories(dataDirectory);
            }
            if (!Files.exists(dataFile)) {
                Files.createFile(dataFile);
            }
            Path filepath = Paths.get("data", "contacts.txt");
            Files.write(filepath, ListString);
//            written a output below
            List<String> updatedList = Files.readAllLines(filepath);
            for (String contact : updatedList){
                System.out.println(contact);
            };
            System.out.println("updatedList = " + updatedList);
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
//                    System.out.println("searching for contact by contact name/prompt for name input, THREE WORKS");
                    Contact.searchContact();
                    break;
                case "4":
                    System.out.println("delete an existing contact - ask for confirmation, FOUR WORKS");
                    break;
                case "5":
                    System.out.println("Exit system/final write");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option selected - please select again!");
                    break;
             }

//            sc.nextLine();
            System.out.printf("Continue using our application? (y/n)%n");
            userContinue = sc.nextLine();

           if (userContinue.equalsIgnoreCase("y" )|| userContinue.equalsIgnoreCase("yes")){
               userOpt = true;
           } else {
               userOpt = false;
           }
        }

        System.out.printf("Thank you for using our Contact Management System! Please use our application again soon! OR ELSE!!");


//        Path filepath = Paths.get("data", "contacts.txt");
//        Files.write(filepath, (Iterable<? extends CharSequence>) testList);
//        System.out.println("ken name = " + ken./getContactNumber());

    }
}
