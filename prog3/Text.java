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

public class Text {

    private String str = null;
    private int wordCount;
    private int sentenceCount = 0;
    private String[] words;

    //Getter Methods
    public int getWordCount() {
        return words.length;
    }

    public int getSentenceCount() {
        return sentenceCount;
    }

    public String[] getWords() {
        return words;
    }

    public Text(String inText) {
        str = inText;
        calculateStats();
    }

    private void calculateStats() {
        words = str.split("\\s+");

        String test;

        char testChar;
        for (int i = 0; i < words.length; i++) {

            test = words[i];
            if (test.length() != 0) {

                testChar = test.charAt((test.length() - 1));
                if (testChar == ',' || testChar == ';' || testChar == ':') {
                    words[i] = test.substring(0, (words[i].length() - 1));
                }
                if (testChar == '.' || testChar == '?' || testChar == '!') {
                    words[i] = test.substring(0, (words[i].length() - 1));
                    sentenceCount++;
                }
            }

        }
        wordCount = words.length;

    }

}
