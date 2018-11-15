
package pkg901;
import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class Characters {
    private Image MrYee;
    private Image Alex;
    private Image Student;
    private Image Tamperer;
    private Image Back;
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
    public void Assign(){
        int role = (int)(Math.random()*4);
            if (role == 0){
               // tamperer
            }
            else if (role == 1){
                //Alex
            }
            else if (role == 2){
                //Yee
            }
            else if (role == 3){
                //Student
            }
    }
    
    
}
