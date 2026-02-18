package org.example.patterns.twoPointers;

public class TrappingRainWater {
    public static void main(String args[]){
        int[] nums = {3,6,2,8,11,2};
        System.out.println(findTrappedRainWater(nums));
    }

    public static int findTrappedRainWater(int[] height) {
        if (height == null || height.length < 3) return 0;

        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int total = 0;

        while (left < right) {
            if (leftMax <= rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                total += Math.max(0, leftMax - height[left]);
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                total += Math.max(0, rightMax - height[right]);
            }
        }
        return total;
    }

}
