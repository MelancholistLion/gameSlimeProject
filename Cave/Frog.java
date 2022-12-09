import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Frog extends Actor
{
    private GifImage myImage = new GifImage("Rana/Rana.gif");
    
    public Frog() {
    }
    public void act()
    {
        if(Greenfoot.mouseClicked(this)) {
            new GreenfootSound("risa.mp3").play();
            DialogueFrame ff = new DialogueFrame();
            FrogDialogue fd = new FrogDialogue();
            
            getWorld().addObject(ff, 330, 320);
            getWorld().addObject(fd, 330, 315);
            Greenfoot.setSpeed(40);
            int frame = 0;
            ff.setLimit(6);
            getWorld().removeObject(this);
        }
        staticMove();
    }
    public void staticMove() {
        setImage(myImage.getCurrentImage());
    }
}
