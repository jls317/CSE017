package prog4;

public class Puzzle {

    private char[][] wordSearch;
    private String fileName;
    private int order;
    private final char BLANK = '*';
    private final int[] colMove = {1, 1, 0, -1, -1, -1, 0, 1};
    private final int[] rowMove = {0, 1, 1, 1, 0, -1, -1, -1};
    private int[] direction = {0, 1, 2, 3, 4, 5, 6, 7};

    public Puzzle(int order, String fileName) {
        this.order = order;
        this.fileName = fileName;
        wordSearch = new char[order][order];
        for (int i = 0; i < order; i++) {
            for (int j = 0; j < order; j++) {
                wordSearch[i][j] = BLANK;
            }
        }
    }

    private int pickRow() {
        return (int) (Math.random() * order);
    }

    private int pickCol() {
        return (int) (Math.random() * order);
    }

    private boolean check(Word word, int row, int col, int dir) {
        boolean space;
        int wordLength = word.getWord().length();
        space = checkSpace(word, row, col, dir);
        if (space) {
                for (int i = 0; i < (wordLength); i++) {
                    if ((wordSearch[row + i * rowMove[dir]][col + i * colMove[dir]]) != '*') {
                        return false;
                    }
                }
                return true;               
        }
        else{return false;}       
    }

    private boolean checkSpace(Word word, int row, int col, int dir) {
        int wordLength = word.getWord().length();

        if ((0 <= row + ((rowMove[dir]) * wordLength)) && (row + (rowMove[dir] * wordLength) <= order)) {
            if ((0 <= col + ((colMove[dir]) * wordLength)) && (col + (colMove[dir] * wordLength) <= order)) {
                return true;
            }
        }
        return false;
    }

    private void place(Word word, int row, int col, int dir) {
        int wordLength = word.getWord().length();

        for (int i = 0; i < (wordLength); i++) {
            wordSearch[row + i * rowMove[dir]][col + i * colMove[dir]] = word.getWord().charAt(i);
        }
    }

    private boolean attemptPlaceWord(Word word) {
        int numTries = 0;
        int[] dir = new int[8];
        boolean x = true;
        while (x) {
            int col = pickCol();
            int row = pickRow();
            dir = getRandomDirection();

            for (int i = 0; i < 8; i++) {
                if (check(word, row, col, dir[i])) {
                    place(word, row, col, dir[i]);
                    display();
                    return true;
                }
            }
            numTries++;
            if (numTries > ((order * order) + order)) {
                System.out.println("Tries Exceeded. No Solution Found.");
                return false;
            }

        }
        return false;
    }

    private int[] getRandomDirection() {
        int[] array = new int[8];
        int[] randDir = new int[8];
        for (int i = 0; i < 8; i++) {
            int Dir = (int) (Math.random() * 8);
            randDir[i] = Dir;
            for (int j = 0; j < i; j++) {
                if (randDir[j] == randDir[i]) {
                    i--;
                    break;
                }
            }
        }
        return randDir;
    }

    public void fillRandom() {
        char[] ABC = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        for (int i = 0; i < order; i++) {
            for (int j = 0; j < order; j++) {
                if (wordSearch[i][j] == '*') {
                    int ABCRank = (int) (Math.random() * 26);
                    wordSearch[i][j] = ABC[ABCRank];
                }
            }
        }
    }

    public void display() {
        for (int i = 0; i < order; i++) {
            for (int j = 0; j < order; j++) {
                System.out.print(wordSearch[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public boolean createPuzzle() {
        WordList listOfWords = new WordList(fileName);
        int listLength = listOfWords.getList().length;
        if (listOfWords.readFile()) {
            listOfWords.readFile();
            Word[] word = listOfWords.getList();

            for (int i = 0; i < listLength; i++) {

                if (!attemptPlaceWord(word[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
