package kyu_4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.codewars.com/kata/53f40dff5f9d31b813000774/train/java
 *
 * @author kp1nz
 * @create 2019-03-27 14:50
 */
public class RecoverSecretString_2 {
    public static String recoverSecret(char[][] triplets) {
        List<Character> secret = new ArrayList<>();
        for (int i = 0; i < triplets.length; i++) {
            char[] triplet = triplets[i];
            handleTriplet(secret, triplet);
        }
        for (int i = triplets.length - 1; i >= 0; i--) {
            char[] triplet = triplets[i];
            handleTriplet(secret, triplet);
        }
        return secret.stream().map(Object::toString).collect(Collectors.joining());
    }

    private static void handleTriplet(List<Character> secret, char[] triplet) {
        Boolean pristine = true;
        for (char ch : triplet) if (secret.contains(ch)) pristine = false;
        if (pristine) {
            handlePristineTriplet(secret, triplet);
        } else {
            handleDirtyTriplet(secret, triplet);
        }
    }

    private static void handlePristineTriplet(List<Character> secret, char[] triplet) {
        for (char ch : triplet) {
            secret.add(ch);
        }
    }

    private static void handleDirtyTriplet(List<Character> secret, char[] triplet) {
        for (int i = 0; i < triplet.length; i++) {
            if (secret.contains(triplet[i]) && i < triplet.length - 1) {
                if (!secret.contains(triplet[i + 1])) secret.add(secret.indexOf(triplet[i]), triplet[i + 1]);
                else if (secret.indexOf(triplet[i]) > secret.indexOf(triplet[i + 1])) {
                    secret.remove(secret.indexOf(triplet[i]));
                    secret.add(secret.indexOf(triplet[i + 1]), triplet[i]);
                }
            }
            if (secret.contains(triplet[i]) && i > 0) {
                if (!secret.contains(triplet[i - 1])) secret.add(secret.indexOf(triplet[i]), triplet[i - 1]);
                else if (secret.indexOf(triplet[i]) < secret.indexOf(triplet[i - 1])) {
                    secret.remove(secret.indexOf(triplet[i]));
                    secret.add(secret.indexOf(triplet[i - 1]) + 1, triplet[i]);
                }
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(recoverSecret(new char[][]{
                {'t', 'u', 'p'},
                {'w', 'h', 'i'},
                {'t', 's', 'u'},
                {'a', 't', 's'},
                {'h', 'a', 'p'},
                {'t', 'i', 's'},
                {'w', 'h', 's'}}));
    }
}
