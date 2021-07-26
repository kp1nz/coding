package Java.leetcode.normal._1easy;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 136. 只出现一次的数字
 *
 * @Author: kp1nz
 * @Date: 2021/7/26 4:29 PM
 */
public class _136 {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (null == map.get(nums[i]))
                map.put(nums[i], false);
            else
                map.put(nums[i], true);
        }
        for(Map.Entry<Integer, Boolean> v : map.entrySet()){
            if (!v.getValue())
                return v.getKey();
        }
        return 0;
    }

    public int singleNumberBetter(int[] nums){
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                // 利用异或的特性：相同数异或等于0，即1^2^3^2^3 = 1
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(2^1);
        System.out.println(3^2);
        System.out.println(1^1);
        _136 v = new _136();
        System.out.println(v.singleNumberBetter(new int[]{2,1,5,5,1}));
    }
}
