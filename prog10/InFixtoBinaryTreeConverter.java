//Jeffrey Stewart
//CSE17
//Prog10
//BinaryTreeConverter
//Converts an infix statement into a binary tree.
//Prints out the infix, tree, inorder, preorder, and post order
//as well as the final result of the statement.
package prog10;

import java.util.LinkedList;

public class InFixtoBinaryTreeConverter {

    private final LinkedList<String> infix;
    private final Stack stack;
    private final Stack btstack;
    private String expression;
    String out = null;
    Node root;

    public InFixtoBinaryTreeConverter() {
        infix = new LinkedList<>();
        stack = new Stack();
        btstack = new Stack();
    }

    public void run(String string) {
        this.expression = string;
        System.out.println(expression);
        createInFix();
        createBinaryTree();
        System.out.println(root.toString());

        inorder(root);
        System.out.println();
        preorder(root);
        System.out.println();
        postorder(root);
        System.out.println();
        optimize(root);
        System.out.println(root.toString());

    }

    private void createInFix() {
        String[] buffer = expression.split("\\s+");
        for (int i = 0; i < buffer.length; i++) {
            infix.addLast(buffer[i]);
        }
    }

    private void createBinaryTree() {

        stack.push("(");
        infix.addLast(")");
        while (!infix.isEmpty()) {
            String read = infix.remove(0);
            if (isNumber(read)) {

                Node node = new Node(read);
                btstack.push(node);

            }
            if (isLParen(read)) {
                stack.push(read);
            }
            if (isOperator(read)) {

                while (isOperator((String) stack.peek())) {

                    if (isHigherPrecedence((String) stack.peek(), read)) {

                        String Op = (String) stack.pop();
                        Node right = (Node) btstack.pop();
                        Node left = (Node) btstack.pop();
                        Node newNode = new Node(Op);
                        newNode.setRight(right);
                        newNode.setLeft(left);
                        btstack.push(newNode);
                    } else if (isHigherPrecedence(read, (String) stack.peek())) {
                        String Op = read;
                        Node right = (Node) btstack.pop();
                        Node left = (Node) btstack.pop();
                        Node newNode = new Node(Op);
                        newNode.setRight(right);
                        newNode.setLeft(left);
                        btstack.push(newNode);
                    }
                }
                stack.push(read);
            }
            if (isRParen(read)) {

                while (isOperator((String) stack.peek())) {

                    String Op = (String) stack.pop();
                    Node right = (Node) btstack.pop();
                    Node left = (Node) btstack.pop();
                    Node newNode = new Node(Op);
                    newNode.setRight(right);
                    newNode.setLeft(left);
                    btstack.push(newNode);

                    if (isLParen((String) stack.peek())) {
                        stack.pop();
                        break;
                    }
                }
            }
        }

        root = (Node) btstack.pop();

    }

    public static boolean isNumber(String Num) {

        try {
            int num = Integer.parseInt(Num);
            return true;

        } catch (NumberFormatException e) {

            return false;
        }

    }

    private boolean isOperator(String Op) {
        if (Op.equals("*") || Op.equals("/") || Op.equals("+") || Op.equals("-")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isLParen(String LP) {
        if (LP.equals("(")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isRParen(String RP) {
        if (RP.equals(")")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isHigherPrecedence(String op1, String op2) {
        if (op1.equals("*") || op1.equals("/")) {
            return true;
        }
        if (op1.equals("+") || op1.equals("-")) {
            if (op2.equals("+") || op2.equals("-")) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Node optimize(Node node) {
        double finalNum;
        if (node == null || node.getLeft() == null || node.getRight() == null) {
            return null;
        } else {
            optimize(node.getLeft());
            optimize(node.getRight());
            double num1 = Double.parseDouble(node.getLeft().getVal());
            double num2 = Double.parseDouble(node.getRight().getVal());

            if (node.getVal().equals("*")) {
                finalNum = num1 * num2;
            } else if (node.getVal().equals("/")) {
                if (num2 == 0) {
                    System.out.println("Cannot Divide By 0");
                    return null;
                } else {
                    finalNum = num1 / num2;
                }
            } else if (node.getVal().equals("+")) {
                finalNum = num1 + num2;
            } else if (node.getVal().equals("-")) {
                finalNum = num1 - num2;
            } else {
                System.out.println("finalNum not initialized!");
                return null;
            } 
            String finalNumS = Double.toString(finalNum);
            node.setVal(finalNumS);

        }
        return null;
    }

    public void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.getLeft());
        System.out.print(node.getVal() + " ");
        inorder(node.getRight());
    }

    public void postorder(Node node) {
        if (node == null) {
            return;
        }
        postorder(node.getLeft());
        postorder(node.getRight());
        System.out.print(node.getVal() + " ");
    }

    public void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getVal() + " ");
        preorder(node.getLeft());
        preorder(node.getRight());
    }
}
