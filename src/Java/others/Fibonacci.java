package others;

/**
 * @author kp1nz
 * @create 2019-04-11 12:58
 */
public class Fibonacci {

    public static int fibonacci(int n)
    {
        if (n <= 0)
            return 0;
        if (n==1 || n==2)
            return 1;
        int numa=1, numb=1, num;
        for (int i=3; i<=n; ++i)
        {
            num = numa + numb;
            numa = numb;
            numb = num;
        }
        return numb;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(121));
    }

}
