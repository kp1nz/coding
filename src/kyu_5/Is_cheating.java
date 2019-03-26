package kyu_5;


import java.util.LinkedList;
import java.util.List;

/**
 *
 * A friend of mine takes a sequence of numbers from 1 to n (where n > 0).
 * Within that sequence, he chooses two numbers, a and b.
 * He says that the product of a and b should be equal to the sum of all numbers
 * in the sequence, excluding a and b.
 * Given a number n, could you tell me the numbers he excluded from the sequence?
 *
 * The function takes the parameter: n (don't worry, n is always strictly greater
 * than 0 and small enough so we shouldn't have overflow) and returns an array of
 * the form:
 * [(a, b), ...] or [[a, b], ...] or {{a, b}, ...} or or [{a, b}, ...]
 * with all (a, b) which are the possible removed numbers in the sequence 1 to n.
 * [(a, b), ...] or [[a, b], ...] or {{a, b}, ...} or ...will be sorted in increasing
 * order of the "a".
 * It happens that there are several possible (a, b). The function returns an empty
 * array if no possible numbers are found which will prove that my friend has not
 * told the truth! (Go: in this case return nil).
 *
 * #Examples:
 * removNb(26) should return [(15, 21), (21, 15)]
 * or
 * removNb(26) should return { {15, 21}, {21, 15} }
 * or
 * removeNb(26) should return [[15, 21], [21, 15]]
 * or
 * removNb(26) should return [ {15, 21}, {21, 15} ]
 * or
 *
 * in C:
 * removNb(26) should return  **an array of pairs {{15, 21}{21, 15}}**
 * tested by way of strings.
 *
 * @author kp1nz
 * @create 2019-03-26 16:29
 */
public class Is_cheating {
    public static List<long[]> removNb(long n) {
        // your code
        if (n == 0) return null;
        List<long[]> list = new LinkedList();

        long sum = (1 + n) * n / 2;
        int count = 0;

        for (long i = 0; i <= n; i++) {
            long x =  (sum + 1) % (i + 1) ;
            long j =  (sum + 1) / (i + 1) -1;
            if (x == 0 &&j<n) {
                System.out.println(i+","+j);
                list.add(count, new long[]{i, j});
                count++;
            }
        }
        return list;
    }


    public static void main(String[] args) {
        System.out.println(removNb(26));
    }
}
