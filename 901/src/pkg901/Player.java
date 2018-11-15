
package pkg901;
import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class Player {
    static Player players[]=new Player[7];
    static Player currentPlayer;
    Characters.Character character;
    private boolean alive;
    private boolean human;
    
    public static void Create(int numPlayers)
    {
        for(int i=0; i<numPlayers;i++)
        {
            players[i]=new Player(true);
        }
        for(int i=numPlayers; i<7; i++)
        {
            players[i]=new Player(false);
        }
        currentPlayer=players[1];
    }
    
    Player(boolean _alive)
    {
        alive=true;
    }
    

}

