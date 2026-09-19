public class SymmetricTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isSymmetric(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        TreeNode p = root.left;
        TreeNode q = root.right;

        return helper(p, q);
    }

    public static boolean helper(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        boolean ans1 = helper(p.left, q.right);
        boolean ans2 = helper(p.right, q.left);

        return ans1 && ans2;
    }

    public static void main(String[] args) {

        /*
                 1
                / \
               2   2
              / \ / \
             3  4 4  3
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println("Symmetric: " + isSymmetric(root));
    }
}