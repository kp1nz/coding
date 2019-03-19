package kyu_6p;

import java.util.*;

/**
 * 给定一个无序数组，包含正数、负数和0，要求从中找出3个数的乘积，使得乘积最大，
 * 要求时间复杂度：O(n)，空间复杂度：O(1)
 * @author kp1nz
 * @create 2019-03-12 21:27
 */
public class Max_multiply {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<Integer>();
        while (scanner.hasNextInt()) {
            list.add(Integer.parseInt(scanner.next()));
        }
        System.out.println(Main(list));
    }
    private static int Main(List list){
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        return ((int)list.get(0))*((int)list.get(1))*((int)list.get(2));
    }
}
