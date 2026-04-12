import java.util.*;
public class Inorder {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> inorderTraversal(Node root){
        List<Integer> ans = new ArrayList<>();
        inOrder(root, ans);
        return ans;
    }
    public static void inOrder(Node root, List<Integer> ans){
        if(root == null){
            return;
        }       
        inOrder(root.left, ans);
        ans.add(root.data);
        inOrder(root.right, ans);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println(inorderTraversal(root));
    }
}
