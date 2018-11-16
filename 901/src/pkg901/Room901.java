
package pkg901;

import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import javax.sound.sampled.*;

    
    
    
    
    public class Room901 extends JFrame implements Runnable {

    boolean animateFirstTime = true;
    Image image;
    Graphics2D g;
    Image nightSky;
    Image FeltBG;
    Image Middle;
//    Image MrYee;
//    Image Alex;
//    Image Student;
//    Image Tamperer;
//    Image Back;
    boolean gamescreen=false;
    boolean nightime = false;
    boolean homescreen = true;
    sound bgSound = null;
    sound NightMusic = null;
    int numPlayers=1;
    int xLeft1=930;
   int xLeft2=1035;
    int yTop1=490;
   int yTop2=540;
   
   
            
   static Room901 frame;
    public static void main(String[] args) {
        frame = new Room901();
        frame.setSize(Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public Room901() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.BUTTON1 == e.getButton()) {
                    //left button
// location of the cursor.
                    int xpos = e.getX();
                    int ypos = e.getY();
                    
                    Board.click(e.getX() - Window.getX(0),
                        e.getY() - Window.getY(0));  
                 if(homescreen)    
                 {
     //+ code  
                     if(xpos>xLeft1 && xpos <xLeft2 && ypos>365 && ypos<470)
                        if(numPlayers <7)
                        numPlayers++;
                     
// - code
                      if(xpos>950)
                        if(xpos<1020)
                        if(ypos>650&&ypos<750)
                        if(numPlayers>1)
                            numPlayers--;

 // 
                 }
                    //Player 1
                        if(xpos>100)
                        if(xpos<325)
                       if(ypos>200&&ypos<270)
                       Player.currentPlayer=Player.players[0];
                          
                        //Player 2
                        if(xpos>100)
                        if(xpos<325)
                       if(ypos>505&&ypos<601)
                       Player.currentPlayer=Player.players[1];
                      
                          //Player 3
                        if(xpos>260)
                        if(xpos<475)
                      if(ypos>877&&ypos<975)
                       Player.currentPlayer=Player.players[2];
                 
                          //Player 4
                        if(xpos>805)
                        if(xpos<475+550)
                       if(ypos>877&&ypos<975)
                       Player.currentPlayer=Player.players[3];
                    
                          //Player 5
                        if(xpos>1355)
                        if(xpos<475+550+550)
                        if(ypos>877&&ypos<975)
                        Player.currentPlayer=Player.players[4];
                        
                          //Player 6
                        if(xpos>1605)
                        if(xpos<1826)
                       if(ypos>505&&ypos<601)
                        Player.currentPlayer=Player.players[5];
                       
                          //Player 7
                        if(xpos>1605)
                        if(xpos<1826)
                     if(ypos>200&&ypos<270)
                         Player.currentPlayer=Player.players[6];
                        
                       
                       
                        
                        
                        
                        
                        if(!homescreen)

                    Board.click(e.getX(),
                        e.getY());  


                }
                if (e.BUTTON3 == e.getButton()) {
                    //right button
                   if(!homescreen)
                    reset();
                }
                repaint();
            }
        });

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
        repaint();
      }
    });

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent e) {

        repaint();
      }
    });

        addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                
              
                
                if (e.VK_UP == e.getKeyCode()) {
                } 
                else if (e.VK_DOWN == e.getKeyCode()) 
               {     
                    nightime=true;
               } 
                else if (e.VK_LEFT == e.getKeyCode()) {
                    
                } 
                else if (e.VK_RIGHT == e.getKeyCode()) {
                    nightime=false;
                    gamescreen=true;
                  
                } 
                else if (e.VK_SPACE == e.getKeyCode()) {
                   
                }
                else if (e.VK_ENTER == e.getKeyCode()) {
                   if(homescreen=true)
                   {
                       Player.Create(numPlayers);
                   }
                   homescreen=false;
                   nightime=true;
                   
                }

                repaint();
            }
        });
        init();
        start();
    }
    Thread relaxer;
////////////////////////////////////////////////////////////////////////////
    public void init() {
        requestFocus();
    }
////////////////////////////////////////////////////////////////////////////
    public void destroy() {
    }



