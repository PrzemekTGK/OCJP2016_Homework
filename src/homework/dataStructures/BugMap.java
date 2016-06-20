/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework.dataStructures;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Przemek Stepien
 */
public class BugMap {

    public static void main(String[] args) {
        Random randomGen = new Random(System.nanoTime());
        HashMap<Integer, Bug> bugMap = new HashMap(20000);
        ArrayList<String> bugNames = new ArrayList();
        ArrayList<String> bugOrigins = new ArrayList<>();
        String currentLine;

        try {
            BufferedReader nameReader = new BufferedReader(new FileReader("Bugs.txt"));
            BufferedReader originReader = new BufferedReader(new FileReader("Countries.txt"));
            while ((currentLine = nameReader.readLine()) != null) {
                bugNames.add(currentLine);
            }
            while ((currentLine = originReader.readLine()) != null) {
                bugOrigins.add(currentLine);
            }
        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

//        for (int i = 0; i < bugNames.size(); i++) {
//            System.out.println((i+1) + ". " + bugNames.get(i));
//        }
//        
//        for (int i = 0; i < bugOrigins.size(); i++) {
//            System.out.println((i+1) + ". " + bugOrigins.get(i));
//        }
        // Populate Hashmap
        for (int i = 0; i < 20000; ++i) {
            String bugName = bugNames.get(randomGen.nextInt(bugNames.size()));
            String bugOrigin = bugOrigins.get(randomGen.nextInt(bugOrigins.size()));
            int bugLegs = randomGen.nextInt(95) + 6;
            Bug bug = new Bug(bugName, bugOrigin, bugLegs);
            bugMap.put(i, bug);
        }

        System.out.println("\n================================================="
                + "=========================================================\n");

        for (int i = 0; i < bugMap.size(); ++i) {
            System.out.println((i + 1) + ". " + bugMap.get(i));
        }

        System.out.println("\n================================================="
                + "=========================================================\n");

        searchByNumOfLegs(searchByOrigin(bugOrigins, searchByName(bugNames, bugMap)));
        
    }

    public static HashMap<Integer, Bug> searchByName(ArrayList<String> bugNames, HashMap bigmap) {
        int index = 0;
        int userChooseName = -1;
        boolean invalidInput = true;
        Scanner scanInt = new Scanner(System.in);
        String bugName = "";
        Iterator iterate = bigmap.entrySet().iterator();
        Set<Map.Entry<Integer, Bug>> smallerSet = Collections.synchronizedSet(new HashSet());
        HashMap<Integer, Bug> smallerMap = new HashMap<>();

        for (int i = 0; i < bugNames.size(); i += 2) {
            System.out.println((i + 1) + ". " + bugNames.get(i) + "\t\t\t\t"
                    + (i + 2) + ". " + bugNames.get(i + 1) + "\t\t\t\t");
        }
        System.out.println("Please pick the bugs to search for: ");

        do {
            while (!scanInt.hasNextInt()) {
                scanInt.next();
            }
            userChooseName = scanInt.nextInt();
            userChooseName--;
            if (userChooseName < 0 || userChooseName >= bugNames.size()) {
                System.out.println("Invalid Input. Please Try again.");
            } else {
                bugName = bugNames.get(userChooseName);
                invalidInput = false;
            }
        } while (invalidInput);

        while (iterate.hasNext()) {
            Entry thisEntry = (Entry) iterate.next();
            if (thisEntry.getValue().toString().contains(bugName)) {
                if (thisEntry.getValue().toString().indexOf(bugName) == 8){
                    smallerSet.add(thisEntry);
                }
            }
        };

        for (Entry<Integer, Bug> entry : smallerSet) {
            Integer key = entry.getKey();
            Bug value = entry.getValue();
            System.out.println(key);
            System.out.println(value);
            smallerMap.put(key, value);
        }
        return smallerMap;
    }

    public static HashMap<Integer, Bug> searchByOrigin(ArrayList<String> bugOrigins, HashMap bigmap) {
        int userChooseOrigin = -1;
        boolean invalidInput = true;
        Scanner scanInt = new Scanner(System.in);
        String bugName = "";
        Iterator iterate = bigmap.entrySet().iterator();
        Set<Map.Entry<Integer, Bug>> smallerSet = Collections.synchronizedSet(new HashSet());
        HashMap<Integer, Bug> smallerMap = new HashMap<>();

        for (int i = 0; i < bugOrigins.size(); i += 2) {
            System.out.println((i + 1) + ". " + bugOrigins.get(i) + "\t\t\t\t"
                    + (i + 2) + ". " + bugOrigins.get(i + 1) + "\t\t\t\t");
        }
        System.out.println("Please pick the origin to search for: ");

        do {
            while (!scanInt.hasNextInt()) {
                scanInt.next();
            }
            userChooseOrigin = scanInt.nextInt();
            userChooseOrigin--;
            if (userChooseOrigin < 0 || userChooseOrigin >= bugOrigins.size()) {
                System.out.println("Invalid Input. Please Try again.");
            } else {
                bugName = bugOrigins.get(userChooseOrigin);
                invalidInput = false;
            }
        } while (invalidInput);

        while (iterate.hasNext()) {
            Entry thisEntry = (Entry) iterate.next();
            if (thisEntry.getValue().toString().contains(bugName)) {
                smallerSet.add(thisEntry);
            }
        };

        for (Entry<Integer, Bug> entry : smallerSet) {
            Integer key = entry.getKey();
            Bug value = entry.getValue();
            System.out.println(key);
            System.out.println(value);
            smallerMap.put(key, value);
        }
        return smallerMap;
    }
    
        
    public static HashMap<Integer, Bug> searchByNumOfLegs(HashMap bigmap) {
        int userChooseLegs = -1;
        boolean invalidInput = true;
        String numLegs = null;
        Scanner scanInt = new Scanner(System.in);
        Iterator iterate = bigmap.entrySet().iterator();
        Set<Map.Entry<Integer, Bug>> smallerSet = Collections.synchronizedSet(new HashSet());
        HashMap<Integer, Bug> smallerMap = new HashMap<>();

        System.out.println("Please type the amount of legs to search by: ");

        do {
            while (!scanInt.hasNextInt()) {
                scanInt.next();
            }
            userChooseLegs = scanInt.nextInt();
            if (userChooseLegs < 6 || userChooseLegs > 100) {
                System.out.println("Invalid Input. Please Try again.");
            } else {
                numLegs = "" + userChooseLegs;
                invalidInput = false;
            }
        } while (invalidInput);
        
        while (iterate.hasNext()) {
            Entry thisEntry = (Entry) iterate.next();
            if (thisEntry.getValue().toString().contains(numLegs)) {
                smallerSet.add(thisEntry);
            }
        };

        for (Entry<Integer, Bug> entry : smallerSet) {
            Integer key = entry.getKey();
            Bug value = entry.getValue();
            System.out.println(key);
            System.out.println(value);
            smallerMap.put(key, value);
        }
        return smallerMap;
    }
}
