package com.leetcode.solution;

/**
 * @Author mingjiang
 * @Date 2019/4/9 14:31
 */
public class Solution11_Container_With_Most_Water {
    public int maxArea(int[] height) {
        if(height.length<2) return 0;
        if(height.length==2)
            return Math.min(height[0],height[1]);
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
}
