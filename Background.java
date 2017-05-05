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
    private ArrayList<SeaLevel> seaLevel;
    
    public int getBG() { return bg; }
    public void addBG() { bg++; if (bg == 2) first2 = true;}
    public void subBG() { bg--; if (bg == 1) first1 = true; }
    
    private void setupBackground1() {
        first1 = false;
        removeObjects(balloons);
        
        Hills h = new Hills();
        addObject(h, getWidth() / 2, 530);
        House houseA = new House();
        House houseB = new House();
        addObject(houseA, getWidth() - 50, 600);
        addObject(houseB, getWidth() - 190, 590);
        seaLevel.add(houseA);
        seaLevel.add(houseB);
        seaLevel.add(h);
        
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
    
    private void setupBackground2() {
        first2 = false;
        removeObjects(seaLevel);
        removeObjects(birds);
        
        for (int i = 0; i < 2; i++) {
            Balloon b = new Balloon(i + 10, i + 20, i + 11, i + 21);
            balloons.add(b);
            addObject(b, i + 10, i + 20);
        }
    }
    
    public Background()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(480, 640, 1);
        bg = 1;
        first1 = first2 = false;
        birds = new ArrayList<Bird>();
        balloons = new ArrayList<Balloon>();
        seaLevel = new ArrayList<SeaLevel>();
        
        addObject(new Cloud(60, getHeight() - 100), 60, getHeight() - 100);
        
        setupBackground1();
    }
    
    public void act() {
        if (bg == 1 && first1) {
            setupBackground1();
        }
        else if (bg == 2 && first2) {
            setupBackground2();
        }
    }
    
}
