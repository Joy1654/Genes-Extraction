
/**
 * Write a description of Part3 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part3 {
    public boolean twoOccurrences(String a, String b) {
        int i = 0, Count = 0;

        while (i < b.length()) {
            int T = b.indexOf(a, i);
            if (T != -1) {
                Count++;
                i = T + a.length();

            } else
                break;
        }
        if (Count > 1) {
            System.out.println(Count);
            return true;
        } else
            return false;


    }

    public String lastPart(String a, String b) {
        int T = b.indexOf(a);
        if (T != -1) {
            return (b.substring(T + a.length(), b.length()));
            //return( b.substring(T+a.length());  IS also correct
        } else

            return (b);
    }

    public void testing() {
        System.out.println(twoOccurrences("aa", "hati"));
        System.out.println(twoOccurrences("aa", "h"));
        System.out.println(twoOccurrences("aa", "haaaati"));
        System.out.println(twoOccurrences("aa", "haati"));

        System.out.println(lastPart("aa", "hati"));
        System.out.println(lastPart("aa", "haateh"));
        System.out.println(lastPart("aaaa", "ha"));

    }

}
