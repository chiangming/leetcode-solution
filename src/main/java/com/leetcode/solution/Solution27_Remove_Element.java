package com.leetcode.solution;

/**
 * @Author mingjiang
 * @Date 2019/4/10 17:43
 */
public class Solution27_Remove_Element {
    public static int removeElement(int[] nums, int val) {
        System.out.println(nums);
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int pos = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != val) {
                nums[pos++] = nums[i];
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6};
        System.out.println(a);
        System.out.println(integerArrayToString(a));
        removeElement(a,3);
        System.out.println(a);
        System.out.println(integerArrayToString(a));
    }

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }
}
