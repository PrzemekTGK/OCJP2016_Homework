/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework.simpleExercises;

/**
 *
 * @author PRZEMEK
 */
public class Fruit {

    private String name;
    private double weight;
    private boolean inSeason;

    public Fruit() {
        name = "a fruit";
        weight = 1.0;
        inSeason = false;
    }

    public Fruit(String name) {
        this.name = name;
        this.weight = 1.0;
        this.inSeason = false;

    }

    public Fruit(String name, double weight, boolean inSeason) {

        this.name = name;
        this.weight = weight;
        this.inSeason = inSeason;
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
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * @return the inSeason
     */
    public boolean isInSeason() {
        return inSeason;
    }

    /**
     * @param inSeason the inSeason to set
     */
    public void setInSeason(boolean inSeason) {
        this.inSeason = inSeason;
    }

    @Override
    public String toString() {
        return "Fruit{" + "name=" + name + ", weight=" + weight + ", inSeason=" + inSeason + '}';
    }
    
    
}
