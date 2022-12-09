import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3 extends Level
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
    SlimeEnemy isaac = new SlimeEnemy(120, 350);
    Rock rock = new Rock();
    Rock rock1 = new Rock();
    Rock2 rock2 = new Rock2();
    Rock2 rock3 = new Rock2();
    Rock2 rock4 = new Rock2();
    Rock2 rock5 = new Rock2();
    Rock1 rock6 = new Rock1();
    Rock1 rock7 = new Rock1();
    Rock1 rock8 = new Rock1();
    Rock3 rock9 = new Rock3();
    Rock3 rock10 = new Rock3();
    Rock3 rock11 = new Rock3();
    Rock3 rock12 = new Rock3();
    Rock3 rock13 = new Rock3();
    Rock1 rock14 = new Rock1();
    Rock1 rock15 = new Rock1();
    Rock1 rock16 = new Rock1();
    
    
    public Level3(Slime rimuru)
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
        addObject(rock, 404, 149);
        addObject(rock1, 402, 190);
        addObject(rock2, 354, 199);
        addObject(rock3, 306, 199);
        addObject(rock4, 259, 199);
        addObject(rock5, 205, 200);
        addObject(rock6, 167, 197);
        addObject(rock7, 164, 233);
        addObject(rock8, 167, 262);
        addObject(rock9, 198, 261);
        addObject(rock10, 250, 261);
        addObject(rock11, 297, 260);
        addObject(rock12, 339, 258);
        addObject(rock13, 385, 255);
        addObject(rock14, 404, 272);
        addObject(rock15, 404, 304);
        addObject(rock16, 410, 335);
        
        addObject(diego, 264, 204);
        
        addObject(isaac, 104, 313);
        
    }
    public void enterLevel() {
        if(!doorsClosed) {
            if(rimuru.getX() > 297 && rimuru.getX() < 400 && rimuru.getY() < 122) {
                Greenfoot.setWorld(new Level4(rimuru));
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
