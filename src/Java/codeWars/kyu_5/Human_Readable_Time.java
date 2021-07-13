package kyu_5;

/**
 * Write a function, which takes a non-negative integer (seconds) as input and
 * returns the time in a human-readable format (HH:MM:SS)
 *
 * HH = hours, padded to 2 digits, range: 00 - 99
 * MM = minutes, padded to 2 digits, range: 00 - 59
 * SS = seconds, padded to 2 digits, range: 00 - 59
 * The maximum time never exceeds 359999 (99:59:59)
 * @author kp1nz
 * @create 2019-03-19 15:51
 */
public class Human_Readable_Time {
    public static String makeReadable(int seconds) {

        StringBuilder sb = new StringBuilder();
        //HH
        if (seconds / 3600 < 10) {
            sb.append(0).append(seconds / 3600).append(":");
        } else {
            sb.append(seconds / 3600).append(":");
        }
        if (seconds > 359999) {
            return null;
        }
        //MM
        int mm = (seconds - 3600 * (seconds / 3600)) / 60;
        if (mm < 10) {
            sb.append(0).append(mm).append(":");
        } else {
            sb.append(mm).append(":");
        }
        //SS
        int ss = seconds - 3600 * seconds / 3600 + seconds % 60;
        if (ss < 10) {
            sb.append(0).append(ss);
        } else {
            sb.append(ss);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(makeReadable(0));
    }
}
