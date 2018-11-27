
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
     private int playerNum = 0;
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

//    public void Advance1()
//    {
//        currentPlayer = players[1];
//    }
//        public void Advance2()
//    {
//        currentPlayer = players[2];
//    }
//        public void Advance3()
//    {
//        currentPlayer = players[3];
//    }
//        public void Advance4()
//    {
//        currentPlayer = players[4];
//    }
//        public void Advance5()
//    {
//        currentPlayer = players[5];
//    }
//        public void Advance6()
//    {
//        currentPlayer = players[6];
//    }
//        public void Advance0()
//    {
//        currentPlayer = players[0];
//    }
//        
    public void advance()
    {
       playerNum++;
       if(Room901.gamescreen)
       {
       if(playerNum <=players.length)
       {
       currentPlayer = players[playerNum]; 
       System.out.println(""+currentPlayer);
       }
       else
       {
       playerNum =0;
       currentPlayer = players[playerNum];
       System.out.println(""+currentPlayer);
       }
       }
       
    }
}

