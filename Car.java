// Car.java
// Author: Jose Fraga
// Created September 10, 2017 7:38PM

import java.awt.Graphics;


// Car class represents a car object which contains an engine and a gas tank, 
// and has methods that allow it to keep track 
// class Car subclass of class Sprite superclass
public class Car extends Sprite
{
    // private instance vaiable declaration
    private String description;
    private GasTank objectGasTank;
    static Engine objectEngine;
    
    // constructor
    public Car(String description, int maxCapacity, Engine objectEngine, 
        String jpgName)
    {   
        // explicit call to Sprite superclass constructor
        super(jpgName);
        
        this.objectGasTank = new GasTank(maxCapacity);
        
        int stringValue = description.length();
        
        // description is length 0
        if (stringValue == 0)
            this.description = "Generic car";
        else
            this.description = description;
        
        // if a null reference is passed in for the Engine parameter 
        if (objectEngine == null)
            this.objectEngine = new Engine("", 0, 0);
        else
            this.objectEngine = objectEngine;
        
        // initialize objectEngine
        if (jpgName == "cop-car.jpg")
        {
            this.objectEngine = new Engine("V8", 30, 100);
        }
        
        if (jpgName == "red-car.jpg")
        {
            this.objectEngine = new Engine("twin-turbo 2JZ", 20, 200);
        }
    }

    // member functions    
    public String getDescription()
    {                           
        return String.format("%s (engine: %s), fuel: %.2f/%d, location: (%d,%d)", 
            description, objectEngine.getDescription(), objectGasTank.getLevel(), 
            objectGasTank.getCapacity(), super.getX(), super.getY());        
    }
    
    public double getFuelLevel()
    {
        return objectGasTank.getLevel();
    }
    
    public int getMPG()
    {
       return objectEngine.getMPG();
    }
    
    public void fillUp()
    {        
        // filling gas tank to maximum capacity
        double fill = objectGasTank.getCapacity();
        objectGasTank.setLevel(fill);
    }
    
    public int getMaxSpeed()
    {
        return objectEngine.getMaxSpeed();
    }

    // takes distance and direction (xRatio, yRatio) as input, this method computes
    // the ending coordinates
    public double drive(int distance, double xRatio, double yRatio)
    {        
        // trip calculations
        double milesAvailable = ((double)objectEngine.getMPG()) * (objectGasTank.getLevel());
        double fuelRequired = (double)distance / (double)objectEngine.getMPG();
        
        // Pythagorean Theorem a^2 + b^2 = c^2
        double C = Math.sqrt( (xRatio * xRatio) + (yRatio * yRatio));
        
        // variable declaration
        double adjacentDistance;
        double oppositeDistance;
        int xCoordinate = super.getX();
        int yCoordinate = super.getY();
        
        if (milesAvailable > distance)
        {            
            // distance traveled. update location
            adjacentDistance = xRatio * (distance / C);
            oppositeDistance = yRatio * (distance / C);
            super.setX(xCoordinate + (int)adjacentDistance);
            super.setY(yCoordinate + (int)oppositeDistance);

            // update fuel after trip
            double fuelUsed = objectGasTank.getLevel() - fuelRequired;
            objectGasTank.setLevel(fuelUsed);
        }
        // Not enough fuel. Travel until empty.
        else
        {
            // distance traveled with limited fuel. update stranded location
            adjacentDistance = xRatio * (milesAvailable / C);
            oppositeDistance = yRatio * (milesAvailable / C);
            super.setX(xCoordinate + (int)adjacentDistance);
            super.setY(yCoordinate + (int)oppositeDistance);
            
            // update fuel after trip
            fuelRequired = distance / objectEngine.getMPG();
            double fuelUsed = objectGasTank.getLevel() - fuelRequired;
            objectGasTank.setLevel(fuelUsed);
            
            System.out.printf("Ran out of gas after driving %.2f.\n", milesAvailable);
            
            return milesAvailable;
        }
        
        // return the number of miles driven
        return distance;
    }
    
    public void updateImage(Graphics g)
    {
        super.updateImage(g);
    }
} // end class Car