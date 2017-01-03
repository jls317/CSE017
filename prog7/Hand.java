
package prog7;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    int cardCount = 0;
    List<Card> cards= new ArrayList<>();
    int[] cardVals = {2,3,4,5,6,7,8,9,10,10,10,10,1};
    public Hand(){
    }

    public int hardValue(){
        int hardValue=0;
        for(int i = 0 ; i < cards.size() ; i++){
            int cardValue = cardVals[(cards.get(i)).getRank()];
            if(cardValue==1){
                hardValue+= 1 ;
            }
            else{
                hardValue+= cardValue;
            }
        }
        return hardValue;
    }
    
    public int softValue(){
        int softValue=0;
        for(int i = 0 ; i < cards.size() ; i++){
            int cardValue = cardVals[(cards.get(i)).getRank()];
            if(cardValue == 1){
                softValue+=11;
            }
            else{
                softValue+= cardValue;
            }
        }
        return softValue;
    }
    
    public void acceptCard(Card c){
        try{
            if(c==(null)){
                throw new IllegalArgumentException();
            }
            else{
                cards.add(c);
            }
        }
        catch(IllegalArgumentException ex){
            System.out.println("Card cannot be null.");
        }
    }
    
    @Override
    public String toString() {
        String display = "";
        for (int w = 0; w < cards.size(); w++) {
            display += cards.get(w).toString() + " ";
        }
        return display;
    }
}
