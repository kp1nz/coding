package others;


/**
 * @author kp1nz
 * @create 2019-04-25 12:47
 */
public class FindKthToTail {
    /**
     * 单链表结点的类
     * 为了简化访问，属性设置问公有的
     */
    public static class ListNode {
        public int data; // 存放数据的属性
        public ListNode next; //指向下一个节点
    }

    /**
     * 查找链表中倒数第k个结点
     */
    public static class Main {

        // 查找链表中倒数第k个结点
        public static ListNode CountdownKListNode(ListNode head, int k) {
            // 判断链表是否为空以及k是否为小于0的数
            if (head == null || k < 0) { // 链表不能为空，查找的倒数第k个结点k不能小于0
                return null;
            }
            // 开始时声明两个结点使其都指向头结点
            ListNode aNode = head;
            ListNode bNode = head;
            // 使aNode达到第k个结点
            for (int i = 0; i < k - 1; i++) {
                if (aNode.next != null)
                    aNode = aNode.next;
                else {
                    return null; // 链表太短，打不到k个结点
                }
            }
            while (aNode.next != null) {
                aNode = aNode.next;
                bNode = bNode.next;
            }
            return bNode; // bNode即为倒数第k个结点
        }
    }

    public static void main(String[] args) {
        /**
         * 测试求链表中倒数第k个结点
         */
        ListNode ln1 = new ListNode();
        ListNode ln2 = new ListNode();
        ListNode ln3 = new ListNode();
        ListNode ln4 = new ListNode();
        ListNode ln5 = new ListNode();
        ListNode ln6 = new ListNode();
        ListNode ln7 = new ListNode();
        ListNode ln8 = new ListNode();
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        ln5.next = ln6;
        ln6.next = ln7;
        ln7.next = ln8;
        ln8.next = null;
        ln1.data = 1;
        ln2.data = 2;
        ln3.data = 3;
        ln4.data = 4;
        ln5.data = 5;
        ln6.data = 6;
        ln7.data = 7;
        ln8.data = 8;

        Main m1 = new Main();
        ListNode kListNode = Main.CountdownKListNode(ln1, 3);
        System.out.println(kListNode.data);

    }
}
