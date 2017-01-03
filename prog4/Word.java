
package prog4;

public class Word {
    private String word;
    private int wordRow;
    private int wordCol;
    private int wordDir;
    
    //Constructor
    public Word(String newWord){
        word=newWord.toUpperCase();
        wordRow=0;
        wordCol=0;
        wordDir=0;
    }
    
    //Setters
    public void setWordRow(int rowNum){
        wordRow=rowNum;
    }
    public void setWordCol(int colNum){
        wordCol=colNum;
    }
    public void setWordDir(int dirNum){
        wordDir=dirNum;
    }
    
    //Getters
    public int getWordRow(){
        return wordRow;
    }
    public int getWordCol(){
        return wordCol;
    }
    public int getWordDir(){
        return wordDir;
    }
    public String getWord(){
        return word;
    }
}