////////////////////////////////////////////////////////////////////////////
    public void paint(Graphics gOld) {
        if (image == null || Window.xsize != getSize().width || Window.ysize != getSize().height) {
            Window.xsize = getSize().width;
            Window.ysize = getSize().height;
            image = createImage(Window.xsize, Window.ysize);
            g = (Graphics2D) image.getGraphics();
            
//        System.out.println("paint " + g);            
            Draw.setDrawingInfo(g,this);
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
        }
//fill background
        g.setColor(Color.cyan);
        g.fillRect(0, 0, Window.xsize, Window.ysize);

        int x[] = {Window.getX(0), Window.getX(Window.getWidth2()), Window.getX(Window.getWidth2()), Window.getX(0), Window.getX(0)};
        int y[] = {Window.getY(0), Window.getY(0), Window.getY(Window.getHeight2()), Window.getY(Window.getHeight2()), Window.getY(0)};
//fill border
        g.setColor(Color.black);
        g.fillPolygon(x, y, 4);
// draw border
        g.setColor(Color.red);
        g.drawPolyline(x, y, 5);

        if (animateFirstTime) {
            gOld.drawImage(image, 0, 0, null);
            return;
        }
        //KEEP THESE THEYRE ARE RIGHT 
        if (bgSound.donePlaying)
                bgSound = new sound ("bgsound.wav");
          if(nightime)     
             {
                 g.drawImage(nightSky,Window.getX(0),Window.getY(0),
                Window.getWidth2(),Window.getHeight2(),this);
             }
        
      //first night cycle displaying their turns 
          
          if(nightime && !homescreen && !gamescreen)
         {
                if(Player.currentPlayer==Player.players[0])
                        {
                            Player.currentPlayer=Player.players[1];
                           }
               else if(Player.currentPlayer==Player.players[1])
                        {
                          Player.currentPlayer=Player.players[2];
                           }
              else if(Player.currentPlayer==Player.players[2])
                        {
                         Player.currentPlayer=Player.players[3];
                        }
                else  if(Player.currentPlayer==Player.players[3])
                        {
                            Player.currentPlayer=Player.players[4];
                           }
                 else  if(Player.currentPlayer==Player.players[4])
                        {
                           Player.currentPlayer=Player.players[5];
                           }
                 else  if(Player.currentPlayer==Player.players[5])
                        {
                            Player.currentPlayer=Player.players[6];
                           }
                   else if(Player.currentPlayer==Player.players[6])
                        {
                           Player.currentPlayer=Player.players[0];
                           }
            
            
        }
        if(!homescreen && !nightime)
        {
            if(gamescreen){
        g.drawImage(FeltBG,Window.getX(0),Window.getY(0),
                Window.getWidth2(),Window.getHeight2(),this);
        


        g.drawImage(Middle,Window.getX(Window.WINDOW_WIDTH/2-150),Window.getY(Window.WINDOW_HEIGHT/2-300),
                Window.getX(300),Window.getY(300),this);
        }
        g.setColor(Color.RED);
        g.drawRect(Window.getX(440),Window.getY(400),Window.getX(220),Window.getY(260));
      
        
          
                   //Player 2
        g.setColor(Color.GRAY);
               g.fillRect(Window.getX(100),Window.getY(480),Window.getX(210),Window.getY(60));      
     //Player 7      
              g.setColor(Color.GRAY);
              g.fillRect(Window.getX(1600),Window.getY(150),Window.getX(210),Window.getY(60));
     //Player 3   
              g.setColor(Color.GRAY);
              g.fillRect(Window.getX(250),Window.getY(850),Window.getX(210),Window.getY(60));
    // Player 4       
              g.setColor(Color.GRAY);
              g.fillRect(Window.getX(800),Window.getY(850),Window.getX(210),Window.getY(60));
    // Player 5        
              g.setColor(Color.GRAY);
              g.fillRect(Window.getX(1350),Window.getY(850),Window.getX(210),Window.getY(60));
       // Player 6       
              g.setColor(Color.GRAY);
              g.fillRect(Window.getX(1600),Window.getY(480),Window.getX(210),Window.getY(60));
            // Player 1   
             g.setColor(Color.GRAY);
             g.fillRect(Window.getX(100),Window.getY(150),Window.getX(210),Window.getY(60));
            
              

               g.setColor(Color.white);
              g.setFont(new Font("Arial",Font.PLAIN,60));
              g.drawString("Player 2", 110, 575); 
              g.setFont(new Font("Arial",Font.PLAIN,60));
              g.drawString("Player 1", 110, 250);   
              g.setFont(new Font("Arial",Font.PLAIN,60));
              g.drawString("Player 4", 810, 950); 
              g.setFont(new Font("Arial",Font.PLAIN,60));
              g.drawString("Player 7", 1610, 240);    
              g.setFont(new Font("Arial",Font.PLAIN,60));
              g.drawString("Player 6", 1610, 575);     
              g.setFont(new Font("Arial",Font.PLAIN,60));
              g.drawString("Player 3", 260, 950);   
              g.setFont(new Font("Arial",Font.PLAIN,60));
              g.drawString("Player 5", 1360, 950);  
             
              
                 if(Player.currentPlayer==Player.players[0])
                        {
                           g.setColor(Color.YELLOW);
                           g.fillRect(Window.getX(100),Window.getY(150),Window.getX(210),Window.getY(60));
                             g.setColor(Color.BLACK);
                           g.setFont(new Font("Arial",Font.PLAIN,60));
                              g.drawString("Player 1", 110, 250);   
                           }
               else if(Player.currentPlayer==Player.players[1])
                        {
                           g.setColor(Color.YELLOW);
                            g.fillRect(Window.getX(100),Window.getY(480),Window.getX(210),Window.getY(60)); 
                             g.setColor(Color.BLACK);
                           g.setFont(new Font("Arial",Font.PLAIN,60));
                               g.drawString("Player 2", 110, 575); 
                           }
              else if(Player.currentPlayer==Player.players[2])
                        {
                          g.setColor(Color.YELLOW);
                          g.fillRect(Window.getX(250),Window.getY(850),Window.getX(210),Window.getY(60));
                             g.setColor(Color.BLACK);
                           g.setFont(new Font("Arial",Font.PLAIN,60));
                             g.drawString("Player 3", 260, 950);    
                           }
                else  if(Player.currentPlayer==Player.players[3])
                        {
                           g.setColor(Color.YELLOW);
                             g.fillRect(Window.getX(800),Window.getY(850),Window.getX(210),Window.getY(60));
                             g.setColor(Color.BLACK);
                           g.setFont(new Font("Arial",Font.PLAIN,60));
                              g.drawString("Player 4", 810, 950);   
                           }
                 else  if(Player.currentPlayer==Player.players[4])
                        {
                           g.setColor(Color.YELLOW);
                            g.fillRect(Window.getX(1350),Window.getY(850),Window.getX(210),Window.getY(60));
                             g.setColor(Color.BLACK);
                           g.setFont(new Font("Arial",Font.PLAIN,60));
                              g.drawString("Player 5", 1360, 950);     
                           }
                 else  if(Player.currentPlayer==Player.players[5])
                        {
                           g.setColor(Color.YELLOW);
                           g.fillRect(Window.getX(1600),Window.getY(480),Window.getX(210),Window.getY(60));
                             g.setColor(Color.BLACK);
                           g.setFont(new Font("Arial",Font.PLAIN,60));
                             g.drawString("Player 6", 1610, 575);        
                           }
                   else if(Player.currentPlayer==Player.players[6])
                        {
                          g.setColor(Color.YELLOW);
                            g.fillRect(Window.getX(1600),Window.getY(150),Window.getX(210),Window.getY(60));
                             g.setColor(Color.BLACK);
                           g.setFont(new Font("Arial",Font.PLAIN,60));
                               g.drawString("Player 7", 1610, 240);       
                           }
        }
               
              
              
      
                 Characters.Draw(this);
                  
                 
                 
                 
        if(homescreen)
                
        {

            
            g.setColor(Color.BLACK);
            g.fillRect(Window.getX(0),Window.getY(0), Window.getWidth2(),Window.getHeight2());
           
            g.setColor(Color.white);
            g.setFont(new Font("Arial",Font.PLAIN,100));
            g.drawString("Amount of Players", 60, 600);     
            
            g.setColor(Color.GRAY);
            g.fillRect(Window.getX(920),Window.getY(480),Window.getX(100),Window.getY(100));

            g.setColor(Color.white);   
            g.setFont(new Font("Arial",Font.PLAIN,100));    
            g.drawString( numPlayers +"", 950, 610); 
            
            g.setColor(Color.white);   
            g.setFont(new Font("Castellar",Font.PLAIN,100));    
            g.drawString("Room 901",1400/2,250); 

             g.setColor(Color.white);
            g.setFont(new Font("Arial",Font.PLAIN,200));    
            g.drawString(  "+", 925, 490);    
            
             g.setColor(Color.white);
            g.setFont(new Font("Arial",Font.PLAIN,200));    
            g.drawString(  "-", 950, 760);    
            
            g.setColor(Color.white);   
            g.setFont(new Font("Arial",Font.PLAIN,50));    
            g.drawString("Press ENTER when ready",1400/2,890); 
          

           
        }
           gOld.drawImage(image, 0, 0, null);
    }
