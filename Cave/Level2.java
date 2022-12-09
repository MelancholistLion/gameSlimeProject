import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends Level
{
    private boolean doorsClosed = true;
    private boolean doorsOpened = true;
    private Slime rimuru;
    private Health heart = new Health();
    private String[] animationClosed1 = {"Habitacion_2/Habitacion_2_cierra-frame-0.png","Habitacion_2/Habitacion_2_cierra-frame-1.png", "Habitacion_2/Habitacion_2_cierra-frame-2.png", "Habitacion_2/Habitacion_2_cierra-frame-3.png"};
    private String[] animationOpened2 = {"Habitacion_2/Habitacion_2_abre-frame-0.png", "Habitacion_2/Habitacion_2_abre-frame-1.png", "Habitacion_2/Habitacion_2_abre-frame-2.png", "Habitacion_2/Habitacion_2_abre-frame-3.png"};
    private int condition;
    private int countCondition = 0;
    Bat diego = new Bat(45, 409);
    Bat isaac = new Bat(262, 652);
    Rock rock = new Rock();
    Rock1 rock1 = new Rock1();
    Rock2 rock2 = new Rock2();
    Rock3 rock3 = new Rock3();
    
    public Level2(Slime rimuru)
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
        addObject(rock, 224, 201);
        addObject(rock1, 444, 161);
        addObject(rock2, 262, 264);
        addObject(rock3, 550, 265);
        
        addObject(diego, 47, 157);
        addObject(isaac, 264, 204);
        
    }
    public void enterLevel() {
        if(!doorsClosed) {
            if(rimuru.getX() > 297 && rimuru.getX() < 400 && rimuru.getY() < 122) {
                Greenfoot.setWorld(new Level3(rimuru));
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
