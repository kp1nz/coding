package kyu_6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * zipString
 *
 * ->aaaaaaaaasssw
 * ->a9s3w
 *
 * @author kp1nz
 * @create 2019-03-19 19:22
 */
public class ZipString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String next = scanner.next();
            System.out.println(zipString(next));
        }
    }

    static class ByteInfo {
        char b;
        int count;
        int pos;
    }

    private static String zipString(String data) {
        char[] dst = new char[data.length()];
        data.getChars(0, data.length(), dst, 0);
        List<ByteInfo> infos = new ArrayList();
        int j = 1;
        for (int i = 0; i < dst.length; i += j) {
            j = 1;
            ByteInfo info = new ByteInfo();
            char current = dst[i];
            info.b = current;
            info.count = 1;
            info.pos = i;
            for (int jj = i + 1; jj < dst.length; jj++) {
                if (current == dst[jj]) {
                    info.count = info.count + 1;
                    j = j + 1;
                } else {
                    break;
                }
            }
            infos.add(info);
        }
        StringBuilder builder = new StringBuilder();
        for (ByteInfo info : infos) {
            if (info.count > 1) {
                builder.append(info.b).append(info.count);
            } else {
                builder.append(info.b);
            }
        }
        return builder.toString();
    }
}
