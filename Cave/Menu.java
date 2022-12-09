import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    private int opcion = 1;
    private Arrow arrow = new Arrow();
    private Continue cont = new Continue();
    private Back back = new Back();
    public Menu() {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 394, 1);
        prepararMundo();
    }
    
    private void prepararMundo() {
        addObject(cont, 500, 150);
        addObject(back, 500, 250);
        addObject(arrow, 375, 150);
    }
    
    public void act() {
        if(Greenfoot.isKeyDown("W") && opcion == 1) {opcion = 0;}
        if(Greenfoot.isKeyDown("S") && opcion == 0) {opcion = 1;}
        
        arrow.setLocation(375, 150 + (opcion * 100));
        
        if(Greenfoot.isKeyDown("SPACE") || Greenfoot.isKeyDown("ENTER")) {
            switch(opcion) {
                case 0:
                    setBackground(new GreenfootImage("Pantalla_Carga/Carga.png"));
                    Greenfoot.delay(10);
                    Greenfoot.setWorld(new MyWorld());
                    break;
                case 1:
                    Greenfoot.stop();
                    break;
            }
            
        }
    }
}

