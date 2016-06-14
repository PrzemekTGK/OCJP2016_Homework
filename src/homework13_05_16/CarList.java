/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework13_05_16;

import java.util.ArrayList;

/**
 *
 * @author PRZEMEK
 */
public class CarList {

    private ArrayList<Car> carList = new ArrayList<>();

    /**
     * @return the carList
     */
    public ArrayList<Car> getCarList() {
        return carList;
    }

    /**
     * @param carList the carList to set
     */
    public void setCarList(ArrayList<Car> carList) {
        this.carList = carList;
    }

    public void addCar(Car car) {
        carList.add(car);
    }

    public void displayCarList() {
        for (int i = 0; i < carList.size(); ++i) {
            System.out.println((i + 1) + ". " + carList.get(i));
        }
    }

    public void searchCarsByMake(String make) {
        for (int i = 0; i < getCarList().size(); ++i) {
            if (getCarList().get(i).getMake().equalsIgnoreCase(make)) {
                System.out.println(getCarList().get(i));
            }
        }
    }

    public void searchCarsByModel(String model) {
        for (int i = 0; i < getCarList().size(); ++i) {
            if (getCarList().get(i).getModel().equalsIgnoreCase(model)) {
                System.out.println(getCarList().get(i));
            }
        }
    }

    public void searchCarsByColor(String color) {
        for (int i = 0; i < getCarList().size(); ++i) {
            if (getCarList().get(i).getColour().equalsIgnoreCase(color)) {
                System.out.println(getCarList().get(i));
            }
        }
    }

    public void searchCarsByBodyType(String bodyType) {
        for (int i = 0; i < getCarList().size(); ++i) {
            if (getCarList().get(i).getBodyType().equalsIgnoreCase(bodyType)) {
                System.out.println(getCarList().get(i));
            }
        }
    }

    public void searchCarsByEngineType(String engineType) {
        for (int i = 0; i < getCarList().size(); ++i) {
            if (getCarList().get(i).getEngineType().equalsIgnoreCase(engineType)) {
                System.out.println(getCarList().get(i));
            }
        }
    }

    public void searchCarsByEngineSize(float engineSize) {
        for (int i = 0; i < getCarList().size(); ++i) {
            if (getCarList().get(i).getEngineSize() == engineSize) {
                System.out.println(getCarList().get(i));
            }
        }
    }

    public void searchCarsByNumSeats(int numSeats) {
        for (int i = 0; i < getCarList().size(); ++i) {
            if (getCarList().get(i).getSeats() == numSeats) {
                System.out.println(getCarList().get(i));
            }
        }
    }

    public void searchCarsBySunroof(boolean hasSunroof) {
        for (int i = 0; i < getCarList().size(); ++i) {
            if (getCarList().get(i).isSunroof() == hasSunroof) {
                System.out.println(getCarList().get(i));
            }
        }
    }
    

    public void searchCarsByMoonroof(boolean hasMoonroof) {
        for (int i = 0; i < getCarList().size(); ++i) {
            if (getCarList().get(i).isMoonroof() == hasMoonroof) {
                System.out.println(getCarList().get(i));
            }
        }
    }
}
