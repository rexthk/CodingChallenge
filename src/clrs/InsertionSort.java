package clrs;

import java.util.Arrays;

/**
 * @author rexthk
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] digits = new int[]{31, 41, 59, 26, 41, 58};

        for (int j = 1; j < digits.length; j++) {
            int key = digits[j]; // for each iteration, select a key ( j = 1 ... array.length )
            int i = j - 1; // first, select the comparing target. In every iteration, it will be the element right before the key

            while (i >= 0 && digits[i] > key) { // if the target is greater than the key
                digits[i + 1] = digits[i]; // move the target forward by replacing the element right after the target
                i--; // do it recursively
            }
            digits[i + 1] = key; // if the target is smaller than the key, we replace the target value with the key ( insertion )
        }

        Arrays.stream(digits).forEach(System.out::println);
    }
}
