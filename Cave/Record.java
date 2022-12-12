import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class Record extends World
{

    StarRecord star = new StarRecord();
    Back back = new Back();
    DialogueRecord dr = new DialogueRecord();
    Arrow arrow = new Arrow();

    public Record()
    {    
        super(600, 400, 1); 
        addObject(star, 55, 52);
        addObject(back, 525, 368);
        addObject(dr, 120, 150);
        addObject(arrow, 425, 373);
    }
    public void act() {
        if(Greenfoot.isKeyDown("SPACE")) {
            removeObject(arrow);
            removeObject(star);
            removeObject(back);
            removeObject(dr);
            Greenfoot.setSpeed(50);
            Greenfoot.setWorld(new Menu());
            
        }
    }
}
    


