package com.leetcode.solution;

import java.util.*;

/**
 * @Author mingjiang
 * @Date 2019/4/9 14:49
 */
public class Solution18_Four_Sum {

}

/*DFS for higher space*/
//public class Solution18_Four_Sum {
//    public static List<List<Integer>> fourSum(int[] nums, int target) {
//        Arrays.sort(nums);
//        Set<List<Integer>> res = new HashSet<List<Integer>>();
//        List<String> chose = new ArrayList<String>();
//        getClosest(res,nums,target,0,new ArrayList<Integer>(),new ArrayList<String>());
//
//        for(List li:res){
//            Collections.sort(li);
//        }
//        return new ArrayList<List<Integer>>(new HashSet<List<Integer>>(res));
//    }
//
//    private static void getClosest(Set<List<Integer>> res, int[] nums, int target, int pos, List<Integer> temp,List<String> chose){
//        if(pos>=4){
//            int sum = getSum(temp);
//            if(sum == target){
//                    res.add( new ArrayList<Integer>(temp));
//            }
//            return;
//        }
//
//
//        for(int i = 0 ; i < nums.length ; i++) {
//            if(!chose.contains(i+""))
//            {
//                int iThis = nums[i];
//                temp.add(iThis);
//                pos += 1;
//                chose.add(i+"");
//                getClosest(res, nums, target, pos, temp, chose);
//                chose.remove(i+"");
//                pos -= 1;
//                temp.remove(temp.size() - 1);
//            }
//        }
//
//    }
//
//    private static int getSum(List<Integer> temp){
//        int sum =0;
//        for(int i:temp){
//            sum +=i;
//        }
//        return sum;
//    }
//    public static void main(String[] args) {
//        int[] nums ={-2, -1, 0, 0, 1,2};
//        List<List<Integer>> l=fourSum(nums,0);
//        System.out.println(l.toString());
//    }
//}
