// Model.java
// Author: Jose Fraga
// created Ocotber 5 4:08PM

import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

class Model
{    
    private Sprite sprite;
    private ArrayList<Sprite> list = new ArrayList<>();
    // counter utilized to alternate between red-car and cop-car
    public static int counter = 0;
        
    // constructor
    Model() throws IOException 
    {    
        sprite = new Bank();
        list.add(sprite);
    }
    
    // updates each sprite in ArrayList
    public void update(Graphics g)
    {
        synchronized(list)
        {
            Iterator<Sprite> iterator = list.iterator();
            while (iterator.hasNext())
            {
                sprite = iterator.next();
                sprite.updateImage(g);
            }
        }
    }
    
    // creates a new Sprite and puts it at location (x,y) when called, 
    // also adding it to the ArrayList
    public void newSprite(int x, int y)
    {               
        // even
        if ((counter % 2) == 0)
        {   
            sprite = new RobberCar();
            sprite.setX(300);
            sprite.setY(300);            
            list.add(sprite);
            counter = counter + 1;
        }
        // odd
        else
        {
            sprite = new CopCar();
            sprite.setX(x);
            sprite.setY(y);
            list.add(sprite);
            counter = counter + 1;
        }        
    }

    public void updateScene(int width, int height)
    {
        // variable to ignore the first object in the arraylist i.e. Bank
        int count = 0;
        
        synchronized(list)
        {
            // iterate over all sprites and call updateState        
            Iterator<Sprite> iterator = list.iterator();
            while (iterator.hasNext())
            {                
                Sprite sprite2 = iterator.next();
                
                sprite2.updateState(width, height);            

                // to ignore the first and last object
                if (iterator.hasNext() && (count > 0))
                {  
                    if ((counter % 2) == 1)
                    {
                        // broken
                        // casting
                        RobberCar rob = (RobberCar) sprite;
                        //RobberCar rob = (RobberCar) sprite2;
                        
                        // true if indeed there is an overlap
                        if (sprite.overlaps(sprite2))
                        {                           
                            rob.captured();
                        }

                        if (rob.hasEscaped())
                        {
                            rob.escaped();

                            // broken
                            //iterator.remove();

                            //System.out.println("I'm free!");
                        }
                    }
                }
               
               count = 1;
            }
        }
    }
    
    public void initialize()    
    {
        synchronized(list)
        {
            Iterator<Sprite> iterator = list.iterator();
            while(iterator.hasNext())
            {
                sprite = iterator.next();
                iterator.remove();
            }
       
            sprite = new Bank();
            list.add(sprite);

            // reset static variables
            RobberCar.captured = 0;
            RobberCar.escaped  = 0;
            Model.counter = 0;        
        }
    }
} // end class Model