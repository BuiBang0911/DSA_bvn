package week9;

import java.util.*;

class Nodeee {
    Nodeee left;
    Nodeee right;
    int data;

    Nodeee(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class LevelOrder {

    /*

    class Node
        int data;
        Node left;
        Node right;
    */
    public static void levelOrder(Nodeee root) {
        Queue<Nodeee> queue = new LinkedList<>();
        if(root!=null){
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            Nodeee p=queue.poll();
            System.out.print(p.data + " ");
            if(p.left!=null) queue.add(p.left);
            if(p.right!=null) queue.add(p.right);
        }

    }

    public static Nodeee insert(Nodeee root, int data) {
        if(root == null) {
            return new Nodeee(data);
        } else {
            Nodeee cur;
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
        Nodeee root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }
}
