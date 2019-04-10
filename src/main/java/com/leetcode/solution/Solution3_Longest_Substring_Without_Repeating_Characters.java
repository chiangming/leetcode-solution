package com.leetcode.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author mingjiang
 * @Date 2019/4/9 14:17
 */
public class Solution3_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {

        int i=0,j=0,max = 0;
        Set set = new HashSet();
        while(i<s.length() && j<s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                max = (max>(j-i))?max:(j-i);
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }
}
