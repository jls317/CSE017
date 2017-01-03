
package prog4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordList {
    private Word[] words;
    private String fileName;
    
    public WordList(String fileName){
        this.fileName=fileName;
        readFile();
    }
    
    public boolean readFile(){
        String line;
        StringBuilder sb = new StringBuilder();
        String[] hiddenWords;
        try {
            BufferedReader in
                    = new BufferedReader(new FileReader(fileName));
            while ((line = in.readLine()) != null) {
                sb.append(line);
                sb.append(' ');
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        String text = sb.toString();
        hiddenWords = text.split("\\s+");
        
        this.words=new Word[hiddenWords.length];
        for (int i = 0 ; i<hiddenWords.length ; i++){
            words[i]=new Word(hiddenWords[i]);
        }
        return true;
    }
    
    public Word[] getList(){
        return words;
    }
}
