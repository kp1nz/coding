package Java.leetcode;

import others.FindKthToTail.ListNode;

import java.util.ArrayList;

/**
 * @Author: kp1nz
 * @Date: 2020/8/18 2:08 下午
 */
public class _109 {

    // 中序遍历还原BST
    public TreeNode sortedListToBST(ListNode head) {
        return buildTreeNode(head, null);
    }


    /**
     * 快慢指针
     *
     * @param head 头节点
     * @param end  尾节点的后一个节点
     */
    private TreeNode buildTreeNode(ListNode head, ListNode end) {
        if (head == end) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != end && fast.next != end) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = buildTreeNode(head, slow);
        root.right = buildTreeNode(slow.next, end);
        return root;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public class TreeNode {
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
}
