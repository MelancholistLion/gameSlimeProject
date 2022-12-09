import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Bat extends mobs
{
    private GifImage BatBase_left= new GifImage("Murcielago_Base_left.gif");
    private GifImage BatBase_right= new GifImage("Murcielago_Base_right.gif");
    private int orientation = 1;
    private int move = 1;
    private int leftLimit;
    private int rightLimit;
    
    public Bat(int leftLimit, int rightLimit) {
        this.leftLimit = leftLimit;
        this.rightLimit = rightLimit;
    }
    public void act() {
        moveLeft();
        moveRight();
        staticMove();
    }
    
    // Movement
    public void moveLeft() {
        if(move==1){
            if(canMoveLeft()) {
                move(-3);
            } else {
                move = 0;
            }
        }
    }
    public void moveRight() {
        if(move==0){
            if(canMoveRight()) {
                move(+3);
            } else {
                move = 1;
            }
        }
    }
    public void staticMove() {
        if(move == 1) {
            setImage(BatBase_left.getCurrentImage());
        } else if(move == 0) {
            setImage(BatBase_right.getCurrentImage());
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
