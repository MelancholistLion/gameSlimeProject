import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Health here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Health extends Actor
{
    private String[] heart = {"Corazon/heart2.png","Corazon/heart1.png", "Corazon/heart0.png"};
    private int health;
    public void act()
    {
        setHeartImage();
        setHealth(health);
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setHeartImage() {
        if(health >= 0 && health < 3) {
            setImage(heart[health]);
        }
    }
}
