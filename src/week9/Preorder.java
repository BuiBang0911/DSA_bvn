package week9;

import java.util.*;

class Nodee {
    Nodee left;
    Nodee right;
    int data;

    Nodee(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Preorder {

/* you only have to complete the function given below.
Node is defined as

class Node {
    int data;
    Node left;
    Node right;
}

*/

    public static void preOrder(Nodee root) {
        System.out.print(root.data + " ");
        if (root.left != null) {
            preOrder(root.left);
            if (root.right != null) {
                preOrder(root.right);
            }
        } else {
            if (root.right != null) {
                preOrder(root.right);
            }
        }
    }

    public static Nodee insert(Nodee root, int data) {
        if(root == null) {
            return new Nodee(data);
        } else {
            Nodee cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Nodee root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        preOrder(root);
    }
}