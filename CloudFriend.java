import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CloudFriends here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CloudFriend extends Actor
{
    /**
     * Act - do whatever the CloudFriends wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private double posY;
    private int frame;
    
    public CloudFriend() {
        super();
        frame = 0;
    }
    
    private void animate() {
        if (frame % 10 == 0) {
            posY += 1.5 * Math.sin(frame);
        }
    }
    
    public void act() 
    {
        if (frame == 0)
            posY = (double)getY();
            
        frame++;
        animate();
        setLocation(getX(), (int)posY);
    }    
}
