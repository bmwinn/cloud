import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

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
    private boolean first1, first2;
    
    private ArrayList<Bird> birds;
    private ArrayList<Balloon> balloons;
    
    public int getBG() { return bg; }
    public void addBG() { bg++; if (bg == 2) first2 = true;}
    public void subBG() { bg--; if (bg == 1) first1 = true; }
    
    public Background()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(480, 640, 1);
        bg = 1;
        first1 = true;
        first2 = false;
        birds = new ArrayList<Bird>();
        balloons = new ArrayList<Balloon>();
        
        addObject(new Cloud(60, getHeight() - 40), 60, getHeight() - 40);
    }
    
    public void act() {
        if (bg == 1 && first1) {
            first1 = false;
            System.out.println("first");
            removeObjects(balloons);
            
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                Bird b = new Bird((i + 2)* 10, (i + 2) * 20, 1, 2, i);
                System.out.println("bird");
                birds.add(b);
                System.out.println("birds");
                addObject(b, (i + 2) * 10, (i + 2) * 20);
                System.out.println("add");
            }
        }
        else if (bg == 2 && first2) {
            first2 = false;
            removeObjects(birds);
            System.out.println("remove");
            
            for (int i = 0; i < 2; i++) {
                Balloon b = new Balloon(i + 10, i + 20, i + 11, i + 21);
                balloons.add(b);
                addObject(b, i + 10, i + 20);
            }
        }
    }
    
}
