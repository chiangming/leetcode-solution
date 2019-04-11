package com.leetcode.solution;


import java.util.HashMap;
import java.util.Map;

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

    //把数组的每个元素保存为 hash 的 key，下标保存为 hash 的 value 。
    //这样只需判断 sub 在不在 hash 的 key 里就可以了，而此时的时间复杂度仅为 O（1）
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int sub=target-nums[i];
            if(map.containsKey(sub)&&map.get(sub)!=i){
                return new int[]{i,map.get(sub)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
