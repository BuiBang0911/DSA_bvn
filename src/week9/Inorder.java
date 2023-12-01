package week9;

import java.util.*;

class Node {
    Nodee left;
    Nodee right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

/* you only have to complete the function given below.
Node is defined as

class Node {
    int data;
    Node left;
    Node right;
}

*/

    public static void inOrder(Nodee root) {
        if (root.left != null) {
            //System.out.println(root.data);
            inOrder(root.left);
            System.out.print(root.data + " ");
            if (root.right != null) {
                inOrder(root.right);
            }
            //else System.out.print(root.data + " ");
        } else {
            System.out.print(root.data + " ");
            if (root.right != null) {
                inOrder(root.right);
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
        inOrder(root);
    }
}
