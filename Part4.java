
/**
 * Write a description of Part4 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */


import edu.duke.*;

import java.io.*;
import java.lang.*;

public class Part4 {
    //URLResource ur = new URLResource("https://ocw.mit.edu/index.htm");
    //for(File f: ur.lines("https://ocw.mit.edu/index.htm"));

    public void Find() {
        URLResource ur = new URLResource("https://www.dukelearntoprogram.com/course2/data/manylinks.html");
        for (String f : ur.lines()) {
            // The whole point of this is finding link that actually work//
            // Applying this  f=f.toLowerCase() is wrong because Links are case sensitive , any changes won't open the link//
            // Applying this  f.indexOf("www.YouTube.com")!=-1 is right , it take cares of the thing //

            if (f.indexOf("www.youtube.com") != -1 || f.indexOf("www.YouTube.com") != -1) {
                int Start_Index = f.indexOf("\"h");
                int Stop_Index = f.indexOf("\"", Start_Index + 1);
                System.out.println(f.substring(Start_Index + 1, Stop_Index));


            }
        }
    }

}
    


