/**
 * 对给定的字符串进行排序。字符串中的每个字都将包含一个数字。这个数字是单词在结果中的位置。
 *
 * @author kp1nz
 * @create 2019-02-14 23:47
 */
public class Order {
    String words = "is2 Thi1s T4est 3a";

    public static String order(String words){
        return "";
    }

    public static void main(String[] args) {
        String words = "is2 Thi1s T4est 3a";
        String[] ws = words.split(" ");
        for (String x:ws){
            System.out.println(x);
        }
    }

}
