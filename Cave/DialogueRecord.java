import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.File;
import java.util.Scanner;

public class DialogueRecord extends Actor
{
    private String Dialogue;
    private Color trans = new Color(0, 0, 0, 0);
    Scanner recordScan;
    public DialogueRecord() {
        Greenfoot.setSpeed(40);
        File file = new File("records.txt");
        try
        {
            recordScan = new Scanner(file);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void act()
    {
        try {
            showRecords();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void showRecords() throws Exception {
        
        if(Greenfoot.isKeyDown("ENTER") && recordScan.hasNextLine()) {
                setImage(new GreenfootImage(recordScan.nextLine(), 30, Color.WHITE, trans));
        }
        
    }
    
}
