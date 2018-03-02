// CopCar.java
// Author: Jose Fraga
// Created October 14, 2017 11:42AM

import java.awt.Graphics;
import java.util.Random;


// class RobberCar subclass of class Car superclass
public class CopCar extends Car
{
    // private instance variable declaration
    private int xRatio;
    private int yRatio;
    
    // constructor
    public CopCar()
    {
        // explicit call to superclass constructor
        super("whatever CopCar", 5000, objectEngine, "cop-car.jpg");
                
        // to create random integers between -5 and 5
        Random randomX = new Random();
        int randomIntX = randomX.nextInt(5 + 5) - 5;
        
        Random randomY = new Random();
        int randomIntY = randomY.nextInt(5 + 5) - 5;       
        
        this.xRatio = randomIntX;
        this.yRatio = randomIntY;
        
        super.fillUp();
    }

    public void updateState(int width, int height)
    {        
        // collision right wall
        if (getX() > width)
        {
            // change direction
            xRatio = -xRatio;
            yRatio = -yRatio;       
        }       
        // collision left wall
        else if (getX() < 0)
        {            
            // change direction
            xRatio = -xRatio;
            yRatio = -yRatio;
        }
        // collision top wall
        else if (getY() < 0)
        {
            // change direction
            xRatio = -xRatio;
            yRatio = -yRatio;
        }
        // collision bottom wall
        else if (getY() > height)
        {
            // change direction
            xRatio = -xRatio;
            yRatio = -yRatio;           
        }
        
        // move the sprite
        //super.drive(20, xRatio, yRatio);        
        super.drive(2, xRatio, yRatio);        
    }
    
    public void updateImage(Graphics g)
    {
        super.updateImage(g);
    }
} // end class CopCar