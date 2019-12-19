package others;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 字节跳动2019 牛牛妞妞求得分
 *
 * @author kp1nz
 * @create 2019-03-14 19:37
 */
public class Getscore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int boxs = scanner.nextInt();
            int girls[] = new int[boxs];
            for (int i = 0; i < boxs; i++) {
                girls[i] = Integer.parseInt(scanner.next());
            }
            int boys[] = new int[boxs];
            for (int i = 0; i < boxs; i++) {
                boys[i] = Integer.parseInt(scanner.next());
            }
            System.out.println(getScore(boxs,girls,boys));
        }
    }

    private static int getScore(int boxs, int[] girls, int[] boys) {

        int res = 0;
        Arrays.sort(girls);
        Arrays.sort(boys);
        for(int index =boxs-1;index>0;index--){
            if(girls[index]>boys[index]){
                res+=girls[index];
                if(girls[index-1]>boys[index]){
                    girls[index-1]=0;
                }else {
                    res-=boys[index];
                }
            }else {
                boys[index]=0;
                if (boys[index-1]>girls[index]){
                    res-=boys[index-1];
                }
            }
        }
        return res;
    }
}
