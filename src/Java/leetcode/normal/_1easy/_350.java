package Java.leetcode.normal._1easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 350. 两个数组的交集 II
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * @Author: kp1nz
 * @Date: 2021/7/27 10:16 AM
 */
public class _350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> n1 = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            n1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (n1.contains(nums2[i])){
                res.add(nums2[i]);
                n1.remove((Object)nums2[i]);
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        _350 v = new _350();
        int[] intersect = v.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
        for (int i = 0; i < intersect.length; i++) {
            System.out.println(intersect[i]);
        }
    }
}
