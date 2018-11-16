
package pkg901;
import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class Characters {
    private static Image MrYee = Toolkit.getDefaultToolkit().getImage("./Mr.Yee.jpg");
    private static Image AlexI = Toolkit.getDefaultToolkit().getImage("./Alex.jpg");
    private static Image StudentI = Toolkit.getDefaultToolkit().getImage("./Student.jpg");
    private static Image TampererI = Toolkit.getDefaultToolkit().getImage("./Tamperer.jpg");;
    private static Image Back = Toolkit.getDefaultToolkit().getImage("./Blank.jpg");
    private static Graphics2D g;
    
    
    public static enum Character {
        Tamperer, Alex, Yee, Student
    }
    
    public  static void Draw(Room901 instance)
    {

        Draw.drawImage(MrYee, 440, 440, 0, 1, 1);
//        g.drawImage(MrYee,Window.getX(440),Window.getY(50),
//                Window.getX(220),Window.getY(260),instance);
//       
//        g.drawImage(AlexI,Window.getX(840),Window.getY(50),
//                Window.getX(220),Window.getY(260),instance);
//        
//        g.drawImage(TampererI,Window.getX(1240),Window.getY(50),
//                Window.getX(220),Window.getY(260),instance);
//        
//        g.drawImage(Back,Window.getX(1240),Window.getY(400),
//                   Window.getX(220),Window.getY(260),instance);
//        
//        g.drawImage(StudentI,Window.getX(440),Window.getY(400),
//                Window.getX(220),Window.getY(260),instance);

    }
    public static void Assign(Player players[]){
        
        //alex
        int pick = (int)(Math.random()*(players.length-1));
        if(players[pick].character!=null)
            players[pick].setRole(Character.Alex);
        
        //Yee
        pick = (int)(Math.random()*(players.length-1));
        if(players[pick].character!=null)
            players[pick].setRole(Character.Alex);
        
        //Tamperer
        pick = (int)(Math.random()*(players.length-1));
        if(players[pick].character!=null)
            players[pick].setRole(Character.Alex);
        
        for(int i=0; i<players.length;i++)
        {
            if(players[pick].character==null)
                players[pick].setRole(Character.Student);
        }
        
    
            
    }
    
    
}
