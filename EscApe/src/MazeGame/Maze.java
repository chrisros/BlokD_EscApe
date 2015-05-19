/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MazeGame;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author chris
 */
public class Maze {
    
    protected Color color;
    boolean walkable;
    protected BufferedImage wall;
    protected BufferedImage pad;
    protected BufferedImage solvedPad;
    protected BufferedImage start;
    protected BufferedImage finish;
    protected BufferedImage held;
    protected BufferedImage returnImage; 
    
    protected  JPanel panel; 
    protected final int startX;
    protected final int startY;
    protected final int endX;
    protected final int endY;
    protected int playerX;
    protected int playerY;
    protected boolean solution = false;
    protected int[][] grid ={{0,0,0,0,0,0,0,0,0,0,0,0},
                             {0,1,1,1,1,0,1,1,1,0,1,0},
                             {0,0,1,0,1,1,1,0,1,0,1,0},       
                             {0,1,1,0,1,0,0,1,1,0,1,0},
                             {0,1,0,0,1,0,0,1,0,0,1,0},
                             {0,1,1,1,1,1,1,1,1,1,1,0}, 
                             {0,0,0,0,0,0,0,0,0,0,0,0}};  

   public Maze(int x, int y){
       startX = x;
       startY = y;
       playerX = x;
       playerY = y;
       endX = 10;
       endY = 5;
       
        try {
            wall       = ImageIO.read(new File("src/images/wall.PNG"));
            pad        = ImageIO.read(new File("src/images/pad.PNG"));
            solvedPad  = ImageIO.read(new File("src/images/solvedPad.PNG"));
            start      = ImageIO.read(new File("src/images/start.PNG"));
            finish     = ImageIO.read(new File("src/images/finish.PNG"));
            held       = ImageIO.read(new File("src/images/held.PNG")); 
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Niet alle grafische onderdelen konden geladen worden.");
        }

    }
   
    public void printMaze() {
   
      System.out.println();

      for (int row=0; row < grid.length; row++) 
      {
         for (int column=0; column < grid[row].length; column++)
            System.out.print (grid[row][column]);
         System.out.println();
      }

      System.out.println();
    }
        
    public void paintMaze() throws IOException
    {
        //panel leegmaken
        panel.removeAll();
                
        for (int row=0; row < grid.length; row++) 
        {
            for (int column=0; column < grid[row].length; column++)
            {
                boolean player = false;
                if(row==startY&&column==startX){grid[row][column]=2;}
                if(row==endY&&column==endX){grid[row][column]=4;}
                if(row==playerY&&column==playerX){player=true;}
                
                int c=grid[row][column];
                
                if     (c==0)           {returnImage=wall;      color=Color.black;      walkable=false;}
                else if(c==7&&solution) {returnImage=solvedPad; color=Color.green;      walkable=true;}
                else if(c==2)           {returnImage=start;     color=Color.orange;     walkable=true;}
                else if(c==4)           {returnImage=finish;    color=Color.red;        walkable=true;}
                else                    {returnImage=pad;       color=Color.lightGray;  walkable=false;}
                
                Block blok; 
                if(player==true)   
                { 
                   color=Color.pink;
                   blok = new HeldBlock(held, returnImage, color);          
                }else
                {
                    blok = new Block(returnImage, color);
                }
                panel.add(blok);            
            }          
        }
        //panel met nieuwe UI inladen
        panel.setBackground(Color.BLACK);
        panel.setFocusable(true);
        panel.requestFocusInWindow();
        panel.updateUI();
        
        
    } 
    
   public int[][] getGrid(){return grid;}
   public int getBlock(int x, int y){return grid[y][x];} 
   public int getStartX(){return startX;}
   public int getStartY(){return startY;}
   public int getEndX(){return endX;}
   public int getEndY(){return endY;}
   public int getWidth(){return grid[0].length  ;}
   public int getHeight(){return grid.length;}
   public int getPlayerX(){return playerX;}
   public int getPlayerY(){return playerY;}
   public void setPanel(JPanel pan){panel = pan;}
   public void setPlayerX(int x){playerX = x;}
   public void setStartY(int y){playerY = y;}
}
