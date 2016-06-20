/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework.dataStructures;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Przemek Stepien
 */
public class DoubleArrays {

    private static DecimalFormat df2 = new DecimalFormat(".##");
    private static Random randomGen = new Random(System.nanoTime());

    public static void main(String[] args) {

        double[] doubleArray = new double[15000];
        ArrayList<Double> doubleList = new ArrayList<Double>();

        // Populate and sort double array 
        for (int i = 0; i < 15000; ++i) {
            int j = i;
            if (j >= 1000) {
                j /= 100;
            }
            doubleArray[i] = randomGen.nextDouble() + j;
        }
        Arrays.sort(doubleArray);

        /*
         Move and round the doubles from Arraay to ArraList.
         Sort the ArrayList
         */
        for (int i = 0; i < doubleArray.length; i++) {
            doubleArray[i] = Double.parseDouble(df2.format(doubleArray[i]));
            doubleList.add(doubleArray[i]);
        }
        doubleList.sort(new DoubleComparator());

        // Remove duplicated entries from ArrayList
        for (int i = 0; i < doubleList.size(); i++) {
            for (int j = 0; j < doubleList.size(); j++) {
                if (i != j) {
                    if (doubleList.get(i).equals(doubleList.get(j))) {
                        doubleList.remove(j);
                    }
                }
            }
        }


        System.out.println("\n================================================="
                + "=========================================================\n");

        for (int i = 0; i < doubleArray.length; i += 15) {
            System.out.println(doubleArray[i] + "\t" + doubleArray[i + 1] + "\t"
                    + doubleArray[i + 2] + "\t" + doubleArray[i + 3] + "\t"
                    + doubleArray[i + 4] + "\t" + doubleArray[i + 5] + "\t"
                    + doubleArray[i + 6] + "\t" + doubleArray[i + 7] + "\t"
                    + doubleArray[i + 8] + "\t" + doubleArray[i + 9] + "\t"
                    + doubleArray[i + 10] + "\t" + doubleArray[i + 11] + "\t"
                    + doubleArray[i + 12] + "\t" + doubleArray[i + 13] + "\t"
                    + doubleArray[i + 14]);
        }
        System.out.println("\nDouble Array size " + doubleArray.length);

        System.out.println("\n================================================="
                + "=========================================================\n");

        if (doubleList.size() % 2 == 0) {
            for (int i = 0; i < doubleList.size(); i += 2) {
                System.out.println(doubleList.get(i) + "\t" + doubleList.get(i + 1) + "\t");
            }
        } else if (doubleList.size() % 3 == 0) {
            for (int i = 0; i < doubleList.size(); i += 3) {
                System.out.println(doubleList.get(i) + "\t" + doubleList.get(i + 1) + "\t"
                        + doubleList.get(i + 2));
            }
        }
        System.out.println("\nDouble List size " + doubleList.size());
        recurscionDouble(doubleList);
    }

    // Find even doubles
    public static ArrayList findEvenDoubleNumbers(ArrayList<Double> doubleArray) {
        ArrayList evenDoubleNumbers = new ArrayList<>();

        for (int i = 0; i < doubleArray.size(); ++i) {
            if (Math.IEEEremainder(doubleArray.get(i), 2.0) > 0.0005) {
                evenDoubleNumbers.add(doubleArray.get(i));
            }
        }
        for (int i = 0; i < evenDoubleNumbers.size(); i++) {
        }

        return evenDoubleNumbers;
    }

    // Find odd doubles
    public static ArrayList findOddDoubleNumbers(ArrayList<Double> doubleArray) {
        ArrayList oddDoubleNumbers = new ArrayList<>();

        for (int i = 0; i < doubleArray.size(); ++i) {
            if (!(Math.IEEEremainder(doubleArray.get(i), 2.0) > 0.0005)) {
                oddDoubleNumbers.add(doubleArray.get(i));
            }
        }
        for (int i = 0; i < oddDoubleNumbers.size(); i++) {
        }

        return oddDoubleNumbers;
    }

    // Find doubles lower than double in the middle of the Array
    public static ArrayList findDoublesLowerThan(ArrayList<Double> doubleArray) {
        ArrayList newArray = new ArrayList();
        for (int i = 0; i < doubleArray.size(); ++i) {
            if (doubleArray.get(i) < doubleArray.get(doubleArray.size() / 2)) {
                newArray.add(doubleArray.get(i));
            }
        }
        return newArray;
    }

    // Recursive search for doubles
    public static void recurscionDouble(ArrayList<Double> doubleArray) {
        System.out.println("======================================== Double "
                + "Recursion =========================================");

        System.out.println("Array lenght: " + doubleArray.size());

        ArrayList evenNumbers = findDoublesLowerThan(findEvenDoubleNumbers(doubleArray));

        for (int i = 0; i < evenNumbers.size(); i++) {
            System.out.println("Even Doubles: " + evenNumbers.get(i));
        }

        ArrayList oddNumbers = findDoublesLowerThan(findOddDoubleNumbers(doubleArray));
        for (int i = 0; i < oddNumbers.size(); i++) {
            System.out.println("Odd Doubles: " + oddNumbers.get(i));
        }

        ArrayList newArray = new ArrayList();

        newArray.addAll(evenNumbers);
        newArray.addAll(oddNumbers);

        System.out.println("Array lenght: " + newArray.size());

        for (int i = 0; i < newArray.size(); ++i) {
            System.out.println("New recursive ArrayList for Doubles: " + newArray.get(i));
        }
        if (newArray.size() > 0) {
            recurscionDouble(newArray);
        }
    }

}
