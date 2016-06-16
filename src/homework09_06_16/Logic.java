/*
 * Main engine class contains 3 fields (Scanner, UsersList, User) and a
 * constructor to initialize 2 of those fields (Scanner and UsersList).
 * User field is initialized from within userLogin method. The class also
 * provides with a set of methods required for the whole progeam to run and
 * startin point of the program is the startPhoneBook method.
 */
package homework09_06_16;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Przemek Stepien
 */
public class Logic {

    // Scanner Object field
    private Scanner scanText;
    // UsersList Object field
    private UsersList usersList = null;
    // User Object field
    private User userLoggedIn = null;

    // Constructor
    public Logic() {
        this.scanText = new Scanner(System.in);
        try {
            FileInputStream fileIn = new FileInputStream("users.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.usersList = (UsersList) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("File Found");
        } catch (IOException ioe) {
            this.usersList = new UsersList();
            System.out.println("File not Found");
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("User class not found");
            return;
        }
    }

    /*
     Starting point of the program. Displays main menu and asks 
     user to choose an option from it. User's choice for menu is
     taken as an input thru scanner object and passed to swtich
     statement as an argument to match one of it's cases.
    */
    public void startPhoneBook() {
        boolean userContinue = true;
        do {
            System.out.println("Welcome to Your Phone Book");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            switch (scanText.nextLine()) {
                case "1":
                    System.out.println("Register");
                    userRegister();
                    break;
                case "2":
                    System.out.println("Login");
                    if (this.usersList.getUsersArrayList().size() == 0) {
                        System.out.println("No users registered. Register to ba "
                                + "able to log in.");
                    } else {
                        userLoggedIn = userLogin();
                        usersMenu(userLoggedIn);
                        
                    }
                    break;
                case "3":
                    System.out.println("Exit");
                    userContinue = false;
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        } while (userContinue);
    }

    /*
     Allows to register new user. Takes in user's name and password
     by calling takeUserNamePassword() method and seving it's result
     in String userName and String password variables. Then the list
     of user objects is checked for same user name as given by the user.
     If user object with name given by the user already exists in the 
     list the warning message is prompted to the screen in which user is
     informed about same name already being present in the list and user
     is asked to type in a different name.
    */
    public void userRegister() {
        boolean userDuplicate = true;
        String userName;
        String password;
        do {
            int duplicatedUsers = 0;
            userName = takeUserNamePasword("User Name");
            password = takeUserNamePasword("Password");      
            
            for (int i = 0; i < this.usersList.getUsersArrayList().size(); i++) {
                if (this.usersList.getUsersArrayList().get(i).getUserName().
                        equals(userName)) {
                    duplicatedUsers++;
                }
            }
            if (duplicatedUsers > 0) {
                System.out.println("User " + userName + " already exists. "
                        + "Please type in a different User Name.");
            } else {
                System.out.println("User Name Available");
                userDuplicate = false;
            }
        } while (userDuplicate);        
        
        User newUser = new User(userName, password);        
        this.usersList.getUsersArrayList().add(newUser);
        System.out.println("User " + newUser.getUserName() + " added to List");
        serializeUsersList();
    }

    /*
     Allows user to log in to the application. Takes in user's name 
     and password by calling takeUserNamePassword() method and saving 
     its result in String userName and String password variables.
     Then the list of user objects is checked for object with matching
     name. If object with matching name was found, it's being checked
     if the password is also matching. If both user's name and password
     of the object match to the user's name and passwords passed in by
     the user the login process is completed successfully, otherwise the
     user is informad about either invalid name or passwords and is asked
     to try to login again. Succesfully logged in user is returned as a
     result of that method.
    */
    public User userLogin() {
        boolean userLoggedIn = false;
        User user = new User();
        int duplicatedUsers = 0;
        do {
            String userName = takeUserNamePasword("User Name");
            String password = takeUserNamePasword("Password");
            for (int i = 0; i < this.usersList.getUsersArrayList().size(); i++) {
                if (this.usersList.getUsersArrayList().get(i).getUserName().
                        equals(userName)) {
                    if (this.usersList.getUsersArrayList().get(i).getPassword().
                            equals(password)) {
                        user = this.usersList.getUsersArrayList().get(i);
                        userLoggedIn = true;
                    } else {
                        System.out.println("Invalid Password");
                    }
                } else {
                    duplicatedUsers++;
                }
            }
            if (duplicatedUsers > 0) {
                System.out.println("Invalid User Name");
            }
        } while (!userLoggedIn);
        return user;
    }

    /*
     Method to take user's input for user's name and password.
     Takes in String argument input type to define whether if
     the method is to be used for user name input or password
     input. User's name or password is returned as the result
     of this method.
    */
    public String takeUserNamePasword(String inputType) {
        boolean invalidUserName = true;
        String userInput = null;
        System.out.println("Please Enter Your " + inputType + ": ");
        do {
            userInput = scanText.nextLine();
            if (userInput.contains(" ")) {
                System.out.println("Invalid User Name. Space ' ' is not allowed"
                        + " in  " + inputType);
            } else if (!userInput.isEmpty()) {
                invalidUserName = false;
            }
        } while (invalidUserName);
        return userInput;
    }

    /*
     Displays user's menu when user logged in and asks the user to choose 
     an option from it. User's choice for menu is taken as an input thru 
     scanner object and passed into swtich statement as an argument to 
     match one of it's cases. Logged in user is passed into the method as
     an argument to have an access to user's contact lists.
    */
    public void usersMenu(User user) {
        boolean userLogout = false;
        do {
            System.out.println("1. Create Contact List");
            System.out.println("2. Manage Contact Lists");
            System.out.println("3. Log Out");
            switch (scanText.nextLine()) {
                case "1":
                    System.out.println("Create Contact List");
                    user = createContactList(user);
                    break;
                case "2":
                    System.out.println("Manage Contact Lists");
                    usersContactListsMenu(user);
                    break;
                case "3":
                    user = null;
                    userLogout = true;
                    System.out.println("Log Out");
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        } while (!userLogout);
    }
    
    /*
     Displays menu for Manage Contact List option from userMenu method.
     Contact Lists are displayed first with a call to diaplayUsersContactLists 
     followed by menu for them and a switch statement to operate this menu. 
     User object is passed into the method as an argument to get an access to 
     user's List of Contact Lists.
    */
    public void usersContactListsMenu(User user){
        boolean userContinue = true;
        if (user.getContactLists().size() > 0) {
            do {
                
                System.out.println();
                System.out.println("1. Select the List");
                System.out.println("2. Remove the List");
                System.out.println("3. Go Back");
                switch (scanText.nextLine()) {
                    case "1":
                        System.out.println("Select the List");
                        usersContactMenu(user,
                            displayContactsFromList(
                                    selectContactList(
                                            displayContactLists(user))));
                        break;
                    case "2":
                        removeContactList(displayContactLists(user));
                        System.out.println("Remove the List");
                        break;
                    case "3":
                        System.out.println("Go Back");
                        userContinue = false;
                        break;
                    default:
                        System.out.println("Invalid Input");
                }
            } while (userContinue);            
        }
    }
   
    /*
     Displays user's contact list menu when user selected one of his 
     contact lists in and asks the user to choose an option from it.
     User's list of contacts lists is checked if it's not empty. If it's
     not, User's choice for menu is taken as an input thru scanner object 
     and passed into swtich statement as an argument to match one of 
     it's cases. Logged in user is passed into the method as an argument
     to have an access to user's List of Contact Lists. User's Contact 
     List is passed into the method as an argument so the required operations
     can be performed on that List.
    */
    public void usersContactMenu(User user, HashMap contactList) {
        boolean userContinue = true;
        if (user.getContactLists().size() > 0) {
            do {
                System.out.println("1. Add Contact to the List");
                System.out.println("2. Remove Contact from the List");
                System.out.println("3. Edit Contact in the List");
                System.out.println("4. Search by Name");
                System.out.println("5. Search by Number");
                System.out.println("6. Display All Contacts");
                System.out.println("7. Go Back");
                switch (scanText.nextLine()) {
                    case "1":
                        System.out.println("Add Contact to the List");
                        addContact(contactList);
                        displayContactsFromList(contactList);
                        break;
                    case "2":
                        System.out.println("Remove Contact from the List");
                        removeContact(contactList);
                        displayContactsFromList(contactList);
                        break;
                    case "3":
                        System.out.println("Edit Contact in the List");
                        editContact(contactList);
                        displayContactsFromList(contactList);
                        break;
                    case "4":
                        System.out.println("Search by Name");
                        searchByName(contactList);
                        break;
                    case "5":
                        System.out.println("Search by Number");
                        searchByPhoneNumber(contactList);
                        break;
                    case "6":
                        System.out.println("Display All Contacts");
                        displayContactsFromList(contactList);
                        break;
                    case "7":
                        System.out.println("Go Back");
                        userContinue = false;
                        break;
                    default:
                        System.out.println("Invalid Input");
                }
            } while (userContinue);            
        }
    }
    
    /*
     Displays all contacts from selected contact list which is passed
     into this method as an argument from selectContactList method.
    */
    public HashMap displayContactsFromList(HashMap contactList) {
        int index = 0;
        try {
            Iterator contactIterator = contactList.entrySet().iterator();
            while (contactIterator.hasNext()) {
                ++index;
                Map.Entry thisEntry = (Map.Entry) contactIterator.next();
                System.out.println(index + ". "
                        + "Name: " + thisEntry.getValue()
                        + "\n   Phone Number: " + thisEntry.getKey());
            }
            System.out.println("");
        } catch (NullPointerException npe) {
            System.out.println("There is no Contact Lists created. Please create"
                    + " a new Contact List");
        }
        return contactList;
    }

    /*
     Then the user is asked to choose one of the contact lists and user's 
     choice is verified. Chosen contact list is returned as a result of 
     this method. Logged in user is passed to this method as an argument 
     to get acces to user's List of Contact Lists.
    */
    public HashMap selectContactList(User user) {
        boolean invalidList = true;
        HashMap<String, HashMap<String, String>> contactList = null;
        if (user.getContactLists().size() != 0) {
            do {
                int invalidLists = 0;
                System.out.println("Please Select User's Contact List "
                        + "(Type in the name of the list)");
                String listName = scanText.nextLine();
                Iterator usersListIterator = user.getContactLists().entrySet()
                        .iterator();
                while (usersListIterator.hasNext()) {
                    Map.Entry thisEntry = (Map.Entry) usersListIterator.next();
                    if (thisEntry.getKey().equals(listName)) {
                        contactList = (HashMap) thisEntry.getValue();
                        invalidLists = 0;
                        invalidList = false;
                        break;
                    } else {
                        invalidLists++;
                    }
                }
                if (invalidLists > 0) {
                    System.out.println("No Such Contact List. Please Try Again.");
                }
            } while (invalidList);
        }
        return contactList;
    }
    
    /*
     Asks user for a name of new Contact List. Checks if there is no Contact 
     List with given name already and if there's not the new Contact List is
     added to the user's List of Contact Lists. If the list with given name
     already exists user is asked to enter different name. Logged in user is 
     passed to this method as an argument to get acces to user's List of 
     Contact Lists. User Object is serialized after successful creation of
     the Contact List.
    */
    public User createContactList(User user) {
        String listName;
        HashMap<String, String> contactList = new HashMap<>();
        boolean invalidName = true;
        if (user.getContactLists().size() > 0) {
            Label:
            do {
                System.out.println("Please enter the name of your contact list");
                listName = scanText.nextLine();
                Iterator listsIterator = user.getContactLists().entrySet().iterator();

                while (listsIterator.hasNext()) {
                    Map.Entry thisEntry = (Map.Entry) listsIterator.next();
                    if (thisEntry.getKey().toString().equals(listName)) {
                        System.out.println("Contact list with this name already exists."
                                + "\nPlease type a different name for the contact list");
                        continue Label;
                    }
                }
                invalidName = false;
            } while (invalidName);
        } else {
            System.out.println("Please enter the name of your contact list");
            listName = scanText.nextLine();
        }
        user.getContactLists().put(listName, contactList);
        serializeUsersList();
        return user;
    }
    
    /*
     Asks user to enter the name of the list that user wants to remove and
     checks for the list with the name given by user in user's List of
     Contact Lists. When List with given name is found it is removed from
     the user's List. Logged in user is passed to this method as an argument
     to get acces to user's List of Contact Lists. User obejct is serialized 
     after successful removal of the Contact List.
    */
    public void removeContactList(User user){
        String listName;
        boolean invalidName = true;
        if (user.getContactLists().size() > 0) {
            do {
                int noLists = 0;
                System.out.println("Please enter the name of the Contact List"
                        + " you want to remove");
                listName = scanText.nextLine();
                Iterator listsIterator = user.getContactLists().entrySet().iterator();
                while (listsIterator.hasNext()) {
                    Map.Entry thisEntry = (Map.Entry) listsIterator.next();
                    if (!thisEntry.getKey().toString().equals(listName)) {
                        noLists++;
                    } else {
                        noLists = 0;
                        System.out.println("Contact List " + thisEntry.getKey().
                                toString() + "was removed succesfully");
                        invalidName = false;
                        break;
                    }
                }                
                if (noLists > 0) {
                    System.out.println("There is no such Contact List to be removed");
                }
            } while (invalidName);
            user.getContactLists().remove(listName);
        } else {
            System.out.println("There is no Contact Lists to be removed");
        }
        serializeUsersList();
    }

    /*
     Displays all of user's Contact Lists to the screen. Logged in user is 
     passed to this method as an argument to get acces to user's List of 
     Contact Lists.
    */
    public User displayContactLists(User user) {
        int index = 0;
        Iterator listsIterator = user.getContactLists().entrySet().iterator();
        while (listsIterator.hasNext()) {
            ++index;
            Map.Entry thisEntry = (Map.Entry) listsIterator.next();
            System.out.println(index + ". " + thisEntry.getKey());
        }
        return user;
    }

    /*
     Asks the user for the Name and Phone Number. Verifies that the given
     Phone Number is not in the user's Contact List already and if it's not
     the created Contact (Name/Phone Number)is added to the user's Contact
     List. User's Contact List is passed into this method as an argument to
     add the contact to that list. User obejct that holds the Contact List
     is serialized after successful addioition of the contact to the list.
    */
    public void addContact(HashMap contactList) {
        boolean invalidPhoneNumber = true;
        System.out.println("Please Type in Contact's Name: ");
        String name = scanText.nextLine();
        String number;
        do {            
            System.out.println("Please Type in the Phone Number: ");
            number = scanText.nextLine();
            try {            
                int tempNum = Integer.parseInt(number);
                assert(tempNum > 0);
            } catch (NumberFormatException nfe){
                System.out.println("Invalid Phone Number. No letters allowed in the "
                        + "Phone Number");
            }            
            Iterator contactListIterator = contactList.entrySet().iterator();
            if (contactList.size() > 0){
                int sameNumbers = 0;
                while(contactListIterator.hasNext()) {
                    Map.Entry thisEntry = (Map.Entry) contactListIterator.next();
                    if (number.equals(thisEntry.getKey())) {
                        System.out.println("This Phone Number exists in the list "
                                + "already.\nPlease type in a correct Phone Number");
                        sameNumbers++;
                    }
                }
                if (sameNumbers == 0){
                    contactList.put(number, name);
                    invalidPhoneNumber = false;                    
                }
            } else {
                contactList.put(number, name);
                invalidPhoneNumber = false;
            }            
        } while (invalidPhoneNumber);
        serializeUsersList();
    } 
   
    /*
     Asks the user for the Phone Number of the contact to remove from the 
     user's Contact List. Check's if the contact with given Phone Number 
     actually exists in the List and if it does it's being removed from that 
     List. User's Contact List is passed into this method as an argument to 
     add the contact to that list. User obejct that holds the Contact List 
     is serialized after successful addioition of the contact to the list.
    */
    public void removeContact(HashMap contactList){
        boolean invalidPhoneNumber = true;
        String number;
        do {
            int numberFound = 0;
            System.out.println("Please type in the number you want to"
                    + "\nremove from the Contact list:");
            number = scanText.nextLine();
            try {            
                int tempNum = Integer.parseInt(number);
                assert(tempNum > 0);
            } catch (NumberFormatException nfe){
                System.out.println("Invalid Phone Number. No letters allowed in the "
                        + "Phone Number");
            }            
            Iterator contactListIterator = contactList.entrySet().iterator();
            if (contactList.size() > 0){
                String tempNumber = null;
                Map.Entry thisEntry = null;
                while(contactListIterator.hasNext()) {
                    thisEntry = (Map.Entry) contactListIterator.next();
                    if (number.equals(thisEntry.getKey())) {
                        tempNumber = thisEntry.getKey().toString();
                        System.out.println("Contact " + thisEntry.getValue() +
                                " was removed!");
                        numberFound++;
                        invalidPhoneNumber = false;
                    }
                }                
                contactList.remove(tempNumber);
                if (numberFound == 0) {
                    System.out.println("No such number in Contact list."
                            + " Please try again!");
                }                
            }
        } while (invalidPhoneNumber);
        serializeUsersList();
    }
    
    /*
     Asks user for the Phone Number of the contact to be edited. Searches
     the user's Contact Lists for the contact with given Phone number. If
     the contact with given Phone Number is found it is removed from the
     Contact List and user is asked to enter new Name and Phone Number for
     new contact that will replace the removed one. User's Contact List is 
     passed into this method as an argument to add the contact to that list. 
     User obejct that holds the Contact List is serialized after successful 
     addioition of the contact to the list.
    */
    public void editContact(HashMap contactList){
        boolean invalidPhoneNumber = true;
        String number;
        do {
            int numberFound = 0;
            System.out.println("Please select the Contact yo want to edit."
                    + "\n(Type in the Phone Number of the contact).");
            number = scanText.nextLine();
            try {            
                int tempNum = Integer.parseInt(number);
                assert(tempNum > 0);
            } catch (NumberFormatException nfe){
                System.out.println("Invalid Phone Number. No letters allowed in the "
                        + "Phone Number");
            }            
            Iterator contactListIterator = contactList.entrySet().iterator();
            if (contactList.size() > 0){
                String tempNumber = null;
                Map.Entry thisEntry = null;
                while(contactListIterator.hasNext()) {
                    thisEntry = (Map.Entry) contactListIterator.next();
                    if (number.equals(thisEntry.getKey())) {
                        tempNumber = thisEntry.getKey().toString();
                        numberFound++;
                        invalidPhoneNumber = false;
                    }
                }                
                contactList.remove(tempNumber);
                addContact(contactList);
                if (numberFound == 0) {
                    System.out.println("No such number in Contact list."
                            + " Please try again!");
                }
            }
        } while (invalidPhoneNumber);
        serializeUsersList();
    }
    
    /*
     Asks the user for the Phone Number that the user want to search for.
     Searches user's Contac List for any contact's with matching Phone Number
     and displays them to the screen. User's Contact List is passed into this 
     method as an argument to add the contact to that list. 
    */
    public void searchByPhoneNumber(HashMap contactList){
        boolean invalidPhoneNumber = true;
        String number;
        do {
            int numberFound = 0;
            System.out.println("Please type in the phone number you want to search for.");
            number = scanText.nextLine();
            try {            
                int tempNum = Integer.parseInt(number);
                assert(tempNum > 0);
            } catch (NumberFormatException nfe){
                System.out.println("Invalid Phone Number. No letters allowed in the "
                        + "Phone Number");
            }            
            Iterator contactListIterator = contactList.entrySet().iterator();
            if (contactList.size() > 0){    
                int index = 0;
                while(contactListIterator.hasNext()) {
                    Map.Entry thisEntry = (Map.Entry) contactListIterator.next();
                    if (number.equals(thisEntry.getKey())) {
                        System.out.println(++index + ". "
                        + "Name: " + thisEntry.getValue()
                        + "\n   Phone Number: " + thisEntry.getKey());
                        numberFound++;                        
                        invalidPhoneNumber = false;
                    }
                }
                if (numberFound == 0) {
                    System.out.println("No such number in Contact list."
                            + " Please try again!");
                }
            }
        } while (invalidPhoneNumber);
        System.out.println("");
    }
    
    /*
     Asks the user for the Name that the user want to search for. Searches 
     user's Contac List for any contact's with matching Name and displays 
     them to the screen. User's Contact List is passed into this method as 
     an argument to add the contact to that list. 
    */
    public void searchByName(HashMap contactList){
        boolean invalidPhoneNumber = true;
        String value;
        do {
            int numberFound = 0;
            System.out.println("Please type in the name you want to search for.");
            value = scanText.nextLine();      
            Iterator contactListIterator = contactList.entrySet().iterator();
            if (contactList.size() > 0){    
                int index = 0;
                while(contactListIterator.hasNext()) {
                    Map.Entry thisEntry = (Map.Entry) contactListIterator.next();
                    if (value.equals(thisEntry.getValue())) {
                        System.out.println(++index + ". "
                        + "Name: " + thisEntry.getValue()
                        + "\n   Phone Number: " + thisEntry.getKey());
                        numberFound++;                        
                        invalidPhoneNumber = false;
                    }
                }
                if (numberFound == 0) {
                    System.out.println("No such name in Contact list."
                            + " Please try again!");
                }
            }
        } while (invalidPhoneNumber);
        System.out.println("");
    }   

    /*
     Serializes the list of users to the file
    */
    public void serializeUsersList() {
        try {
            FileOutputStream fileOut = new FileOutputStream("users.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this.usersList);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in users.ser");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
