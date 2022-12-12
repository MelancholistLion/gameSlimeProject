import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Menu extends World
{
    private int opcion = 0;
    private Arrow arrow = new Arrow();
    private Continue cont = new Continue();
    private Back back = new Back();
    private StarRecord star = new StarRecord();
    
    public Menu() {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 394, 1);
        prepararMundo();
    }
    
    private void prepararMundo() {
        addObject(cont, 500, 150);
        addObject(back, 500, 250);
        addObject(arrow, 375, 150);
        addObject(star, 245, 142);
    }
    
    public void act() {
        if(Greenfoot.isKeyDown("W") && opcion == 1) {
            opcion = 0;
            arrow.setLocation(375, 150);
        }
        if(Greenfoot.isKeyDown("D") && opcion == 2) {
            opcion = 0;
            arrow.setLocation(375, 150);
        }
        if(Greenfoot.isKeyDown("S") && opcion == 0) {
            opcion = 1;
            arrow.setLocation(375, 250);
        }
        if(Greenfoot.isKeyDown("A") && opcion == 0) {
            opcion = 2;
            arrow.setLocation(179, 150);
        }
        
        if(Greenfoot.isKeyDown("ENTER")) {
            switch(opcion){
                case 0:
                    back.removeObject();
                    cont.removeObject();
                    star.removeObject();
                    arrow.removeObject();
                    setBackground(new GreenfootImage("Pantalla_Carga/Carga.png"));
                    Greenfoot.delay(50);
                    Greenfoot.setWorld(new MyWorld());
                    break;
                case 1:
                    Greenfoot.stop();
                    break;
                case 2:
                    Greenfoot.setWorld(new Record());
                    break;
            } 
        }
    }
}

