/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MazeGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 *
 * @author Chris
 */
class HeldBlock extends Block {

    private final BufferedImage held;
    
    public HeldBlock(BufferedImage held, BufferedImage returnImage, Color color) throws IOException 
    {
        super(returnImage, color);
        this.held = held; 
    }
    @Override
    public void paintComponent(Graphics g){
        //maakt een component met een bepaalde hoeveelheid squares
    
        try {
            g.drawImage(returnImage, 0,0,100,100, this);
            g.drawImage(held, 0,0,100,100, this);
            //g.fillRect(0, 0, 64, 64);
            setVisible(true);
        } catch (Exception e) {
            g.setColor(returnColor);
            g.fillRect(0, 0, 100, 100);
            setVisible(true);
        
        }
        
        
    }
}
