package com.leetcode.solution;

/**
 * @Author mingjiang
 * @Date 2019/4/9 14:24
 */

//refer to  Integer.parseInt(String s, int radix);
public class Solution8_String_to_Integer {

    public int myAtoi(String s) {
        if (s == null || s.length() == 0)
            return 0;
        s = s.trim();
        if (s== null || s.length() == 0)
            return 0;
        int result = 0;
        int radix =10;
        boolean negative = false;
        int i = 0, len = s.length();
        int limit = -Integer.MAX_VALUE;
        int multmin;
        int digit;

        if (len > 0) {
            char firstChar = s.charAt(0);
            if (firstChar < '0') { // Possible leading "+" or "-"
                if (firstChar == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE;
                } else if (firstChar != '+')
                    return 0;

                if (len == 1) // Cannot have lone "+" or "-"
                    return 0;
                i++;
            }
            multmin = limit / radix;
            while (i < len) {
                // Accumulating negatively avoids surprises near MAX_VALUE
                digit = Character.digit(s.charAt(i++),radix);
                if (digit < 0) {
                    return 0;
                }
                if (result < multmin) {
                    return 0;
                }
                result *= radix;
                if (result < limit + digit) {
                    return 0;
                }
                result -= digit;
            }
        } else {
            return 0;
        }
        return negative ? result : -result;
    }
}
