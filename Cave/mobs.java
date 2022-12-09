import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class mobs extends Actor
{   
    private int orientation = 1;
    private int[] upLeft = {28,120};
    private int[] downLeft = {28, 370};
    private int[] upRight = {674, 120};
    private int[] downRight = {674, 370};
    private int[] doorLeft = {297, 120};
    private int[] doorRight = {400, 120};
    private int leftLimit;
    private int rightLimit;
    private int upLimit;
    private int downLimit;
    
    public void act()
    {
        
    }
    //Posibility of Movement Scenary
    public boolean canMoveUp() {
        if(getY()-3 > upLimit) {
            return true;
        } else {
            return false;
        }
    }
    public boolean canMoveDown() {
        if(getY()+3 < downLimit) {
            return true;
        } else {
            return false;
        }
    }
    public boolean canMoveRight() {
        if(getX()+3 < rightLimit) {
            return true;
        } else {
            return false;
        }
    }
    public boolean canMoveLeft() {
        if(getX()-3 > leftLimit) {
            return true;
        } else {
            return false;
        }
    }
}
