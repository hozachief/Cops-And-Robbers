// Engine.java
// Author: Jose Fraga
// Created September 10, 2017 7:38PM

// Engine class represents an engine object and stores a few attributes of the engine.
public class Engine 
{
    // private instance variable declaration
    private String engine;
    private int MPG;
    private int maxSpeed;
    
    // constructor to initialize the three instance variables. 
    public Engine(String engine, int MPG, int maxSpeed)
    {    
        int stringValue = engine.length();
        
        // string argument has length 0
        if (stringValue == 0)
            this.engine = "Generic engine";
        else
            this.engine = engine;
            
        // integer argument is negative
        if (MPG < 0)
            this.MPG = 0;
        else
            this.MPG = MPG;
        // integer argument is negative
        if (maxSpeed < 0)
            this.maxSpeed = 0;
        else
            this.maxSpeed = maxSpeed;
    }

    // member functions
    public String getDescription()
    {
        return String.format("%s (MPG: %d, Max speed: %d)", engine, MPG, maxSpeed);
    }

    public int getMPG()
    {
        return MPG;
    }

    public int getMaxSpeed()
    {
        return maxSpeed;
    }
}
