package BinarySearchTrees;

public class MirrorBST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void Preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data + "");
        Preorder(root.left);
        Preorder(root.right);

    }

    public static Node Mirror(Node root) {
        if (root == null) {
            return null;
        }
        Node leftMirror = Mirror(root.left);
        Node rightMirror = Mirror(root.right);

        root.left = rightMirror;
        root.right = leftMirror;
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.right = new Node(7);
        root.left = new Node(2);
        root.left.right = new Node(3);
        root.left.left = new Node(1);
        root.right.right = new Node(9);
        root.right.left = new Node(6);
        Preorder(root);
        System.out.println();
        root = Mirror(root);
        Preorder(root);
    }
}
