package kyu_6p;

/**
 *    reverse
 *
 * @author kp1nz
 * @create 2019-03-19 17:56
 */
public class SpinWords {
    public static String spinWords(String sentence) {

        String[] s = sentence.split(" ");
        System.out.println();
        for (int i=0;i<s.length;i++){
            if (s[i].length()>4){
                StringBuilder stringBuilder =new StringBuilder(s[i]);
                s[i]=stringBuilder.reverse().toString();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String a:
             s) {
            sb.append(a+" ");
        }
        String substring = sb.substring(0, sb.length() - 1);
        return substring;
    }

    public static void main(String[] args) {
        System.out.println(spinWords("Welcome"));
    }
}
