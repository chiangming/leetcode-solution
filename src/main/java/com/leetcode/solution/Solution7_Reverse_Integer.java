package com.leetcode.solution;

/**
 * @Author mingjiang
 * @Date 2019/4/9 14:22
 */
public class Solution7_Reverse_Integer {
    public int reverse(int x) {
        if(x==0) return x;
        if(x<0){
            x=-x;
            int a =0,b=0;
            int target = 0;
            while(x>0){
                a = x/10;
                b = x%10;
                if (target > Integer.MAX_VALUE/10 || (target == Integer.MAX_VALUE / 10 && b > 7)) return 0;
                target=target*10+b;
                x = a;
            }
            return -target;
        }

        int a =0,b=0;
        int target = 0;
        while(x>0){
            a = x/10;
            b = x%10;
            if (target > Integer.MAX_VALUE/10 || (target == Integer.MAX_VALUE / 10 && b > 7)) return 0;
            target=target*10+b;
            x = a;
        }
        return target;
    }
}
