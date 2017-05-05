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
        
        // if user wants to travel right
        if (Greenfoot.isKeyDown("right")) {
            // don't let character image bleed past world edge
            if (posX + halfX < distX) { posX += 2; }
        }
        if (Greenfoot.isKeyDown("left")) {
            if (posX - halfX > 0) { posX -= 2; }
        }
        
        Background back = getWorldOfType(Background.class);
        if (Greenfoot.isKeyDown("up")) {
            if (isAtEdge()) {
                if (back.getBG() < 2) {
                    back.addBG();
                    getWorld().setBackground("background" + back.getBG() + ".png");
                    posY = distY - halfY;
                }
            }
            else { posY -= 2; }
        }
        
        if (Greenfoot.isKeyDown("down")) {
            if (isAtEdge()) {
                if (back.getBG() > 1) {
                    back.subBG();
                    getWorld().setBackground("background" + back.getBG() + ".png");
                    posY = halfY;
                }
            }
            else { posY += 2; }
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
        
        step();
        animate();
        
        setLocation((int)posX, (int)posY);
    }    
}
