import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Color;

/**
 * Write a description of class FrogDialogue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FrogDialogue extends Actor
{
    DialogueFrame df = new DialogueFrame();
    private int frame = 0;
    private String[] Dialogue = {"Hola baboso aventurero", "Para moverte usa las teclas WASD", "Para pegar, usa SPACE", "Vuelvete fuerte y...", "sal de la cueva", "Para seguir explorando este mundo"};
    private Color trans = new Color(0, 0, 0, 0);
    public FrogDialogue() {
        //getWorld().addObject(df, 350, 350);
        setImage(new GreenfootImage(Dialogue[frame], 23, Color.WHITE, trans));
    }
    public void act()
    {
        if(frame < 6) {
            setImage(new GreenfootImage(Dialogue[frame], 23, Color.WHITE, trans));
            frame++;
            Greenfoot.delay(10);
        } else if(frame > 5) { 
            Greenfoot.delay(10);
            getWorld().removeObject(this);
            Greenfoot.setSpeed(50);
        }
    }
    public void setFrame(int frame) {
        this.frame = frame;
    }
    public int getFrame() {
        return frame;
    }
}