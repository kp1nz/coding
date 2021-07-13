package Java.leetcode.normal;

/*
* 搜索插入位置 二分查找
* @Author: kp1nz
* @Date: 2021-07-11 16:19:19
*/
public class _35 {
    public static int searchInsert(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while(start <= end){
            mid = start + (end - start);
            if(nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                start = mid + 1;
            }else if (nums[mid] > target){
                end = mid - 1;
            }
        }
        return mid += nums[mid] < target ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3,5,6},2));
    }
}