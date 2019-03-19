package others;

import java.util.Scanner;

/**
 * 经过严密的计算，小赛买了一支股票，他知道从他买股票的那天开始，股票会有以下变化：
 * 第一天不变，以后涨一天，跌一天，涨两天，跌一天，涨三天，跌一天...依此类推。
 * 为方便计算，假设每次涨和跌皆为1，股票初始单价也为1，请计算买股票的第n天每股股票值多少钱？
 * @author kp1nz
 * @create 2019-03-07 15:35
 */
public class 股神 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int days = scanner.nextInt();
            int res = compute(days);
            System.out.println(res);
        }
    }

    private static Integer compute(int days) {
        int i = 0;// i统计遇到了多少次下跌
        int j = 2;// 每次下跌之后上涨的天数，包含已经下跌的那天
        int k = days;
        while (k > j) {
            i += 2;
            k -= j;
            j++;
        }
        return days - i;
    }


}
