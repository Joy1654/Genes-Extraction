
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public void howMany(String stringa,String stringb)
    {
        int Startc=0,Count=0;
        while(Startc<stringb.length())
        {
            Startc=stringb.indexOf(stringa,Startc);
            
            if(Startc!=-1)
            {
                Count++;
                Startc+=stringa.length();
            }
            else
            {
                break;
            }
            }
         System.out.println(Count);   
        
        
        
    }
    

}
