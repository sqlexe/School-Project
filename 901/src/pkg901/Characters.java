
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

        g.drawImage(MrYee,Window.getX(440),Window.getY(50),
                Window.getX(220),Window.getY(260),instance);
       
        g.drawImage(AlexI,Window.getX(840),Window.getY(50),
                Window.getX(220),Window.getY(260),instance);
        
        g.drawImage(TampererI,Window.getX(1240),Window.getY(50),
                Window.getX(220),Window.getY(260),instance);
        
        g.drawImage(Back,Window.getX(1240),Window.getY(400),
                   Window.getX(220),Window.getY(260),instance);
        
        g.drawImage(StudentI,Window.getX(440),Window.getY(400),
                Window.getX(220),Window.getY(260),instance);

    }
    public Characters.Character Assign(){
        int role = (int)(Math.random()*4);
            if (role == 0){
               // tamperer
            }
            else if (role == 1){
                //Alex
            }
            else if (role == 2){
                return Character.Yee;
            }
            else if (role == 3){
                return Character.Student;
            }
            return null;
    }
    
    
}
