package Java.leetcode.mst;

/*
 * 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
 * 摩尔投票问题
 * 
 * @Author: kp1nz
 * @Date: 2021-07-09 16:16:46
 */
public class mst17_10 {
    public static int majorityElement(int[] nums) {
        int x = -1;
        int count = 0;
        for (int i : nums) {
            if (count == 0) {
                x = i;
                count = 1;
            } else {
                count += x == i ? 1 : -1;
            }
        }
        System.out.print(x);
        System.out.print(count);
        count = 0;
        for (int i : nums) {
            if (x == i) {
                count++;
            }
        }
        return count > nums.length / 2 ? x : -1;
    }

    public static int trySolve(int[] nums) {
        int x = -1;
        int count = 0;
        int def = 0;
        for (int a = 0; a < nums.length; a++) {
            if (count == 0) {
                x = nums[a];
                count = 1;
            } else {
                if (nums[a] == x) {
                    count++;
                } else {
                    //[3,2,3]这种情况def的计算会有误
                    def++;
                    count--;
                    if (count == 0) {
                        x = nums[a];
                        count = 1;
                    }
                }
            }
        }
        System.out.println("def"+def);
        System.out.println("x"+x);
        System.out.println("count"+count);
        count -= def;
        System.out.println("acount"+count);
        if(count > 0){
            return x;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] a =new int[] { 3, 2, 3};
        System.out.println(majorityElement(a));
        System.out.println("-----");
        System.out.println(trySolve(a));
    }
}
