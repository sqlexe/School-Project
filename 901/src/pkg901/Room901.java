
package pkg901;

import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.util.ArrayList;


    
    
    
    
    public class Room901 extends JFrame implements Runnable {

    boolean animateFirstTime = true;
    Image image;
    Graphics2D g;
    
    Image FeltBG;
    Image Middle;
    Image MrYee;
    Image Alex;
    Image Student;
    Image Tamperer;
    Image Back;
    boolean homescreen = true;
    int numPlayers =1;

   
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
                    
                    Board.AddTokenPixel(e.getX() - Window.getX(0),
                        e.getY() - Window.getY(0));  

                }
                if (e.BUTTON3 == e.getButton()) {
                    //right button
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
                    homescreen = false;
               } 
                else if (e.VK_LEFT == e.getKeyCode()) {
                    
                } 
                else if (e.VK_RIGHT == e.getKeyCode()) {
                  
                } 
                else if (e.VK_SPACE == e.getKeyCode()) {
                   
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
            Drawing.setDrawingInfo(g,this);
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

        g.drawImage(FeltBG,Window.getX(0),Window.getY(0),
                Window.getWidth2(),Window.getHeight2(),this);
        
        
        
        g.drawImage(MrYee,Window.getX(440),Window.getY(50),
                Window.getX(220),Window.getY(260),this);

       
        g.drawImage(Alex,Window.getX(840),Window.getY(50),
                Window.getX(220),Window.getY(260),this);
        
        g.drawImage(Tamperer,Window.getX(1240),Window.getY(50),
                Window.getX(220),Window.getY(260),this);

        g.drawImage(Back,Window.getX(1240),Window.getY(400),
                   Window.getX(220),Window.getY(260),this);
        
        g.drawImage(Student,Window.getX(440),Window.getY(400),
                Window.getX(220),Window.getY(260),this);

        g.drawImage(Middle,Window.getX(Window.WINDOW_WIDTH/2-150),Window.getY(Window.WINDOW_HEIGHT/2-150),
                Window.getX(300),Window.getY(300),this);

        g.setColor(Color.RED);
        g.drawRect(Window.getX(440),Window.getY(400),Window.getX(220),Window.getY(260));
        
   
        
        if(homescreen)
        {
            g.setColor(Color.BLACK);
            g.fillRect(Window.getX(0),Window.getY(0), Window.getWidth2(),Window.getHeight2());
           
            g.setColor(Color.white);
            g.setFont(new Font("Arial",Font.PLAIN,100));
            g.drawString("Amount of Players", 60, 360);     
            
            g.setColor(Color.GRAY);
            g.fillRect(Window.getX(950),Window.getY(250),Window.getX(100),Window.getY(100));
           
            g.setColor(Color.white);
            g.setFont(new Font("Arial",Font.PLAIN,100));
            g.drawString( numPlayers +"", 950,250);    

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
            double seconds = 1/5;    //time that 1 frame takes.
            int miliseconds = (int) (1000.0 * seconds);
            try {
                Thread.sleep(miliseconds);
            } catch (InterruptedException e) {
            }
        }
    }
/////////////////////////////////////////////////////////////////////////
    public void reset() {
   

    }
/////////////////////////////////////////////////////////////////////////
    public void animate() {
        if (animateFirstTime) {
            animateFirstTime = false;
            if (Window.xsize != getSize().width || Window.ysize != getSize().height) {
                Window.xsize = getSize().width;
                Window.ysize = getSize().height;
            }
            FeltBG = Toolkit.getDefaultToolkit().getImage("./FeltBG.jpg");
            Middle = Toolkit.getDefaultToolkit().getImage("./blackHole.gif");
            Tamperer = Toolkit.getDefaultToolkit().getImage("./Tamperer.jpg");
            MrYee = Toolkit.getDefaultToolkit().getImage("./Mr.Yee.jpg");
            Alex = Toolkit.getDefaultToolkit().getImage("./Alex.jpg");
            Student = Toolkit.getDefaultToolkit().getImage("./Student.jpg");
            Back = Toolkit.getDefaultToolkit().getImage("./Blank.jpg");
            numPlayers =1;
            homescreen =true; 
            
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








class Drawing {
    private static Graphics2D g;
    private static Room901 mainClassInst;

    public static void setDrawingInfo(Graphics2D _g,Room901 _mainClassInst) {
        g = _g;
        mainClassInst = _mainClassInst;
    }
////////////////////////////////////////////////////////////////////////////
  
////////////////////////////////////////////////////////////////////////////
    public static void drawImage(Image image,int xpos,int ypos,double rot,double xscale,
            double yscale) {
        int width = image.getWidth(mainClassInst);
        int height = image.getHeight(mainClassInst);
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );

        g.drawImage(image,-width/2,-height/2,
        width,height,mainClassInst);

        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
    }
   

}

