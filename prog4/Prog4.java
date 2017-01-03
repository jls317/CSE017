/*
 Jeffrey Stewart
 Prog4
 CSE17
 02/18/15
 JLS317
 Purpose: To create a word search given the order (size) and
the fileName.txt from command line arguments. 
 */


package prog4;

import java.util.Scanner;

public class Prog4 {

    public static void main(String[] args) {
        int order = 0;
        String fileName = null;
        if (args.length < 2) {
            System.out.println("Usage: wordsearch <order> <wordfilename>");
            return;
        } else {
            try {
                order = Integer.parseInt(args[0]);
            } catch (Exception ex) {
                System.out.println("Invalid order: " + args[0]);
                return;
            }
            fileName = args[1];
        }
        Puzzle puzzle = new Puzzle(order, fileName);
        if (puzzle.createPuzzle()) {
            puzzle.display();
            puzzle.fillRandom();
            puzzle.display();
        } else {
            System.out.println("Can't create puzzle.");
        }
    }
}
