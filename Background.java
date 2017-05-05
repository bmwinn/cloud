import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends World
{

    /**
     * Constructor for objects of class Background.
     * 
     */
    
    private int bg;
    
    public int getBG() { return bg; }
    public void addBG() { bg++; }
    public void subBG() { bg--; }
    
    public Background()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(480, 640, 1);
        bg = 1;
        
        int startX = 60;
        int startY = getHeight() - 40;
        addObject(new Cloud(startX, startY), startX, startY);
    }
}
