
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
    
    public  static void Draw(Room901 instance,boolean nightime,boolean gamescreen,boolean homeScreen )
    {


//        if (nightime && !gamescreen && !homeScreen)
//        {
//        Draw.drawImage(MrYee, 440, 840, 0, 1, 1);
//        Draw.drawImage(AlexI, 840, 840, 0, 1, 1);
//        Draw.drawImage(TampererI, 1240, 250, 0, 1, 1);
//        Draw.drawImage(Back, 1240, 840, 0, 1.1, 1.1);
//        Draw.drawImage(StudentI, 440, 250, 0, 1, 1);
//        }

//        Draw.drawImage(MrYee, 440, 840, 0, .8, .8);
//        Draw.drawImage(AlexI, 840, 840, 0, .8, .8);
//        Draw.drawImage(TampererI, 1240, 250, 0, .8, .8);
//        Draw.drawImage(Back, 1240, 840, 0, .9, .9);
//        Draw.drawImage(StudentI, 440, 250, 0, .8, .8);

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
            players[pick].setRole(Character.Yee);
        
        //Tamperer
        pick = (int)(Math.random()*(players.length-1));
        if(players[pick].character!=null)
            players[pick].setRole(Character.Tamperer);
        
        for(int i=0; i<players.length;i++)
        {
            if(players[pick].character==null)
                players[pick].setRole(Character.Student);
        }
        
            
    }
    
    
 public  static void DrawYee(Room901 instance,boolean nightime,boolean gamescreen,boolean homeScreen ){
         Draw.drawImage(MrYee, 440, 840, 0, 1, 1);}
       public  static void DrawAlex(Room901 instance,boolean nightime,boolean gamescreen,boolean homeScreen ){
    Draw.drawImage(AlexI, 840, 840, 0, 1, 1);}
        public  static void DrawTampererI(Room901 instance,boolean nightime,boolean gamescreen,boolean homeScreen ){
       Draw.drawImage(TampererI, 1240, 250, 0, 1, 1);}
       public  static void DrawBack(Room901 instance,boolean nightime,boolean gamescreen,boolean homeScreen ){
        Draw.drawImage(Back, 1240, 840, 0, 1.1, 1.1);}
        public  static void DrawStudentI(Room901 instance,boolean nightime,boolean gamescreen,boolean homeScreen ){
       Draw.drawImage(StudentI, 440, 250, 0, 1, 1);}




}
