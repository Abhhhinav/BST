package BinarySearchTrees;
public class Array2balBST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node CreateBST(int arr[], int st, int end) {
        if (st > end) {
            return null;
        }
        int mid = (st + end) / 2;
        Node root = new Node(arr[mid]);
        root.left = CreateBST(arr, st, mid - 1);
        root.right = CreateBST(arr, mid + 1, end);
        return root;
    }

    public static void Preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data + "");
        Preorder(root.left);
        Preorder(root.right);

    }
    public static void main(String[] args) {
        int arr[] = { 3, 5, 6, 8, 10, 11, 12 };
        Node root = CreateBST(arr, 0, arr.length - 1);
        Preorder(root);

    }
}