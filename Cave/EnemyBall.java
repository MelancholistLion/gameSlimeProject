import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyBall extends Shot
{
    private int orientation;
    private int x;
    private int y;
    public EnemyBall(int orientation) {
        this.orientation = orientation;
    }
    public void act()
    {
        move();
    }
    public void move() {
        if(!isTouching(Slime.class)) {
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
                } else {
                    getWorld().removeObject(this);
                }
                break;
            case 4:
                if(getX() - 4 > 45 && getY() + 4 < 350) {
                    setLocation(getX() - 4, getY()+4);

                } else {
                    getWorld().removeObject(this);
                }
                break;
            case 3:
                if(getY() + 4 < 350) {
                    setLocation(getX(), getY()+4);
                } else {
                    getWorld().removeObject(this);
                }
                break;
            case 5:
                if(getX() + 4 < 652 && getY() + 4 < 350) {
                    setLocation(getX() + 4, getY() + 4);
                } else {
                    getWorld().removeObject(this);
                }
                break;
            } 
        } else {
            getWorld().removeObject(this);
        }
    }
}
