import edu.duke.*;

import java.io.File;

/**
 * Write a description of Part1 here.
 *
 * @author (Joydeep Das)
 * @version (July,2020)
 */
public class Part1 {
    int Index = 0;

    public int findStopCodon(String dna, int StartIndex, String StopCodon) {
        int T = dna.indexOf(StopCodon);
        if (T != -1 && (StartIndex - T) % 3 == 0) {
            return T;
        } else

            return dna.length();

    }

    public void testFindStopCodon() {
        System.out.println(findStopCodon("CTAGATGCTTGACTAAGCT", 4, "TAA"));

        System.out.println(findStopCodon("CTAGATGCTTGACTAAGCT", 4, "CTR"));
    }

    public String findGene(String DNA, int startCount) {

        int startindex = DNA.indexOf("ATG", startCount);

        if (startindex != -1) {
            int A = findStopCodon(DNA, startindex, "TAA");
            int B = findStopCodon(DNA, startindex, "TAG");
            int C = findStopCodon(DNA, startindex, "TGA");

            if ((A - C) > 0 && (B - C) > 0) {
                Index = (startindex);
                return DNA.substring(startindex, C + 3);

            } else if (A - B > 0) {
                Index = (startindex);
                return DNA.substring(startindex, B + 3);

            } else if (A - B < 0) {
                Index = (startindex);
                return DNA.substring(startindex, A + 3);

            } else
                return "";

        } else
            return "";
    }

    public void testFindGene() {
        // System.out.println(findGene("AGGTCCAGAAGCTCTCGAGAT\n\n\n\n\n\n\n"));
        //     System.out.println(findGene("GTAATGCTTACCTGGAGGTCCA"));
        //   System.out.println(findGene("TCCATGGDTCTTAAGGACCATTGTGAGGATAGCTT"));
        //   System.out.println(findGene("TCCATGGCTTAFFGGGACCATTGTGAGGATTAGCTT"));
        //   System.out.println (findGene("TCCATGGCTTAAGGACCATTGTGAGGATAGCTTT"));
    }

    public void printAllGenes(String dna) {
        int startc = 0, Count = 0;

        while (startc < dna.length()) {
            String q = findGene(dna, startc);
            if (q.equals("")) {
                break;
            } else {
                System.out.println(q + "\n");
                startc = Index + q.length();
                Count++;

            }


        }
        System.out.println(Count);
    }


}
