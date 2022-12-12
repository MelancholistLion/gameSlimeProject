import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Level5 extends Level
{

    private boolean doorsClosed = true;
    private boolean doorsOpened = true;
    private Slime rimuru;
    private Health heart = new Health();
    private String[] animationClosed1 = {"Habitacion_2/Habitacion_2_cierra-frame-0.png","Habitacion_2/Habitacion_2_cierra-frame-1.png", "Habitacion_2/Habitacion_2_cierra-frame-2.png", "Habitacion_2/Habitacion_2_cierra-frame-3.png"};
    private String[] animationOpened2 = {"Habitacion_2/Habitacion_2_abre-frame-0.png", "Habitacion_2/Habitacion_2_abre-frame-1.png", "Habitacion_2/Habitacion_2_abre-frame-2.png", "Habitacion_2/Habitacion_2_abre-frame-3.png"};
    private int condition;
    private int countCondition = 0;
    
    Bat diego = new Bat(290, 420);
    Bat bat2 = new Bat(290, 420);
    Bat bat3 = new Bat(290, 420);
    SlimeEnemy isaac = new SlimeEnemy(120, 350);
    SlimeEnemy slime2 = new SlimeEnemy(120, 350);
    SlimeEnemy slime3 = new SlimeEnemy(120, 350);
    SlimeEnemy slime4 = new SlimeEnemy(120, 350);
    
    
    protected Level5(Slime rimuru)
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
        addObject(isaac, 100, 120);
        addObject(slime2, 250, 120);
        addObject(slime3, 400, 120);
        addObject(slime4, 550, 120);
        
        addObject(diego, 100, 100);
        addObject(bat2, 250, 160);
        addObject(bat3, 400, 260);
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
            try
            {
                saveScore();
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
            }
            Greenfoot.setWorld(new GameOver(rimuru));
        }
    }
    public void saveScore() throws IOException {
        File file = new File("records.txt");
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(rimuru.getName() + " Nivel: 5\n");
            fileWriter.close();
        } catch(IOException ioexception) {
            throw ioexception;
        }
        
    }
}
