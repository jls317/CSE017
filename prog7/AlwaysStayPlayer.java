
package prog7;

public class AlwaysStayPlayer extends Player {

    public AlwaysStayPlayer(String name) {
        super(name);
    }

    @Override
    public int nextAction() {
        return STAY;
    }
    
}
