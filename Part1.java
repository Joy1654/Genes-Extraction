
/**
 * Write a description of Part1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part1 {
    public String findSimpleGene(String DNA) {

        int Start_Codon = DNA.indexOf("ATG");
        if (Start_Codon == -1) {
            return null;
        }


        int Stop_Codon = DNA.indexOf("TAA", Start_Codon + 2);

        if (Stop_Codon == -1) {
            return null;
        }

        String Sub_String = DNA.substring(Start_Codon, Stop_Codon + 3);
        if (Sub_String.length() % 3 != 0) {
            return null;
        } else {
            return Sub_String;
        }


    }

    public void testSimpleGene() {
        String dna = "AAATGCCCTAACTAGATTAAGAAACC";
        System.out.println(findSimpleGene(dna));

        //String dna_2="TGGCATAGCCTTCGGCTGTAACCGT";
        //System.out.println(findSimpleGene(dna_2));
        //String dna_3="TTTGCCGATGGACTTAGGCACG";
        //System.out.println(findSimpleGene(dna_3));
        //String dna_4="AATAATGTGGACGATAGTAACAAGACG";
        //System.out.println(findSimpleGene(dna_4));


    }


}
