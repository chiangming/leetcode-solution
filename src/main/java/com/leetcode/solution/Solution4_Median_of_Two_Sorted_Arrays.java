package com.leetcode.solution;

/**
 * @Author mingjiang
 * @Date 2019/4/9 14:19
 */
public class Solution4_Median_of_Two_Sorted_Arrays {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }

        int range=((m+n)%2==0)?((m+n)/2):((m+n+1)/2);

        //binary
        int iMin = 0,iMax = m;
        while(iMin<=iMax){
            int i = (iMin+iMax)/2;
            int j = range -i;
            if(i < iMax&&B[j-1]>A[i]){
                iMin = i+1;
                continue;
            }
            if(i > iMin &&A[i-1]>B[j]){
                iMax = i-1;
                continue;
            }
            int maxLeft = 0;
            if (i == 0) { maxLeft = B[j-1]; }
            else if (j == 0) { maxLeft = A[i-1]; }
            else { maxLeft = Math.max(A[i-1], B[j-1]); }
            if ( (m + n) % 2 == 1 ) { return maxLeft; }

            int minRight = 0;
            if (i == m) { minRight = B[j]; }
            else if (j == n) { minRight = A[i]; }
            else { minRight = Math.min(B[j], A[i]); }

            return (maxLeft + minRight) / 2.0;
        }
        return 0.0;
    }
}
