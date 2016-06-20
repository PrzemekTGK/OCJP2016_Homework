/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework.dataStructures;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author Przemek Stepien
 */
public class IntArrays {

    private static Random randomGen = new Random(System.nanoTime());

    public static void main(String[] args) {

        int[] numArray = new int[1000];

        // Populate int array
        for (int i = 0; i < numArray.length; ++i) {
            numArray[i] = i + 1;
        }

//        System.out.println("\n================================================="
//                + "=========================================================\n");       
//        // Print all the Collections
//        for (int i = 0; i < numArray.length; i += 10) {
//            System.out.println(numArray[i] + "\t" + numArray[i + 1] + "\t" 
//                    + numArray[i + 2] + "\t" + numArray[i + 3] + "\t" 
//                    + numArray[i + 4] + "\t" + numArray[i + 5] + "\t" 
//                    + numArray[i + 6] + "\t" + numArray[i + 7] + "\t"
//                    + numArray[i + 8] + "\t" + numArray[i + 9]);
//        }   

        recursionInt(numArray);

    }

    // Find even int numbers
    public static int[] findEvenNumbers(int[] numArray) {
        int[] evenNumbers = new int[numArray.length / 2];
        for (int i = 0, j = 0; i < numArray.length; ++i) {
            if ((numArray[i] & 1) == 0) {
                evenNumbers[j] = numArray[i];
                j++;
            }
        }
        return evenNumbers;
    }

    // Find odd int numbers
    public static int[] findOddNumbers(int[] numArray) {
        int[] oddNumbers = new int[numArray.length / 2];
        for (int i = 0, j = 0; i < numArray.length; ++i) {
            if ((numArray[i] & 1) == 1) {
                oddNumbers[j] = numArray[i];
                j++;
            }
        }
        return oddNumbers;
    }

    // Find numbers lower than number in the middle of the Array
    public static int[] findNumbersLowerThan(int[] numArray) {
        int[] newArray = new int[numArray.length / 2];
        for (int i = 0, j = 0; i < numArray.length; ++i) {
            if (numArray[i] < numArray[numArray.length / 2]) {
                newArray[j] = numArray[i];
                j++;
            }
        }
        return newArray;
    }

    // Recursive search for ints
    public static void recursionInt(int[] numArray) {
        System.out.println("============================================ "
                + "Recursion ============================================");

        System.out.println("Array lenght: " + numArray.length);

        int[] evenNumbers = findNumbersLowerThan(findEvenNumbers(numArray));
        for (int i = 0; i < evenNumbers.length; i++) {
            System.out.println("Even Numbers: " + evenNumbers[i]);
        }

        int[] oddNumbers = findNumbersLowerThan(findOddNumbers(numArray));
        for (int i = 0; i < oddNumbers.length; i++) {
            System.out.println("Odd Numbers: " + oddNumbers[i]);
        }

        int[] newArray = new int[evenNumbers.length + oddNumbers.length];

        for (int i = 0, j = 0; i < newArray.length; i += 2, ++j) {
            newArray[i] = oddNumbers[j];
            newArray[i + 1] = evenNumbers[j];
        }

        for (int i = 0; i < newArray.length; ++i) {
            System.out.println("New recursive array: " + newArray[i]);
        }
        if (newArray.length > 0) {
            recursionInt(newArray);
        }
    }
}
