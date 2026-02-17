package org.example.patterns.twoPointers;

import java.util.Arrays;

public class SquaresOfASortedArray {
    public static void main(String args[]){
        int[] nums = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(findSquaresOfASortedArray(nums)));
    }
    private static int[] findSquaresOfASortedArray(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];

        int left = 0;
        int right = n - 1;
        int p = n - 1;
        while (left <= right) {
            if (Math.abs(arr[left]) > Math.abs(arr[right])) {
                res[p] = arr[left] * arr[left];
                left++;
            } else {
                res[p] = arr[right] * arr[right];
                right--;
            }
            p--;
        }
        return res;
    }
}
