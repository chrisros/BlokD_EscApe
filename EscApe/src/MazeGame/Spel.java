/*
 * Maakt de levels van het spel
 */

package MazeGame;

import javax.swing.JFrame;

/**
 * @author Chris
 */
public class Spel {
   //config 
   int x = 1;               //default start positie 
   int y = 1;               //default start positie
   int blockSize = 100;     //grootte van elke block ven het grid
   int steps;
   
   public void constructLevel(){
   //  Level data, creates new Maze object with the start and finish // 
    int i = 1;
    Maze doolhof = new Maze(x, y);
    Solver solver = new Solver(doolhof, i);
    Maze_Solved opgelost = solver.start();
    steps = opgelost.getSteps();
    while (i<4)
    {
        i++;
        Maze doolhof2 = new Maze(x, y);
        Solver solver2 = new Solver(doolhof2, i);
        Maze_Solved opgelost2 = solver2.start();
        int curSteps = opgelost2.getSteps();
        
        if(curSteps<steps&&curSteps>0)
        {
            steps = curSteps;
            opgelost=opgelost2;
        }
    }
       
    //================================================================//
        Speler speler = new Speler(x, y, doolhof);
        Frame frame = new Frame(doolhof, opgelost, speler);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(doolhof.getWidth()*blockSize, doolhof.getHeight()*blockSize);
        String feedback;
        if(opgelost.isDone())
        {
            feedback="Minimale hoeveelheid stappen = "+opgelost.getSteps();
        } else{
            feedback = "Geen oplossing";
        }
        frame.setFeedback(feedback);
    //================================================================//    
         

   }
}
