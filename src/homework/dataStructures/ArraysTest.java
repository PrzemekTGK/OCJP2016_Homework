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
public class ArraysTest {
    
    private static DecimalFormat df2 = new DecimalFormat(".##");
    private static Random randomGen = new Random(System.nanoTime());
    
    public static void main(String[] args){
        int[] smallArray = new int[50];
        int[] numArray = new int[1000];
        double[] doubleArray = new double[15000];
        ArrayList doubleList = new ArrayList();        
        HashMap bigMap = new HashMap(20000);
        
        for (int i = 0; i < smallArray.length; i++) {
            smallArray[i] = i+1;
            
        }
        
        for (int i = 0; i < numArray.length; ++i) {
            numArray[i] = i+1;
        }
        
        for (int i = 0 ; i < 15000; ++i) {
            int j= i;
            if (j >= 1000) {
                j /=100;
            }            
            doubleArray[i] = randomGen.nextDouble() + j;
        }
        
        Arrays.sort(doubleArray);
        
        for (int i = 0; i < doubleArray.length; i++) {
            doubleList.add(doubleArray[i]);
        }
        
        for (int i = 0; i < doubleList.size(); i++) {
            for (int j = 0; j < doubleList.size(); j++) {
                if (doubleList.get(i).equals(doubleList.get(j))) {
                    doubleList.remove(j);
                }
            }
        }  
        
        doubleList.sort(new DoubleComparator());

        for(int i = 0; i < 20000; ++i){
            bigMap.put(i, "" + (i+2) + "ab");
        }

        
        for (int i = 0; i < numArray.length; i += 10) {
            System.out.println(numArray[i] + "\t" + numArray[i + 1] + "\t" 
                    + numArray[i + 2] + "\t" + numArray[i + 3] + "\t" 
                    + numArray[i + 4] + "\t" + numArray[i + 5] + "\t" 
                    + numArray[i + 6] + "\t" + numArray[i + 7] + "\t"
                    + numArray[i + 8] + "\t" + numArray[i + 9]);
        }  

        
        System.out.println("\n=====================================================================================================================\n");
        
        for (int i = 0; i < doubleArray.length; i += 15) {
            System.out.println(df2.format(doubleArray[i]) + "\t" + df2.format(doubleArray[i + 1]) + "\t" 
                    + df2.format(doubleArray[i + 2]) + "\t" + df2.format(doubleArray[i + 3]) + "\t" 
                    + df2.format(doubleArray[i + 4]) + "\t" + df2.format(doubleArray[i + 5]) + "\t" 
                    + df2.format(doubleArray[i + 6]) + "\t" + df2.format(doubleArray[i + 7]) + "\t"
                    + df2.format(doubleArray[i + 8]) + "\t" + df2.format(doubleArray[i + 9]) + "\t" 
                    + df2.format(doubleArray[i + 10]) + "\t" + df2.format(doubleArray[i + 11]) + "\t" 
                    + df2.format(doubleArray[i + 12]) + "\t" + df2.format(doubleArray[i + 13]) + "\t" 
                    + df2.format(doubleArray[i + 14]));
        }
        System.out.println("Double Array size " + doubleArray.length);
        
        System.out.println("\n=====================================================================================================================\n");
        
        for (int i = 0; i < doubleList.size(); i += 15) {
            System.out.println(df2.format(doubleList.get(i)) + "\t" + df2.format(doubleList.get(i + 1)) + "\t" 
                    + df2.format(doubleList.get(i + 2)) + "\t" + df2.format(doubleList.get(i + 3)) + "\t" 
                    + df2.format(doubleList.get(i + 4)) + "\t" + df2.format(doubleList.get(i + 5)) + "\t" 
                    + df2.format(doubleList.get(i + 6)) + "\t" + df2.format(doubleList.get(i + 7)) + "\t"
                    + df2.format(doubleList.get(i + 8)) + "\t" + df2.format(doubleList.get(i + 9)) + "\t" 
                    + df2.format(doubleList.get(i + 10)) + "\t" + df2.format(doubleList.get(i + 11)) + "\t" 
                    + df2.format(doubleList.get(i + 12)) + "\t" + df2.format(doubleList.get(i + 13)) + "\t" 
                    + df2.format(doubleList.get(i + 14)));
        }
        System.out.println("Double List size " + doubleList.size());
        
        System.out.println("\n=====================================================================================================================\n");
        
        for (int i = 0; i < bigMap.size(); i += 10) {
            System.out.println(bigMap.get(i) + "\t" + bigMap.get(i+1) + "\t" 
                    + bigMap.get(i+2) + "\t" + bigMap.get(i+3) + "\t" 
                    + bigMap.get(i+4) + "\t" + bigMap.get(i+5) + "\t"
                    + bigMap.get(i+6) + "\t" + bigMap.get(i+7) + "\t" 
                    + bigMap.get(i+8) + "\t" + bigMap.get(i+9) + "\t");
        }
        
                recursionInt(numArray);
        
    }
    
    public static int[] findEvenNumbers(int[] numArray) {
        int[] evenNumbers = new int[numArray.length/2];
        for (int i = 0, j = 0; i < numArray.length; ++i) {
            if ((numArray[i] & 1) == 0) {
                evenNumbers[j] = numArray[i];
                j++;
            }
        }
        return evenNumbers;
    }

    public static int[] findOddNumbers(int[] numArray) {
        int[] oddNumbers = new int[numArray.length/2];
        for (int i = 0, j = 0; i < numArray.length; ++i) {
            if ((numArray[i] & 1) == 1) {
                oddNumbers[j] = numArray[i];
                j++;
            }
        }
        return oddNumbers;
    }
    
    public static int[] findNumbersLowerThan(int [] numArray){
        int[] newArray = new int[numArray.length/2];
        for (int i = 0, j = 0; i < numArray.length; ++i) {
           if (numArray[i] < numArray[numArray.length/2]) {
               newArray[j] = numArray[i];
               j++;
           }
        }
        
        for (int i = 0; i < newArray.length; i++) {            
               System.out.println("New array: " + newArray[i]);
        }
        return newArray;
    }
    
    public static void recursionInt(int[] numArray){
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
        
        for (int i = 0, j = 0; i < newArray.length; i+=2, ++j) {
            newArray[i] = oddNumbers[j];
            newArray[i+1] = evenNumbers[j];
        }
        
        for (int i=0; i<newArray.length; ++i) {
            System.out.println("New recursive array: " + newArray[i]);
        }
        if (newArray.length > 0) {
            recursionInt(newArray);
        }
    }
}