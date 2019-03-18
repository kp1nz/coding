import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Delete occurrences of an element if it occurs more than n times
 * <p>
 * Given a list lst and a number N,
 * create a new list that contains each number of lst at most N times without reordering.
 * For example if N = 2, and the input is [1,2,3,1,2,1,2,3], you take [1,2,3,1,2],
 * drop the next [1,2] since this would lead to 1 and 2 being in the result 3 times,
 * and then take 3, which leads to [1,2,3,1,2,3].
 *
 * @author kp1nz
 * @create 2019-03-18 11:20
 */
public class EnoughIsEnough_great {

    public static int[] deleteNth(int[] elements, int maxOccurrences) {

        if (maxOccurrences < 1) return new int[0];

        final HashMap<Integer, Integer> map = new HashMap<>();
        final List<Integer> list = new ArrayList<>();

        for (final Integer i : elements) {
            final Integer v = map.put(i, map.getOrDefault(i, 0) + 1);
            if (v == null || v < maxOccurrences) list.add(i);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] arr;
        arr = deleteNth(new int[]{1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1}, 3);
        for (int a :
                arr) {
            System.out.print(a + ",");
        }
    }
}