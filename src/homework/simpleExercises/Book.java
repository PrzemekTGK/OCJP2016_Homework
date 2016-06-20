package homework.simpleExercises;

/**
 *
 * @author Przemek Stepien
 */
public class Book {

    // The fields.
    private String author;
    private String title;
    private int pages;
    private String refNumber;

    /**
     * Constructor which sets the author and title fields for the
     * new object made.
     */
    public Book(String bookAuthor, String bookTitle, int pages){
        this.author = bookAuthor;
        this.title = bookTitle;
        this.pages = pages;
        this.refNumber = "";
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    public String getRefNumber() {
        return refNumber;
    }

    public void setRefNumber(String refNumber) {
        if (refNumber.length() < 3) {
            System.out.println("Invalid reference number");
        } else {
            this.refNumber = refNumber;            
        }
    }  
    
    public void printDetails(){
        System.out.println("Author: " + this.getAuthor());
        System.out.println("Title: " + this.getTitle());
        System.out.println("Pages: " + this.getPages());
        if (this.getRefNumber().equals("")){
            System.out.println("Reference number: ZZZ");
        } else {
            System.out.println("Reference number: " + this.getRefNumber());
        }
    }
    
}
