
package pkg901;
import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class Player {
    static Player players[];
    static Player currentPlayer;
    Characters.Character character;
    private boolean alive;

    
    
    public static void Create(int numPlayers)
    {
        players=new Player[numPlayers];
        for(int i=0; i<numPlayers;i++)
        {
            players[i]=new Player();
        }
 
        currentPlayer=players[0];
        Characters.Assign(players);
    }
    
    Player()
    {
        alive=true;
    }
    
    public void setRole(Characters.Character role)
    {
        character=role;
    }
    static public Player getCurrentPlayer()
    {
        return currentPlayer;
    }
    public Characters.Character getRole()
    {
        return currentPlayer.character;
    }


}

