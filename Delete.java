package BinarySearchTrees;

import BinarySearchTrees.BuildBST.Node;

public class Delete {
    public static Node Del(Node root,int val){
        
        if(root.data > val){
            root.left = Del(root.left, val);
        }
        else if(root.data<val){
           root.right  = Del(root.right, val);
        }
        else{
            if(root.left == null && root.right == null){  // 0 child
                return null;
            }
            if(root.right == null){
                return root.left;
            }
            else if(root.left == null){
                return root.right;
            }
            Node IS = findSuccess(root.right);
            root.data = IS.data;
            root.right = Del(root.right,IS.data);
        }
     return root;

    }
    public static Node findSuccess(Node root){
        while(root!=null){
            root = root.left;
        }
        return root;
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
    public static void Inorder(Node root) {
            if (root == null) {
                return;
            }
            Inorder(root.left);
            System.out.print(root.data + " ");
            Inorder(root.right);

        }
    public static void main(String[] args) {
        int values[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        Inorder(root);
        System.out.println();

        root = Del(root,1);
        Inorder(root);
    }
}
