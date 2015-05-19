//haalt de levels uit een txt files en parsed ze naar 'Spel'

//IN DEV

package MazeGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chris
 */
public class LevelLoader {

    public LevelLoader(){
        loadLevels();
    }
   
    private void loadLevels(){
        // create Scanner inFile1
    Scanner inFile1;
       try {
           String token1;
           inFile1 = new Scanner(new File("C:\\levels.txt"));
           token1 = inFile1.nextLine();
           System.out.println(token1);
       } catch (FileNotFoundException ex) {
           Logger.getLogger(Spel.class.getName()).log(Level.SEVERE, null, ex);
           
       }
    
        
}
}