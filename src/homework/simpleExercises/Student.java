/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework.simpleExercises;

import java.util.logging.Logger;

/**
 *
 * @author Przemek Stepien
 */
public class Student {
    
    private String name;
    private String Id;
    private int credits;
    
    public Student(String name){
        this.name = name;
        this.Id = "blyfmt002";
        this.credits = 10;
    }

    public Student(String name, String Id) {
        this.name = name;
        this.Id = Id;
        this.credits = 0;
    }
    
    

    

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the Id
     */
    public String getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     * @return the credits
     */
    public int getCredits() {
        return credits;
    }

    /**
     * @param credits the credits to set
     */
    public void setCredits(int credits) {
        this.credits = credits;
    }
    
    
}
