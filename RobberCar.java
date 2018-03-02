// RobberCar.java
// Author: Jose Fraga
// Created October 14, 2017 11:42AM

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;


// class RobberCar subclass of class Car superclass
public class RobberCar extends Car
{
    // private instance variable declaration
    private int xRatio;
    private int yRatio;
    
    // constructor
    public RobberCar()
    { 
        // explicit call to superclass constructor
        super("whatever RobberCar", 5000, objectEngine, "red-car.jpg");
        
        // to create random integers between -5 and 5
        Random randomX = new Random();
        int randomIntX = randomX.nextInt(5 + 5) - 5; 
        
        Random randomY = new Random();
        int randomIntY = randomY.nextInt(5 + 5) - 5;
        
        this.xRatio = randomIntX;
        this.yRatio = randomIntY;
        
        super.fillUp();
    }

    // flag variable
    boolean flag = false;

    public void updateState(int width, int height)
    {
        // detect if the image has moved completely out of the window
        if ((getX() > width) || (getX() < 0) || (getY() > height) || (getY() < 0))
        {    
            flag2 = true;          
        }
        
        if (flag)
        {
            super.drive(0, 0, 0);
        }
        else
        {
            //super.drive(40, xRatio, yRatio);

            super.drive(4, xRatio, yRatio);            
        }
    }

    // cause the images to be drawn but not drive the cars
    public void updateImage(Graphics g)
    {
        super.updateImage(g);
    }
    
    public static int captured = 0;
    public void captured()
    {        
        // change RobberCar to jail.jpg
        setImage("jail.jpg");
              
        // captured counter
        captured = captured + 1;
        
        flag = true;
    }
    
    public static int escaped = 0;
    boolean flag2 = false;
    public void escaped()
    {        
        escaped = escaped + 1;        
    }
    
    // will return true iff RobberCar has been captured   
    public boolean isCaptured()
    { 
        if (flag)
        {
            return true;
        }
        
        return false;
    }
    
    // returns true iff the instance has escaped
    public boolean hasEscaped()
    {
        if (flag2)
        {
            return true;
        }
        
        return false;
    }
} // end class RobberCar