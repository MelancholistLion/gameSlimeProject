import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends Level
{
    private boolean doorsClosed = true;
    private boolean doorsOpened = true;
    private Slime rimuru;
    private Health heart = new Health();
    private int health;
    private Bat diego = new Bat(45, 652);
    private Bat isaac = new Bat(45, 652);
    private String[] animationClosed1 = {"Habitacion_2/Habitacion_2_cierra-frame-0.png","Habitacion_2/Habitacion_2_cierra-frame-1.png", "Habitacion_2/Habitacion_2_cierra-frame-2.png", "Habitacion_2/Habitacion_2_cierra-frame-3.png"};
    private String[] animationOpened2 = {"Habitacion_2/Habitacion_2_abre-frame-0.png", "Habitacion_2/Habitacion_2_abre-frame-1.png", "Habitacion_2/Habitacion_2_abre-frame-2.png", "Habitacion_2/Habitacion_2_abre-frame-3.png"};
    private int condition;
    private int countCondition = 0;
    
    public Level1(Slime rimuru)
    {    
        super(rimuru);
        this.rimuru = rimuru;
        addObject(this.rimuru, 335, 313);
    }
    public void act() {
        closedCave();
        prepararMundo();
        openedCave();
        UpdateHealth();
        enterLevel();
    }
    private void prepararMundo() {
        addObject(heart, 26, 22);
        addObject(isaac, 631, 164);
        addObject(diego, 42, 257);
    }
    public void enterLevel() {
        if(!doorsClosed) {
            if(rimuru.getX() > 297 && rimuru.getX() < 400 && rimuru.getY() < 122) {
                Greenfoot.setWorld(new Level2(rimuru));
            }
        }
    }
    public void openedCave() {
        if(doorsOpened) {
            for(int i = 0; i < 4; i++) {
                setBackground(new GreenfootImage(animationOpened2[i]));
                Greenfoot.delay(2);
            }
            doorsOpened = false;
        }
    }
    public void closedCave() {
        if(doorsClosed) {
            for(int i = 0; i < 4; i++) {
                setBackground(new GreenfootImage(animationClosed1[i]));
                Greenfoot.delay(10);
            }
            doorsClosed = false;
        }
    }
    public void UpdateHealth() {
        if(rimuru.getHealth() > 0) {
            heart.setHealth(rimuru.getHealth());
            heart.setHeartImage();
        } else if(rimuru.getHealth() == 0) {
            heart.setHealth(rimuru.getHealth());
            heart.setHeartImage();
            Greenfoot.setWorld(new GameOver());
        }
    }
    
}