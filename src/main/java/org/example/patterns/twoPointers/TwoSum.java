package org.example.patterns.twoPointers;

import java.util.Arrays;

public class TwoSum {
    public static void main(String args[]){
        int[] nums = {2, 7, 11, 15};
        int target = 19;
        System.out.println(Arrays.toString(findTwoSum(nums, target)));
        System.out.println(Arrays.toString(findTwoSumCleanerVersion(nums, target)));

    }
    public static int[] findTwoSum(int[] nums, int k){
        int length = nums.length;

        if(length == 0 ) return nums;
        int left = 0;
        int right = length - 1;


        for(int i =0; i<length; i++){
            if(left == right){
                System.out.println("not found");
                return new int[] {-1, -1};
            }
            if(nums[left] + nums[right] == k){
                return new int[] {left, right};
            } else if (nums[left] + nums[right] < k) {
                left++;
            }else{
                right--;
            }
        }
        return nums;
    }

    public static int[] findTwoSumCleanerVersion(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int currentSum = nums[left] + nums[right];

            if (currentSum == k) {
                return new int[] {left + 1, right + 1};
            } else if (currentSum < k) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {-1, -1};
    }
}
