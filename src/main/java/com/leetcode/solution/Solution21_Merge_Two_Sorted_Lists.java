package com.leetcode.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author mingjiang
 * @Date 2019/4/10 11:05
 */


public class Solution21_Merge_Two_Sorted_Lists {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1==null &&l2==null) return null;
        if(l1==null) return l2;
        if(l2==null) return l1;

        ListNode res = new ListNode(0);
        ListNode head = new ListNode(-1);
        head.next = res;

        if(l1!=null && l2!=null){
            if(l1.val<l2.val){
                res = l1;
                l1 = l1.next;
            }else{
                res = l2;
                l2 = l2.next;
            }
            head.next = res;
        }

        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                res.next = l1;
                l1 = l1.next;
            }else{
                res.next = l2;
                l2 = l2.next;
            }
            res=res.next;
        }
        if(l1==null&&l2!=null){
            res.next = l2;
        }
        if(l1!=null&&l2==null){
            res.next = l1;
        }
        return head.next;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode l1 = stringToListNode(line);
            line = in.readLine();
            ListNode l2 = stringToListNode(line);

            ListNode ret = new Solution21_Merge_Two_Sorted_Lists().mergeTwoLists(l1, l2);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }


    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

}
