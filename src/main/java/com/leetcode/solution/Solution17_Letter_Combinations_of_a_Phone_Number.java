package com.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author mingjiang
 * @Date 2019/4/9 14:41
 */
public class Solution17_Letter_Combinations_of_a_Phone_Number {
    private static String[] chars = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<String>();
        if(digits.length()==0) return res;
        getLetters(res,digits,0,new StringBuilder());
        return res;
    }

    private static void getLetters(List<String> res,String digits,int pos,StringBuilder prefix){
        if(pos==digits.length()){
            res.add(prefix.toString());
            return;
        }

        int digit = digits.charAt(pos)-'2';
        char[] chs = chars[digit].toCharArray();
        for(char ch:chs){
            prefix.append(ch);
            getLetters(res,digits,pos+1,prefix);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }
}
