package BinarySearchTrees;
public class ValidateBST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }
    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }
    public static boolean SEARCH(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        if (root.data > key) {
            return SEARCH(root.left, key);
        } else {
            return SEARCH(root.right, key);
        }
    }
    public static boolean Validate(Node root,Node min,Node max){
        if(root == null){
            return true;
        }
        if(min!=null && min.data>=root.data){
            return false;
        }
        else if(max!=null && max.data <= root.data){
            return false;
        }
        return (Validate(root.left, min, root) && Validate(root.right, root, max));
    }

    public static void main(String[] args) {
        int values[] = { 1,1,1,1,1,2 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
     
        if(Validate(root, null, null)){
            System.out.println("Valid");
        }
        else{
            System.out.println("Not Valid");
        }
    }
}
