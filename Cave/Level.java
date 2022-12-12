import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Level extends World
{
    private boolean doorsClosed = true;
    private boolean doorsOpened = true;
    protected Slime rimuru;
    private String[] animationClosed1;
    private String[] anumationOpened2;
    private int condition;
    private int countCondition = 0;
    
    public Level(Slime rimuru){    
        super(700, 394, 1);
    }
}
