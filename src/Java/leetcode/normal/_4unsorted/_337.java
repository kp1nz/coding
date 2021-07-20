package Java.leetcode.normal._4unsorted;

import java.util.HashMap;

/**
 * @Author: kp1nz
 * @Date: 2020/8/5 11:27 下午
 */
public class _337 {

    // 偷父节点就不能偷子节点只能偷孙子节点
    // 最后取父节点和孙子节点和俩子节点的最大值
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int res = root.val;
        if (root.left != null) {
            res += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            res += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(res, rob(root.left) + rob(root.right));
    }

    // 缓存重复计算
    public int rob2(TreeNode root) {
        if (root == null) return 0;
        HashMap<TreeNode, Integer> cache = new HashMap<>();
        return getRes(root, cache);
    }

    private int getRes(TreeNode root, HashMap<TreeNode, Integer> cache) {
        if (cache.containsKey(root)) return cache.get(root);
        if (root == null) return 0;
        int res = root.val;
        if (root.left != null) {
            res += getRes(root.left.left, cache) + getRes(root.left.right, cache);
        }
        if (root.right != null) {
            res += getRes(root.right.left, cache) + getRes(root.right.right, cache);
        }
        int max = Math.max(res, getRes(root.left, cache) + getRes(root.right, cache));
        cache.put(root, max);
        return max;
    }

    // 二叉树深度=2 为一个子问题
    // 用长度为二的数组表述当前子问题结果
    // 对于当前父节点0表示不偷，1表示偷
    // 结果则为Math.max(res[0],res[1])
    public int rob3(TreeNode root) {
        return Math.max(getRes2(root)[0], getRes2(root)[1]);
    }

    private int[] getRes2(TreeNode root) {
        if (root == null) return new int[2];
        int[] res = new int[2];
        int[] rf = getRes2(root.left);
        int[] rr = getRes2(root.right);

        res[1] = rf[0] + rr[0] + root.val;
        // 当前节点不偷，结果为左右子树分别能偷到钱的和
        res[0] = Math.max(rf[0], rf[1]) + Math.max(rr[0], rr[1]);
        return res;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
