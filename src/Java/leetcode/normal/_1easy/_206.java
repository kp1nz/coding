package Java.leetcode.normal._1easy;

import java.util.Stack;

/**
 * 206. 反转链表
 *
 * @Author: kp1nz
 * @Date: 2021/7/20 5:16 PM
 */
public class _206 {

    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode dummyNode = new ListNode();
        ListNode currentNode = dummyNode;
        Stack<Integer> ints = new Stack<>();
        while (head != null) {
            ints.push(head.val);
            head = head.next;
        }
        while (!ints.isEmpty()){
            currentNode.next = new ListNode(ints.pop());
            currentNode = currentNode.next;
        }
        return dummyNode.next;
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
}
