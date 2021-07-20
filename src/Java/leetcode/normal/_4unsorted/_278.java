package Java.leetcode.normal._4unsorted;

/*
* 第一个错误的版本，二分查找 
* @Author: kp1nz
* @Date: 2021-07-11 15:52:59
*/
public class _278 {
    // 找最大的false
    public static int firstBadVersion(int n) {
        int start = 0;
        int end = n - 1;
        int res = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (!isBadVersion(mid)) {
                res = Math.max(mid, res);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res + 1;
    }

    public static boolean isBadVersion(int a){
        return a <= 4;
    }

    public static void main(String[] args) {
        firstBadVersion(5);
    }
}
