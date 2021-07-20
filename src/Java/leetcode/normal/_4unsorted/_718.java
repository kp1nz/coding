package Java.leetcode.normal._4unsorted;

/**
 * @Author: kp1nz
 * @Date: 2020/7/1 11:01 下午
 */
public class _718 {
    public static int findLength(int[] A, int[] B) {
        int res = 0;
        int[][] dp = new int[A.length+1][B.length+1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i-1]==B[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                res = Math.max(res,dp[i][j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 1};
        int[] b = {3, 2, 1, 4, 7};
        System.out.println(findLength(a,b));
    }
}
