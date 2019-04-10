package com.leetcode.solution;

/**
 * @Author mingjiang
 * @Date 2019/4/9 14:14
 */

/**
 * Definition for singly-linked list.
 * */


public class Solution2_Add_Two_Numbers {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        ListNode current = new ListNode(0);
        ListNode result = current;
        while(l1!=null || l2!=null){
            if(l1!=null){
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2!=null){
                sum += l2.val;
                l2 = l2.next;
            }

            current.next = new ListNode(sum%10);
            current = current.next;

            sum = sum/10;
        }

        if(sum>0){
            current.next = new ListNode(sum);
        }

        return result.next;
    }
}
