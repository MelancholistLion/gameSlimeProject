import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class DialogueFrame extends Actor
{
    private int limit;
    private int time = 0;
    public void act()
    {
    
        if(time < limit) {
            time++;
            Greenfoot.delay(10);
        } else if(time > limit-1) {
            Greenfoot.delay(10);
            getWorld().removeObject(this);
            Greenfoot.setSpeed(50);
        }
    }
    public void setLimit(int limit) {
        this.limit = limit;
    }
}
