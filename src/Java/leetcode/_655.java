package Java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入:
 * 1
 * /
 * 2
 * 输出:
 * [["", "1", ""],
 * ["2", "", ""]]
 * <p>
 * <p>
 * 输入:
 * 1
 * / \
 * 2   3
 * \
 * 4
 * 输出:
 * [["", "", "", "1", "", "", ""],
 * ["", "2", "", "", "", "3", ""],
 * ["", "", "4", "", "", "", ""]]
 *
 * 执行用时：
 * 1 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：39.9 MB, 在所有 Java 提交中击败了68.84%的用户
 *
 * @Author: kp1nz
 * @Date: 2020/8/20 18:48
 */
public class _655 {

    static int nowDepth = 1;
    static int len;
    // length : pow(2,n)-1
    static int depth;

    public static List<List<String>> printTree(TreeNode root) {
        depth = calcDepth(root);
        len = (1 << depth) - 1;
        List<List<String>> res = new ArrayList<>(depth);
        // 构建二叉树
        for (int i = 0; i < depth; i++) {
            List<String> h = new ArrayList<>(len);
            for (int j = 0; j < len; j++) {
                h.add("-");
            }
            res.add(h);
        }
        execTree(root, res, len / 2);
        return res;
    }

    private static void execTree(TreeNode root, List<List<String>> res, int index) {
        if (root == null)
            return;
        res.get(nowDepth - 1).set(index, String.valueOf(root.val));
        // 与中点的绝对距离
        int n = 1 << (depth - nowDepth - 1);
        // 进入递归前先处理深度
        nowDepth++;
        execTree(root.left, res, index - n);
        execTree(root.right, res, index + n);
        nowDepth--;
    }

    private static int calcDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(calcDepth(root.left), calcDepth(root.right)) + 1;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int x, TreeNode l, TreeNode r) {
            val = x;
            left = l;
            right = r;
        }
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3));
//        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), null), null), new TreeNode(5));
        TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(6, null, new TreeNode(7)));
        System.out.println("dep:" + calcDepth(root));
        List<List<String>> lists = printTree(root);
        lists.forEach(a -> System.out.println(a.toString()));
    }
}