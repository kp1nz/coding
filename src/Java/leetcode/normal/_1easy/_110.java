package Java.leetcode.normal._1easy;

/**
 * @Author: kp1nz
 * @Date: 2020/8/17 2:27 下午
 */
public class _110 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    boolean res = true;

    public boolean isBalanced(TreeNode root) {
        execNode(root);
        return res;
    }

    private int execNode(TreeNode root) {
        if (root == null) return 0;
        int left = execNode(root.left) + 1;
        int right = execNode(root.right) + 1;
        if (Math.abs(left - right) > 1) res = false;
        return Math.max(left, right);
    }
}
