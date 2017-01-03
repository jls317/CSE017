/*
 Jeffrey Stewart
 Prog3
 CSE17
 02/11/15
 JLS317
 Purpose: To compare a user-given text to the DaleChall
 word list, to get a reading level score for the given text.
 */

package prog3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

public class DaleChall {

    private Text text;
    private String easyWords[] = new String[3000];
    private int numWords = 0;
    private String daleChall;
    private Text DCText;
    private Text gettysText;
    private int i = 0;

    public DaleChall(Text text, String filename) {

        readList();
    }

    private void readList() {
        StringBuilder sb = new StringBuilder();
        String line;

        try {
            BufferedReader in = new BufferedReader(new FileReader("Dale-ChallWordList.txt"));
            while ((line = in.readLine()) != null) {
                sb.append(line);
                sb.append(' ');
                easyWords[i] = line.trim();
                i++;

            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        daleChall = sb.toString();

        numWords = i;
    }

    public int onDaleChall(Text text1) {
        int onList = 0;
        for (int k = 0; k < (text1.getWordCount()); k++) {
            for (int j = 0; j < numWords; j++) {
                if (text1.getWords()[k].equals(easyWords[j])) {
                    onList++;
                }
            }
        }
        return onList;
    }

    public double calcReadingEase(Text gettysText) {
        int onList = onDaleChall(gettysText);       //easy words
        int notOnList = gettysText.getWordCount() - onList;   //hard words
        double PDW = 100 * ((double) notOnList / gettysText.getWordCount());    //percentage of diff. words
        double ASL = (double) gettysText.getWordCount() / gettysText.getSentenceCount();    //avg sentence length
        double RAW = (0.1579 * (PDW)) + (0.0496 * (ASL)) + 3.6365;  
        return RAW;
    }
}
