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



}

