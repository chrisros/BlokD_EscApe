/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MazeGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Chris
 */
public class GetKey implements KeyListener
{
    private int c1;
    private int c2;
    private int c3;
    private int c4;
    private final Speler speler;
    
    
    public GetKey(Speler speler){
        this.speler = speler;
    }
    
    

    @Override
    public void keyPressed(KeyEvent e) 
    {
        
        int keyCode = e.getKeyCode();
        
        //kijkt of er een het woord 'help' word getyped
        c4=c3; c3=c2; c2=c1; c1 = keyCode;
        if(c4==72&&c3==69&&c2==76&&c1==80){System.out.println("Jij cheater");} 
    
        //parsed de keypresses naar de player in game (richting is gelijk aan numpad)
        if(keyCode==37){speler.move(4);}//arrowKey links
        if(keyCode==38){speler.move(8);}//arrowKey up
        if(keyCode==39){speler.move(6);}//arrowKey rechts
        if(keyCode==40){speler.move(2);}//arrowKey down
        //if(keyCode==32){speler.verkrijgSnelsteRoute();}//laat oplossing zien
        
    }

    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}
}
