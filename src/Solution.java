
/**
 * File: Solution.java
 *
 * Created the function consecutive(arr) that takes an array of integers and return the minimum number of integers
 * needed to make the contents of arr consecutive from the lowest number to the highest number.
 */
public class Solution {

    public static int consecutive(final int[] arr) {
        if (arr.length <= 1) return 0;
        int max = arr[0];
        int min = arr[0];
        for (int j : arr) {
            if (j < min) min = j;
            if (j > max) max = j;
        }

        return max - min + 1 - arr.length; // your code here
    }
}