/////////////////////////////////////////////////////////////////////////////      
     public void HomeScreen(int xpos,int ypos,double rot,double xscale,double yscale)
    {
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );

        g.setColor(Color.BLACK);
        g.fillRect(Window.getX(0),Window.getY(0), Window.getWidth2(),Window.getHeight2());
        
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);

    }
////////////////////////////////////////////////////////////////////////////
// needed for     implement runnable
    public void run() {
        while (true) {
            animate();
            repaint();
//            double seconds = .04;    //time that 1 frame takes.
            double seconds = 1/60;    //time that 1 frame takes.
            int miliseconds = (int) (1000.0 * seconds);
            try {
                Thread.sleep(miliseconds);
            } catch (InterruptedException e) {
            }
        }
    }
/////////////////////////////////////////////////////////////////////////
    public void reset() {
            homescreen = true;
            nightime=false;
            numPlayers =1;
            
            if(bgSound != null)
                bgSound.getPlay(true);
            bgSound = new sound ("bgsound.wav");
    }
/////////////////////////////////////////////////////////////////////////
    public void animate() {
        if (animateFirstTime) {
            animateFirstTime = false;
            if (Window.xsize != getSize().width || Window.ysize != getSize().height) {
                Window.xsize = getSize().width;
                Window.ysize = getSize().height;
            }
               nightSky = Toolkit.getDefaultToolkit().getImage("./nightSky.jpg");
            FeltBG = Toolkit.getDefaultToolkit().getImage("./FeltBG.jpg");
                Middle = Toolkit.getDefaultToolkit().getImage("./blackHole.gif");
//                Tamperer = Toolkit.getDefaultToolkit().getImage("./Tamperer.jpg");
//                MrYee = Toolkit.getDefaultToolkit().getImage("./Mr.Yee.jpg");
//                Alex = Toolkit.getDefaultToolkit().getImage("./Alex.jpg");
//                Student = Toolkit.getDefaultToolkit().getImage("./Student.jpg");
//                Back = Toolkit.getDefaultToolkit().getImage("./Blank.jpg");
//                
                reset();
            
            }
           
             

            
                             
        
      
    }

