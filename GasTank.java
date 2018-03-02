// GasTank.java
// Author: Jose Fraga
// Created September 10, 2017 7:38PM

// GasTank class represents an object to keep track of the current and maximum levels of fuel.
public class GasTank 
{
    // private instance variable declaration
    // keeps track of maximum capacity
    private final int maxCapacity;
    // keeps track of current level
    private double curCapacity;
            
    // constructor
    public GasTank(int maxCapacity)
    {        
        // set the instance variable for capacity
        if (maxCapacity >= 0)
        {
            this.maxCapacity = maxCapacity;
        }
        // negative value is passed in
        else
        {
            this.maxCapacity = 0;
            this.curCapacity = 0;
        }
    }

    // member function to retrieve the maxCapacity from the object
    public int getCapacity()
    {   
        // return value of maxCapacity to caller
        return maxCapacity;
    }

    // member function to retrieve the curCapacity from the object
    public double getLevel()
    {
        // return value of curCapacity to caller
        return curCapacity;
    }
 
    // member function to set curCapacity in the object
    public void setLevel(double curCapacity)
    {
        this.curCapacity = curCapacity;
        
        if (curCapacity >= maxCapacity)
            // store the levelIn value
            this.curCapacity = maxCapacity;
        
        if (curCapacity < 0)
            this.curCapacity = 0;
    }   
} // end class GasTank 