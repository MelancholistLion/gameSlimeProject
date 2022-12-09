import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level4 extends Level
{
    private boolean doorsClosed = true;
    private boolean doorsOpened = true;
    private Slime rimuru;
    private Health heart = new Health();
    private String[] animationClosed1 = {"Habitacion_2/Habitacion_2_cierra-frame-0.png","Habitacion_2/Habitacion_2_cierra-frame-1.png", "Habitacion_2/Habitacion_2_cierra-frame-2.png", "Habitacion_2/Habitacion_2_cierra-frame-3.png"};
    private String[] animationOpened2 = {"Habitacion_2/Habitacion_2_abre-frame-0.png", "Habitacion_2/Habitacion_2_abre-frame-1.png", "Habitacion_2/Habitacion_2_abre-frame-2.png", "Habitacion_2/Habitacion_2_abre-frame-3.png"};
    private int condition;
    private int countCondition = 0;
    Bat diego = new Bat(120, 674);
    Bat bat2 = new Bat(270, 420);
    Bat bat3 = new Bat(270, 420);
    
    Rock rock = new Rock();
    Rock rock1 = new Rock();
    Rock2 rock2 = new Rock2();
    Rock2 rock3 = new Rock2();
    Rock2 rock4 = new Rock2();
    Rock2 rock5 = new Rock2();
    Rock1 rock6 = new Rock1();
    Rock1 rock7 = new Rock1();
    Rock3 rock8 = new Rock3();
    Rock3 rock9 = new Rock3();
    Rock3 rock10 = new Rock3();
    Rock3 rock11 = new Rock3();
    Rock3 rock12 = new Rock3();
    Rock3 rock13 = new Rock3();
    
    
    public Level4(Slime rimuru)
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
        addObject(heart, 26, 22);//Corazon
        addObject(rock, 233, 140);
        addObject(rock1, 233, 175);
        addObject(rock2, 233, 210);
        addObject(rock3, 233, 245);
        addObject(rock4, 233, 280);
        addObject(rock5, 233, 315);
        addObject(rock6, 233, 350);
        
        addObject(rock7, 438, 140);
        addObject(rock8, 438, 175);
        addObject(rock9, 438, 210);
        addObject(rock10, 438, 245);
        addObject(rock11, 438, 280);
        addObject(rock12, 438, 315);
        addObject(rock13, 438, 350);
        
        addObject(diego, 100, 100);
        addObject(bat2, 250, 160);
        addObject(bat3, 400, 260);
        
    }
    public void enterLevel() {
        if(!doorsClosed) {
            if(rimuru.getX() > 297 && rimuru.getX() < 400 && rimuru.getY() < 122) {
                Greenfoot.setWorld(new Level5(rimuru));
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


