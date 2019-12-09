import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ContactManagementApp {
    final static String folder = "data";
    final static String fileName = "contacts.txt";
//    static Contact kenHowell = new Contact("Ken Howell", 2103153119);
//static Contact kellseyNeagley = new Contact("Kellsey Neagley", 2103810439);
//
//    static List<Contact> testList = Arrays.asList(kenHowell, kellseyNeagley);

    public static void main(String[] args) {

        Path dataDirectory = Paths.get(folder);
        Path dataFile = Paths.get(folder, fileName);
        Contact kenHowell = new Contact("Ken Howell", "2103153119");
        Contact kellseyNeagley = new Contact("Kellsey Neagley", "2103810439");

        List<String> ListString = Arrays.asList(kenHowell.getName() + " | " + kenHowell.getContactNumber(), kellseyNeagley.getName() + " | " + kellseyNeagley.getContactNumber());

        try{
            if(!Files.exists(dataDirectory)){
                Files.createDirectories(dataDirectory);
            }
            if(!Files.exists(dataFile)){
                Files.createFile(dataFile);
            }
            Path filepath = Paths.get("data", "contacts.txt");
            Files.write(filepath, ListString);
//            written a output below
            List<String> updatedList = Files.readAllLines(filepath);
            for (String contact : updatedList){
                System.out.println(contact);
            };
//            System.out.println("updatedList = " + updatedList);
        } catch(IOException e) {
            e.printStackTrace();
        }


//        Path filepath = Paths.get("data", "contacts.txt");
//        Files.write(filepath, (Iterable<? extends CharSequence>) testList);
//        System.out.println("ken name = " + ken./getContactNumber());

    }
}
