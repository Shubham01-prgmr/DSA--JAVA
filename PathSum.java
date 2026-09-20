public class PathSum {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        int currSum = 0;

        return helper(root, targetSum, currSum);
    }

    public static boolean helper(TreeNode root, int targetSum, int currSum) {

        if (root == null) {
            return false;
        }

        currSum += root.val;

        if (root.left == null && root.right == null) {
            return currSum == targetSum;
        }

        boolean ans1 = helper(root.left, targetSum, currSum);
        boolean ans2 = helper(root.right, targetSum, currSum);

        return ans1 || ans2;
    }

    public static void main(String[] args) {

        /*
                  5
                 / \
                4   8
               /   / \
              11  13  4
             /  \      \
            7    2      1
        */

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;

        System.out.println(
            "Has Path Sum: " + hasPathSum(root, targetSum)
        );
    }
}