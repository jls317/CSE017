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

public class Prog3 {

    public static void main(String[] args) {
        String line;
        StringBuilder sb = new StringBuilder();
        String[] gettysArray = new String[10000];
        int i = 0;
        try {
            BufferedReader in
                    = new BufferedReader(new FileReader(args[0]));

            while ((line = in.readLine()) != null) {

                sb.append(line);
                sb.append(' ');
                gettysArray[i] = line.trim();
                i++;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        String gettysburg = sb.toString();

        Text gettysText = new Text(gettysburg);

        DaleChall DC1 = new DaleChall(gettysText, "Dale-ChallWordList.txt");

        double RawScore = DC1.calcReadingEase(gettysText);
        double printRaw = (double) ((int) (RawScore * 10)) / 10;
        System.out.println("Raw Score: " + printRaw);
        System.out.println("Grade Level: " + gradeLevel(RawScore));

    }

    public static String gradeLevel(double RawScore) {
        if (RawScore < 5) {
            return "Grade 4 and below.";
        }
        if (5 <= RawScore && RawScore < 6) {
            return "Grades 5-6";
        }
        if (6 <= RawScore && RawScore < 7) {
            return "Grades 7-8";
        }
        if (7 <= RawScore && RawScore < 8) {
            return "Grades 9-10";
        }
        if (8 <= RawScore && RawScore < 9) {
            return "Grades 11-12";
        }
        if (9 <= RawScore && RawScore < 10) {
            return "Grades 13-15 (college)";
        }
        if (10 <= RawScore) {
            return "Grades 16 and above.";
        }
        return "Inconclusive.";
    }

}
