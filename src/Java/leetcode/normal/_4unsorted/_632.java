package Java.leetcode.normal._4unsorted;


import java.util.*;

/**
 * @Author: kp1nz
 * @Date: 2020/8/1 9:26 下午
 */
public class _632 {

    public static int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();
        int inf = (int)Math.pow(10,6);
        int max = -inf;
        int st = -inf;
        int ed = inf;
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.v,o2.v));

        for (int i = 0; i < n; i++) {
            int value = nums.get(i).get(0);
            priorityQueue.offer(new Node(i,0,value));
            max = Math.max(max,value);
        }

        while (priorityQueue.size() == n){
            Node poll = priorityQueue.poll();
            int i = poll.i;
            int j = poll.j;
            int v = poll.v;

            if (max - v < ed -st){
                st = v;
                ed = max;
            }

            if (j + 1 < nums.get(i).size()){
                Integer nv = nums.get(i).get(j + 1);
                priorityQueue.offer(new Node(i,j+1,nv));
                max = Math.max(max,nv);
            }
        }
        return new int[]{st,ed};
    }

    static class Node{
        int i,j,v;

        public Node(int i, int j, int v) {
            this.i = i;
            this.j = j;
            this.v = v;
        }
    }


    public static void main(String[] args) {

        List<Integer> a = Arrays.asList(4, 10, 15, 24, 26);
        List<Integer> b = Arrays.asList(0, 9, 12, 20);
        List<Integer> c = Arrays.asList(5, 18, 22, 30);
        List<List<Integer>> nums =
                (new ArrayList<>(Arrays.asList(a,b,c)));

        System.out.println(smallestRange(nums)[0]);
        System.out.println(smallestRange(nums)[1]);
    }
}
