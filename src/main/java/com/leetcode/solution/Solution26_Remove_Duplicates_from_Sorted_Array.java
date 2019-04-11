package com.leetcode.solution;

/**
 * @Author mingjiang
 * @Date 2019/4/10 17:04
 */
public class Solution26_Remove_Duplicates_from_Sorted_Array {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int pos = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != nums[i - 1]) {
                nums[pos++] = nums[i];
            }
        }
        return pos;
    }
}
