/**
 * Complete the findNextSquare method that finds the next integral perfect square after the one passed as a parameter.
 * Recall that an integral perfect square is an integer n such that sqrt(n) is also an integer.
 *
 * If the parameter is itself not a perfect square, than -1 should be returned.
 * You may assume the parameter is positive.
 * @author kp1nz
 * @create 2019-03-18 18:30
 */
public class NumberFun {
    public static long findNextSquare(long sq) {
        double sqrt = Math.sqrt(sq);
        if (sqrt%1==0){
            return new Double((sqrt+1)*(sqrt+1)).longValue();
        }else return -1;
    }

    public static void main(String[] args) {
        System.out.println(findNextSquare(114));
    }
}
