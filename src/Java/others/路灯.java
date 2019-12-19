package others;

import java.text.DecimalFormat;
import java.util.*;

/**
 * V先生有一天工作到很晚，回家的时候要穿过一条长l的笔直的街道，这条街道上有n个路灯。
 * 假设这条街起点为0，终点为l，第i个路灯坐标为ai。
 * 路灯发光能力以正数d来衡量，其中d表示路灯能够照亮的街道上的点与路灯的最远距离，
 * 所有路灯发光能力相同。为了让V先生看清回家的路，路灯必须照亮整条街道，又为了节省电力希望找到最小的d是多少？
 *
 * @author kp1nz
 * @create 2019-03-07 19:35
 */
public class 路灯 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int num = Integer.parseInt(scanner.next());
            int s_long = Integer.parseInt(scanner.next());
            int position[] = new int[num];
            for (int i = 0; i < num; i++) {
                position[i] = Integer.parseInt(scanner.next());
            }
            System.out.println(compute(position, s_long));
        }
    }

    private static String compute(int[] position, int s_long) {
        quickSort(position, 0, position.length - 1);
        int max = 0;
        //考虑中间的路灯
        for (int i = 0; i < position.length - 1; i++) {
            if (max < (position[i + 1] - position[i])) {
                max = position[i + 1] - position[i];
            }
        }
        //考虑路两头的路灯
        for (int i = 0; i < position.length - 1; i++) {
            int sw_side_max;
            sw_side_max = position[0] > (s_long - position[position.length - 1]) ?
                    position[0] : s_long - position[position.length - 1];
            //路两头只靠一盏灯照明，所以*2
            if (sw_side_max * 2 > max) {
                max = sw_side_max;
                DecimalFormat df = new DecimalFormat(".00");
                double res = max;
                return df.format(res);
            }
        }
        DecimalFormat df = new DecimalFormat(".00");
        double res = max / 2.00;
        return df.format(res);
    }

    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        // get pivot
        int pivotIndex = partition(arr, startIndex, endIndex);
        // left!
        quickSort(arr, startIndex, pivotIndex - 1);

        quickSort(arr, pivotIndex + 1, endIndex);
    }

    private static int partition(int[] arr, int startIndex, int endIndex) {
        int heart = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            while (left < right && arr[right] > heart) {
                right--;
            }
            while (left < right && arr[left] <= heart) {
                left++;
            }
            if (left < right) {
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }
        //heart<-->指针
        int p = arr[left];
        arr[left] = arr[startIndex];
        arr[startIndex] = p;
        return left;
    }
}
