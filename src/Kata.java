import java.util.ArrayList;
import java.util.List;

/**
 * Write a method, that gets an array of integer-numbers and return an array of
 * the averages of each integer-number and his follower,
 * if there is one.
 *
 * Example:
 *
 * Input:  [ 1, 3, 5, 1, -10]
 * Output:  [ 2, 4, 3, -4.5]
 *
 * @author kp1nz
 * @create 2019-03-18 19:20
 */
public class Kata {
    public static double[] averages(int[] numbers) {

        List<Double> list = new ArrayList<Double>();
        for(int i =0;i<numbers.length-1;i++){
            if (numbers[i]==0||numbers[i]==1||numbers.length==0||numbers==null){
                return new double[0];
            }
            list.add(new Double((numbers[i]+numbers[i+1]))/2.0);
        }
        double[] arr = new double[numbers.length-1];
        int count = 0;
        for (double a:
             list) {
            arr[count]=a;
            count++;
        }
        return arr;
    }
    public static double[] averages(double[] numbers) {

        List<Double> list = new ArrayList<Double>();
        for(int i =0;i<numbers.length-1;i++){
            if (numbers[i]==0||numbers[i]==1||numbers.length==0||numbers==null){
                return new double[0];
            }
            list.add(new Double((numbers[i]+numbers[i+1]))/2.0);
        }
        double[] arr = new double[numbers.length-1];
        int count = 0;
        for (double a:
                list) {
            arr[count]=a;
            count++;
        }
        return arr;
    }

    public static void main(String[] args) {

        double[] averages = averages(new double[] { 2.0, 4.0, 3.0, -4.5 });
        for (double a:
        averages) {
            System.out.print(a+",");
        }
    }
}