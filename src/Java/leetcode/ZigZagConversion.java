package leetcode;

/**
 * @author kp1nz
 * @create 2019-04-13 22:25
 */
public class ZigZagConversion {

    public static String convert(String s, int numRows) {

        if (s == null || s.length() == 0 ||numRows ==1) return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }
        int curRows = 0;
        boolean isDown = false;
        for (char a :
                s.toCharArray()) {
            sb[curRows].append(a);
            if (curRows == 0 || curRows == numRows - 1)
                isDown = !isDown;
            if (isDown) {
                curRows++;
            } else curRows--;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder a :
                sb) {
            res.append(a);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("ABCCC", 1));
    }
}
