package others;

/**
 * 有一楼梯共m级，刚开始时你在第一级，若每次只能跨上一级或者二级，要走上m级，共有多少走法？
 * 注：规定从一级到一级有0种走法。
 *
 * 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100。
 * 为了防止溢出，请返回结果Mod 1000000007的值。
 * @author kp1nz
 * @create 2019-03-19 20:14
 */
public class 爬楼梯 {

    public static int countWays_1(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return countWays_1(n - 1) + countWays_1(n - 2);
        }
    }

    public static int countWays(int n) {
        int dp[]=new int [n];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        if(n>2){
            for(int i=3;i<n;i++){
                dp[i]=(dp[i-1]+dp[i-2])%1000000007;
            }

        }
        return dp[n-1];

    }

    public static void main(String[] args) {
//        System.out.println(countWays(1));
//        System.out.println(countWays(2));
        System.out.println(countWays(3));
        System.out.println(countWays(4));
        System.out.println(countWays(5));
        System.out.println(countWays(121));
    }
}
