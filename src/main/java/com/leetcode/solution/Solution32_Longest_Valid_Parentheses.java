package com.leetcode.solution;

import java.util.Map;
import java.util.Stack;

/**
 * @Author mingjiang
 * @Date 2019/4/11 17:41
 */
public class Solution32_Longest_Valid_Parentheses {
    //如果能使用for循环就使用for循环，而不是没有剪枝的DFS迭代

     public int longestValidParentheses(String s) {
        int maxlen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j+=2) {
                if (isValid(s.substring(i, j))) {
                    maxlen = Math.max(maxlen, j - i);
                }
            }
        }
        return maxlen;
    }


    /*
    int res = -1;

    public int longestValidParentheses(String s) {
        if(s.length()==0||s.length()==1) return 0;
        validString(s,0,s.length());
        return res;
    }

    public int validString(String s,int i,int j){

         if(isValid(s.substring(i,j))){
             res = (j-i)>res?j-i:res;
             return res;
         }else{
             int a =(validString(s,i,j-1));
             int b = (validString(s,i+1,j));
             res= res>Math.max(a,b)?res: Math.max(a,b);
             return res;
         }

    }*/

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        if (s.length() % 2 != 0) return false;

        Stack<Character> chs= new Stack<Character>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if (ch=='('){
                chs.push(ch);
            } else if (!chs.isEmpty() && ch==')'){
                if(chs.peek()=='(') chs.pop();
            }else{
                return false;
            }
        }
       return chs.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution32_Longest_Valid_Parentheses().longestValidParentheses(")()"));
    }
}
