package com.leetcode.solution;

/**
 * @Author mingjiang
 * @Date 2019/4/9 14:21
 */
public class Solution6_ZigZag_Conversion {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        char[] chs =s.toCharArray();
        StringBuffer res =new StringBuffer();
        int h = 2*numRows - 2;
        int r=chs.length/h+1;

        for(int j=0;j<=numRows-1;j++)
        {
            for(int i = 0; i<=r;i++)
            {
                checkAppend(res,j+i*h,chs);
                if(j!=0&&j!=numRows-1){
                    checkAppend(res,(h-j)+i*h,chs);
                }
            }
        }
        return res.toString();
    }

    private void checkAppend(StringBuffer res,int pos,char[] chs){
        if(pos<chs.length){res.append(chs[pos]);}
    }
}
