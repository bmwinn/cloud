import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public double posX, posY;
    public double dirX, dirY;
    public int frame;
    
    public Enemy(int posX, int posY, double dirX, double dirY) {
        this.posX = (double)posX;
        this.posY = (double)posY;
        this.dirX = dirX;
        this.dirY = dirY;
        frame = 0;
    }
    
    public void act() { }   
}
