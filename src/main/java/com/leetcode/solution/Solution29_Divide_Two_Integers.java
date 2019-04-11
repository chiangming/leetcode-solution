package com.leetcode.solution;

/**
 * @Author mingjiang
 * @Date 2019/4/11 10:23
 */
public class Solution29_Divide_Two_Integers {

    public static int divide(int dividend, int divisor) {
        int quotient = div(dividend > 0 ? -dividend : dividend, divisor > 0 ? -divisor : divisor);
        return (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0) ? (quotient == Integer.MIN_VALUE ? Integer.MAX_VALUE : -quotient) : quotient;
    }

    public static int div(int dividend, int divisor){
        if (dividend < 0){
            int variable = divisor, quotient = dividend - variable > 0 ? 0 : -1;
            while (dividend - variable <= variable){
                variable += variable;
                quotient += quotient;
            }
            return quotient + div(dividend - variable, divisor);
        }
        return 0;
    }

    //    public static int divide(int dividend, int divisor) {
//        if(divisor==1) return dividend;
//        if(divisor==0) return Integer.MAX_VALUE;
//        if(dividend==0) return 0;
//
//
//
//        if(dividend>0&&divisor>0){
//            /*This solution cause overflows */
////            if(dividend>=divisor)
////                return 1+divide(dividend-divisor,divisor);
////            else
////                return 0;
//            int res = 0;
//            while(dividend>=divisor){
//                res++;
//                dividend=dividend - divisor;
//            }
//            return res;
//        }
//        if(dividend<0&&divisor>0){
//            if(dividend==Integer.MIN_VALUE){
//                return ((divide(dividend+divisor,divisor)<=Integer.MIN_VALUE)?Integer.MAX_VALUE:divide(dividend+divisor,divisor)-1);
//
//            }
//            return -divide(-dividend,divisor);
//        }
//        if(dividend>0&&divisor<0){
//            if(divisor==Integer.MIN_VALUE) return 0;
//            return -divide(dividend,-divisor);
//        }
//        if(dividend<0&&divisor<0){
//            if(dividend==Integer.MIN_VALUE){
//                return ((divide(dividend-divisor,divisor)>=Integer.MAX_VALUE)?Integer.MAX_VALUE:divide(dividend-divisor,divisor)+1);
//            }
//            if(divisor==Integer.MIN_VALUE) return 0;
//            return divide(-dividend,-divisor);
//        }
//        return 0;
//    }

    public static void main(String[] args) {
        System.out.println(divide(1038925803,
                -2147483648));
    }
}
