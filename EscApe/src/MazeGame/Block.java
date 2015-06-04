/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MazeGame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JComponent;

/**
 *
 * @author Chris
 */
public class Block extends JComponent {
    private BufferedImage returnImage;
    private BufferedImage topImage;
    private int blokSize;
    private boolean hasItem;

    
    public Block(BufferedImage image, int bS, boolean item) throws IOException{
        
        try {
            returnImage = image;   
            blokSize = bS;
            hasItem = item;
        } catch (Exception e) {
            
        }
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        //maakt een component met een bepaalde hoeveelheid squares
    
        try {
            
            g.drawImage(returnImage, 0,0, this);
            if(hasItem){
                g.drawImage(topImage, 0,0,blokSize,blokSize, this);
            }
            setVisible(true);
        } catch (Exception e) {
            g.fillRect(0, 0, blokSize, blokSize);
            setVisible(true);
        
        }
        
        
    }
    public void setTopImage(BufferedImage topimage){
        topImage=topimage;
    }
    
}
