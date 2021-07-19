package Java.leetcode.normal._2mid;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 *
 * @Author: kp1nz
 * @Date: 2021/7/19 5:36 PM
 */
public class _116 {
    public Node connect(Node root) {
        if (root == null)
            return null;
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }
        root.left = connect(root.left);
        root.right = connect(root.right);
        return root;
    }


    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;
}
