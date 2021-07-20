package Java.leetcode.normal._4unsorted;

/**
 * @author kp1nz
 * @create 2019-04-12 15:50
 */
public class AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(-1);
            ListNode p1 = l1, p2 = l2;
            ListNode p3 = dummyHead;
            int carry = 0;
            while (p1 != null || p2 != null) {
                int v1 = p1 == null ? 0 : p1.val;
                int v2 = p2 == null ? 0 : p2.val;
                p3.next = new ListNode((carry + v1 + v2) % 10);//当前位的值
                carry = (v1 + v2 + carry) / 10;
                p3 = p3.next;
                if (p1 != null) p1 = p1.next;
                if (p2 != null) p2 = p2.next;
            }
            if (carry != 0) p3.next = new ListNode(carry);//最后别忘了进位
            return dummyHead.next;
        }
    }
}
