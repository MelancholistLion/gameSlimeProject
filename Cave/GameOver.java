import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GameOver extends World
{
    private int opcion = 1;
    private Arrow arrow = new Arrow();
    public GameOver() {
        super(700, 394, 1);
        prepararMundo();
    }
    private void prepararMundo() {
        addObject(arrow, 124, 216);
    }
    public void act() {
        if(Greenfoot.isKeyDown("A") && opcion == 1) {opcion = 0;}
        if(Greenfoot.isKeyDown("D") && opcion == 0) {opcion = 1;}
        
        arrow.setLocation(124 + (opcion * 328), 216);
        
        if(Greenfoot.isKeyDown("SPACE") || Greenfoot.isKeyDown("ENTER")) {
            switch(opcion) {
                case 0:
                    Greenfoot.setWorld(new Level1(new Slime()));
                    break;
                case 1:
                    Greenfoot.setWorld(new Menu());
                    break;
            }
            
        }
    }
}
