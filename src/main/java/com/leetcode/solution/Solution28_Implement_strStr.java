package com.leetcode.solution;

/**
 * @Author mingjiang
 * @Date 2019/4/10 18:04
 */
public class Solution28_Implement_strStr {
    public static int strStr(String haystack, String needle) {
        if(needle.length()==0)
            return 0;
        if(needle.length()>haystack.length())
            return -1;
        for(int i=0;i+needle.length()<=haystack.length();i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                if(needle.equals(haystack.substring(i,i+needle.length())))
                    return i;
            }
        }
        return -1;
    }

/* I should use substring to simplify the code*/
    //    public static int strStr(String haystack, String needle) {
//        if(needle.length()==0) return 0;
//        if(haystack.length()<needle.length()) return -1;
//        int i=0;
//        int j=0;
//        int pos =-1;
//        while(i<haystack.length()){
//            if(haystack.charAt(i)!=needle.charAt(j)){i++;}
//            else{
//                pos =i;
//                if(i==haystack.length()||j==needle.length()){
//                    return -1;
//                }
//                while(haystack.charAt(i) == needle.charAt(j)){
//
//                    i++;
//                    j++;
//                    if(j==needle.length()){
//                        return pos;
//                    }
//                    if(i==haystack.length()||j==needle.length()){
//                        return -1;
//                    }
//                }
//                i= pos+1;
//                j=0;
//                pos=-1;
//            }
//        }
//        return pos;
//    }

    public static void main(String[] args) {
        System.out.println(strStr("mississippi","issipi"));
    }
}
