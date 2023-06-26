package BinarySearchTrees;
import BinarySearchTrees.BuildBST.Node;
public class RangePrint {
   
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
    public static void Range(Node root,int k1,int k2){
        if(root==null){
            return;
        }
        if(root.data>=k1 && root.data<=k2){
            Range(root.left,k1,k2);
            System.out.println(root.data+"");
            Range(root.right, k1, k2);
        }
        else if(root.data<k1){
            Range(root.left, k1, k2);
        }
        else{
            Range(root.right, k1, k2);
        }
    }
    public static void main(String[] args) {
        int values[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        Inorder(root);
        System.out.println();
        Range(root, 5, 10);
    }
}
