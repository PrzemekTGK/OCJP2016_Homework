/*
 * A User class that holds all the required info about the user. Contains
 * 2 String fields to store user's name and password and 1 HashMap field
 * to store the list uf user's Contact Lists. Provides a simple constructor
 * that takes in 2 strings as arguments for user's name and password and 
 * initializes the HashMap field to the new instance of the HashMap Object.
 * Also provides a set of getter and setter methods for those fields.
 */
package homework09_06_16;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Pzemek Stepien
 */
public class User implements Serializable{
    
    // User's name and password
    private String userName;
    private String password;
    
    // User's List od contact Lists
    private HashMap<String, HashMap<String, String>> contactLists;

    // Constructors
    public User() {
    }
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.contactLists = new HashMap<>();
    }
    
    // Getters and setters
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public HashMap<String, HashMap<String, String>> getContactLists() {
        return contactLists;
    }
    public void setContactLists(HashMap<String, HashMap<String, String>> contactLists) {
        this.contactLists = contactLists;
    }        
}
