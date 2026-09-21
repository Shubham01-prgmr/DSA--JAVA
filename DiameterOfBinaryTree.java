public class DiameterOfBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int diameterOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftD = diameterOfBinaryTree(root.left);
        int leftH = height(root.left);

        int rightD = diameterOfBinaryTree(root.right);
        int rightH = height(root.right);

        int selfD = leftH + rightH;

        return Math.max(selfD, Math.max(rightD, leftD));
    }

    public static int height(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh) + 1;
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

        System.out.println(
            "Diameter: " + diameterOfBinaryTree(root)
        );
    }
}