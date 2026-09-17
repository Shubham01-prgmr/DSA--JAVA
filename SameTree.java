public class SameTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        // Both nodes are null
        if (p == null && q == null) {
            return true;
        }

        // One node is null
        if (p == null || q == null) {
            return false;
        }

        // Values are different
        if (p.val != q.val) {
            return false;
        }

        // Compare left subtrees
        boolean ans1 = isSameTree(p.left, q.left);

        // Compare right subtrees
        boolean ans2 = isSameTree(p.right, q.right);

        return ans1 && ans2;
    }

    public static void main(String[] args) {

        /*
            Tree 1:        Tree 2:

                1              1
               / \            / \
              2   3          2   3
        */

        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        System.out.println("Same Tree: " + isSameTree(p, q));
    }
}