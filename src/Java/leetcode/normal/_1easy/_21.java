package Java.leetcode.normal._1easy;

import java.util.List;

/**
 * 21. 合并两个有序链表
 * @Author: kp1nz
 * @Date: 2021/7/20 5:00 PM
 */
public class _21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode();
        ListNode currentNode = dummyNode;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val) {
                currentNode.next = l1;
                l1 = l1.next;
            }else {
                currentNode.next = l2;
                l2 = l2.next;
            }
            currentNode = currentNode.next;
        }
        if (l1 == null){
            currentNode.next = l2;
        }else {
            currentNode.next = l1;
        }
        return dummyNode.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
