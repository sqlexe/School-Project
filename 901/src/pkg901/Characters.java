
package pkg901;
import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class Characters {
    private Image MrYee = Toolkit.getDefaultToolkit().getImage("./Mr.Yee.jpg");
    private Image Alex = Toolkit.getDefaultToolkit().getImage("./Alex.jpg");
    private Image Student = Toolkit.getDefaultToolkit().getImage("./Student.jpg");
    private Image Tamperer = Toolkit.getDefaultToolkit().getImage("./Tamperer.jpg");;
    private Image Back = Toolkit.getDefaultToolkit().getImage("./Blank.jpg");
    private Graphics2D g;
    
    
    public static enum Character {
        Tamperer, Alex, Yee, Student
    }
    
    public void Draw(Room901 instance)
    {
       g.drawImage(MrYee,Window.getX(440),Window.getY(50),
                Window.getX(220),Window.getY(260),instance);
       
        g.drawImage(Alex,Window.getX(840),Window.getY(50),
                Window.getX(220),Window.getY(260),instance);
        
        g.drawImage(Tamperer,Window.getX(1240),Window.getY(50),
                Window.getX(220),Window.getY(260),instance);
        
        g.drawImage(Back,Window.getX(1240),Window.getY(400),
                   Window.getX(220),Window.getY(260),instance);
        
        g.drawImage(Student,Window.getX(440),Window.getY(400),
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
