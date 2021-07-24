package Java.leetcode.normal._2mid;

/**
 * 138. 复制带随机指针的链表
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * @Author: kp1nz
 * @Date: 2021/7/22 7:59 PM
 */
public class _138 {

    public Node copyRandomListBetter(Node head){
        if (head == null) return null;
        Node dummy = new Node(-1);
        dummy.next = head;
        while (head != null) {
            Node node = new Node(head.val);
            node.next = head.next;
            head.next = node;
            head = node.next;
        }
        head = dummy.next;
        while (head != null) {
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
        head = dummy.next;
        Node ans = head.next;
        while (head != null) {
            Node tmp = head.next;
            if (head.next != null) head.next = head.next.next;
            head = tmp;
        }
        return ans;
    }

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node dummy = new Node(0);
        dummy.next = head;
        // 先复制一份在原链表上
        while (head != null) {
            Node tmp = new Node(head.val);
            tmp.next = head.next;
            head.next = tmp;
            head = head.next.next;
        }
        // 给random赋值
        Node fillRandom = dummy.next;
        while (fillRandom != null) {
            if (fillRandom.random != null)
                fillRandom.next.random = fillRandom.random.next;
            fillRandom = fillRandom.next.next;
        }
        // 拆分链表
        Node current = dummy.next;
        while (current != null) {
            if (current.next != null)
                current = current.next;
            current = current.next;
        }
        return dummy;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
        public Node(int val,Node next, Node random){
            this.val = val;
            this.next = next;
            this.random = random;
        }
    }

    public static void main(String[] args) {
        _138 v = new _138();
    }
}
