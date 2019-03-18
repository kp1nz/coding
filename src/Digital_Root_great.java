/**
 * @author kp1nz
 * @create 2019-03-18 11:07
 */
public class Digital_Root_great {
    public static int digital_root(int n) {
        return (n != 0 && n%9 == 0) ? 9 : n % 9;
    }

    public static void main(String[] args) {
        System.out.println(digital_root(16));
    }
}
