import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lich here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lich extends mobs
{
    /**
     * Act - do whatever the Lich wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int move = 0;
    private int healthy = 500;
    public void act()
    {
        move();
        shot();
        lossHealth();
    }
    public void move() {
        if(move==0){
            if(canMoveLeft()) {
                move(-1);
            } else {
                move = 1;
            }
        } else if(move == 1){
            if(canMoveRight()) {
                move(1);
            } else {
                move = 0;
            }
        }
    }
    public void shot() {
        if(getX() > 322 && getX() < 450 && getY() == 186) { // int orientation, int x, int y
            EnemyBall ball = new EnemyBall(0); // izquierda
            EnemyBall ball1 = new EnemyBall(4); // izqAbajo
            EnemyBall ball2 = new EnemyBall(3); // Abajo
            EnemyBall ball3 = new EnemyBall(5); // derAbajo
            EnemyBall ball4 = new EnemyBall(1); // derecha
            getWorld().addObject(ball, getX(), getY());
            getWorld().addObject(ball1, getX(), getY());
            getWorld().addObject(ball2, getX(), getY());
            getWorld().addObject(ball3, getX(), getY());
            getWorld().addObject(ball4, getX(), getY());
        }
    }
    public boolean canMoveRight() {
        if(getX()+3 < 600) {
            return true;
        } else {
            return false;
        }
    }
    public boolean canMoveLeft() {
        if(getX()-3 > 75) {
            return true;
        } else {
            return false;
        }
    }
    public void lossHealth() {
        if(isTouching(Slime.class)) {
            healthy--;
        }
        if(isTouching(AllyBall.class)) {
            healthy--;
        }
    }
    public int getHealth() {
        return healthy;
    }
}
