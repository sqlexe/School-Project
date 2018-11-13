
package pkg901;
import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class Characters {
    private Image tamperer;
    private Image alex;
    private Image yee;
    private Image student;
    
    public static enum Character {
        Tamperer, Alex, Yee, Student
    }
    
    public void Draw()
    {
       
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
