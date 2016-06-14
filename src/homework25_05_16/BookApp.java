/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework25_05_16;

import java.util.Scanner;

/**
 *
 * @author PRZEMEK
 */
public class BookApp {
    
    public static void main (String[] args) {
        Scanner scanText = new Scanner(System.in);
        Scanner scanInt = new Scanner(System.in);
        System.out.println("Please enter the author of the Book?");
        String author = scanText.nextLine();
        System.out.println("Please enter the title of the Book?");
        String title = scanText.nextLine();
        System.out.println("Please enter the nuber of pages in the Book?");
        while(!scanInt.hasNextInt()){
            scanInt.next();
        }
        int pages = scanInt.nextInt();
        Book book1 = new Book(author, title, pages);
        book1.setRefNumber("Comp7");
        book1.printDetails();
        Book book2 = new Book("Daniel Defoe", "Robinson Crusoe", 232);
        book2.setRefNumber("Adv4");
        book2.printDetails();
        Book book3 = new Book("Harper Lee", "To Kill a Mocking Bird", 256);
        book3.setRefNumber("Ab");
        book3.printDetails();
        Book book4 = new Book("Charlotte Bronte", "Jane Eyre", 189);
        book4.setRefNumber("Hist5");
        book4.printDetails();
    }
    
}
