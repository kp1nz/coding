package Java.leetcode.normal._1easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 217. 存在重复元素
 * 示例 1:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: true
 *
 * @Author: kp1nz
 * @Date: 2021/7/26 5:05 PM
 */
public class _217 {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (null == map.get(nums[i])) {
                map.put(nums[i], false);
            } else {
                map.put(nums[i], true);
            }
        }
        for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
            if (entry.getValue())
                return true;
        }
        return false;
    }

    public boolean containsDuplicate1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!set.add(nums[i])){
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        return IntStream.of(nums).distinct().count() != nums.length;
    }

}
