package com.leetcode.solution;

/**
 * @Author mingjiang
 * @Date 2019/4/9 14:20
 */
public class Solution5_Longest_Palindromic_Substring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int n = s.length();
        String res = null;

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;

    }
}
