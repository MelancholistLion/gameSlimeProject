import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AllyBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AllyBall extends Shot
{
    private int orientation;
    private int waiter = 0;
    public AllyBall(int orientation) {
        this.orientation = orientation;
    }
    public void act()
    {
        move();
    }
    public void waitingTo() {
        for(int i = 0; i < 1000; i++) {
            waiter++;
        }
        waiter = 0;
    }
    public void move() {
        if(!isTouching(mobs .class)) {
            switch(orientation) {
            case 0:
                if(getX() - 4 > 45) {
                    setLocation(getX() - 4, getY());
                } else {
                    getWorld().removeObject(this);
                }
                break;
            case 1:
                if(getX() + 4 < 652) {
                    setLocation(getX() + 4, getY());
                    waitingTo();
                } else {
                    getWorld().removeObject(this);
                }
                break;
            case 2:
                if(getY()- 4 > 120) {
                    setLocation(getX(), getY()-4);
                    waitingTo();
                } else if(getY()- 4 <= 120) {
                    getWorld().removeObject(this);
                }
                break;
            case 3:
                if(getY() + 4 < 350) {
                    setLocation(getX(), getY()+4);
                    waitingTo();
                } else if(getY() + 4 >= 350) {
                    getWorld().removeObject(this);
                }
                break;
            } 
        } else {
            getWorld().removeObject(this);
        }
    }
}
