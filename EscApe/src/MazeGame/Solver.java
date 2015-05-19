/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MazeGame;

import java.io.IOException;

/**
 *
 * @author chris
 */

public class Solver {
    // waardes van de snelste route
    private int[][] gridFast;
    private int stepsFast;
    
    private final int startY;
    private final int startX;
    private final int endX;
    private final int endY;
    private int order;
    private int[][] grid;
    private int steps;

    public Solver(Maze Maze, int recur)
    {
        grid    = Maze.getGrid();            //verkrijgen van doolhof
        startX  = Maze.getPlayerX();          //verkrijgen van startpunt
        startY  = Maze.getPlayerY();          //verkrijgen van startpunt
        endX    = Maze.getEndX();            //verkrijgen van startpunt
        endY    = Maze.getEndY();            //verkrijgen van startpunt
        order = recur;
        steps   = -1;                        //varibele voor opslaan hoeveel stappen er zijn
    }
        //Start de solve actie 
       public Maze_Solved start() throws IOException
       {
          
           boolean  solved = solve(startY, startX);         
           Maze_Solved doolhofOpgelost = new Maze_Solved(grid, startX, startY, steps, solved);              
           return doolhofOpgelost;
         
       }
    
       private boolean solve (int row, int column) 
       {       
            boolean done = false;
            
            if (valid (row, column)) 
            {
                grid[row][column] = 3;                        // laat 'breadcrumb'achter (cell is geprobeerd)

                if (row == endY && column == endX)
                {
                   done = true;                              // doolhoof opgelost (eindpunt bereikt)  
                }
                else if(order == 1)
                {
                   done = solve (row+1, column);             // down
                   if (!done)
                      done = solve (row, column+1);          // right
                   if (!done)
                      done = solve (row-1, column);          // up
                   if (!done)
                      done = solve (row, column-1);         // left
                } else if(order == 2)
                {
                   done = solve (row, column+1);             // right
                   if (!done)
                      done = solve (row+1, column);          // down
                   if (!done)
                      done = solve (row-1, column);          // up
                   if (!done)
                      done = solve (row, column-1);         // left
                } else if(order == 3)
                {
                   done = solve (row+1, column);             // down
                   if (!done)
                      done = solve (row, column+1);          // right
                   if (!done)
                      done = solve (row, column-1);          // left
                   if (!done)
                      done = solve (row-1, column);         // up
                } else if(order == 4)
                {
                   done = solve (row, column+1);             // right
                   if (!done)
                      done = solve (row+1, column);          // down
                   if (!done)
                      done = solve (row, column-1);          // left
                   if (!done)
                      done = solve (row-1, column);         // up
                }
                if (done)                                   // markeer als'final path'
                   grid[row][column] = 7;
                   steps++;
          }
           
          return done;    
        } 
       private boolean valid (int row, int column) {

      boolean result = false;
 
        // check if cell is in the bounds of the matrix
        if (row >= 0 && row < grid.length &&
            column >= 0 && column < grid[0].length)

        //  check if cell is not blocked and not previously tried
        if (grid[row][column] == 1||grid[row][column] == 2||grid[row][column] == 4)
           result = true;

      return result;

   }
       
}
