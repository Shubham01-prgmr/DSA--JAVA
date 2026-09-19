public class MinDepth {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.left == null) {
            return minDepth(root.right) + 1;
        }

        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        int lh = minDepth(root.left);
        int rh = minDepth(root.right);

        return Math.min(lh, rh) + 1;
    }

    public static void main(String[] args) {

        /*
                 3
                / \
               9   20
                  /  \
                 15   7
        */

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Minimum Depth: " + minDepth(root));
    }
}