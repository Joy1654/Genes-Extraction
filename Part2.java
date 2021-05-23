
/**
 * Write a description of Part2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part2 {
    public String findSimpleGene(String DNA, int Start_Codon, int Stop_Codon) {


        if (Start_Codon != -1 && Stop_Codon != -1) {

            String Sub_String = DNA.substring(Start_Codon, Stop_Codon + 3);
            if (Sub_String.length() % 3 != 0) {
                return null;
            } else {
                return Sub_String;
            }

        } else {
            return null;
        }


    }

    public void testSimpleGene() {
        String dna = "CCTGCAATGTGGCGATAGTAACAA";
        String dna_2 = "TGGCATAGCCTTCGGCTGTAACCGT";
        String dna_3 = "TTTGCCGATGGACTTAGGCACG";
        String dna_4 = "AATAATGTGGACGATAGTAACAAGACG";
        int Start_Codon = dna.indexOf("ATG");
        int Stop_Codon = dna.indexOf("TAA", Start_Codon + 3);
        System.out.println(findSimpleGene(dna, Start_Codon, Stop_Codon));
        Start_Codon = dna_2.indexOf("ATG");
        Stop_Codon = dna_2.indexOf("TAA", Start_Codon + 3);
        System.out.println(findSimpleGene(dna_2, Start_Codon, Stop_Codon));
        Start_Codon = dna_3.indexOf("ATG");
        Stop_Codon = dna_3.indexOf("TAA", Start_Codon + 3);
        System.out.println(findSimpleGene(dna_3, Start_Codon, Stop_Codon));
        Start_Codon = dna_4.indexOf("ATG");
        Stop_Codon = dna_4.indexOf("TAA", Start_Codon + 3);


        System.out.println(findSimpleGene(dna_4, Start_Codon, Stop_Codon));

    }


}
