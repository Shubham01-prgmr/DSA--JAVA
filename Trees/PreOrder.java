import java.util.*;
public class PreOrder {
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
    
    public static List<Integer> preorderTraversal(Node root){
        List<Integer> ans = new ArrayList<>();
        preOrder(root, ans);
        return ans;
    }
    public static void preOrder(Node root, List<Integer> ans){
        if(root == null){
            return;
        }
        ans.add(root.data);
        preOrder(root.left, ans);
        preOrder(root.right, ans);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println(preorderTraversal(root));
    }
}
