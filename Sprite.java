// Sprite.java
// Author unknown
// Created unkown

import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.Rectangle;

// The Sprite class is used to create objects which have images associated with 
// them that can be drawn to the window and moved around.
class Sprite
{
    private String jpgName;
    private int locationX;
    private int locationY;
    private Image image;

    public Sprite(String jpgName)
    {
        setImage(jpgName);
        locationX = 0;
        locationY = 0;
    }

    public int getX() 
    {	
        return locationX; 
    }
    public int getY() 
    {	
        return locationY; 
    }
    public void setX(int x) 
    { 
        locationX = x; 
    }
    public void setY(int y) 
    { 
        locationY = y; 
    }

    public void setImage(String imagePath) 
    {
        try 
        {
            image = ImageIO.read(new File(imagePath));
        } 
        catch (IOException ioe) 
        {
            System.out.println("Unable to load image file.");
        }
    }
    
    public Image getImage() 
    { 
        return image; 
    }	

    public void updateImage(Graphics g)
    {
        g.drawImage(image, locationX, locationY, 60, 60, null);
    }
    
    public void updateState(int width, int height)
    {
        // empty body, does nothing        
    }
    
    // returns true if the image of the Sprite overlaps (at all) with the image of s
    public boolean overlaps(Sprite s)           
    {       
        s.locationX = s.getX();
        s.locationY = s.getY();
        locationX = getX();
        locationY = getY();
         
            // x <= s.x <= x + 60
        if  ((locationX <= s.locationX) && (s.locationX <= locationX + 60) && 
            // y <= s.y <= y + 60               
            (locationY <= s.locationY) && (s.locationY <= locationY + 60) ||
                
            // x <= s.x + 60 <= x + 60                
            (locationX <= s.locationX) && (s.locationX <= locationX + 60) &&
            // y <= s.y <= y + 60
            (locationY <= s.locationY) && (s.locationY <= locationY + 60) ||
                
            // x <= s.x <= x + 60   
            (locationX <= s.locationX) && (s.locationX <= locationX + 60) &&
            // y <= s.y + 60 <= y + 60
            (locationY <= s.locationY + 60) && (s.locationY <= locationY + 60) ||
            
            // x <= s.x + 60 <= x + 60
            (locationX <= s.locationX + 60) && (s.locationX + 60 <= locationX + 60) &&
            // y <= s.y + 60 < y + 60
            (locationY <= s.locationY + 60) && (s.locationY + 60 <= locationY + 60)) 
        {
            return true;
        }
        
        return false;
    }
} // end class Sprite