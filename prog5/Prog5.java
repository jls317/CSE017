/*
 Jeffrey Stewart
 Prog5
 CSE17
 02/26/15
 JLS317
 Purpose:  
 */
package prog5;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import static javax.imageio.ImageIO.read;


public class Prog5 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        System.out.print("Please enter the image URL: ");
        String input = scanner.next();
        BufferedImage image = null;
        char[][] imageSymbols;
        try{
            if("http:".equals(input.substring(0,5))||"https:".equals(input.substring(0,6))){
                URL address = new URL(input);
                image= read(address);
            }
            else{
                File badAddress = new File (input);
                image= read(badAddress);
            }
            
        }
        catch(IllegalArgumentException ex){
            System.out.println("You did not enter a valid URL or file path. Try Again.");
        }
        catch(IOException ex){
            System.out.println("You did not enter a valid URL or file path. Try Again.");
        }
        catch(StringIndexOutOfBoundsException ex){
            System.out.println("You did not enter a valid URL or file path.");
        }
        GImage myImage= new GImage(image);
        imageSymbols=myImage.convertToChars();
        for(int i = 0; i<imageSymbols.length; i++){
            for(int j=0 ; j<imageSymbols[i].length; j++){
                System.out.print(imageSymbols[j][i]);
            }
            System.out.println("");
        }
    }
    
}
