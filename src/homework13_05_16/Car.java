/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework13_05_16;

/**
 *
 * @author PRZEMEK
 */
public class Car {
    
    private String make;
    private String model;
    private String colour;
    private String bodyType;
    private String engineType;
    private float engineSize;
    private int seats;
    private boolean sunroof;
    private boolean moonroof;

    public Car() {
    }

    
    
    public Car(String make, String model, String colour, String engineType
            , float engineSize, int seats, boolean sunroof, boolean moonroof
            , String bodyType) {
        this.make = make;
        this.model = model;
        this.colour = colour;
        this.engineType = engineType;
        this.engineSize = engineSize;
        this.seats = seats;
        this.sunroof = sunroof;
        this.moonroof = moonroof;
        this.bodyType = bodyType;
    }

    /**
     * @return the make
     */
    public String getMake() {
        return make;
    }

    /**
     * @param make the make to set
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the colour
     */
    public String getColour() {
        return colour;
    }

    /**
     * @param colour the colour to set
     */
    public void setColour(String colour) {
        this.colour = colour;
    }

    /**
     * @return the engine
     */
    public String getEngineType() {
        return engineType;
    }

    /**
     * @param engine the engine to set
     */
    public void setEngineType(String engine) {
        this.engineType = engine;
    }

    /**
     * @return the mpg
     */
    public float getEngineSize() {
        return engineSize;
    }

    /**
     * @param mpg the mpg to set
     */
    public void setEngineSize(float mpg) {
        this.engineSize = mpg;
    }

    /**
     * @return the seats
     */
    public int getSeats() {
        return seats;
    }

    /**
     * @param seats the seats to set
     */
    public void setSeats(int seats) {
        this.seats = seats;
    }

    /**
     * @return the sunroof
     */
    public boolean isSunroof() {
        return sunroof;
    }

    /**
     * @param sunroof the sunroof to set
     */
    public void setSunroof(boolean sunroof) {
        this.sunroof = sunroof;
    }

    /**
     * @return the moonroof
     */
    public boolean isMoonroof() {
        return moonroof;
    }

    /**
     * @param moonroof the moonroof to set
     */
    public void setMoonroof(boolean moonroof) {
        this.moonroof = moonroof;
    }

    /**
     * @return the body
     */
    public String getBodyType() {
        return bodyType;
    }

    /**
     * @param body the body to set
     */
    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    @Override
    public String toString() {
        return "Car \n" + "make = " + make 
                + ", \nmodel = " + model 
                + ", \ncolour = " + colour 
                + ", \nbodyType = " + bodyType 
                + ", \nengineType = " + engineType 
                + ", \nengineSize = " + engineSize 
                + ", \nseats = " + seats 
                + ", \nsunroof = " + sunroof 
                + ", \nmoonroof = " + moonroof;
    }
    
    
}
