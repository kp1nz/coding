package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author kp1nz
 * @create 2019-04-02 19:36
 */
public class Main {


        static class ListNode {
            int val;
            ListNode next;
            ListNode(int x) { val = x; }
        }

        static ListNode mergeKLists(ListNode[] lists) {
            ListNode listNode =null;
            for (int i=0;i<lists.length;i++){
                 listNode= new ListNode(lists[i].val);
            }
            return listNode;
        }

        static ListNode string2ListNode(String str) {
            StringTokenizer token = new StringTokenizer(str, ",");
            ListNode head, foot;
            head = foot = new ListNode(0);
            while(token.hasMoreTokens()) {
                int val = Integer.parseInt(token.nextToken());
                foot = foot.next = new ListNode(val);
            }
            return head.next;
        }

        static String listNode2String(ListNode listNode) {
            StringBuilder result = new StringBuilder();
            while (listNode != null) {
                result.append(listNode.val).append(",");
                listNode = listNode.next;
            }
            if (result.length() > 0) {
                result.setLength(result.length() - 1);
            }
            return result.toString();
        }

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            List<ListNode> list = new ArrayList<>();
            while (input.hasNext()) {
                list.add(string2ListNode(input.next()));
            }
            ListNode[] listNode = list.toArray(new ListNode[list.size()]);
            System.out.print(listNode2String(mergeKLists(listNode)));
        }


}
