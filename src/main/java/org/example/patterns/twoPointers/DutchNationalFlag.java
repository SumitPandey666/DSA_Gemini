package org.example.patterns.twoPointers;

import java.util.Arrays;

public class DutchNationalFlag {
    public static void main(String args[]){
        int[] nums = {2,0,1};
        sortColors(nums);
    }
    public static void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;

                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;

                high--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
