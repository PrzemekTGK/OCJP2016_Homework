package homework25_05_16;


/**
 *
 * @author Przemek Stepien
 */
public class FruitApp {
    
    
    
    public static void main(String... args) {
        Fruit f1 = new Fruit();
        Fruit f2 = new Fruit("Banana");
        Fruit f3 = new Fruit("Kiwi", 0.1, true);
        
        f1.setName("Lemon");
        f1.setWeight(120);
        
        f2.setWeight(8);
        f2.setInSeason(true);
        
        System.out.println(f1 + "\n" + f2 + "\n" + f3);

    }  
}
