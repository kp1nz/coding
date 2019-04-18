package others;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author kp1nz
 * @create 2019-04-16 20:12
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
    }

    private LinkedList[] arr;
    private int hashsize;

    //构造表结构
    public Main3() {
        hashsize = 10;
        arr = new LinkedList[hashsize];
    }

    public Main3(int hashsize) {
        this.hashsize = hashsize;
        arr = new LinkedList[hashsize];
    }

    public void put(int key, String value) {
        int index = getHashIndex(key);
        if (arr[index] == null) {
            arr[index] = new LinkedList();
        }
        arr[index].add(key, value);
    }

    public String get(int key){
        int index = getHashIndex(key);
        if (arr[index] != null){
            return (String) arr[index].get(key);
        }return null;
    }

    private int getHashIndex(int key) {
        return key % hashsize;
    }
}
