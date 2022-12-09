import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Slime here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Slime extends Actor
{
    private GifImage SlimeDown= new GifImage("Version_3/downAnimation.gif");
    private GifImage SlimeFront = new GifImage("Version_3/frontAnimation.gif");
    private GifImage SlimeDamage = new GifImage("Version_3/damage.gif");
    
    private boolean damaged = false;
    private int orientation = 1;
    private int[] upLeft = {45,120};
    private int[] downLeft = {45, 370};
    private int[] upRight = {674, 120};
    private int[] downRight = {674, 370};
    private int[] doorLeft = {297, 120};
    private int[] doorRight = {400, 120};
    private int healthy = 2;
    
    
    public void act() {
        moveLeft();
        moveRight();
        moveUp();
        moveDown();
        staticMove();
        lossHealth();
        shotSlime();
    }
    
    // Movement
    public void moveLeft() {
        if(Greenfoot.isKeyDown("A") && canMoveLeft()) {
            move(-3);
            setImage("Version_3/Slime_left.gif");
            orientation = 0;
        }
    }
    public void moveRight() {
        if(Greenfoot.isKeyDown("D") && canMoveRight()) {
            move(3);
            setImage("Version_3/Slime_right.gif");
            orientation = 1;
        }
    }
    public void moveUp() {
        if(Greenfoot.isKeyDown("W") && canMoveUp()) {
            setLocation(getX(), getY()-3);
            setImage(SlimeFront.getCurrentImage());
            orientation = 2;
        }
    }
    public void moveDown() {
        if(Greenfoot.isKeyDown("S") && canMoveDown()) {
            setLocation(getX(), getY()+3);
            setImage(SlimeDown.getCurrentImage());
            orientation = 3;
        }
    }
    public void staticMove() {
        if(!Greenfoot.isKeyDown("S") && !Greenfoot.isKeyDown("W") && !Greenfoot.isKeyDown("A") && !Greenfoot.isKeyDown("D") && orientation == 2) {
            setImage(SlimeFront.getCurrentImage());
        } else if(!Greenfoot.isKeyDown("S") && !Greenfoot.isKeyDown("W") && !Greenfoot.isKeyDown("A") && !Greenfoot.isKeyDown("D") && orientation == 3) {
            setImage(SlimeDown.getCurrentImage());
        }
    }
    
    //Posibility of Movement Scenary
    public boolean canMoveUp() {
        if(getY()-3 > 120 && !isTouching(Obstacles.class)) {
            return true;
        } else if(isTouching(Obstacles.class)){
            setLocation(getX(), getY()+4);
            return false;
        } else {
            return false;
        }
    }
    public boolean canMoveDown() {
        if(getY()+3 < 350 && !isTouching(Obstacles.class)) {
            return true;
        } else if(isTouching(Obstacles.class)){
            setLocation(getX(), getY()-4);
            return false;
        } else {
            return false;
        }
    }
    public boolean canMoveRight() {
        if(getX()+3 < 652 && !isTouching(Obstacles.class)) {
            return true;
        } else if(isTouching(Obstacles.class)){
            move(-4);
            return false;
        } else {
            return false;
        }
    }
    public boolean canMoveLeft() {
        if(getX()-3 > 45 && !isTouching(Obstacles.class)) {
            return true;
        } else if(isTouching(Obstacles.class)){
            move(4);
            return false;
        } else {
            return false;
        }
    }
    public int getHealth() {
        return healthy;
    }
    public void lossHealth() {
        if(isTouching(mobs.class)) {
            setLocation(335, 313);
            
            orientation = 2;
            healthy--;
        }
        if(isTouching(EnemyBall.class)) {
            setLocation(335, 313);
            orientation = 2;
            healthy--;
        }
    }
    public void shotSlime() {
        if(Greenfoot.isKeyDown("SPACE")) {
            AllyBall shotBallSlime = new AllyBall(orientation);
            getWorld().addObject(shotBallSlime, getX(), getY());
        }
    }
    public void damaged() {
        if(damaged) {
            setImage(SlimeDamage.getCurrentImage());
            Greenfoot.delay(3);
            setImage(SlimeDamage.getCurrentImage());
            Greenfoot.delay(3);
            setImage(SlimeDamage.getCurrentImage());
        }
        damaged = false;
    }
}
