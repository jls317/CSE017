
package prog7;

public class HitTil21Player extends Player{

    public HitTil21Player(String name) {
        super(name);
    }

    @Override
    public int nextAction() {
        if(hand.hardValue()<21 && hand.softValue() <21){
            return HIT;
        }
        else{
            return STAY;
        }
    }
    
}