////////////////////////////////////////////////////////////////////////////
    public void start() {
        if (relaxer == null) {
            relaxer = new Thread(this);
            relaxer.start();
        }
    }
////////////////////////////////////////////////////////////////////////////
    public void stop() {
        if (relaxer.isAlive()) {
            relaxer.stop();
        }
        relaxer = null;
    }

}
////////////////////////////////////////////////////////////////////////////

class Window {
    
    
//    private static final int YBORDER = 20;
    
   
    
    private static final int YTITLE = 30;
    private static final int WINDOW_BORDER = 8;
    static final int WINDOW_WIDTH = 2*(WINDOW_BORDER) + 1900;
    static final int WINDOW_HEIGHT = YTITLE + WINDOW_BORDER + 1000;
    static int xsize = -1;
    static int ysize = -1;


/////////////////////////////////////////////////////////////////////////
    public static int getX(int x) {
        return (x  + WINDOW_BORDER);
    }

    public static int getY(int y) {
//        return (y + YBORDER + YTITLE );
        return (y  + YTITLE );
        
    }

    public static int getYNormal(int y) {
//          return (-y + YBORDER + YTITLE + getHeight2());
      return (-y + YTITLE + getHeight2());
        
    }
    
    public static int getWidth2() {
        return (xsize - 2 * (WINDOW_BORDER));
    }

    public static int getHeight2() {
//        return (ysize - 2 * YBORDER - WINDOW_BORDER - YTITLE);
        return (ysize  - WINDOW_BORDER - YTITLE);
    }    
}





