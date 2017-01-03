package prog9;

import java.util.ArrayList;

public class Stack {

    private ArrayList myList = new ArrayList();

    public int getSize(){
        return myList.size();
    }
    
    public boolean isEmpty() {
        return myList.isEmpty();
    }

    public Object push(Object obj) {
        myList.add(obj);
        return obj;
    }

    public Object pop() {
        Object obj = myList.get(myList.size() - 1);
        myList.remove(obj);
        return obj;
    }

    public Object peek() {
        return myList.get(myList.size() - 1);
    }

}
