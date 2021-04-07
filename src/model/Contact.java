package model;

/**
 * This class is used to create Contacts in the program.
 * It corresponds with the contacts table.
 * @author Will Lapinski
 */
public class Contact {
    //fields
    private int Contact_ID;
    private String Contact_Name;
    private String email;

    //constructor
    public Contact(int contact_ID, String contact_Name, String email) {
        Contact_ID = contact_ID;
        Contact_Name = contact_Name;
        this.email = email;
    }

    //getters and setters
    public int getContact_ID() {
        return Contact_ID;
    }

    public void setContact_ID(int contact_ID) {
        Contact_ID = contact_ID;
    }

    public String getContact_Name() {
        return Contact_Name;
    }

    public void setContact_Name(String contact_Name) {
        Contact_Name = contact_Name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
