/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MazeGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author Chris
 */
public class Frame extends JFrame{

    private JButton startButton = new JButton();
    private JButton restartButton = new JButton();
    private final JPanel topPanel;
    private final JPanel gamePanel;
    private final JPanel bottomPanel;
    
    
    Frame(String title) {
        
        setTitle(title);
        setVisible(true);
        setDefaultCloseOperation(1);
        setSize(1000, 600);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setResizable(false);
        
        topPanel = new JPanel();
        topPanel.setSize(1000, 50);
        topPanel.setBackground(Color.red);
        this.add(topPanel);
        
        gamePanel = new JPanel();
        gamePanel.setSize(1000, 500);
        gamePanel.setBackground(Color.blue);
        this.add(gamePanel);
       
        bottomPanel = new JPanel();
        bottomPanel.setSize(1000, 50);
        bottomPanel.setBackground(Color.green);
        this.add(bottomPanel);
        bottomPanel.add(startButton);
        bottomPanel.add(restartButton);
    } 
    //getters ubd setters   
    public JPanel getGamePanel() {
        return gamePanel;
    }
}
