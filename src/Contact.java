import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

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
}

