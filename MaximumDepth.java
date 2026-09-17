public class MaximumDepth {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftH = maxDepth(root.left);
        int rightH = maxDepth(root.right);

        return Math.max(leftH, rightH) + 1;
    }

    public static void main(String[] args) {

        /*
                 1
                / \
               2   3
              / \
             4   5
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Maximum Depth: " + maxDepth(root));
    }
}