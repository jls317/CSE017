//Jeffrey Stewart
//CSE17
//Prog10
//BinaryTreeConverter
//Converts an infix statement into a binary tree.
//Prints out the infix, tree, inorder, preorder, and post order
//as well as the final result of the statement.
package prog10;

import java.util.ArrayList;

public class Stack {

    private ArrayList myList = new ArrayList();

    public int getSize() {
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
