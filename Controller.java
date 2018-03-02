// Controller.java
// Author: Jose Fraga

import java.awt.Graphics;
import java.io.IOException;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import javax.swing.SwingUtilities;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.io.PrintStream;

class Controller implements MouseListener, KeyListener
{
    Model model;
    View view;

    Controller() throws IOException, Exception 
    {
        model = new Model();
        view = new View(this);
    }

    public void update(Graphics g) 
    {
        model.update(g);
    }
    
    // handle press of any key
    public void keyPressed(KeyEvent e)  {   }
    
    // handle release of any key
    public void keyReleased(KeyEvent e) {   }

    // handle press of an action key
    public void keyTyped(KeyEvent e) 
    {        
        if (e.getKeyChar() == 'n')
        {          
            // refer to static variables
            System.out.printf("robbers captured: %d\n robbers escaped: %d\n", 
                RobberCar.captured, RobberCar.escaped);
        }
        else if (e.getKeyChar() == 'r')
        {            
            model.initialize();
            
            // window to automatically refresh
            view.repaint();
        }
        else if (e.getKeyChar() == 's')
        {
            Thread t = new Thread(new SpriteMover(model, view));
            t.start();
        }
    }
    
    public void mousePressed(MouseEvent e)
    {
        if (SwingUtilities.isLeftMouseButton(e))             
        { 
            // left mouse button was clicked
            // get coordinates of the click to use for new sprite location
            int x = e.getX();
            int y = e.getY();
            
            model.newSprite(x, y);
            
            // so any changes caused are drawn on the window
            view.repaint();
        } 
        else if (SwingUtilities.isRightMouseButton(e))  
        {            
            // right mouse button was clicked 
            // using width and height of the window as parameters
            model.updateScene(view.getWidth(), view.getHeight());

            // so any changes caused are drawn on the window
            view.repaint();
        }
    }

    public void mouseReleased(MouseEvent e) {    }
    public void mouseEntered(MouseEvent e) {    }
    public void mouseExited(MouseEvent e) {    }
    public void mouseClicked(MouseEvent e) {    }

    
    
    public static void main(String[] args) throws Exception 
    {
        //  Use the following line to determine which directory your program
        //  is being executed from, since that is where the image files will
        //  need to be.
        //System.out.println("cwd=" + System.getProperty("user.dir"));
        new Controller();
    }
} // end class Controller