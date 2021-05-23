
/**
 * Write a description of Part1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.lang.Object;

import edu.duke.StorageResource;
import edu.duke.FileResource;
import edu.duke.URLResource;

public class Part1 {

    //StorageResource sr=new StorageResource();
    int Index = 0;
    StorageResource sr = new StorageResource();

    public int findStopCodon(String dna, int StartIndex, String StopCodon) {
        int T = dna.indexOf(StopCodon, StartIndex);
        int StartPosition = StartIndex;
        if (T == -1) {

            return dna.length();
        } else if ((T - StartIndex) % 3 == 0) {
            System.out.println("Found Position at: " + T);
            return T;
        } else {
            while (T != -1) {
                T = dna.indexOf(StopCodon, StartPosition);
                if ((T - StartIndex) % 3 == 0) {
                    System.out.println("Found Position at: " + T);
                    return T;
                } else

                    StartPosition = T + 3;
            }
            return dna.length();
        }
        // return dna.length();
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
            Index = (startindex);
            if ((A - C) > 0 && (B - C) > 0) {

                System.out.println(DNA.substring(startindex, C + 3));
                return DNA.substring(startindex, C + 3);

            } else if (A - B > 0) {
                System.out.println(DNA.substring(startindex, B + 3));
                return DNA.substring(startindex, B + 3);

            } else if (A - B < 0) {
                System.out.println(DNA.substring(startindex, A + 3));
                return DNA.substring(startindex, A + 3);

            } else
                // System.out.println("Not Found");
                return "";

        } else
            //System.out.println("Not Found");
            return "";
    }


    public void getAllGenes(String dna) {
        int startc = 0;//Count=0;
        while (startc < dna.length()) {
            String q = findGene(dna, startc);
            if (q.equals("")) {
                // System.out.println("That's all folks");
                break;
            } else {
                System.out.println(q + "\n");
                sr.add(q);
                // Count++;
                startc = Index + q.length();
            }
        }
        //System.out.println(Count);
    }

    public double cgRatio(String Genes) {
        int i = 0;
        double Count = 0;

        while (i < Genes.length()) {
            int C = Genes.indexOf("C", i);
            int G = Genes.indexOf("G", i);
            if (G != -1 || C != -1) {
                if (C != -1) {
                    Count++;
                }
                if (G != -1) {
                    Count++;
                }
                int Max = Math.max(C, G);
                i = Max + 1;
            } else
                break;

        }
        return (double) (Count / Genes.length());

    }

    public int countCTG(String dna) {
        int i = 0, Count = 0;
        while (i < dna.length()) {
            int INDEX = dna.indexOf("CTG", i);
            if (INDEX != -1) {
                Count++;
                i = INDEX + 3;

            } else
                break;
        }

        System.out.println(Count);
        return Count;
    }

    public void ProcessGenes(StorageResource PG) {
        int Count = 0, cg_Count = 0, Length = 0;
        for (String q : PG.data()) {
            if (q.length() > 60) {
                Count++;
                // System.out.println("String greater than 60 char:\n " + q);
            }
            if (cgRatio(q) > 0.35) {
                cg_Count++;
                // System.out.println("CG Ratio greater than 0.35:\n " + q);
            }
            if (q.length() > Length) {
                Length = q.length();

            }


        }
        System.out.println("No. of Strings greater than 60 Characters: \n" + Count +
                "\nNo.of CG :\n " + cg_Count +
                "\nLength of the Longest Gene:\n " + Length +
                "\nTotal Genes: \n" + PG.size()

        );

    }

    public void testProcessGenes() {
        URLResource fr = new URLResource("https://users.cs.duke.edu/~rodger/GRch38dnapart.fa");
        //FileResource fr=new FileResource();
        String Mega_DNA = fr.asString();
        Mega_DNA = Mega_DNA.toUpperCase();
        //System.out.println(Mega_DNA);
        //Mega_DNA=Mega_DNA.toUpperCase();
        getAllGenes(Mega_DNA);
        //for(String g: sr.data())
        //{
        //System.out.println(g + "\n") ;
        //}
        ProcessGenes(sr);
    }
}

