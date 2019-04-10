package com.leetcode.solution;

import java.util.*;

/**
 * @Author mingjiang
 * @Date 2019/4/9 14:37
 */
public class Solution15_Three_Sum {
    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> aList = new ArrayList<List<Integer>>();
        Set<List<Integer>> hSet = new HashSet<List<Integer>>();

        for(int i =0;i<nums.length-2;i++){
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum == 0) hSet.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                else if ( sum >0) k--;
                else if (sum<0) j++;
            }
        }

        return new ArrayList<List<Integer>>(hSet);
    }
}
