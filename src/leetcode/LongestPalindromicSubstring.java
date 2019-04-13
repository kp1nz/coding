package leetcode;


/**
 * 动态规划解决回文数
 *
 * @author kp1nz
 * @create 2019-04-13 18:30
 */
public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        int begin =0;
        int end =0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i= s.length()-2;i>=0;i--){
           for (int j = i+1;j<s.length();j++){
               if (s.charAt(i) == s.charAt(j)&&(j-i<=2||dp[i+1][j-1])==true){
                   dp[i][j]=true;
                   if (j-i>end-begin){
                       end = j;
                       begin =i;
                   }
               }
           }
        }return s.substring(begin,end+1);
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}
