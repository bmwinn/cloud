import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;

/**
 * Write a description of class Bird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bird extends Enemy
{
    /**
     * Act - do whatever the Bird wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int count;
    public Bird(int posX, int posY, double dirX, double dirY, int c) {
        super(posX, posY, dirX, dirY);
        count = c;
    }
    
    private void step() {
        if (isAtEdge()) {
            if (posX - 1 <= 0 || posX + 1 >= getWorld().getWidth()) {
                dirX *= -1;
            }
            if (posY - 1 <= 0 || posY + 1 >= getWorld().getHeight()) {
                dirY *= -1;
            }
        }
        
        posX += dirX;
        posY += dirY;
    }
    
    private void animate() {
        if (frame % 10 == 0) {
            if (count % 2 == 0)
               posY += 3 * Math.sin(frame);
            else
               posY -= 3 * Math.sin(frame);
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
