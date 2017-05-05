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
    private int bg;
    private boolean first1, first2, first3;
    
    private ArrayList<Bird> birds;
    private ArrayList<Balloon> balloons;
    private ArrayList<SeaLevel> seaLevel;
    private ArrayList<CloudFriend> friends;
    
    public int getBG() { return bg; }
    public void addBG() { bg++; if (bg == 2) first2 = true; else if (bg == 3) first3 = true; }
    public void subBG() { bg--; if (bg == 1) first1 = true; else if (bg == 2) first2 = true; }
    
    private void addBalloons() {
        for (int i = 0; i < 2; i++) {
            Balloon b = new Balloon(i + 10, i + 20, i + 11, i + 21);
            addObject(b, i + 10, i + 20);
            balloons.add(b);
        }
    }
    
    private void addFriends() {
        for (int i = 0; i < 5; i++) {
            CloudFriend c = new CloudFriend();
            int y = 20;
            if (i % 2 == 1) { y -= 10; }
            addObject(c, i * 100, y);
        }
    }
    
    private void addBirds() {
        for (int i = 0; i < 25; i++) {
            int y = (i + 2) * 20;
            int x = (i + 2) * 10;
            if (i % 2 == 1) { y += 50; }
            if (i % 3 == 1) { x += 30; }
            Bird b = new Bird(x, y, 1, 2, i);
            addObject(b, x, y);
            birds.add(b);
        }
    }
    
    private void addSeaLevel() {
        Hills h = new Hills();
        addObject(h, getWidth() / 2, 530);
        House houseA = new House();
        House houseB = new House();
        addObject(houseA, getWidth() - 50, 600);
        addObject(houseB, getWidth() - 190, 590);
        seaLevel.add(houseA);
        seaLevel.add(houseB);
        seaLevel.add(h);
    }
    
    private void setupBackground1() {
        first1 = false;
        removeObjects(balloons);
        addSeaLevel();
        addBirds();
    }
    
    private void setupBackground2() {
        first2 = false;
        removeObjects(seaLevel);
        removeObjects(birds);
        removeObjects(friends);
        addBalloons();
    }
    
    private void setupBackground3() {
        first3 = false;
        removeObjects(balloons);
        addFriends();
    }
    
    public Background()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(480, 640, 1);
        bg = 1;
        first1 = first2 = first3 = false;
        birds = new ArrayList<Bird>();
        balloons = new ArrayList<Balloon>();
        seaLevel = new ArrayList<SeaLevel>();
        friends = new ArrayList<CloudFriend>();
        
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
        else if (bg == 3 && first3) {
            setupBackground3();
        }
    }
    
}
