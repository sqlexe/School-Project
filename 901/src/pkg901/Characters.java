
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
        boolean keepLooping = true;
        //alex
        while(keepLooping)
        {
            int pick = (int)(Math.random()*(players.length));
            if(players[pick].character==null)
            {
                players[pick].setRole(Character.Alex);
                keepLooping=false;
            }
        }
        
        //Yee
        keepLooping = true;
        while(keepLooping)
        {
            int pick = (int)(Math.random()*(players.length));
            if(players[pick].character==null)
            {
                players[pick].setRole(Character.Yee);
                keepLooping=false;
            }
        }
        
        //Tamperer
        keepLooping = true;
        while(keepLooping)
        {
            int pick = (int)(Math.random()*(players.length));
            if(players[pick].character==null)
            {
                players[pick].setRole(Character.Tamperer);
                keepLooping=false;
            }
        }
        
        for(int i=0; i<players.length;i++)
        {
            if(players[i].character==null)
                players[i].setRole(Character.Student);
        }
        
            
    }
    
    
 public  static void DrawYee(int xpos, int ypos, double rot, double xscale, double yscale){
         Draw.drawImage(MrYee, xpos, ypos, rot, xscale, yscale);}
       public  static void DrawAlex(int xpos, int ypos, double rot, double xscale, double yscale){
    Draw.drawImage(AlexI, xpos, ypos, rot, xscale, yscale);}
        public  static void DrawTampererI(int xpos, int ypos, double rot, double xscale, double yscale){
       Draw.drawImage(TampererI, xpos, ypos, rot, xscale, yscale);}
       public  static void DrawBack(int xpos, int ypos, double rot, double xscale, double yscale){
        Draw.drawImage(Back, xpos, ypos, rot, xscale, yscale);}
        public  static void DrawStudentI(int xpos, int ypos, double rot, double xscale, double yscale){
       Draw.drawImage(StudentI, xpos, ypos, rot, xscale, yscale);}




}
