package com.leetcode.solution;

/**
 * @Author mingjiang
 * @Date 2019/4/9 14:12
 */
public class Solution1_Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            int a = nums[i];
            int b = target - a;
            for(int j =i+1;j<nums.length;j++){
                if(b == nums[j]){
                    int[] twoSum = {i,j};
                    return twoSum;
                }
            }
        }
        return null;
    }
}
