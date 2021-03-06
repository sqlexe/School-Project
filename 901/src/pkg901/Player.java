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
    static int playerNum = 0;
    Characters.Character character;
    private boolean alive;
    private boolean immune;
    private boolean displayed;

    public static void Create(int numPlayers) {
        players = new Player[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            players[i] = new Player();
        }

        currentPlayer = players[0];
        Characters.Assign(players);
    }

    Player() {
        alive = true;
        immune = false;
    }

    public void setRole(Characters.Character role) {
        character = role;
    }

    static public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Characters.Character getRole() {
        return currentPlayer.character;
    }

    public static void tampererTurn(int s) {
        if (!players[s].immune) {
            players[s].alive = false;
        }
    }

    public static void alexTurn(int s) {
        players[s].immune = true;
        players[s].alive = true;
    }

    public static void yeeTurn(int s) {
        players[s].displayed = true;

    }

    public static void displayReset() {
        for (int i = 0; i < players.length; i++) {
            players[i].displayed = false;
        }
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
    public void advance() {

        boolean keepLooping = true;
        while (keepLooping) {
            playerNum++;
            if (Room901.gamescreen) {
                if (players.length == playerNum) {
                    playerNum = 0;
                    Room901.nightime = true;
                }
                if (players[playerNum].getAlive()) {
                    currentPlayer = players[playerNum];
                    keepLooping = false;
                } else {
                    currentPlayer = players[playerNum + 1];
                }
            }
        }
//       if(Room901.gamescreen)
//       {
////           System.out.println("This is a test");
//       if(playerNum <players.length)
//       {
//           
//       currentPlayer = players[playerNum]; 
////       System.out.println(""+currentPlayer);
//       }
//       else
//       {
//       playerNum =0;
//       currentPlayer = players[playerNum];
//       System.out.println(""+currentPlayer);
////      Room901.kickp1-=Room901.kickp1;
////          Room901.kickp2-= Room901.kickp2;
////          Room901.kickp3-=  Room901.kickp3;
////          Room901.kickp4-= Room901.kickp4;
////          Room901.kickp5-= Room901.kickp5;
////          Room901.kickp6-=  Room901.kickp6;
////          Room901.kickp7-=Room901.kickp7;
//       
//       
//       
//         
//       
// 
//       
//       }
//       }     

    }

    public void Donzo() {
        alive = false;
    }

    public boolean getAlive() {
        return alive;
    }

}
