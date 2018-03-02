// SpriteMover.java
// Author: Jose Fraga
// Created November 2 3:11PM

public class SpriteMover implements Runnable
{
    Model model;
    View view;
    
    // constructor
    public SpriteMover(Model model, View view)
    {
        this.model = model;
        this.view = view;
    }
    
    public void run() 
    {
        while (true) 
        {
            // model reference to update the scene
            model.updateScene(view.getWidth(), view.getHeight());
            
            // view reference to redraw (repaint) the scene
            view.repaint();
            
            try 
            {
                Thread.sleep(2);
            } 
            catch (InterruptedException e) {}
        }
    }
}