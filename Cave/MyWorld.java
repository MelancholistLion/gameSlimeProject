import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class MyWorld extends World
{
    private boolean doorsClosed = true;
    private Frog leo = new Frog();
    private Slime rimuru = new Slime();
    private String[] animationOpen = {"cscene/esc0.png","cscene/esc1.png","cscene/esc2.png","cscene/esc3.png","cscene/esc4.png"};
    
    public MyWorld()
    {    
        super(700, 394, 1); 
        prepararMundo();

    }
    private void prepararMundo() {
        addObject(leo, 191, 289);
        addObject(rimuru, 350, 250);
        Greenfoot.setSpeed(50);
    }
    
    public void act() {
        openedCave();
        enterLevel();
    }
    
    public void openedCave() {
        if(Greenfoot.mouseClicked(leo) && doorsClosed) {
            for(int i = 0; i < 5; i++) {
                setBackground(new GreenfootImage(animationOpen[i]));
                Greenfoot.delay(2);
            }
            doorsClosed = false;
        }
    }
    public void enterLevel() {
        if(!doorsClosed) {
            if(rimuru.getX() > 297 && rimuru.getX() < 400 && rimuru.getY() < 122) {
                Greenfoot.setWorld(new Level1(rimuru));
            }
        }
    }
}
