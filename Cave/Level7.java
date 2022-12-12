import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;


public class Level7 extends Level
{
    private boolean doorsClosed = true;
    private Slime rimuru;
    private Health heart = new Health();
    private String[] animationClosed1 = {"hab_boss/hab_0.png", "hab_boss/hab_1.png", "hab_boss/hab_2.png", "hab_boss/hab_3.png"};
    private boolean victory = false;
    private Lich TheLich = new Lich();
    
    protected Level7(Slime rimuru)
    {    
        super(rimuru);
        this.rimuru = rimuru;
        addObject(this.rimuru, 335, 313);
    }
    public void act() {
        closedCave();
        prepararMundo();
        UpdateHealth();
        UpdateHealthLich();
    }
    private void prepararMundo() {
        addObject(heart, 26, 22);
        addObject(TheLich, 250, 186);
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
            fileWriter.write(rimuru.getName() + " Nivel: 7\n");
            fileWriter.close();
        } catch(IOException ioexception) {
            throw ioexception;
        }
    }
    public void saveScoreWon() throws IOException {
        File file = new File("records.txt");
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(rimuru.getName() + " Victorioso\n");
            fileWriter.close();
        } catch(IOException ioexception) {
            throw ioexception;
        }
    }
    public void UpdateHealthLich() {
        if(TheLich.getHealth() <= 0) {
            try
            {
                saveScoreWon();
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
            }
            Greenfoot.setWorld(new Win());
        }
    }
}
