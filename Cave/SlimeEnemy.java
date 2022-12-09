import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SlimeEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SlimeEnemy extends mobs
{
    private GifImage SlimeAnim = new GifImage("Enemigos/Slime/slime.gif");
    private int move = 0;
    private int upLimit;
    private int downLimit;
    
    public SlimeEnemy(int upLimit, int downLimit) {
        this.upLimit = upLimit;
        this.downLimit = downLimit;
    }
    public void act()
    {
        moveUp();
        moveDown();
    }
    public void moveUp() {
        if(move==0){
            if(canMoveUp()) {
                setLocation(getX(), getY()-2);
            } else {
                move = 1;
            }
        }
    }
    public void moveDown() {
        if(move==1){
            if(canMoveDown()) {
                setLocation(getX(), getY()+2);
            } else {
                move = 0;
            }
        }
    }
    public boolean canMoveUp() {
        if(getY()-2 > upLimit) {
            return true;
        } else {
            return false;
        }
    }
    public boolean canMoveDown() {
        if(getY()+2 < downLimit) {
            return true;
        } else {
            return false;
        }
    }
    public void staticMove() {
        if(move == 1) {
            setImage(SlimeAnim.getCurrentImage());
        } else if(move == 0) {
            setImage(SlimeAnim.getCurrentImage());
        }
    }
}
