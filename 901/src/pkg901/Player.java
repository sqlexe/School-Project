
package pkg901;
import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class Player {
    static Player players[]=new Player[6];
    Characters.Character character;
    private boolean alive;
    
    public static void Create(int numPlayers)
    {
        for(int i=0; i<numPlayers;i++)
        {
            players[i]=new Player();
        }
    }
    
    Player()
    {
        alive=true;
    }
    

}

