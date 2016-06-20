/*
 * Main driver class with main method that instatiating 1 object og Logic class
 * and calls its startPhoneBook method to start the program.
 */
package homework.phonebook;

/**
 *
 * @author Pzemek Stepien
 */
public class PhoneBookApp {
    public static void main (String[] args){
        Logic logic = new Logic();
        logic.startPhoneBook();
    }
}
