package MazeGame;

import java.io.IOException;
import javax.swing.JPanel;


/**
 *
 * @author Chris
 */
public class Speler{
    private int x;
    private int y;
    private Maze doolhof;
    private int steps = 0;
    
    public Speler(int x, int y, Maze doolhof){
        this.x = x;
        this.y = y;
        this.doolhof = doolhof;
    }
    public void move(int key) throws IOException{
        int oldX = x;
        int oldY = y;
        if(key==4){x--; if(doolhof.getBlock(x, y)==0){x++;}}
        if(key==6){x++; if(doolhof.getBlock(x, y)==0){x--;}}
        if(key==8){y--; if(doolhof.getBlock(x, y)==0){y++;}}
        if(key==2){y++; if(doolhof.getBlock(x, y)==0){y--;}}
        
        //kijkt of er verandering heeft plaatsgevonden
        if(x==oldX&&y==oldY){}
        else
        {
           steps++;
           doolhof.setPlayerX(x);
           doolhof.setStartY(y);
           doolhof.paintMaze();
           //System.out.println(steps);
           //System.out.println(x+" "+y); 
        }
    }
    
    public void verkrijgSnelsteRoute(JPanel panel) throws IOException
    {
        int i = 1;
        Maze doolhof2 = new Maze(x, y);
        Solver solver = new Solver(doolhof2, i);
        Maze_Solved opgelost = solver.start();
        opgelost.setPanel(panel);
        steps = opgelost.getSteps();
        while (i<4)
        {
            i++;
            Solver solver2 = new Solver(doolhof2, i);
            Maze_Solved opgelost2 = solver2.start();
            int curSteps = opgelost2.getSteps();

            if(curSteps<steps&&curSteps>0)
            {
                steps = curSteps;
                opgelost=opgelost2;
            }
        }
        opgelost.paintMaze();
    }
    
    public int getX(){return x;}
    public int getY(){return y;}
}