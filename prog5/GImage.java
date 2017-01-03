
package prog5;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

public class GImage {
    private BufferedImage buffImage;
    private Color colorInt;
    private int[][] grayArray;
    private char[] symbols= {'@','%','#','*','+','=','-',':','.',' '};
    
    public GImage(BufferedImage image){
        this.buffImage=image;
    }
    private void convertToGray(){
        grayArray= new int[buffImage.getHeight()][buffImage.getWidth()];
        for(int i = 0 ; i<buffImage.getHeight(); i++){
            for(int j=0 ; j<buffImage.getWidth(); j++){
                colorInt=new Color(buffImage.getRGB(i,j));
                int red = colorInt.getRed();
                int blue = colorInt.getBlue();
                int green= colorInt.getGreen();
                int gray = (red+blue+green)/3;
                grayArray[i][j]=gray;
            }
        }
    }
    public char[][] convertToChars(){
        
        convertToGray();
        
        char[][] pixelChars= new char[buffImage.getHeight()][buffImage.getWidth()];
        for(int i = 0 ; i<buffImage.getHeight(); i++){
            for (int j=0 ; j<buffImage.getWidth(); j++){
                pixelChars[i][j]=symbols[(int)(((grayArray[i][j]))/25.51)];
            }
        }
        return pixelChars;
    }
}
