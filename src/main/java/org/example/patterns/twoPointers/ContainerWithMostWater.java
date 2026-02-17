package org.example.patterns.twoPointers;

public class ContainerWithMostWater {
    public static void main(String args[]){
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(findContainerWithMostWater(height));
    }
    public static int findContainerWithMostWater(int[] arr){

        int length = arr.length;
        int left = 0;
        int right = length -1;
        int maxArea = 0;

        while(left < right){
            int height = Math.min(arr[left], arr[right]);
            int width = right - left;
            int area = height * width;
            if(area > maxArea){ maxArea = area;}
            if(arr[left] < arr[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}
