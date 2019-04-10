package com.leetcode.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author mingjiang
 * @Date 2019/4/10 11:42
 */

//use stack is also ok

public class Solution22_Generate_Parentheses {
    /*
    * public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if(n==1){
            res.add("()");
            return res;
        }

        Stack<Character> chs = new Stack<Character>();
        StringBuilder prefix = new StringBuilder();
        getParenthesis(res,chs,n,0,0,prefix);

        return res;
    }

    private void getParenthesis(List<String> res,Stack<Character> chs,int n,int pos,int left,StringBuilder prefix){
        if(pos == 2*n){
            res.add(prefix.toString());
            return;
        }

        for(int i=0;i<2;i++){
            if(i==0 && left<n){
                chs.push('(');
                prefix.append('(');
                pos++;
                left++;
                getParenthesis(res,chs,n,pos,left,prefix);
                left--;
                pos--;
                prefix.deleteCharAt(prefix.length()-1);
                chs.pop();
            }
            if(i==1){
                if(!chs.isEmpty()){
                    chs.pop();
                    prefix.append(')');
                    pos++;
                    getParenthesis(res,chs,n,pos,left,prefix);
                    pos--;
                    prefix.deleteCharAt(prefix.length()-1);
                    chs.push('(');
                }
            }
        }
    }*/
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if(n==1){
            res.add("()");
            return res;
        }

        StringBuilder prefix = new StringBuilder();
        getParenthesis(res,n,0,0,prefix);

        return res;
    }

    private void getParenthesis(List<String> res,int n,int left,int right,StringBuilder prefix){
        if(left>n || right>n){
            return;
        }
        if(left == n && right == n){
            res.add(prefix.toString());
            return;
        }

        prefix.append('(');
        left++;
        getParenthesis(res,n,left,right,prefix);
        left--;
        prefix.deleteCharAt(prefix.length()-1);


        if(right<left){     //when ')' is less than '('
            prefix.append(')');
            right++;
            getParenthesis(res,n,left,right,prefix);
            right--;
            prefix.deleteCharAt(prefix.length()-1);
        }

    }

    public static void main(String[] args) throws IOException {
            List<String> ret = new Solution22_Generate_Parentheses().generateParenthesis(4);
            String out = stringListToString(ret);
            System.out.print(out);

    }

    public static String stringListToString(List<String> stringList) {
        StringBuilder sb = new StringBuilder("[");
        for (String item : stringList) {
            sb.append(item);
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }
}
