/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework.dataStructures;

/**
 *
 * @author Przemek Stepien
 */
public class Bug {
    private String name;
    private String origin;
    private int numLegs;

    public Bug() {
    }

    public Bug(String name, String origin, int numLegs) {
        this.name = name;
        this.origin = origin;
        this.numLegs = numLegs;
    }

    public int getNumLegs() {
        return numLegs;
    }

    public void setNumLegs(int numLegs) {
        this.numLegs = numLegs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return  " Name = " + name 
                + "\n Origin = " + origin 
                + "\n Number of Legs = " + numLegs + "\n";
    }   
}
