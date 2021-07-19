package Java.leetcode.normal._2mid;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 *
 * @Author: kp1nz
 * @Date: 2021/7/15 10:32 AM
 */
public class _19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) return null;
        ListNode dummy = new ListNode(-1, head);
        ListNode s = dummy;
        ListNode e = head;
        for (int i = 0; i < n; i++) {
            e = e.next;
        }
        while (e != null) {
            s = s.next;
            e = e.next;
        }
        s.next = s.next.next;
        return dummy.next;
    }

    //Definition for singly-linked list.
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
