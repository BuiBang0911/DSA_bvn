package week10;

public class AVL {
    	/* Class node is defined as :
    class Node
    	int val;	//Value
    	int ht;		//Height
    	Node left;	//Left child
    	Node right;	//Right child

	*/

    public static Node insert(Node current, int val) {
        if (current == null) {
            Node node = new Node();
            node.ht = 0;
            node.val = val;
            return node;
        }
        if (val < current.val) {
            current.left = insert(current.left, val);
        } else if (val > current.val) {
            current.right = insert(current.right, val);
        } else {
            return current;
        }
        current.ht = Math.max(height(current.left), height(current.right)) + 1;
        int balance = balanceFactor(current);

        if (balance > 1 && val < current.left.val) {
            current = rotateRight(current);
        } else if (balance < -1 && val > current.right.val) {
            current = rotateLeft(current);
        } else if (balance > 1 && val > current.left.val) {
            current.left = rotateLeft(current.left);
            current = rotateRight(current);
        } else if (balance < -1 && val < current.right.val) {
            current.right = rotateRight(current.right);
            current = rotateLeft(current);
        }
        return current;
    }

    public static Node rotateRight(Node node) {
        Node temp = node.left;
        Node temp2 = temp.right;
        temp.right = node;
        node.left = temp2;
        node.ht = Math.max(height(node.left), height(node.right)) + 1;
        temp.ht = Math.max(height(temp.left), height(temp.right)) + 1;
        return temp;
    }

    public static Node rotateLeft(Node node) {
        Node temp = node.right;
        Node temp2 = temp.left;
        temp.left = node;
        node.right = temp2;
        node.ht = Math.max(height(node.left), height(node.right)) + 1;
        temp.ht = Math.max(height(temp.left), height(temp.right)) + 1;
        return temp;
    }

    public static int height(Node node) {
        if (node == null)
            return -1;
        else {
            return node.ht;
        }
    }

    public static int balanceFactor(Node node) {
        if (node == null) {
            return 0;
        } else {
            return (height(node.left) - height(node.right));
        }
    }
}
