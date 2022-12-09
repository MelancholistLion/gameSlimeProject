import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level7 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level7 extends Level
{
    private boolean doorsClosed = true;
    private Slime rimuru;
    private Health heart = new Health();
    private String[] animationClosed1 = {"hab_boss/hab_0.png", "hab_boss/hab_1.png", "hab_boss/hab_2.png", "hab_boss/hab_3.png"};
    private boolean victory = false;
    private Lich TheLich = new Lich();
    
    public Level7(Slime rimuru)
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
            heart.setHealth(rimuru.getHealth());
            heart.setHeartImage();
            Greenfoot.setWorld(new GameOver());
        }
    }
    public void UpdateHealthLich() {
        if(TheLich.getHealth() <= 0) {
            Greenfoot.setWorld(new Win());
        }
    }
}
