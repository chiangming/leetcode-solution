package com.leetcode.solution;

import java.util.Arrays;

/**
 * @Author mingjiang
 * @Date 2019/4/9 14:39
 */
public class Solution16_Three_Sum_Closest {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length==3) return nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);

        int pos= Integer.MAX_VALUE;
        int neg= Integer.MIN_VALUE+1;

        for(int i =0;i<nums.length-2;i++){
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                int diff = sum -target;
                if(diff == 0) return sum;
                else if ( diff >0) {
                    pos = diff<pos?diff:pos;
                    k--;
                }
                else if (diff <0) {
                    neg = diff>neg?diff:neg;
                    j++;
                }
            }
        }

        return pos<Math.abs(neg)?(target+pos):(target+neg);
    }
}
