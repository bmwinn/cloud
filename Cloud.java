import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;
import java.util.List;

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
    private int health;
    
    public Cloud(int posX, int posY) {
        this.posX = (double)posX;
        this.posY = (double)posY;
        health = 100;
    }
  
    private void step() {
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
            if (isAtEdge() && posY - halfY - 5 < 0) {
                if (back.getBG() < 3) {
                    back.addBG();
                    getWorld().setBackground("background" + back.getBG() + ".png");
                    posY = distY - halfY;
                }
            }
            else {
                posY -= 2;
            }
        }
        
        if (Greenfoot.isKeyDown("down")) {
            if (isAtEdge() && posY + halfY + 5 > distY) {
                if (back.getBG() > 1) {
                    back.subBG();
                    getWorld().setBackground("background" + back.getBG() + ".png");
                    posY = halfY;
                }
            }
            else {
                posY += 2;
            }
        }
    }
    
    private void animate() {
        if (frame % 10 == 0) {
            posY += 1.5 * Math.sin(frame);
        }
    }
    
    private void collision() {
        List intersecting = getIntersectingObjects(Enemy.class);
        if (!intersecting.isEmpty()) {
            health--;
            System.out.println("ouch!");
        }
    }
    
    private void checkHealth() {
        if (health < 0) {
            System.out.println("game over");
            setImage("cloud.png");
            Greenfoot.stop();
        }
        else if (health < 30) {
            System.out.println("careful!");
            setImage("cloud.png");
        }
        else if (health < 60) {
            System.out.println("doing ok.");
            setImage("cloud.png");
        }
        else if (health < 90) {
            System.out.println("good work!");
            setImage("cloud.png");
        }
        else {
            setImage("cloud.png");
        }
    }
            
    
    public void act() 
    {
        frame++;
        
        step();
        collision();
        checkHealth();
        animate();
        
        setLocation((int)posX, (int)posY);
    }    
}
