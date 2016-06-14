package homework25_05_16;

/**
 *
 * @author Przemek Stepien
 */
public class StudentApp {
    
    public static void main(String[] args) {
        
        Student stu2 = new Student("Jack Frost");
        Student stu3 = new Student("Bessie Brooks");       
        Student stu4 = new Student("Tom Thumb", "blyfmt004");
        stu4.setCredits(stu4.getCredits()+40);        
        
        System.out.println(stu2);
        System.out.println(stu3);
        System.out.println(stu4);
    }    
}
