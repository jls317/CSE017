//Jeffrey Stewart
//CSE17
//Prog10
//BinaryTreeConverter
//Converts an infix statement into a binary tree.
//Prints out the infix, tree, inorder, preorder, and post order
//as well as the final result of the statement.
package prog10;

public class Prog10 {

    public static void main(String[] args) {
        InFixtoBinaryTreeConverter fp = new InFixtoBinaryTreeConverter();
        fp.run("( ( 6 + 2 ) - 5 ) * 8 / 2");
    }
}
