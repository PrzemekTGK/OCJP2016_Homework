/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework13_05_16;

import java.util.Scanner;

/**
 *
 * @author PRZEMEK
 */
public class Logic {

    public static void startProgram() {

        // CarListObject to store cars in it
        CarList carList = new CarList();
        
        // Separate scanner objects for texts, ints and floats
        Scanner scanText = new Scanner(System.in);
        Scanner scanInt = new Scanner(System.in);
        Scanner scanFloat = new Scanner(System.in);
        
        // Main program loop condition
        boolean userContinue = true;

        // Main menu
        String[] menu = {"Please select what you want ot search the cars by: "
                , " 1. Make", " 2. Model", " 3. Color ", " 4. Body Type"
                , " 5. Engine Type", " 6. Engine Size", " 7. Amount of Seats"
                , " 8. Has Soonroof or not", " 9. Has Moonroof or not"
                , "10. Exit program"};

        /*
         5 for loops filling up the list of cars with 5*10
         of same make and model.
        */
        for (int i = 0; i < 10; ++i) {
            Car car = new Car("Toyota", "Avensis", "Black", "Diesel", 2.0F, 5, true, false, "Saloon");
            carList.addCar(car);
        }
        for (int i = 0; i < 10; ++i) {
            Car car = new Car("BMW", "3", "Grey", "Petrol", 1.8F, 5, false, false, "Coupe");
            carList.addCar(car);
        }
        for (int i = 0; i < 10; ++i) {
            Car car = new Car("Honda", "Accord", "Blue", "Diesel", 2.2F, 5, true, false, "Estate");
            carList.addCar(car);
        }
        for (int i = 0; i < 10; ++i) {
            Car car = new Car("Audi", "A6", "Red", "Diesel", 2.0F, 5, false, false, "Saloon");
            carList.addCar(car);
        }
        for (int i = 0; i < 10; ++i) {
            Car car = new Car("Mazda", "6", "White", "Petrol", 2.0F, 5, true, false, "Hatchback");
            carList.addCar(car);
        }

        // Main program loop
        do {
            // Input check condition
            boolean validInput = true;
            
            // Input check loop
            do {
                
                // Prints out the main manu
                for (int i = 0; i < menu.length; ++i) {
                    System.out.println(menu[i]);
                }
                
                // Asks user for input to choose option from main menu
                System.out.print("Please select an option: ");
                String option = scanText.nextLine();

                /*
                 Switch statement with 10 cases of which 8 cases is for 
                 searching the Car Object in CarList Object by an of Car 
                 Object's fields (make, model, color, etc.). Case 9 takes
                 user back to previous menu and case 10 ends the program.
                */
                switch (option) {
                    case "1":
                        System.out.println("Type in the make of the car:");
                        String make = scanText.nextLine();
                        carList.searchCarsByMake(make);
                        break;
                    case "2":
                        System.out.println("Type in the model of the car:");
                        String model = scanText.nextLine();
                        carList.searchCarsByModel(model);
                        break;
                    case "3":
                        System.out.println("Type in the color of the car:");
                        String color = scanText.nextLine();
                        carList.searchCarsByColor(color);
                        break;
                    case "4":
                        System.out.println("Type in the body type of the car:");
                        String bodyType = scanText.nextLine();
                        carList.searchCarsByBodyType(bodyType);
                        break;
                    case "5":
                        System.out.println("Type in the fuel type of the car:");
                        String engineType = scanText.nextLine();
                        carList.searchCarsByEngineType(engineType);
                        break;
                    case "6":
                        System.out.println("Type in the engine size of the car:");
                        while (!scanFloat.hasNextFloat()) {
                            System.out.println("Invalid input");
                            scanFloat.next();
                        }
                        float engineSize = scanInt.nextFloat();
                        carList.searchCarsByEngineSize(engineSize);
                        break;
                    case "7":
                        System.out.println("Type in the amount of seats in the car:");
                        while (!scanInt.hasNextFloat()) {
                            System.out.println("Invalid input");
                            scanInt.next();
                        }
                        int numSeats = scanInt.nextInt();
                        carList.searchCarsByEngineSize(numSeats);
                        break;
                    case "8":
                        boolean validInputSunroof = false;
                        do {
                            boolean hasSunroof;
                            System.out.println("Does the care have a sunroof "
                                    + "(true/false)?:");
                            String optionSunroof = scanText.nextLine();
                            switch (optionSunroof) {
                                case "true":
                                    hasSunroof = true;
                                    carList.searchCarsBySunroof(hasSunroof);
                                    validInputSunroof = true;
                                    break;
                                case "false":
                                    hasSunroof = false;
                                    carList.searchCarsBySunroof(hasSunroof);
                                    validInputSunroof = true;
                                    break;
                                default:
                                    System.out.println("Invalid Input");

                            }

                        } while (!validInputSunroof);
                        break;
                    case "9":
                        boolean validInputMoonroof = false;
                        do {
                            boolean hasSunroof;
                            System.out.println("Does the care have a Moonroof "
                                    + "(true/false)?:");
                            String optionMoonroof = scanText.nextLine();
                            switch (optionMoonroof) {
                                case "true":
                                    hasSunroof = true;
                                    carList.searchCarsBySunroof(hasSunroof);
                                    validInputSunroof = true;
                                    break;
                                case "false":
                                    hasSunroof = false;
                                    carList.searchCarsBySunroof(hasSunroof);
                                    validInputSunroof = true;
                                    break;
                                default:
                                    System.out.println("Invalid Input");

                            }

                        } while (!validInputMoonroof);
                        break;
                    case "10":
                        validInput = false;
                        userContinue = false;
                        break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }
            } while (validInput);

        } while (userContinue);
    }

}
