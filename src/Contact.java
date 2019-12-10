import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Contact {
    private String contactName;
    private String contactNumber;

    public void setName(String setname){
        this.contactName = setname;
    };

    public void setContactNumber(String setnumber){
        this.contactNumber = setnumber;
    }

    public String getName(){
        return this.contactName;
    }

    public String getContactNumber(){
        return this.contactNumber;
    };

    public Contact (String contactName, String contactNumber){
        setName(contactName);
        setContactNumber(contactNumber);
    }
    public static void newPerson (String getName, String getContactNumber){
        Contact newPerson = new Contact(getName, getContactNumber);

        Path filepath = Paths.get("data", "contacts.txt");
        try {
            Files.write(filepath,
                    Arrays.asList(newPerson.getName() + " | " + newPerson.getContactNumber()),
                    StandardOpenOption.APPEND
            );
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void printContacts() {
        String [] bucket;
        Path filepath = Paths.get("data", "contacts.txt");

        try {
            List<String> updatedList = Files.readAllLines(filepath);
            for (String contact : updatedList) {
                bucket = contact.split("\\|");
                System.out.printf("%-18s | %s%n", bucket[0], bucket[1]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void addContact(){
        boolean addContact = true;
        Scanner sc = new Scanner(System.in);
        String contactname;
        String contactnumber;
        String addcontactConfirm;
        while (addContact){
            System.out.printf("Add a contact - please enter the contacts name:%n");
            contactname = sc.nextLine();
            System.out.printf("%s is the name you input - please input a phone number for %s%n", contactname, contactname);
            contactnumber = sc.nextLine();
            System.out.printf("%s is the name you input and the phone number is %s - is that correct? (Y/N)%n", contactname, contactnumber);
            addcontactConfirm = sc.nextLine();
            if (addcontactConfirm.equalsIgnoreCase("y") || addcontactConfirm.equalsIgnoreCase("yes")){
                Contact.newPerson(contactname, contactnumber);
                System.out.printf("Okay - %s with a phone number of %s added!%n", contactname, contactnumber);
                addContact = false;

            } else {
                System.out.println("No problem, let's try again.");
            }
        }
    }

    public static void searchContact(){
        Path filepath = Paths.get("data", "contacts.txt");
        String userInput;
        Scanner sc = new Scanner(System.in);
        boolean nomatch = true;

        System.out.printf("Search for existing contact - please enter your search (either by NAME or PHONE NUMBER)%n");
        userInput = sc.nextLine();

        try {

            List<String> updatedList = Files.readAllLines(filepath);

            for (String contact : updatedList) {
                if (contact.toLowerCase().contains(userInput.toLowerCase())) {
                    System.out.printf("Match found: %s%n", contact);
                    nomatch = false;
                }
            }

            if (nomatch){
                System.out.printf("No match found!%n");
            }

        } catch (IOException e){
            e.printStackTrace();
        }


    }

    public static void deleteContact(){
        Path filepath = Paths.get("data", "contacts.txt");
        String userInput;
        String userDeleteInput;
        Scanner sc = new Scanner(System.in);
        boolean nomatch = true;
        boolean deleteplease = false;

        System.out.printf("Search for existing contact to delete - please enter your search (either by NAME or PHONE NUMBER)%n");
        userInput = sc.nextLine();

        try {

            List<String> updatedList = Files.readAllLines(filepath);
            List<String> tempList = new ArrayList<>();

            for (String contact : updatedList) {
                if (contact.toLowerCase().contains(userInput.toLowerCase())) {
                    nomatch = false;
                    System.out.printf("Match to delete found:%s%nConfirm delete?%n", contact);
                    userDeleteInput = sc.nextLine();
                    if (userDeleteInput.equalsIgnoreCase("y") || userDeleteInput.equalsIgnoreCase("yes")){
                        deleteplease = true;
                        continue;
                    } else {
                        System.out.printf("Understood, returning to main menu.%n");
                        tempList.clear();
                        break;
                    }
                }
                tempList.add(contact);
            }

            if (nomatch){
                System.out.printf("No match found!%n");
            }

            if (deleteplease) {
                Files.write(filepath, tempList);
            }

        } catch (IOException e){
            e.printStackTrace();
        }

    }
};


