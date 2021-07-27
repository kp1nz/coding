package Java.leetcode.normal._2mid;

/**
 * @Author: kp1nz
 * @Date: 2020/8/2 5:53 下午
 */
public class _114 {

    public static void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        // 暂存右子树
        TreeNode temp = root.right;
        // 左子树移到右子树
        root.right = root.left;
        root.left = null;
        // 接右子树
        while (root.right!= null){
            root = root.right;
        }
        root.right = temp;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));
        flatten(treeNode);
        System.out.println(treeNode.right.val);
        System.out.println(treeNode.right.right.val);
        System.out.println(treeNode.right.right.right.val);
        System.out.println(treeNode.right.right.right.right.val);
        System.out.println(treeNode.right.right.right.right.right.val);
    }
}
