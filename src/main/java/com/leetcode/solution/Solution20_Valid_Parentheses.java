package com.leetcode.solution;

import java.util.Stack;

/**
 * @Author mingjiang
 * @Date 2019/4/10 10:04
 */
public class Solution20_Valid_Parentheses{

//    class MyStack<Item> {
//
//    private Object[] myArray = null;//元素容器
//    private int capacity = 0;//元素容量
//    private int n = 0;//元素个数
//
//    public MyStack() {
//        capacity = 2;
//        myArray = new Object[capacity];
//    }
//
//    public MyStack(int capacity) {
//        this.capacity = capacity;
//        myArray = new Object[capacity];
//    }
//
//    public void push(Item item) {
//        if (n >= capacity/2) {
//            capacity *= 2;
//            Object[] temp = new Object[capacity];
//            for (int i = 0; i < capacity/2; i++)
//                temp[i] = myArray[i];
//            myArray = temp;
//        }
//        myArray[n++] = item;
//    }
//
//
//    public Item peek() {
//        if (n == 0)
//            return null;
//        Item item = (Item) myArray[n-1];
//        return item;
//    }
//
//    public Item pop() {
//        if (isEmpty()) throw new NullPointerException();
//        Item item = (Item) (myArray[--n]);
//        myArray[n] = null;
//        return item;
//    }
//
//    public int size() {
//        return n;
//    }
//
//    public boolean isEmpty() {
//        return n == 0;
//    }
//}

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        if (s.length() % 2 != 0) return false;

        Stack<Character> chs= new Stack<Character>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if (chs.isEmpty()||ch=='('||ch=='{'||ch =='['){
                chs.push(ch);
            }
            if (ch==')'||ch=='}'||ch ==']'){
                char c = chs.peek();

                char p=' ';
                if(ch==')') p='(';
                if(ch=='}') p='{';
                if(ch==']') p='[';
                if(p==c){
                   chs.pop();
                }else{
                    return false;
                }
            }
        }
        if(chs.isEmpty()) {
            return true;
        }else {
            return false;
        }
    }
}
