package com.leetcode.solution;

/**
 * @Author mingjiang
 * @Date 2019/4/9 14:28
 */
public class Solution9_Palindrome_Number {
    public boolean isPalindrome(int x) {
        if(x==0) return true;
        if(x<0) return false;
        String s = String.valueOf(x);
        return isPalindrome(s);
    }

    public boolean isPalindrome(String x) {
        for(int i=0;i<x.length()/2;i++){
            if(x.charAt(i)!=x.charAt(x.length()-1-i))
                return false;
        }
        return true;
    }
}
