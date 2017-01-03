//Jeffrey Stewart
//CSE17
//Prog10
//BinaryTreeConverter
//Converts an infix statement into a binary tree.
//Prints out the infix, tree, inorder, preorder, and post order
//as well as the final result of the statement.
package prog10;

public class Node {

    private String val;
    private Node left;
    private Node right;

    public String getVal() {
        return val;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public Node(String val) {
        this.val = val;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        return toString0(this);
    }

    public String toString0(Node node) {
        String out = "";
        if (node == null) {
            return "";
        }
        if (node.getVal().equals("*") || node.getVal().equals("/") || node.getVal().equals("+") || node.getVal().equals("-")) {
            out += node.getVal() + '(' + node.getLeft().toString() + ',' + node.getRight().toString() + ')';
        } else {
            out += node.getVal();
        }

        return out;
    }
}
