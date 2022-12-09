import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level extends World
{
    private boolean doorsClosed = true;
    private boolean doorsOpened = true;
    private Slime rimuru;
    private String[] animationClosed1;
    private String[] anumationOpened2;
    private int condition;
    private int countCondition = 0;
    public Level(Slime rimuru)
    {    
        super(700, 394, 1);
        this.rimuru = rimuru;
        addObject(this.rimuru, 335, 313);
    }
    public void act() {}
    private void prepararMundo() {}
    public void enterLevel() {}
    public void openedCave() {}
    public void closedCave() {}
}
