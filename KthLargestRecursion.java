import java.util.*;
public class KthLargestRecursion {
    
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void kthLevel(TreeNode root, int level, int k) {
        if(root == null){
            return;
        }
        if(level == k){
            System.out.print(root.val + " ");
            return;
        }
        kthLevel(root.left, level+1, k);
        kthLevel(root.right, level+1, k);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(6);

        root.left.left.left = new TreeNode(7);

        int k = 2;

        kthLevel(root, 0, k);
    }
}
