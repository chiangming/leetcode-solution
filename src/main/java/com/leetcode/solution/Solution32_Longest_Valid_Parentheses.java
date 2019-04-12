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

//动态规划
    // dp [ i ] 代表以下标 i 结尾!!!!! 的合法序列的最长长度
//    首先我们初始化所有的 dp 都等于零。
//    以左括号结尾的字符串一定是非法序列，所以 dp 是零，不用更改。
//    以右括号结尾的字符串分两种情况。
//
//    右括号前边是 ( ，类似于 ……【……】（）。
//            dp [ i ] = dp [ i - 2] + 2 （前一个合法序列的长度，加上当前新增的长度 2）
//
//            右括号前边是 )，类似于 ……【……】））。
//    此时我们需要判断 i - dp[i - 1] - 1 （前一个合法序列的前边一个位置） 是不是左括号。
//   即为判断 类似于……(【……】))还是……)【……】))

    public int longestValidParentheses2(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                //右括号前边是左括号
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    //右括号前边是右括号，并且除去前边的合法序列的前边是左括号
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    //使用栈解决配对问题
    public int longestValidParentheses3(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
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
