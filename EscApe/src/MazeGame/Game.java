/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MazeGame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Chris
 */
public class Game {

    private BufferedImage wall;
    private BufferedImage pad;
    private BufferedImage solvedPad;
    private BufferedImage start;
    private BufferedImage finish;
    private BufferedImage held;
    private BufferedImage heldT;
    private BufferedImage heldB;
    private BufferedImage heldL;
    private BufferedImage heldR;
    private BufferedImage returnImage; 
    
    private final Frame frame;
    private final JPanel gamePanel;
    private int curLevel;
    
    //level data die later uit een XML wordt gehaald
    private int blockSize = 40;
    protected int[][] grid ={{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                             {0,2,1,1,1,0,1,0,0,1,1,0,1,1,1,0},
                             {0,0,1,0,1,0,1,1,1,1,1,1,1,0,1,0},       
                             {0,0,0,1,1,1,1,0,0,1,0,1,1,0,1,0},      
                             {0,1,0,1,1,0,0,0,0,1,1,0,1,0,1,0},
                             {0,1,0,0,1,0,1,0,0,1,0,0,1,0,1,0},
                             {0,1,1,1,1,1,1,0,0,1,1,1,4,0,1,0}, 
                             {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
    
    Game(JFrame gameframe) {
        frame = (Frame) gameframe;
        gamePanel = frame.getGamePanel();
        curLevel = 1;
        getImages();
        constructLevel(curLevel);
        createBlocks();
        getLevelVars(curLevel);
    }
    
    private void getLevelVars(int level){
        
    }
    
    //creert de 'blok' objecten die later aan het doolhof worden toegevoegd
    private void createBlocks(){
        for (int row=0; row < grid.length; row++) 
        {
            for (int column=0; column < grid[row].length; column++)
            {
                boolean player = false;
                boolean walkable;
                
                switch (grid[row][column]){
                    case(0) :          
                        returnImage = wall;           
                        walkable = false;
                        break;
                    case(2)  :        
                        returnImage = start;        
                        walkable = true;
                        player = true;
                        break;
                    case(4)  :        
                        returnImage = finish;           
                        walkable = true;
                        break;
                
                    default :
                        returnImage = pad;       
                        walkable = false;
                }
                
                
                Block blok;
                try {
                    if(player==true)   
                    { 
                       blok = new Block(returnImage, blockSize, true);
                       blok.setTopImage(held);
                    }else
                    {
                        blok = new Block(returnImage, blockSize, false);
                    }
                    gamePanel.add(blok);
                } catch (Exception e) {
                  
                }
            }    
                    
        }
        
    }
            
        private void constructLevel(int level){
        
        //panel met nieuwe UI inladen
        gamePanel.removeAll();
        GridLayout layout = new GridLayout(grid.length,grid[0].length);
        gamePanel.setLayout(layout);
        gamePanel.setBackground(Color.BLACK);
        gamePanel.setFocusable(true);
        gamePanel.requestFocusInWindow();
        gamePanel.updateUI();
    }

    private void getImages() {
        try {
            wall       = ImageIO.read(new File("src/images/wall.PNG"));
            pad        = ImageIO.read(new File("src/images/pad.PNG"));
            solvedPad  = ImageIO.read(new File("src/images/solvedPad.PNG"));
            start      = ImageIO.read(new File("src/images/start.PNG"));
            finish     = ImageIO.read(new File("src/images/finish.PNG"));
            heldB       = ImageIO.read(new File("src/images/heldBottom.PNG")); 
            heldL       = ImageIO.read(new File("src/images/heldLeft.PNG")); 
            heldR       = ImageIO.read(new File("src/images/heldRight.PNG")); 
            heldT       = ImageIO.read(new File("src/images/heldTop.PNG")); 
            held = heldR;
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Niet alle grafische onderdelen konden geladen worden.");
        }
    }
}
