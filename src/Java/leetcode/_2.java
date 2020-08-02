package Java.leetcode;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * @Author: kp1nz
 * @Date: 2020/8/2 9:16 下午
 */
public class _2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int sum = v1 + v2 + carry;
            carry = sum > 9 ? 1 : 0;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1) cur.next = new ListNode(carry);
        return pre.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int x, ListNode n) {
            val = x;
            next = n;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        System.out.println(addTwoNumbers(l1, l2).val);
        System.out.println(addTwoNumbers(l1, l2).next.val);
        System.out.println(addTwoNumbers(l1, l2).next.next.val);
    }

}
