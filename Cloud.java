import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;

/**
 * Write a description of class Cloud here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cloud extends Actor
{
    /**
     * Act - do whatever the Cloud wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private double posX, posY;
    private double frame;
    
    public Cloud(int posX, int posY) {
        this.posX = (double)posX;
        this.posY = (double)posY;
    }
  
    public void step() {
        double halfX = getImage().getWidth() / 2.0;
        double halfY = getImage().getHeight() / 2.0;
        double distX = getWorld().getBackground().getWidth();
        double distY = getWorld().getBackground().getHeight();
        
        if (Greenfoot.isKeyDown("right")) {
            if (posX + halfX < distX) { posX += 2; }
        }
        if (Greenfoot.isKeyDown("left")) {
            if (posX - halfX > 0) { posX -= 2; }
        }
        if (Greenfoot.isKeyDown("up")) {
            if (posY - halfY > 0 ) { posY -= 2; }
        }
        if (Greenfoot.isKeyDown("down")) {
            if (posY + halfY < distY) { posY += 2; }
        }
    }
    
    public void animate() {
        if (frame % 10 == 0) {
            posY += 1.5 * Math.sin(frame);
        }
    }
    
    public void act() 
    {
        frame++;
        
        animate();
        step();
        
        setLocation((int)posX, (int)posY);
    }    
}
