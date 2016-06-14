/*
 * Simple class holding a list of all users as an ArrayList. Contains 1 
 * ArrayList field to hold the users in and provides a getter and a setter
 * methods for that field as wel ass a simple constructor for the class itself.
 *
 */
package homework09_06_16;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Pzemek Stepien
 */
public class UsersList implements Serializable {
    
    // ArrayList field to store the users
    private ArrayList<User> usersArrayList;

    // Construtod
    public UsersList() {
        usersArrayList = new ArrayList<User>();
    }

    // Getters and setters
    public ArrayList<User> getUsersArrayList() {
        return usersArrayList;
    }
    public void setUsersArrayList(ArrayList<User> usersArrayList) {
        this.usersArrayList = usersArrayList;
    }
    
}
