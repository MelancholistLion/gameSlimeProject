import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level6 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level6 extends Level
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
    Bat bat2 = new Bat(310, 674);
    SlimeEnemy isaac = new SlimeEnemy(120, 350);
    SlimeEnemy slime2 = new SlimeEnemy(120, 350);
    
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
    Rock1 rock14 = new Rock1();
    Rock1 rock15 = new Rock1();
    Rock1 rock16 = new Rock1();
    Rock rock17 = new Rock();
    Rock2 rock18 = new Rock2();
    Rock2 rock19 = new Rock2();
    Rock1 rock20 = new Rock1();
    Rock1 rock21 = new Rock1();
    Rock1 rock22 = new Rock1();
    Rock1 rock23 = new Rock1();
    Rock1 rock24 = new Rock1();
    
    
    public Level6(Slime rimuru)
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
        addObject(rock1, 97, 260);
        addObject(rock2, 131, 260);
        addObject(rock3, 165, 260);
        addObject(rock4, 199, 260);
        addObject(rock, 233, 260);
        addObject(rock5, 267, 260);
        addObject(rock6, 301, 260);
        addObject(rock7, 335, 260);
        addObject(rock8, 370, 260);
        addObject(rock9, 404, 260);
        addObject(rock10, 438, 260);
        addObject(rock11, 472, 260);
        addObject(rock12, 506, 260);
        addObject(rock13, 540, 260);
        addObject(rock14, 574, 260);
        addObject(rock15, 608, 260);
        
        addObject(rock16, 97, 220);
        addObject(rock17, 97, 180);
        addObject(rock18, 233, 140);
        
        addObject(rock19, 608, 220);
        addObject(rock20, 608, 180);
        addObject(rock21, 438, 140);
        
        addObject(diego, 264, 204);
        addObject(bat2, 580, 204);
        
        addObject(isaac, 108, 313);
        addObject(slime2, 580, 313);
        
    }
    public void enterLevel() {
        if(!doorsClosed) {
            if(rimuru.getX() > 297 && rimuru.getX() < 400 && rimuru.getY() < 122) {
                Greenfoot.setWorld(new Level7(rimuru));
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
