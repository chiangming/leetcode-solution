package com.leetcode.solution;

/**
 * @Author mingjiang
 * @Date 2019/4/9 14:34
 */
public class Solution13_Roman_to_Integer {
    public int romanToInt(String s) {
        int sum = 0;
        String M[] = {"M", "MM", "MMM"};
        String C[] = {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        for(int m =M.length-1;m>=0;m--){
            if(s.indexOf(M[m])==0){
                sum+= (m+1)*1000;
                s=s.replaceFirst(M[m],"");
                break;
            }
        }

        for(int c =C.length-1;c>=0;c--){
            if(s.indexOf(C[c])==0){
                sum+= (c+1)*100;
                s=s.replaceFirst(C[c],"");
                break;
            }
        }

        for(int x =X.length-1;x>=0;x--){
            if(s.indexOf(X[x])==0){
                sum+= (x+1)*10;
                s=s.replaceFirst(X[x],"");
                break;
            }
        }

        for(int i =I.length-1;i>=0;i--){
            if(s.indexOf(I[i])==0){
                sum+= (i+1);
                break;
            }
        }
        return sum;
    }
}
