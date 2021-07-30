package Java.leetcode.normal._2mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 15. 三数之和
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 *
 * @Author: kp1nz
 * @Date: 2021/7/28 6:25 PM
 */
public class _15 {
    // 超时。。
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        if (len < 3) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        for (int i = 0, j = i + 1, k = j + 1; i < len - 2; ) {
            // 第一个数大于 0，后面的数都比他大，肯定不成立了
            if (nums[i] > 0) break;
            if (nums[i] + nums[j] + nums[k] == 0
                    && (ans.size() == 0 || nums[j] != ans.get(ans.size() - 1).get(2))) {
                tmp.add(nums[i]);
                tmp.add(nums[j]);
                tmp.add(nums[k]);
                ans.add(tmp);
                tmp = new ArrayList<>();
            }
            if (j == len - 2) {
                i++;
                j = i + 1;
                k = i + 2;
                continue;
            }
            if (k == len - 1) {
                j++;
                k = j + 1;
                continue;
            }
            k++;
        }
        return ans.stream().distinct().collect(Collectors.toList());
    }

    public List<List<Integer>> threeSumBetter(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (len < 3) return ans;
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int target = -nums[i];
            int left = i + 1, right = len - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1])
                        left++;
                    while (left < right && nums[right] == nums[right + 1])
                        right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                }else if (nums[left] + nums[right] > target){
                    right--;
                }
            }
        }
        return ans  ;
    }

    public static void main(String[] args) {
        _15 v = new _15();
        List<List<Integer>> lists = v.threeSumBetter(new int[]{-1, 0, 1, 2, -1, -4});
        lists.forEach(System.out::println);
    }
}
